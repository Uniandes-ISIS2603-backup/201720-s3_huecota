/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.resources;

import co.edu.uniandes.nocompila.huecota.dtos.ImagenDTO;
import co.edu.uniandes.nocompila.huecota.ejb.ImagenLogic;
import co.edu.uniandes.nocompila.huecota.entities.ImagenEntity;
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
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author le.viana
 */
@Path("/imagenes")
@Produces("application/json")
@Consumes("application/json")
@Stateless
public class ImagenResource {
    
    @Inject
    ImagenLogic imagenLogic;
    
    private static final Logger LOGGER = Logger.getLogger(ImagenResource.class.getName());
    
    /**
     * POST  http://localhost:8080/huecota-web/api/imagenes
     * @param imagen corresponde a la representacion java del objeto json
     * enviado en el llamado.
     * @return Devuelve el objeto json de entrada que contiene el id creado por la base de datos
     * y el tipo del objeto java.
     */
    @POST
    public ImagenDTO createImagen(ImagenDTO imagen)
    {
        ImagenEntity entity = imagen.toEntity();
        
        ImagenEntity nuevaImagen = imagenLogic.createImagen(entity);
        
        return new ImagenDTO(nuevaImagen);
    }
    
    /**
     * GET para todas las imagenes.
     * http://localhost:8080/huecota-web/api/imagenes
     * @return la lista de todas las imagenes en objetos json DTO.
     */
    @GET
    public List<ImagenDTO> getImagenes()
    {
        return listEntityToDTO(imagenLogic.getImagenes());
    }
    
    /**
     * lista de entidades a DTO
     * 
     * Este metodo convierte una lista de objetos ImagenEntity a una lista de
     * objetos ImagenDTO
     * @param entityList correspone a una lista de imagenes de tipo entity.
     * @return la lista de accidentes en forma DTO
     */
    private List<ImagenDTO> listEntityToDTO(List<ImagenEntity> entityList)
    {
        List<ImagenDTO> list = new ArrayList();
        for(ImagenEntity entity : entityList)
        {
            list.add(new ImagenDTO(entity));
        }
        
        return list;
    }
    
    /**
     * GET para una imagen.
     * http://localhost:8080/huecota-web/api/imagenes/{id}
     * @param id identificador de la imagen a consultar
     * @return  la imagen consltada.
     */
    @Path("{id: \\d+}")
    public ImagenDTO getImagen(@PathParam("id") Long id)
    {
        ImagenDTO dto = new ImagenDTO(imagenLogic.getImagen(id));
        return dto;
    }
    
    /**
     * PUT http://localhost:8080/huecota-web/api/imagenes/{id}
     * @param id corresponde a la imagen a actualizar.
     * @param imagen corresponde al objeto con los cambios que se van a realizar
     * @return La Imagen actualizada
     * @throws BusinessLogicException 
     * 
     * En caso de no existir el id de la imagen a actualizar se retorna un 404 con el mensaje
     */
    @PUT
    @Path("{id: \\d+}")
    public ImagenDTO updateImagen(@PathParam("id") Long id, ImagenDTO imagen) throws BusinessLogicException
    {
            imagen.setId(id);
            ImagenEntity entity = imagenLogic.getImagen(id);
            
            if(entity == null)
            {
                throw new WebApplicationException("El recurso /imagenes/" + id + "no existe.", 404);
            }
            return new ImagenDTO(imagenLogic.updateImagen(entity));
    }
    
    /**
     * DELETE http://localhost:8080/huecota-web/api/imagenes/{id}
     * @param id corresponde a la imagen a borrar.
     * 
     * En caso de no exisitr el id de la imagen a actualizar se reotrna un 404 con el mensaje.
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteImagen(@PathParam("id") Long id)
    {
        imagenLogic.deleteImagenEntity(id);
    }
}
