/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.resources;

import co.edu.uniandes.nocompila.huecota.dtos.CalificacionDTO;
import co.edu.uniandes.nocompila.huecota.ejb.ClienteLogic;
import co.edu.uniandes.nocompila.huecota.entities.CalificacionEntity;
import co.edu.uniandes.nocompila.huecota.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @author c.martinezc1
 */
@Consumes("application/json")
@Produces("application/json")
public class ClienteCalificacionResource {
     @Inject
    private ClienteLogic clienteLogic;
     
     /**
     * Convierte una lista de CalificacionEntity a una lista de CalificacionDTO
     * @param entityList Lista de CalificacionEntity a convertir.
     * @return Lista de CalificacionDTO.
     */
    private List<CalificacionDTO> calificacionesListEntity2DTO(List<CalificacionEntity> entityList)
    {
        List<CalificacionDTO> list = new ArrayList();
        for(CalificacionEntity entity : entityList)
        {
            list.add(new CalificacionDTO(entity));
        }
        
        return list;
    }
    
    /**
     * Convierte una lista de CalificacionDTO a una lista CalificacionEntity
     * @param dtos Lista de CalificacionDTO a convertir.
     * @return Lista de CalificacionEntity convertida.
     */
    private List<CalificacionEntity> calificacionesListDTO2Entity(List<CalificacionDTO> dtos)
    {
        List<CalificacionEntity> list = new ArrayList();
        for(CalificacionDTO dto : dtos)
        {
            list.add(dto.toEntity());
        }
        
        return list;
    }
    
    /**
     * Obtiene  una colección de instancias de CalificacionDTO asociados a un hueco
     * @param clienteid identificador de la instancia de hueco.
     * @return Coleccion de instancias de calificacionDTO asociadas al hueco.
     */
    @GET
    public List<CalificacionDTO> listCalificaciones(@PathParam("clienteid") Long clienteid)
    {
        try {
            return calificacionesListEntity2DTO(clienteLogic.listaCalificacion(clienteid));
        } catch (BusinessLogicException ex) {
            Logger.getLogger(ClienteCalificacionResource.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    /**
     * Obtiene una instancia de calificacion asociada a un hueco.
     * @param clienteid identificador de la instancia hueco.
     * @param huecoId identificador de la calificacion-
     * @return calificacion que pertenece a un hueco.
     */
    @GET
    @Path("{huecoId: \\d+}")
    public CalificacionDTO getCalificacion(@PathParam("clienteid") Long clienteid, @PathParam("calificacionId") Long calificacionId)
    {
        try {
            return new CalificacionDTO(clienteLogic.getCalificacion(clienteid, calificacionId));
        } catch (BusinessLogicException ex) {
            Logger.getLogger(ClienteCalificacionResource.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    @POST
    @Path("{huecoId: \\d+}")
    public CalificacionDTO addCalificacion(@PathParam("clienteid") Long clienteid, @PathParam("calificacionId") Long calificacionId)
    {
        return new CalificacionDTO(clienteLogic.addCalificacion(clienteid, calificacionId));
    }
    
    @PUT
    @Path("{huecoId: \\d+}")
    public List<CalificacionDTO> remplazarCalificacion(@PathParam("clienteid") Long clienteid,List<CalificacionDTO> calificaciones)
    {
        return calificacionesListEntity2DTO(clienteLogic.replaceCalificaciones(clienteid, calificacionesListDTO2Entity(calificaciones)));
    }
    
    
    @DELETE
    @Path("{huecoId: \\d+}")
    public void removeCalificacion(@PathParam("clienteId") Long clienteId, @PathParam("calificacionId") Long calificacionId)
    {
        clienteLogic.removeCalificacion(clienteId, calificacionId);
    }
    
}
