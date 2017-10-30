/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.resources;

import co.edu.uniandes.nocompila.huecota.dtos.HuecoDetailDTO;
import co.edu.uniandes.nocompila.huecota.ejb.HuecoLogic;
import co.edu.uniandes.nocompila.huecota.entities.HuecoEntity;
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

/**
 *
 * @author ch.patino
 */
@Path("/huecos")
@Produces("application/json")
@Consumes("application/json")
@Stateless
public class HuecoResource {
 
    @Inject
    HuecoLogic huecoLogic;
    
    private static final Logger LOGGER = Logger.getLogger(HuecoResource.class.getName());

    /**
     * POST http://localhost:8080/huecota-web/api/huecos
     *
     * @param hueco correponde a la representación java del objeto json
     * enviado en el llamado.
     * @return Devuelve el objeto json de entrada que contiene el id creado por
     * la base de datos y el tipo del objeto java. Ejemplo: { "type":
     * "HuecoDetailDTO", "id": 1, atributo1 : "valor" }
     * @throws BusinessLogicException
     */
    @POST
    public HuecoDetailDTO createhueco(HuecoDetailDTO hueco) throws BusinessLogicException {
        // Convierte el DTO (json) en un objeto Entity para ser manejado por la lógica.
        HuecoEntity entity = hueco.toEntity();
        // Invoca la lógica para crear el hueco nuev
        HuecoEntity nuevoHueco = huecoLogic.createHueco(entity);
        // Como debe retornar un DTO (json) se invoca el constructor del DTO con argumento el entity nuevo
        return new HuecoDetailDTO(nuevoHueco);
    }
    
    /**
     * GET para todas los huecos.
     * http://localhost:8080/huecota-web/api/huecos
     *
     * @return la lista de todas los huecos en objetos json DTO.
     * @throws BusinessLogicException
     */
    @GET
    public List<HuecoDetailDTO> gethuecos() throws BusinessLogicException {
        return listEntity2DetailDTO(huecoLogic.getHuecos());
    }
    
     /**
     *
     * lista de entidades a DTO.
     *
     * Este método convierte una lista de objetos huecoEntity a una lista de
     * objetos huecoDetailDTO (json)
     *
     * @param entityList corresponde a la lista de huecos de tipo Entity
     * que vamos a convertir a DTO.
     * @return la lista de huecos en forma DTO (json)
     */
    private List<HuecoDetailDTO> listEntity2DetailDTO(List<HuecoEntity> entityList) {
        List<HuecoDetailDTO> list = new ArrayList();
        for (HuecoEntity entity : entityList) {
            list.add(new HuecoDetailDTO(entity));
        }
        return list;
    }
    
    /**
     * GET para un hueco.
     * http://localhost:8080/huecota-web/api/huecos/{id}
     *
     * @param id
     * @return el hueco en objeto json DTO.
     * @throws BusinessLogicException
     */
    @GET
    @Path("{id: \\d+}")
    public HuecoDetailDTO gethueco(@PathParam("id") Long id) throws BusinessLogicException{
        HuecoDetailDTO dto = new HuecoDetailDTO(huecoLogic.getHueco(id));
        return dto;
    }
    
     /**
     * PUT http://localhost:8080/huecota-web/api/huecos/{id} 
     * json { "id": 1, "atirbuto1": "Valor nuevo" }
     *
     * @param id corresponde al hueco a actualizar.
     * @param hueco corresponde  al objeto con los cambios que se van a
     * realizar.
     * @return El hueco actualizada.
     * @throws BusinessLogicException
     *
     * En caso de no existir el id de el hueco a actualizar se retorna un
     * 404 con el mensaje.
     */
    @PUT
    @Path("{id: \\d+}")
    public HuecoDetailDTO updatehueco(@PathParam("id") Long id, HuecoDetailDTO hueco) throws BusinessLogicException, UnsupportedOperationException {
          hueco.setId(id);
        HuecoEntity entity = huecoLogic.getHueco(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /books/" + id + " no existe.", 404);
        }
        return new HuecoDetailDTO(huecoLogic.updateHueco(id, hueco.toEntity()));
    }
    
    /**
     * DELETE http://localhost:8080/huecota-web/api/huecos/{id}
     *
     * @param id corresponde al hueco a borrar.
     * @throws BusinessLogicException
     *
     * En caso de no existir el id de el cleitne a actualizar se retorna un
     * 404 con el mensaje.
     *
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deletehueco(@PathParam("id") Long id) throws BusinessLogicException {
         huecoLogic.deleteHueco(id);
    }
    
    @Path("{idBook: \\d+}/reviews")
    public Class<PuntoResource> getPuntoResource(@PathParam("idhueco") Long huecoId) {
        try{
          HuecoEntity entity = huecoLogic.getHueco(huecoId);
        if (entity == null) {
            throw new WebApplicationException("El recurso /books/" + huecoId + "/reviews no existe.", 404);
        }
        return PuntoResource.class;  
        }
        catch(Exception e){
            return null;
        }
        
    }
}
