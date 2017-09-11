/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.persistence;

import co.edu.uniandes.nocompila.huecota.entities.PuntoEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 *
 * @author c.martinezc1
 */
@Stateless
public class PuntoPersistence {
    
    private static final Logger LOGGER = Logger.getLogger(HuecoPersistence.class.getName());

    @PersistenceContext(unitName = "puntoPU")
    protected EntityManager em;
    
   public PuntoEntity find(Long id){
         LOGGER.log(Level.INFO, "Consultando Punto con id={0}", id);
        return em.find(PuntoEntity.class, id);
    }
    
    public List<PuntoEntity> findAll(){
        TypedQuery q = em.createQuery("select u from PuntoEntity u",PuntoEntity.class);
        return q.getResultList();
        
    }
    
    public void create(PuntoEntity cliente){
        em.persist(cliente);
    }
    
    public PuntoEntity update(PuntoEntity punto){
        return em.merge(punto);
    }
    
    public void delete(Long id){
        PuntoEntity entity = em.find(PuntoEntity.class, id);
        em.remove(entity);
    }
}
