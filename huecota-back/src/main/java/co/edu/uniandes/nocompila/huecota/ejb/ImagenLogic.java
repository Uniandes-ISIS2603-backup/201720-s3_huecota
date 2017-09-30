/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.ejb;

import co.edu.uniandes.nocompila.huecota.entities.ImagenEntity;
import co.edu.uniandes.nocompila.huecota.exceptions.BusinessLogicException;
import co.edu.uniandes.nocompila.huecota.persistence.ImagenPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author le.viana
 */
@Stateless
public class ImagenLogic {
    
    private static final Logger LOGGER = Logger.getLogger(ImagenLogic.class.getName());
    
    @Inject
    private ImagenPersistence persistence;
    
    /**
     * 
     * @param entity entidad a crear.
     * @return la entidad que se creo.
     *  
     */
    public ImagenEntity createImagen(ImagenEntity entity)
    {
        LOGGER.info("Inicia proceso de creacion de imagen");
        //Invoca la persistencia para crear la imagen
        persistence.create(entity);
        LOGGER.info("Termina proceso de creacion de una imagen");
        return entity;
    }
    
    /**
     * Obtiene todas las imagenes
     * @return las imagenes consultadas.
     */
    public List<ImagenEntity> getImagenes()
    {
        LOGGER.info("Inicia proceso de consultar todas las imagenes");
        List<ImagenEntity> imagenes = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas las imagenes");
        return imagenes;
    }
    
    /**
     * 
     * @param id el identificador de la imagen.
     * @return la imagen consultada.
     */
    public ImagenEntity getImagen(Long id)
    {
        ImagenEntity imagen = persistence.find(id);
        return imagen;
    }
    
    /**
     * 
     * @param entity por la cual se va a remplazar
     * @return imagen remplazada.
     */
    public ImagenEntity updateImagen(ImagenEntity entity)
    {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar la imagen con id={0}", entity.getId());
        ImagenEntity imagen = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina el proceso de actualizar la imagen con id= {0}", entity.getId());
        return imagen;
    }
    
    /**
     * elimina una imagen de la base de datos.
     * @param id identificador de la imagen.
     */
    public void deleteImagenEntity(Long id)
    {
        LOGGER.log(Level.INFO, "Inicia el proceso de borrar imagen con id = {0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "termina el proceso de borrar imagen con id={0}",id);
    }
}
