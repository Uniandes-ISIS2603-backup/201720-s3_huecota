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

    @PersistenceContext(unitName = "huecotaPU")
    protected EntityManager em;
    
   public PuntoEntity find(Long id){
         LOGGER.log(Level.INFO, "Consultando Punto con id={0}", id);
        return em.find(PuntoEntity.class, id);
    }
    
    public List<PuntoEntity> findAll(){
        TypedQuery q = em.createQuery("select u from PuntoEntity u",PuntoEntity.class);
        return q.getResultList();
        
    }
    
    public PuntoEntity create(PuntoEntity entity){
        em.persist(entity);
        return entity;
    }
    
    public PuntoEntity update(PuntoEntity punto){
        return em.merge(punto);
    }
    
    public void delete(Long id){
        LOGGER.log(Level.INFO, "Borrando accidente con id={0}", id);
        // Se hace uso de mismo m�todo que esta explicado en public AccidenteEntity find(Long id) para obtener el accidente a borrar.
        PuntoEntity entity = em.find(PuntoEntity.class, id);
         /* Note que una vez obtenido el objeto desde la base de datos llamado "entity", volvemos hacer uso de un método propio del
         EntityManager para eliminar de la base de datos el objeto que encontramos y queremos borrar.
         Es similar a "delete from AccidenteEntity where id=id;" - "DELETE FROM table_codigo WHERE condition;" en SQL.*/
        em.remove(entity);
    }
}
