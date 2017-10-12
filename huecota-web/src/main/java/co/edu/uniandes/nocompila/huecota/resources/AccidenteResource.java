/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.resources;

/**
 *
 * @author ma.puentes
 */

import co.edu.uniandes.nocompila.huecota.dtos.AccidenteDTO;
import co.edu.uniandes.nocompila.huecota.ejb.AccidenteLogic;
import co.edu.uniandes.nocompila.huecota.entities.AccidenteEntity;
import co.edu.uniandes.nocompila.huecota.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

@Path("/accidentes")
@Produces("application/json")
@Consumes("application/json")
@Stateless

public class AccidenteResource
{
 
    @Inject
    AccidenteLogic accidenteLogic;

    /**
     * POST http://localhost:8080/huecota-web/api/accidentes
     *
     * @param accidente correponde a la representación java del objeto json
     * enviado en el llamado.
     * @return Devuelve el objeto json de entrada que contiene el id creado por
     * la base de datos y el tipo del objeto java. Ejemplo: { "type":
     * "AccidentelDTO", "id": 1, atributo1 : "valor" }
     * @throws BusinessLogicException
     */
    @POST
    public AccidenteDTO createAccidente(AccidenteDTO accidente) throws BusinessLogicException
	{
        // Convierte el DTO (json) en un objeto Entity para ser manejado por la lógica.
       AccidenteEntity entity = accidente.toEntity();
        // Invoca la lógica para crear el accidente nuevo.
       AccidenteEntity nuevoAccidente = accidenteLogic.createAccidente(entity);
        // Como debe retornar un DTO (json) se invoca el constructor del DTO con argumento el entity nuevo
        return new AccidenteDTO(nuevoAccidente);
    }
    
    /**
     * GET para todos los accidentes.
     * http://localhost:8080/huecota-web/api/accidentes
     *
     * @return la lista de todas los accidentes en objetos json DTO.
     * @throws BusinessLogicException
     */
    @GET
    public List<AccidenteDTO> getAccidentes() throws BusinessLogicException
	{
        return listEntityToDTO(accidenteLogic.getAccidentes());
    }
    
     /**
     *
     * lista de entidades a DTO.
     *
     * Este método convierte una lista de objetos AccidenteEntity a una lista de
     * objetos AccidenteDTO (json)
     *
     * @param entityList corresponde a la lista de accidentes de tipo Entity
     * que vamos a convertir a DTO.
     * @return la lista de accidentes en forma DTO (json)
     */
    private List<AccidenteDTO> listEntityToDTO(List<AccidenteEntity> entityList)
	{
        List<AccidenteDTO> list = new ArrayList();
        for (AccidenteEntity entity : entityList)
		{
            list.add(new AccidenteDTO(entity));
        }
        return list;
    }
    
    /**
     * GET para un accidente.
     * http://localhost:8080/huecota-web/api/accidentes/{id}
     *
     * @return el accidente en objeto json DTO.
     * @throws BusinessLogicException
     */
	@GET
    @Path("{id: \\d+}")
    public AccidenteDTO getAccidente(@PathParam("id") Long id) throws BusinessLogicException
	{
       AccidenteDTO dto = new AccidenteDTO(accidenteLogic.getAccidente(id));
       return dto;
    }
    
     /**
     * PUT http://localhost:8080/huecota-web/api/accidentes/{id} 
     * json { "id": 1, "atirbuto1": "Valor nuevo" }
     *
     * @param id corresponde al accidente a actualizar.
     * @param Accidente corresponde  al objeto con los cambios que se van a
     * realizar.
     * @return El accidente actualizada.
     * @throws BusinessLogicException
     *
     * En caso de no existir el id del accidente a actualizar se retorna un
     * 404 con el mensaje.
     */
    @PUT
    @Path("{id: \\d+}")
    public AccidenteDTO updateAccidente(@PathParam("id") Long id, AccidenteDTO accidente) throws BusinessLogicException, UnsupportedOperationException
	{
		accidente.setId(id);
		AccidenteEntity entity = accidenteLogic.getAccidente(id);
		if (entity == null)
		{
			throw new WebApplicationException("El recurso /direcciones/" + id + "no existe.", 404);
		}
		return new AccidenteDTO( accidenteLogic.updateAccidente(id, accidente.toEntity()));
    }
    
    /**
     * DELETE http://localhost:8080/huecota-web/api/accidentes/{id}
     *
     * @param id corresponde al accidente a borrar.
     * @throws BusinessLogicException
     *
     * En caso de no existir el id del accidente a actualizar se retorna un
     * 404 con el mensaje.
     *
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteAccidente(@PathParam("id") Long id) throws BusinessLogicException
	{
         accidenteLogic.deleteAccidente(id);
    }
}
