/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.resources;

import co.edu.uniandes.baco.huecota.ejb.HuecoLogic;
import co.edu.uniandes.nocompila.huecota.dtos.CalificacionDTO;
import co.edu.uniandes.nocompila.huecota.entities.CalificacionEntity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
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
    private List<CalificacionDTO> calificacionListEntity2DTO(List<CalificacionEntity> entityList)
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
    private List<CalificacionEntity> calificacionListDTO2Entity(List<CalificacionDTO> dtos)
    {
        List<CalificacionEntity> list = new ArrayList();
        for(CalificacionDTO dto : dtos)
        {
            list.add(dto.toEntity());
        }
        
        return list;
    }
    
    
    @GET
    public List<CalificacionDTO> listCalificaciones(@PathParam("huecosid") Long huecosid)
    {
        return null;
    }
}
