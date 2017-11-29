/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.resources;

import co.edu.uniandes.nocompila.huecota.dtos.AbiertoDTO;
import co.edu.uniandes.nocompila.huecota.ejb.AbiertoLogic;
import co.edu.uniandes.nocompila.huecota.entities.AbiertoEntity;
import co.edu.uniandes.nocompila.huecota.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
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
 * @author jpr.arango10
 */
@Path("/estadosAbierto")
@Produces("application/json")
@Consumes("application/json")
@Stateless
public class AbiertoResource {
    @Inject
    AbiertoLogic abiertoLogic;
    
    /**
     * POST http://localhost:8080/huecota-web/api/estadosAbierto
     * @param state corresponde a la representacion Java del objeto json.
     * enviado en el llamado.
     * @return Devuelve el objeto json de entrada que contiene el id creado por la base de datos y el tipo del objeto java.
     */
    @POST
    public AbiertoDTO createState(AbiertoDTO state) throws BusinessLogicException {
        AbiertoEntity entity = state.toEntity();
        AbiertoEntity newState = abiertoLogic.createState(entity);
        return new AbiertoDTO(newState);
    }
    
    /**
     * GET para todos los estados abierto.
     * http://localhost:8080/huecota-web/api/estadosAbierto
     * @return  la lista de todas las calificaciones en objetos json DTO.
     */
    @GET
    public List<AbiertoDTO> getStates() throws BusinessLogicException {
        return listEntity2DetailDTO(abiertoLogic.getStates());
    }
    
    private List<AbiertoDTO> listEntity2DetailDTO(List<AbiertoEntity> entityList) {
        List<AbiertoDTO> list = new ArrayList();
        for (AbiertoEntity entity : entityList) {
            list.add(new AbiertoDTO(entity));
        }
        return list;
    }
    
    /**
     * GET para un estado abierto con in id específico,
     * http://localhost:8080/huecota-web/api/estadosAbierto/{id}
     * @param id del estado que se quiere.
     * @return  el objeto calificacion que se consulto.
     */
    @GET
    @Path("{id: \\d+}")
    public AbiertoDTO getState(@PathParam("id") Long id) throws BusinessLogicException{
        AbiertoDTO dto = new AbiertoDTO(abiertoLogic.getState(id));
        return dto;
    }
    
    /**
     * PUT http://localhost:8080/huecota-web/api/estadosAbierto/{id}
     * 
     * @param id corresponde al estado a actualizar.
     * @param cliente corresponde al objeto con los cambios que se van a realizar.
     * @return La calificacion actualizada.
     * @throws BusinessLogicException 
     * 
     * En caso de no existir el id del accidente a actualizar se retorna 404 con el mensaje.
     */
    @PUT
    @Path("{id: \\d+}")
    public AbiertoDTO updateState(@PathParam("id") Long id, AbiertoDTO state) throws BusinessLogicException, UnsupportedOperationException {
        state.setId(id);
        AbiertoEntity entity = abiertoLogic.getState(id);
        if (entity == null)
            throw new WebApplicationException("El recurso estado: " + id + " no existe.", 404);
        return new AbiertoDTO(abiertoLogic.updateState(state.toEntity()));
    }
    
    /**
     * DELETE http://localhost:8080/huecota-web/api/estadosAbierto/{id} 
     * @param id corresponde al estado a borrar.
     * 
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteHueco(@PathParam("id") Long id) throws BusinessLogicException {
         abiertoLogic.deleteState(id);
    }
}
