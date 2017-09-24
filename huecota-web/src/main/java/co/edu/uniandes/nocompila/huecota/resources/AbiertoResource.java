/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.resources;

import co.edu.uniandes.nocompila.huecota.dtos.AbiertoDetailDTO;
import co.edu.uniandes.nocompila.huecota.ejb.AbiertoLogic;
import co.edu.uniandes.nocompila.huecota.entities.AbiertoEntity;
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
    
    private static final Logger LOGGER = Logger.getLogger(AbiertoResource.class.getName());

    @POST
    public AbiertoDetailDTO createState(AbiertoDetailDTO state) throws BusinessLogicException {
        AbiertoEntity entity = state.toEntity();
        AbiertoEntity newState = abiertoLogic.createState(entity);
        return new AbiertoDetailDTO(newState);
    }
    
    @GET
    public List<AbiertoDetailDTO> getStates() throws BusinessLogicException {
        return listEntity2DetailDTO(abiertoLogic.getStates());
    }
    
    private List<AbiertoDetailDTO> listEntity2DetailDTO(List<AbiertoEntity> entityList) {
        List<AbiertoDetailDTO> list = new ArrayList();
        for (AbiertoEntity entity : entityList) {
            list.add(new AbiertoDetailDTO(entity));
        }
        return list;
    }
    
    @Path("{id: \\d+}")
    public AbiertoDetailDTO getState(@PathParam("id") Long id) throws BusinessLogicException{
        AbiertoDetailDTO dto = new AbiertoDetailDTO(abiertoLogic.getState(id));
        return dto;
    }
    
    @PUT
    @Path("{id: \\d+}")
    public AbiertoDetailDTO updateState(@PathParam("id") Long id, AbiertoDetailDTO cliente) throws BusinessLogicException, UnsupportedOperationException {
          return null;
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void deleteHueco(@PathParam("id") Long id) throws BusinessLogicException {
         abiertoLogic.deleteState(id);
    }
}
