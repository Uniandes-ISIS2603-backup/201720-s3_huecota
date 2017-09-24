/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.persistence;

import co.edu.uniandes.nocompila.huecota.entities.CalificacionEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author le.viana
 */
@Stateless
public class CalificacionPersistence {
    
    private static final Logger LOGGER = Logger.getLogger(CalificacionPersistence.class.getName());
    
    @PersistenceContext(unitName = "huecotaPU")
    protected EntityManager em;
    
    
    /**
     * Crea una entidad calificacion en la base de datos
     * @param entity objeto calificacion que se crea en la base de datos.
     * @return devuelve la entidad crada con un id dado por la base de datos.
     */
    public CalificacionEntity create(CalificacionEntity entity)
    {
        LOGGER.info("Creando una calificacion nueva");
        
        em.persist(entity);
        
        LOGGER.info("Creando una calificacion nueva");
        return entity;
        
    }
    
    /**
     * Actualiza una calificacion
     * @param entity la calificacion que viene con los nuevos cambios.
     * @return  una calificacion con los cambios aplicados
     */
    public CalificacionEntity update(CalificacionEntity entity)
    {
        LOGGER.log(Level.INFO, "Actualizando Calificacion con id={0}", entity.getId());
        
        return em.merge(entity);
    }
    
    /**
     * Elimina una calificaci�n de la base de datos recibiendo como argumento el id de la calificacion.
     * @param id: id correspondiente a la calificacion a borrar.
     */
    public void delete(Long id)
    {
        LOGGER.log(Level.INFO, "Eliminando calificacion con id={0}", id);
        
        CalificacionEntity entity = em.find(CalificacionEntity.class, id);
        
        em.remove(entity);
    }
    
    /**
     * Busca si hay alguna calificacion con el id que se envia de argumento.
     * @param id id correspondiente con la calificacion buscada.
     * @return una calificacion.
     */
    public CalificacionEntity find(Long id)
    {
        LOGGER.log(Level.INFO, "Consultando calificación con id={0}", id);
        
        return em.find(CalificacionEntity.class, id);
    }
    
    /**
     * Devuelve todas las calificaciones de la base de datos.
     * @return una lista con todas las calificaciones que encuentre en la base de datos,
     * "select u from CalificacionEntity u" es como un "se�ect * from HuecoEntity;" - "SELECT * FROM table_codigo" en SQL.
     */
    public List<CalificacionEntity> findAll()
    {
        LOGGER.info("Consultando todas las calificaciones");
        
        TypedQuery query = em.createQuery("select u from CalificacionEntity u", CalificacionEntity.class);
        
        return query.getResultList();
    }
}
