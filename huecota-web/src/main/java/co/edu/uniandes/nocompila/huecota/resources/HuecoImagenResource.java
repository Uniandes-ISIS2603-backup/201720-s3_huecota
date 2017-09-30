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
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
    
    /**
     * Obtiene  una colección de instancias de CalificacionDTO asociados a un hueco
     * @param huecosid identificador de la instancia de hueco.
     * @return Coleccion de instancias de calificacionDTO asociadas al hueco.
     */
    @GET
    public List<ImagenDTO> listImagenes(@PathParam("huecosid") Long huecosid)
    {
        return imagenesListEntity2DTO(huecoLogic.getFotos(huecosid));
    }
    
    /**
     * Obtiene una instancia de calificacion asociada a un hueco.
     * @param huecosid identificador de la instancia hueco.
     * @param imagenesId identificador de la calificacion-
     * @return calificacion que pertenece a un hueco.
     */
    @GET
    @Path("{imagenesId: \\d+}")
    public ImagenDTO getImagen(@PathParam("huecosid") Long huecosid, @PathParam("imagenesId") Long imagenesId)
    {
        return new ImagenDTO(huecoLogic.getFoto(huecosid, imagenesId));
    }
    
    @POST
    @Path("{imagenesId: \\d+}")
    public ImagenDTO addImagen(@PathParam("huecosid") Long huecosid, @PathParam("imagenesId") Long imagenesId)
    {
        return new ImagenDTO(huecoLogic.addFoto(huecosid, imagenesId));
    }
    
    @PUT
    public List<ImagenDTO> remplazarImagen(@PathParam("huecosid") Long huecosid,List<ImagenDTO> imagenes)
    {
        return imagenesListEntity2DTO(huecoLogic.replaceFotos(huecosid, imagenesListDTO2Entity(imagenes)));
    }
    
    
    @DELETE
    @Path("{imagenesId: \\d+}")
    public void removeCalificaciones(@PathParam("huecosid") Long huecosid, @PathParam("imagenesid") Long imagenesid)
    {
        huecoLogic.removeFoto(huecosid, imagenesid);
    }
    
}
