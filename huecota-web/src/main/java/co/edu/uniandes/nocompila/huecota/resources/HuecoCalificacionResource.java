/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.resources;

import co.edu.uniandes.nocompila.huecota.ejb.HuecoLogic;
import co.edu.uniandes.nocompila.huecota.dtos.CalificacionDTO;
import co.edu.uniandes.nocompila.huecota.entities.CalificacionEntity;
import java.util.ArrayList;
import java.util.List;
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
 * @author le.viana
 */
@Consumes("application/json")
@Produces("application/json")
public class HuecoCalificacionResource {
    
    @Inject
    private HuecoLogic huecoLogic;
    
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
     * @param huecosid identificador de la instancia de hueco.
     * @return Coleccion de instancias de calificacionDTO asociadas al hueco.
     */
    @GET
    public List<CalificacionDTO> listCalificaciones(@PathParam("huecosid") Long huecosid)
    {
        return calificacionesListEntity2DTO(huecoLogic.getCalificaciones(huecosid));
    }
    
    /**
     * Obtiene una instancia de calificacion asociada a un hueco.
     * @param huecosid identificador de la instancia hueco.
     * @param calificacionesId identificador de la calificacion-
     * @return calificacion que pertenece a un hueco.
     */
    @GET
    @Path("{calificacionesId: \\d+}")
    public CalificacionDTO getCalificacion(@PathParam("huecosid") Long huecosid, @PathParam("calificacionesId") Long calificacionesId)
    {
        return new CalificacionDTO(huecoLogic.getCalificacion(huecosid, calificacionesId));
    }
    
    @POST
    @Path("{calificacionesId: \\d+}")
    public CalificacionDTO addCalificacion(@PathParam("huecosid") Long huecosid, @PathParam("calificacionesId") Long calificacionesId)
    {
        return new CalificacionDTO(huecoLogic.addCalificacion(huecosid, calificacionesId));
    }
    
    @PUT
    public List<CalificacionDTO> remplazarCalificacion(@PathParam("huecosid") Long huecosid,List<CalificacionDTO> calificaciones)
    {
        return calificacionesListEntity2DTO(huecoLogic.replaceCalificaciones(huecosid, calificacionesListDTO2Entity(calificaciones)));
    }
    
    
    @DELETE
    @Path("{calificacionesId: \\d+}")
    public void removeCalificaciones(@PathParam("huecosid") Long huecosid, @PathParam("calificacionesid") Long calificacionesid)
    {
        huecoLogic.removeCalificacion(huecosid, calificacionesid);
    }
}
