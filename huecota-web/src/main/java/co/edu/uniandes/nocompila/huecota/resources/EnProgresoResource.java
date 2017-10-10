/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.resources;

import co.edu.uniandes.nocompila.huecota.dtos.EnProgresoDetailDTO;
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

    @POST
    public EnProgresoDetailDTO createState(EnProgresoDetailDTO state) throws BusinessLogicException {
        EnProgresoEntity entity = state.toEntity();
        EnProgresoEntity newState = enProgresoLogic.createState(entity);
        return new EnProgresoDetailDTO(newState);
    }
    
    @GET
    public List<EnProgresoDetailDTO> getStates() throws BusinessLogicException {
        return listEntity2DetailDTO(enProgresoLogic.getStates());
    }
    
    private List<EnProgresoDetailDTO> listEntity2DetailDTO(List<EnProgresoEntity> entityList) {
        List<EnProgresoDetailDTO> list = new ArrayList();
        for (EnProgresoEntity entity : entityList) {
            list.add(new EnProgresoDetailDTO(entity));
        }
        return list;
    }
    
    @GET
    @Path("{id: \\d+}")
    public EnProgresoDetailDTO getState(@PathParam("id") Long id) throws BusinessLogicException{
        EnProgresoDetailDTO dto = new EnProgresoDetailDTO(enProgresoLogic.getState(id));
        return dto;
    }
    
    @PUT
    @Path("{id: \\d+}")
    public EnProgresoDetailDTO updateState(@PathParam("id") Long id, EnProgresoDetailDTO cliente) throws BusinessLogicException, UnsupportedOperationException {
          return null;
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void deleteState(@PathParam("id") Long id) throws BusinessLogicException {
         enProgresoLogic.deleteState(id);
    }
}
