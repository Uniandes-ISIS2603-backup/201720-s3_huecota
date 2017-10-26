/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.resources;

import co.edu.uniandes.nocompila.huecota.dtos.ContratistaDetailDTO;
import co.edu.uniandes.nocompila.huecota.ejb.ContratistaLogic;
import co.edu.uniandes.nocompila.huecota.entities.ContratistaEntity;
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
 * @author lc.garavito
 */
@Path("/contratistas")
@Produces("application/json")
@Consumes("application/json")
@Stateless
public class ContratistaResource
{
    
    @Inject
    ContratistaLogic contratistaLogic;
    
    private static final Logger LOGGER = Logger.getLogger(ContratistaResource.class.getName());
    
    @POST
    public ContratistaDetailDTO createContratista(ContratistaDetailDTO contratista)
    {
        ContratistaEntity entity = contratista.toEntity();
        ContratistaEntity newContratista = contratistaLogic.crearContratista(entity);
        return new ContratistaDetailDTO(newContratista);
    }
    
    @GET
    public List<ContratistaDetailDTO> getContratistas()
    {
        List<ContratistaDetailDTO> toReturn = new ArrayList<ContratistaDetailDTO>();
        List<ContratistaEntity> list = contratistaLogic.getContratistas();
        for ( ContratistaEntity entity : list )
        {
            toReturn.add(new ContratistaDetailDTO(entity));
        }
        return toReturn;
    }
    
    @GET
    @Path("{id: \\d+}")
    public ContratistaDetailDTO getContratista(@PathParam("id") Long id)
    {
        ContratistaEntity entity = contratistaLogic.getContratista(id);
        if(entity == null)
        {
            throw new WebApplicationException( "El recurso contratista: " + id + " no existe",404);
        }
        return new ContratistaDetailDTO(entity);
    }
    
    @PUT
    @Path("{id: \\d+}")
    public ContratistaDetailDTO updateContratista(@PathParam("id") Long id, ContratistaDetailDTO contratista)
    {
        contratista.setId(id);
        ContratistaEntity entity = contratistaLogic.getContratista(id);
        if (entity == null)
            throw new WebApplicationException("El recurso contratista: " + id + " no existe.", 404);
        return new ContratistaDetailDTO(contratistaLogic.updateContratista(contratista.toEntity()));
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void deleteContratista(@PathParam("id") Long id)
    {
        ContratistaEntity entity = contratistaLogic.getContratista(id);
        if (entity == null)
            throw new WebApplicationException("El recurso contratista: " + id + " no existe.", 404);
        contratistaLogic.deleteContratistaEntity(id);
    }
    
    @Path("{idContratista: \\d+}/cuentascobro")
     public Class<CuentaCobroResource> getContratistaCuentaCobroResource(@PathParam ("idContratista") Long contratistasId)
    {
        ContratistaEntity entity = contratistaLogic.getContratista(contratistasId);
        if(entity==null)
            throw new WebApplicationException("El recurso /contratistas/"+contratistasId+" no existe", 404);
        return CuentaCobroResource.class;
        
    }
}