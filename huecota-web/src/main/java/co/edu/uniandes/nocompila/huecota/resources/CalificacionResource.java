/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.resources;

import co.edu.uniandes.nocompila.huecota.dtos.CalificacionDTO;
import co.edu.uniandes.nocompila.huecota.ejb.CalificacionLogic;
import co.edu.uniandes.nocompila.huecota.entities.CalificacionEntity;
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
@Path("/calificaciones")
@Produces("application/json")
@Consumes("application/json")
@Stateless
public class CalificacionResource {
    
    @Inject
    CalificacionLogic calificacionLogic;
    
    private static final Logger LOGGER = Logger.getLogger(CalificacionResource.class.getName());
    
    /**
     * POST http://localhost:8080/huecota-web/api/calificaciones
     * @param calificacion corresponde a la representacion Java del objeto json.
     * enviado en el llamado.
     * @return Devuelve el objeto json de entrada que contiene el id creado por la base de datos y el tipo del objeto java.
     */
    @POST
    public CalificacionDTO createCalificacion(CalificacionDTO calificacion)
    {
        CalificacionEntity entity = calificacion.toEntity();
        
        CalificacionEntity nuevaCalificacion = calificacionLogic.createCalificacion(entity);
        
        return new CalificacionDTO(nuevaCalificacion);
    }
    
    /**
     * POST para todas las calificaciones.
     * http://localhost:8080/huecota-web/api/calificacions
     * @return  la lista de todas las calificaciones en objetos json DTO.
     */
    @GET
    public List<CalificacionDTO> getCalificacion()
    {
        return listEntityToDTO(calificacionLogic.getCalificaciones());
    }
    
    /**
     * lista de entidades a DTO
     * 
     * Este método convierte una lista de objetos CalificacionEntity a una lista de
     * objetos Calificaciones (json)
     * @param entityList corresponde a la lista de calificaciones de tipo Entity
     * que vamos a convertir a DTO.
     * @return  la lista de Calificaciones en forma DTO (json)
     */
    private List<CalificacionDTO> listEntityToDTO(List<CalificacionEntity> entityList)
    {
        List<CalificacionDTO> list = new ArrayList();
        for(CalificacionEntity entity : entityList)
        {
            list.add(new CalificacionDTO(entity));
        }
        
        return list;
    }
    
    /**
     * GET para una calificacion
     * http://localhost:8080/huecota-web/api/calificaciones({id}
     * @param id de la calificacion que se quiere.
     * @return  el objeto calificacion que se consulto.
     */
    @Path("{id:\\d+}")
    public CalificacionDTO getCalificacion(@PathParam("id") Long id)
    {
        CalificacionDTO dto = new CalificacionDTO(calificacionLogic.getCalificacion(id));
        return dto;
    }
    
    /**
     * PUT http://localhost:8080/huecota-web/api/calificaciones/{id}
     * 
     * @param id corresponde a la calfificacion a actualizar.
     * @param calificacion corresponde al objeto con los cambios que se van a realizar.
     * @return La calificacion actualizada.
     * @throws BusinessLogicException 
     * 
     * En caso de no existir el id del accidente a actualizar se retorna 404 con el mensaje.
     */
    @PUT
    @Path("{id: \\d+)")
    public CalificacionDTO updateCalificacion(@PathParam("id") Long id, CalificacionDTO calificacion) throws BusinessLogicException
    {
        calificacion.setId(id);
        CalificacionEntity entity = calificacionLogic.getCalificacion(id);
        if(entity == null)
        {
            throw new WebApplicationException("El recurso /calificaciones/" + id + "no existe.",404);
        }
        
        return new CalificacionDTO(calificacionLogic.updateCalificacion(entity));
        
    }
    
    /**
     * DELETE http://localhost:8080/huecota-web/api/calificaciones/{id} 
     * @param id corresponde a la calificacion a borrar.
     * 
     */
    @DELETE
    @Path("{id: \\d+")
    public void deleteCalificacion(@PathParam("id") Long id)
    {
        calificacionLogic.deleteCalificacion(id);
    }
}
