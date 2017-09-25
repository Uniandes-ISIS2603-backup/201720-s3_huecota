/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.resources;

import co.edu.uniandes.nocompila.huecota.dtos.CerradoDetailDTO;
import co.edu.uniandes.nocompila.huecota.ejb.CerradoLogic;
import co.edu.uniandes.nocompila.huecota.entities.CerradoEntity;
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
@Path("/estadosCerrado")
@Produces("application/json")
@Consumes("application/json")
@Stateless
public class CerradoResource {
    @Inject
    CerradoLogic cerradoLogic;
    
    private static final Logger LOGGER = Logger.getLogger(CerradoResource.class.getName());

    @POST
    public CerradoDetailDTO createState(CerradoDetailDTO state) throws BusinessLogicException {
        CerradoEntity entity = state.toEntity();
        CerradoEntity newState = cerradoLogic.createState(entity);
        return new CerradoDetailDTO(newState);
    }
    
    @GET
    public List<CerradoDetailDTO> getStates() throws BusinessLogicException {
        return listEntity2DetailDTO(cerradoLogic.getStates());
    }
    
    private List<CerradoDetailDTO> listEntity2DetailDTO(List<CerradoEntity> entityList) {
        List<CerradoDetailDTO> list = new ArrayList();
        for (CerradoEntity entity : entityList) {
            list.add(new CerradoDetailDTO(entity));
        }
        return list;
    }
    
    @GET
    @Path("{id: \\d+}")
    public CerradoDetailDTO getState(@PathParam("id") Long id) throws BusinessLogicException{
        CerradoDetailDTO dto = new CerradoDetailDTO(cerradoLogic.getState(id));
        return dto;
    }
    
    @PUT
    @Path("{id: \\d+}")
    public CerradoDetailDTO updateState(@PathParam("id") Long id, CerradoDetailDTO cliente) throws BusinessLogicException, UnsupportedOperationException {
          return null;
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void deleteHueco(@PathParam("id") Long id) throws BusinessLogicException {
         cerradoLogic.deleteState(id);
    }
}
