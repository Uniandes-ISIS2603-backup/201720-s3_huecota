/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.persistence;

import co.edu.uniandes.nocompila.huecota.entities.AccidenteEntity;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.logging.Level;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author ma.puentes
 */
@Stateless
public class AccidentePersistence
{

    private static final Logger LOGGER = Logger.getLogger(AccidentePersistence.class.getName());

    @PersistenceContext(unitName = "huecotaPU")
    protected EntityManager em;

    /**
     *
     * @param entity objeto accidente que se crea en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public AccidenteEntity create(AccidenteEntity entity)
	{
        LOGGER.info("Creando un accidente nuevo");
        em.persist(entity);
        LOGGER.info("Creando un accidente nuevo");
        return entity;
    }

    /**
     * Actualiza un accidente.
     *
     * @param entity: el accidente que viene con los nuevos cambios. Por ejemplo
     * el codigo pudo cambiar. En ese caso, se haria uso del m�todo update.
     * @return un accidente con los cambios aplicados.
     */
    public AccidenteEntity update(AccidenteEntity entity)
	{
        LOGGER.log(Level.INFO, "Actualizando accidente con id={0}", entity.getId());
        /* Note que hacemos uso de un método propio del EntityManager llamado merge() que recibe como argumento
        el accidente con los cambios, esto es similar a 
        "UPDATE table_codigo SET column1 = value1, column2 = value2, ... WHERE condition;" en SQL.
         */
        return em.merge(entity);
    }

    /**
     *
     * Borra un accidente de la base de datos recibiendo como argumento el id
     * de el accidente
     *
     * @param id: id correspondiente al accidente a borrar.
     */
    public void delete(Long id)
	{
        LOGGER.log(Level.INFO, "Borrando accidente con id={0}", id);
        // Se hace uso de mismo m�todo que esta explicado en public AccidenteEntity find(Long id) para obtener el accidente a borrar.
        AccidenteEntity entity = em.find(AccidenteEntity.class, id);
        /* Note que una vez obtenido el objeto desde la base de datos llamado "entity", volvemos hacer uso de un método propio del
         EntityManager para eliminar de la base de datos el objeto que encontramos y queremos borrar.
         Es similar a "delete from AccidenteEntity where id=id;" - "DELETE FROM table_codigo WHERE condition;" en SQL.*/
        em.remove(entity);
    }

    /**
     * Busca si hay algun accidente con el id que se envía de argumento
     *
     * @param id: id correspondiente al accidente buscado.
     * @return un accidente.
     */
    public AccidenteEntity find(Long id)
	{
        LOGGER.log(Level.INFO, "Consultando accidente con id={0}", id);
        /* Note que se hace uso del metodo "find" propio del EntityManager, el cual recibe como argumento 
        el tipo de la clase y el objeto que nos hara el filtro en la base de datos en este caso el "id"
        Suponga que es algo similar a "select * from AccidenteEntity where id=id;" - "SELECT * FROM table_codigo WHERE condition;" en SQL.
         */
        return em.find(AccidenteEntity.class, id);
    }

    /**
     * Devuelve todas las accidentes de la base de datos.
     *
     * @return una lista con todas los accidentes que encuentre en la base de
     * datos, "select u from AccidenteEntity u" es como un "select * from
     * AccidenteEntity;" - "SELECT * FROM table_codigo" en SQL.
     */
    public List<AccidenteEntity> findAll()
	{
        LOGGER.info("Consultando todos los accidentes");
        // Se crea un query para buscar todas los accidentes en la base de datos.
        TypedQuery query = em.createQuery("select u from AccidenteEntity u", AccidenteEntity.class);
        // Note que en el query se hace uso del método getResultList() que obtiene una lista de accidentes.
        return query.getResultList();
    }
}
