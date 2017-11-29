/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.resources;

import co.edu.uniandes.nocompila.huecota.dtos.CerradoDTO;
import co.edu.uniandes.nocompila.huecota.ejb.CerradoLogic;
import co.edu.uniandes.nocompila.huecota.entities.CerradoEntity;
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
import javax.ws.rs.core.MediaType;

/**
 *
 * @author jpr.arango10
 */
@Path("/estadosCerrado")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class CerradoResource {
    @Inject
    CerradoLogic cerradoLogic;

    /**
     * POST http://localhost:8080/huecota-web/api/estadosCerrado
     * @param state corresponde a la representacion Java del objeto json.
     * enviado en el llamado.
     * @return Devuelve el objeto json de entrada que contiene el id creado por la base de datos y el tipo del objeto java.
     */
    @POST
    public CerradoDTO createState(CerradoDTO state) throws BusinessLogicException {
        CerradoEntity entity = state.toEntity();
        CerradoEntity newState = cerradoLogic.createState(entity);
        return new CerradoDTO(newState);
    }
    
    /**
     * GET para todos los estados cerrado.
     * http://localhost:8080/huecota-web/api/estadosCerrado
     * @return  la lista de todas las calificaciones en objetos json DTO.
     */
    @GET
    public List<CerradoDTO> getStates() throws BusinessLogicException {
        return listEntity2DetailDTO(cerradoLogic.getStates());
    }
    
    private List<CerradoDTO> listEntity2DetailDTO(List<CerradoEntity> entityList) {
        List<CerradoDTO> list = new ArrayList();
        for (CerradoEntity entity : entityList) {
            list.add(new CerradoDTO(entity));
        }
        return list;
    }
    
    /**
     * GET para un estado abierto con in id específico,
     * http://localhost:8080/huecota-web/api/estadosCerrado/{id}
     * @param id del estado que se quiere.
     * @return  el objeto calificacion que se consulto.
     */
    @GET
    @Path("{id: \\d+}")
    public CerradoDTO getState(@PathParam("id") Long id) throws BusinessLogicException{
        CerradoDTO dto = new CerradoDTO(cerradoLogic.getState(id));
        return dto;
    }
    
    /**
     * PUT http://localhost:8080/huecota-web/api/estadosCerrado/{id}
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
    public CerradoDTO updateState(@PathParam("id") Long id, CerradoDTO state) throws BusinessLogicException, UnsupportedOperationException {
        state.setId(id);
        CerradoEntity entity = cerradoLogic.getState(id);
        if (entity == null)
            throw new WebApplicationException("El recurso estado: " + id + " no existe.", 404);
        return new CerradoDTO(cerradoLogic.updateState(state.toEntity()));
    }
    
    /**
     * DELETE http://localhost:8080/huecota-web/api/estadosCerrado/{id} 
     * @param id corresponde al estado a borrar.
     * 
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteState(@PathParam("id") Long id) throws BusinessLogicException {
         cerradoLogic.deleteState(id);
    }
}
