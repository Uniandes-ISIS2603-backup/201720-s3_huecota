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

import co.edu.uniandes.nocompila.huecota.dtos.DireccionDTO;
import co.edu.uniandes.nocompila.huecota.ejb.DireccionLogic;
import co.edu.uniandes.nocompila.huecota.entities.DireccionEntity;
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

@Path("/direcciones")
@Produces("application/json")
@Consumes("application/json")
@Stateless

public class DireccionResource
{
 
    @Inject
    DireccionLogic direccionLogic;
    
    private static final Logger LOGGER = Logger.getLogger(DireccionResource.class.getName());

    /**
     * POST http://localhost:8080/huecota-web/api/direcciones
     *
     * @param direccion correponde a la representación java del objeto json
     * enviado en el llamado.
     * @return Devuelve el objeto json de entrada que contiene el id creado por
     * la base de datos y el tipo del objeto java. Ejemplo: { "type":
     * "DireccionDTO", "id": 1, atributo1 : "valor" }
     * @throws BusinessLogicException
     */
    @POST
    public DireccionDTO createDireccion(DireccionDTO direccion) throws BusinessLogicException
	{
        // Convierte el DTO (json) en un objeto Entity para ser manejado por la lógica.
      DireccionEntity entity = direccion.toEntity();
        // Invoca la lógica para crear la nueva direccion.
       DireccionEntity nuevaDireccion = direccionLogic.createDireccion(entity);
        // Como debe retornar un DTO (json) se invoca el constructor del DTO con argumento el entity nuevo
        return new DireccionDTO(nuevaDireccion);
    }
    
    /**
     * GET para todas las direcciones.
     * http://localhost:8080/huecota-web/api/direcciones
     *
     * @return la lista de todas las direcciones en objetos json DTO.
     * @throws BusinessLogicException
     */
    @GET
    public List<DireccionDTO> getDirecciones() throws BusinessLogicException
	{
        return listEntityToDTO(direccionLogic.getDirecciones());
    }
    
     /**
     *
     * lista de entidades a DTO.
     *
     * Este método convierte una lista de objetos DireccionEntity a una lista de
     * objetos DireccionDTO (json)
     *
     * @param entityList corresponde a la lista de direcciones de tipo Entity
     * que vamos a convertir a DTO.
     * @return la lista de direcciones en forma DTO (json)
     */
    private List<DireccionDTO> listEntityToDTO(List<DireccionEntity> entityList)
	{
        List<DireccionDTO> list = new ArrayList();
        for (DireccionEntity entity : entityList)
		{
            list.add(new DireccionDTO(entity));
        }
        return list;
    }
    
    /**
     * GET para una direccion.
     * http://localhost:8080/huecota-web/api/direcciones/{id}
     *
     * @return la direccion en objeto json DTO.
     * @throws BusinessLogicException
     */
    @Path("{id: \\d+}")
    public DireccionDTO getDireccion(@PathParam("id") Long id) throws BusinessLogicException
	{
       DireccionDTO dto = new DireccionDTO(direccionLogic.getDireccion(id));
       return dto;
    }
    
     /**
     * PUT http://localhost:8080/huecota-web/api/direcciones/{id} 
     * json { "id": 1, "atirbuto1": "Valor nuevo" }
     *
     * @param id corresponde a la direccion a actualizar.
     * @param Direccion corresponde  al objeto con los cambios que se van a
     * realizar.
     * @return El direccion actualizada.
     * @throws BusinessLogicException
     *
     * En caso de no existir el id de la direccion a actualizar se retorna un
     * 404 con el mensaje.
     */
    @PUT
    @Path("{id: \\d+}")
    public DireccionDTO updateDireccion(@PathParam("id") Long id, DireccionDTO direccion) throws BusinessLogicException, UnsupportedOperationException
	{
		direccion.setId(id);
		DireccionEntity entity = direccionLogic.getDireccion(id);
		if (entity == null)
		{
			throw new WebApplicationException("El recurso /direcciones/" + id + "no existe.", 404);
		}
		return new DireccionDTO( direccionLogic.updateDireccion(id, direccion.toEntity()));
    }
	    
    /**
     * DELETE http://localhost:8080/huecota-web/api/direcciones/{id}
     *
     * @param id corresponde a la direccion a borrar.
     * @throws BusinessLogicException
     *
     * En caso de no existir el id de la direccion a actualizar se retorna un
     * 404 con el mensaje.
     *
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteDireccion(@PathParam("id") Long id) throws BusinessLogicException
	{
         direccionLogic.deleteDireccion(id);
    }
}
