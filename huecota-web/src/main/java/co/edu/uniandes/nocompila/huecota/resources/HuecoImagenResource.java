/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.resources;

import co.edu.uniandes.nocompila.huecota.ejb.HuecoLogic;
import co.edu.uniandes.nocompila.huecota.dtos.ImagenDTO;
import co.edu.uniandes.nocompila.huecota.entities.ImagenEntity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

/**
 * 
 * URI: huecos/{huecosid: \\d+}/authors
 *
 * @author le.viana
 */
@Consumes("application/json")
@Produces("application/json")
public class HuecoImagenResource {
    
    @Inject
    private HuecoLogic huecoLogic;
    
    /**
     * Convierte una lista de ImagenEntity a una lista de ImagenDTO.
     * @param entityList lista de ImagenEntity a convertir.
     * @return Lista de ImagenDTO convertida.
     */
    private List<ImagenDTO> imagenesListEntity2DTO(List<ImagenEntity> entityList)
    {
        List<ImagenDTO> list = new ArrayList();
        for(ImagenEntity entity : entityList)
        {
            list.add(new ImagenDTO(entity));
        }
        
        return list;
    }
    
    /**
     * Convierte una lista de ImagenDTO a una lista de ImagenEntity
     * @param dtos lista de ImagenDTO a convertir.
     * @return Lista de ImagenEntity convertido.
     */
    public List<ImagenEntity> imagenesListDTO2Entity(List<ImagenDTO> dtos)
    {
        List<ImagenEntity> list = new ArrayList();
        for(ImagenDTO dto : dtos)
        {
            list.add(dto.toEntity());
        }
        return list;
    }
    
    
    
}
