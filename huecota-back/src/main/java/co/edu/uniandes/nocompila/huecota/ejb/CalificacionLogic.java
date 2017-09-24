/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.ejb;

import co.edu.uniandes.nocompila.huecota.entities.CalificacionEntity;
import co.edu.uniandes.nocompila.huecota.persistence.CalificacionPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author le.viana
 */
@Stateless
public class CalificacionLogic {
    
    private static final Logger LOGGER = Logger.getLogger(CalificacionLogic.class.getName());
    
    @Inject
    private CalificacionPersistence persistence;
    
    
    /**
     * Obtiene la lista de los registros de Calificacion.
     * @return Colección de objetos Calificacion.
     */
    public List<CalificacionEntity> getCalificaciones()
    {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todas las calificaciones");
        return persistence.findAll();
    }
    
    /**
     * Obtiene los datos de una instancia  de Calificacion  a partir de su id.
     * @param id identificador de la instancia a consultar.
     * @return Instancia de CalificacionEntity  con los datos de la calificacion consultada.
     */
    public CalificacionEntity getCalificacion(Long id)
    {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar un autor con id = {0}", id);
        return persistence.find(id);
    }
    
    /**
     * Se encarga de crear una calificacion en la base de datos.
     * @param entity objeto de CalificacionEntity  con los datos nuevos.
     * @return  Objeto de CalificacionEntity con los datos nuevos y su Id.
     */
    public CalificacionEntity createCalificacion(CalificacionEntity entity)
    {
        LOGGER.log(Level.INFO, "Inicia proceso de crear una calificacion");
        
        return persistence.create(entity);
    }
    
    /**
     * Actualiza la informacion de una instancia de Calificacion
     * @param entity Instancia de CalificacionEntity con los nuevos datos.
     * @return Instancia de CalificacionEntity con los datos actualizados.
     */
    public CalificacionEntity updateCalificacion(CalificacionEntity entity)
    {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar una calificacion");
        
        return persistence.update(entity);
    }
    
    /**
     * Elimina una instancia de calificacion de la base de datos.
     * @param id Identificador de la instancia a eliminar.
     */
    public void deleteCalificacion(Long id)
    {
        LOGGER.log(Level.INFO, "Inicia Proceso  de borrar calificacion");
        persistence.delete(id);
    }
    
}
