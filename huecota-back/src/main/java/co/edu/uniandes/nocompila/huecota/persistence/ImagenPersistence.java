/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.persistence;
import co.edu.uniandes.nocompila.huecota.entities.ImagenEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author le.viana
 */
@Stateless
public class ImagenPersistence {
    
    private static final Logger LOGGER = Logger.getLogger(ImagenPersistence.class.getName());
    
    @PersistenceContext(unitName = "huecotaPU")
    protected EntityManager  em;
    
    /**
     * Crea una entidad imagen en la base de datos.
     * @param entity objeto Imagen que se crea en la base de datos.
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public ImagenEntity create(ImagenEntity entity)
    {
        LOGGER.info("Creando una imagen nueva");
        
        em.persist(entity);
        
        LOGGER.info("Creando una imagen nueva");
        return entity;
    }
    
    /**
     * Actualiza una imagen.
     * @param entity la imagen  que viene con los nuevos cambios.
     * @return una imagen con los cambios aplicados.
     */
    public ImagenEntity update(ImagenEntity entity)
    {
        LOGGER.log(Level.INFO, "Actualizando Imagen con id={0}", entity.getId());
        
        return em.merge(entity);
    }
    
    /**
     * Elimina una imagen de la base de datos recibiendo como argumento el id de la imagen.
     * @param id: id correspondiente a la imagen a borrar.
     */
    public void delete(Long id)
    {
        LOGGER.log(Level.INFO,"Eliminando imagen con id={0}",id);
        
        ImagenEntity entity = em.find(ImagenEntity.class,id);
        
        em.remove(entity);
    }
    
    /**
     * Busca si hay alguna imagen con el id que se envia de argumento.
     * @param id id correspondiente con la imagen buscada.
     * @return una imagen.
     */
    public ImagenEntity find(Long id)
    {
        LOGGER.log(Level.INFO, "Consultando imagen con id={0}",id);
        
        return em.find(ImagenEntity.class,id);
    }
    
    /**
     * Devuelve todas las imagenes de la base de datos
     * @return  una lista con todas las imagenes que encuente en la base de datos
     */
    public List<ImagenEntity> findAll()
    {
        LOGGER.info("Consultando todas las imagenes");
        
        TypedQuery query = em.createQuery("select u from ImagenEntity u", ImagenEntity.class);
        
        return query.getResultList();
    }
    
}
