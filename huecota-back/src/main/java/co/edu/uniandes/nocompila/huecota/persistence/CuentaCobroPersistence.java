/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.persistence;

import co.edu.uniandes.nocompila.huecota.entities.CuentaCobroEntity;
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
public class CuentaCobroPersistence
{
    private static final Logger LOGGER = Logger.getLogger(CuentaCobroPersistence.class.getName());
    @PersistenceContext(unitName = "huecotaPU")
    protected EntityManager em;
    
    /**
     * Crea una nueva cuenta de cobro en la base de datos.
     * @param entity Objeto CuentaCobro que se creará en la base de datos.
     * @return La entidad creada con un id por la base de datos.
     */
    public CuentaCobroEntity create(CuentaCobroEntity entity)
    {
        LOGGER.info("Creando una cuenta de cobro nueva");
        em.persist(entity);
        LOGGER.info("Se creó una nueva cuenta de cobro");
        return entity;
    }
    
    
    /**
     * Actualiza una cuenta de cobro dada de la base de datos.
     * @param entity Objeto entity que se actualizará en la base de datos.
     * @return La entidad actualizada por la base de datos.
     */
    public CuentaCobroEntity update(CuentaCobroEntity entity)
    {
        LOGGER.log(Level.INFO, "Actualizando Cuenta de Cobro con id={0}", entity.getId());
        return em.merge(entity);
    }
    
    
    /**
     * Borra el registro de una cuenta de cobro de la base de datos.
     * @param id  Identificador de la cuenta de cobro a eliminar.
     */
    public void delete(Long id)
    {
        LOGGER.log(Level.INFO, "Borrando Cuenta de Cobro con id={0}", id);
        CuentaCobroEntity entity = em.find(CuentaCobroEntity.class, id);
        em.remove(entity);
    }
    
    
    /**
     * Encuentra una cuenta de cobro dado un id.
     * @param id Identificador de la cuenta de cobro a buscar.
     * @return Entidad de la cuenta de cobro buscada.
     */
    public CuentaCobroEntity find(Long id)
    {
        LOGGER.log(Level.INFO, "Consultando Cuenta de Cobro con id={0}", id);
        return em.find(CuentaCobroEntity.class, id);
    }
    
    
    /**
     * Retorna todas las cuentas de cobro de la base de datos.
     * @return Lista de todas las cuentas de cobro de la base de datos..
     */
    public List<CuentaCobroEntity> findAll()
    {
        LOGGER.info("Consultando todas las cuentas de cobro");
        TypedQuery query = em.createQuery("select u from CuentaCobroEntity u", CuentaCobroEntity.class);
        return query.getResultList();
    }
}
