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

    @POST
    public AbiertoDTO createState(AbiertoDTO state) throws BusinessLogicException {
        AbiertoEntity entity = state.toEntity();
        AbiertoEntity newState = abiertoLogic.createState(entity);
        return new AbiertoDTO(newState);
    }
    
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
    
    @GET
    @Path("{id: \\d+}")
    public AbiertoDTO getState(@PathParam("id") Long id) throws BusinessLogicException{
        AbiertoDTO dto = new AbiertoDTO(abiertoLogic.getState(id));
        return dto;
    }
    
    @PUT
    @Path("{id: \\d+}")
    public AbiertoDTO updateState(@PathParam("id") Long id, AbiertoDTO cliente) throws BusinessLogicException, UnsupportedOperationException {
          return null;
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void deleteHueco(@PathParam("id") Long id) throws BusinessLogicException {
         abiertoLogic.deleteState(id);
    }
}
