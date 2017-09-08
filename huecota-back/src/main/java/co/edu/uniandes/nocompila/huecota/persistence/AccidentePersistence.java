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

    private static final Logger LOGGER = Logger.getLogger(HuecoPersistence.class.getName());

    @PersistenceContext(unitName = "huecotaPU")
    protected EntityManager em;

    /**
     *
     * @param entity objeto Hueco que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public AccidenteEntity create(AccidenteEntity entity)
	{
        LOGGER.info("Creando un accidente nuevo");
        /* Note que hacemos uso de un método propio de EntityManager para persistir la Hueco en la base de datos.
        Es similar a "INSERT INTO table_codigo (column1, column2, column3, ...) VALUES (value1, value2, value3, ...);" en SQL.
         */
        em.persist(entity);
        LOGGER.info("Creando un accidente nuevo");
        return entity;
    }

    /**
     * Actualiza un huecota.
     *
     * @param entity: la Hueco que viene con los nuevos cambios. Por ejemplo
     * el codigo pudo cambiar. En ese caso, se haria uso del método update.
     * @return un huecota con los cambios aplicados.
     */
    public AccidenteEntity update(AccidenteEntity entity)
	{
        LOGGER.log(Level.INFO, "Actualizando Hueco con id={0}", entity.getId());
        /* Note que hacemos uso de un método propio del EntityManager llamado merge() que recibe como argumento
        la Hueco con los cambios, esto es similar a 
        "UPDATE table_codigo SET column1 = value1, column2 = value2, ... WHERE condition;" en SQL.
         */
        return em.merge(entity);
    }

    /**
     *
     * Borra un huecota de la base de datos recibiendo como argumento el id
     * de la Hueco
     *
     * @param id: id correspondiente a la Hueco a borrar.
     */
    public void delete(Long id)
	{
        LOGGER.log(Level.INFO, "Borrando accidente con id={0}", id);
        // Se hace uso de mismo método que esta explicado en public HuecoEntity find(Long id) para obtener la Hueco a borrar.
        AccidenteEntity entity = em.find(AccidenteEntity.class, id);
        /* Note que una vez obtenido el objeto desde la base de datos llamado "entity", volvemos hacer uso de un método propio del
         EntityManager para eliminar de la base de datos el objeto que encontramos y queremos borrar.
         Es similar a "delete from HuecoEntity where id=id;" - "DELETE FROM table_codigo WHERE condition;" en SQL.*/
        em.remove(entity);
    }

    /**
     * Busca si hay algun huecota con el id que se envía de argumento
     *
     * @param id: id correspondiente al accidente buscado.
     * @return un accidente.
     */
    public AccidenteEntity find(Long id)
	{
        LOGGER.log(Level.INFO, "Consultando accidente con id={0}", id);
        /* Note que se hace uso del metodo "find" propio del EntityManager, el cual recibe como argumento 
        el tipo de la clase y el objeto que nos hara el filtro en la base de datos en este caso el "id"
        Suponga que es algo similar a "select * from HuecoEntity where id=id;" - "SELECT * FROM table_codigo WHERE condition;" en SQL.
         */
        return em.find(AccidenteEntity.class, id);
    }

    /**
     * Devuelve todas las Huecoes de la base de datos.
     *
     * @return una lista con todas las Huecoes que encuentre en la base de
     * datos, "select u from HuecoEntity u" es como un "select * from
     * HuecoEntity;" - "SELECT * FROM table_codigo" en SQL.
     */
    public List<AccidenteEntity> findAll()
	{
        LOGGER.info("Consultando todas las Huecoes");
        // Se crea un query para buscar todas las Huecoes en la base de datos.
        TypedQuery query = em.createQuery("select u from AccidenteEntity u", AccidenteEntity.class);
        // Note que en el query se hace uso del método getResultList() que obtiene una lista de Huecoes.
        return query.getResultList();
    }
}
