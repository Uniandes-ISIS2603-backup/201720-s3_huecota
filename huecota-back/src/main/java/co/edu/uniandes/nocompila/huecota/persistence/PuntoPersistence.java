/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.persistence;

import co.edu.uniandes.nocompila.huecota.entities.PuntoEntity;
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
    
    public PuntoEntity find(Long clienteid, Long puntoid) {
        TypedQuery<PuntoEntity> q = em.createQuery("select p from PuntoEntity p where (p.cliente.id = :clienteid) and (p.id = :puntoid)", PuntoEntity.class);
        q.setParameter("clienteid", clienteid);
        q.setParameter("puntoid", puntoid);
        return q.getSingleResult();
    }
    public PuntoEntity find(Long puntoid) {
        PuntoEntity entity = em.find(PuntoEntity.class, puntoid);
        return entity;
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
