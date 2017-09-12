/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.persistence;

import co.edu.uniandes.nocompila.huecota.entities.CerradoEntity;
import co.edu.uniandes.nocompila.huecota.entities.CerradoEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author jpr.arango10
 */
@Stateless
public class CerradoPersistence {
    private static final Logger LOGGER = Logger.getLogger(AbiertoPersistence.class.getName());
        
    @PersistenceContext(unitName = "huecotaPU")
    protected EntityManager em;
    
     /**
     *
     * Crea una entidad de estado con la base de datos.
     * @param entity objeto accidente que se crea en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public CerradoEntity create(CerradoEntity entity)
	{
        LOGGER.info("Creando un estado nuevo");
        
        em.persist(entity);
        
        LOGGER.info("Creando un estado nuevo");
        
        return entity;
    }
    
     /**
     * Actualiza un estado.
     * @param entity el estado que viene con los nuevos cambios.
     * @return  un estado con los cambios aplicados
     */
    public CerradoEntity update(CerradoEntity entity)
    {
        LOGGER.log(Level.INFO, "Actualizando estado con id={0}", entity.getId());
        
        return em.merge(entity);
    }
    
    /**
     * Elimina un estado de la base de datos recibiendo como argumento el id del estado.
     * @param id: id correspondiente al estado a borrar.
     */
    public void delete(Long id)
    {
        LOGGER.log(Level.INFO, "Eliminando estado con id={0}", id);
        
        CerradoEntity entity = em.find(CerradoEntity.class, id);
        
        em.remove(entity);
    }
    
     /**
     * Busca si hay algun estado con el id que se envia de argumento.
     * @param id id correspondiente con la calificacion buscada.
     * @return un estado.
     */
    public CerradoEntity find(Long id)
    {
        LOGGER.log(Level.INFO, "Consultando estado con id={0}", id);
        
        return em.find(CerradoEntity.class, id);
    }
    
    /**
     * Devuelve todos los estados de la base de datos.
     * @return una lista con todos los estados que encuentre en la base de datos,
     */
    public List<CerradoEntity> findAll()
    {
        LOGGER.info("Consultando todos los estados abiertos");
        
        TypedQuery query = em.createNamedQuery("select u from CerradoEntity u", CerradoEntity.class);
        
        return query.getResultList();
    }
}

