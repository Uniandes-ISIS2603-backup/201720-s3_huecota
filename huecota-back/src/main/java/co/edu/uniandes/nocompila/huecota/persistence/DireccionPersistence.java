package co.edu.uniandes.nocompila.huecota.persistence;

import co.edu.uniandes.nocompila.huecota.entities.DireccionEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author ma.puentes
 */

@Stateless
public class DireccionPersistence
{

    private static final Logger LOGGER = Logger.getLogger(DireccionPersistence.class.getName());

    @PersistenceContext(unitName = "huecotaPU")
    protected EntityManager em;

    /**
     *
     * @param entity objeto direccion que se crea en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public DireccionEntity create(DireccionEntity entity)
	{
        LOGGER.info("Creando una direccion nueva");
        em.persist(entity);
        return entity;
    }

    /**
     * Actualiza una direccion.
     *
     * @param entity: el direccion que viene con los nuevos cambios. Por ejemplo
     * el codigo pudo cambiar. En ese caso, se haria uso del método update.
     * @return una direccion con los cambios aplicados.
     */
    public DireccionEntity update(DireccionEntity entity)
	{
        LOGGER.log(Level.INFO, "Actualizando una direccion con id={0}", entity.getId());
        return em.merge(entity);
    }

    /**
     *
     * Borra una direccion de la base de datos recibiendo como argumento el id
     * de la direccion.
     *
     * @param id: id correspondiente a la direccion a borrar.
     */
    public void delete(Long id)
	{
        LOGGER.log(Level.INFO, "Borrando direccion con id={0}", id);
        DireccionEntity entity = em.find(DireccionEntity.class, id);
        em.remove(entity);
    }

    /**
     * Busca si hay alguna direccion con el id que se envía de argumento.
     * @param id: id correspondiente al direccion buscado.
     * @return un direccion.
     */
    public DireccionEntity find(Long id)
	{
        return em.find(DireccionEntity.class, id);
    }

    /**
     * Devuelve todas las direcciones de la base de datos.
     *
     * @return una lista con todas los direccion que encuentre en la base de
     * datos, "select u from DireccionEntity u" es como un "select * from
     * DireccionnteEntity;" - "SELECT * FROM table_codigo" en SQL.
     */
    public List<DireccionEntity> findAll()
	{
        TypedQuery query = em.createQuery("select u from DireccionEntity u", DireccionEntity.class);
        return query.getResultList();
    }
}
