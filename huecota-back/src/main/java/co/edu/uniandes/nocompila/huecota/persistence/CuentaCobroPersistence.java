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
    
    public CuentaCobroEntity create(CuentaCobroEntity entity)
    {
        LOGGER.info("Creando una cuenta de cobro nueva");
        em.persist(entity);
        LOGGER.info("Se creó una nueva cuenta de cobro");
        return entity;
    }
    
    public CuentaCobroEntity update(CuentaCobroEntity entity)
    {
        LOGGER.log(Level.INFO, "Actualizando Cuenta de Cobro con id={0}", entity.getId());
        return em.merge(entity);
    }
    
    public void delete(Long id)
    {
        LOGGER.log(Level.INFO, "Borrando Cuenta de Cobro con id={0}", id);
        CuentaCobroEntity entity = em.find(CuentaCobroEntity.class, id);
        em.remove(entity);
    }
    
    public CuentaCobroEntity find(Long id)
    {
        LOGGER.log(Level.INFO, "Consultando Cuenta de Cobro con id={0}", id);
        return em.find(CuentaCobroEntity.class, id);
    }
    
    public List<CuentaCobroEntity> findAll()
    {
        LOGGER.info("Consultando todas las cuentas de cobro");
        TypedQuery query = em.createQuery("select u from CuentaCobroEntity u", CuentaCobroEntity.class);
        return query.getResultList();
    }
}
