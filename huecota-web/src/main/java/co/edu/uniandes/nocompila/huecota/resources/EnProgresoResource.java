/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.resources;

import co.edu.uniandes.nocompila.huecota.dtos.EnProgresoDTO;
import co.edu.uniandes.nocompila.huecota.ejb.EnProgresoLogic;
import co.edu.uniandes.nocompila.huecota.entities.EnProgresoEntity;
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
import javax.ws.rs.core.MediaType;

/**
 *
 * @author jpr.arango10
 */
@Path("estadosEnProgreso")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class EnProgresoResource {
    @Inject
    EnProgresoLogic enProgresoLogic;

    /**
     * POST http://localhost:8080/huecota-web/api/estadosEnProgreso
     * @param state corresponde a la representacion Java del objeto json.
     * enviado en el llamado.
     * @return Devuelve el objeto json de entrada que contiene el id creado por la base de datos y el tipo del objeto java.
     */
    @POST
    public EnProgresoDTO createState(EnProgresoDTO state) throws BusinessLogicException {
        EnProgresoEntity entity = state.toEntity();
        EnProgresoEntity newState = enProgresoLogic.createState(entity);
        return new EnProgresoDTO(newState);
    }
    
    /**
     * GET para todos los estados en progreso.
     * http://localhost:8080/huecota-web/api/estadosEnProgreso
     * @return  la lista de todos los estados en objetos json DTO.
     */
    @GET
    public List<EnProgresoDTO> getStates() throws BusinessLogicException {
        return listEntity2DetailDTO(enProgresoLogic.getStates());
    }
    
    private List<EnProgresoDTO> listEntity2DetailDTO(List<EnProgresoEntity> entityList) {
        List<EnProgresoDTO> list = new ArrayList();
        for (EnProgresoEntity entity : entityList) {
            list.add(new EnProgresoDTO(entity));
        }
        return list;
    }
    
    /**
     * GET para un estado abierto con in id específico,
     * http://localhost:8080/huecota-web/api/estadosEnProgreso/{id}
     * @param id del estado que se quiere.
     * @return  el objeto calificacion que se consulto.
     */
    @GET
    @Path("{id: \\d+}")
    public EnProgresoDTO getState(@PathParam("id") Long id) throws BusinessLogicException{
        EnProgresoDTO dto = new EnProgresoDTO(enProgresoLogic.getState(id));
        return dto;
    }
    
    /**
     * PUT http://localhost:8080/huecota-web/api/estadosEnProgreso/{id}
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
    public EnProgresoDTO updateState(@PathParam("id") Long id, EnProgresoDTO cliente) throws BusinessLogicException, UnsupportedOperationException {
          return null;
    }
    
    /**
     * DELETE http://localhost:8080/huecota-web/api/estadosEnProgreso/{id} 
     * @param id corresponde al estado a borrar.
     * 
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteState(@PathParam("id") Long id) throws BusinessLogicException {
         enProgresoLogic.deleteState(id);
    }
}
