/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.persistence;

import co.edu.uniandes.nocompila.huecota.entities.ClienteEntity;
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
public class ClientePersistence {


    private static final Logger LOGGER = Logger.getLogger(HuecoPersistence.class.getName());

    @PersistenceContext(unitName = "huecotaPU")
    protected EntityManager em;
    
    public ClienteEntity find(Long id){
         LOGGER.log(Level.INFO, "Consultando Cliente con id={0}", id);
        return em.find(ClienteEntity.class, id);
    }
    
    public List<ClienteEntity> findAll(){
        TypedQuery q = em.createQuery("select u from ClienteEntity u",ClienteEntity.class);
        return q.getResultList();
        
    }
    
    public ClienteEntity create(ClienteEntity cliente){
        em.persist(cliente);
        return cliente;
    }
    
    public ClienteEntity update(ClienteEntity cliente){
        return em.merge(cliente);
    }
    
    public void delete(Long id){
LOGGER.log(Level.INFO, "Borrando cliente con id={0}", id);
        // Se hace uso de mismo m�todo que esta explicado en public ClienteEntity find(Long id) para obtener el cliente a borrar.
        ClienteEntity entity = em.find(ClienteEntity.class, id);
        /* Note que una vez obtenido el objeto desde la base de datos llamado "entity", volvemos hacer uso de un método propio del
         EntityManager para eliminar de la base de datos el objeto que encontramos y queremos borrar.
         Es similar a "delete from ClienteteEntity where id=id;" - "DELETE FROM table_codigo WHERE condition;" en SQL.*/
        em.remove(entity);    }
}
