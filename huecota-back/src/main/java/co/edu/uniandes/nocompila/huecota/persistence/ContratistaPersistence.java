/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.persistence;

import co.edu.uniandes.nocompila.huecota.entities.ContratistaEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author lc.garavito
 */
@Stateless
public class ContratistaPersistence
{
    private static final Logger LOGGER = Logger.getLogger(ContratistaPersistence.class.getName());
    @PersistenceContext(unitName = "huecotaPU")
    protected EntityManager em;
    
    /**
     * Crea un nuevo contratista en la base de datos.
     * @param entity Objeto Contratista que se creará en la base de datos.
     * @return La entidad creada con un id por la base de datos.
     */
    public ContratistaEntity create(ContratistaEntity entity)
	{
        LOGGER.info("Creando un contratista nuevo");
        em.persist(entity);
        LOGGER.info("Creando un contratista nuevo");
        return entity;
    }
    
    /**
     * Actualiza un contratista dado en la base de datos.
     * @param entity Objeto entity que se actualizará en la base de datos.
     * @return La entidad actualizada por la base de datos.
     */
    public ContratistaEntity update(ContratistaEntity entity)
    {
        LOGGER.log(Level.INFO, "Actualizando contratista con id={0}", entity.getId());
        return em.merge(entity);
    }
    
    /**
     * Borra el registro de un contratista en la base de datos.
     * @param id  Id del contratista a eliminar.
     */
    public void delete(Long id)
    {
        LOGGER.log(Level.INFO, "Borrando contratista con id={0}", id);
        ContratistaEntity entity = em.find(ContratistaEntity.class, id);
        em.remove( entity);
    }
    
    /**
     * Encuentra un contratista dado un id.
     * @param id Identificador del contratista a buscar.
     * @return Entidad del contratista buscado.
     */
    public ContratistaEntity find(Long id)
    {
        LOGGER.log(Level.INFO,"Consultando contratista con id={0}",id);
        return em.find(ContratistaEntity.class, id);
    }
    
    /**
     * Retorna todos los contratistas que se encuentren en la base de datos.
     * @return Lista de todos los contratistas de la base de datos.
     */
    public List<ContratistaEntity> findAll()
    {
        LOGGER.info("Consultando todos los contratistas");
        TypedQuery query = em.createQuery("select u from ContratistaEntity u", ContratistaEntity.class);
        return query.getResultList();
    }
}
