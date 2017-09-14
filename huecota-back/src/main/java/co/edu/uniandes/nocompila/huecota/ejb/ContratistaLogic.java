/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.ejb;

import co.edu.uniandes.nocompila.huecota.entities.ContratistaEntity;
import co.edu.uniandes.nocompila.huecota.persistence.ContratistaPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author lc.garavito
 */
@Stateless
public class ContratistaLogic
{
    private static final Logger LOGGER = Logger.getLogger(ContratistaLogic.class.getName());
    
    @Inject
    private ContratistaPersistence persistence;
    
    public ContratistaEntity crearContratista(ContratistaEntity entity)
    {
        LOGGER.info("Inicia el proceso de creación de un contratista");
        ContratistaEntity toReturn = persistence.create(entity);
        LOGGER.info("Finaliza el proceso de creación de un contratista");
        return toReturn;
    }
    
    public ContratistaEntity getContratista(Long id)
    {
        LOGGER.info("Inicia el proceso de consultar un contratista");
        ContratistaEntity toReturn = persistence.find(id);
        LOGGER.info("Termina el proceso de consultar un contratista");
        return toReturn;
    }
    
    public List<ContratistaEntity> getContratistas()
    {
        LOGGER.info("Inicia el proceso de consultar todos los contratistas");
        List<ContratistaEntity> toReturn = persistence.findAll();
        LOGGER.info("Termina el proceso de consultar todos los contratistas");
        return toReturn;
    }
    
    public ContratistaEntity updateContratista(ContratistaEntity entity)
    {
        LOGGER.log(Level.INFO, "Inicia el proceso de actualizar el contratista con id={0}", entity.getId());
        ContratistaEntity toReturn = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina el proceso de actualizar el contratista con id={0}", entity.getId());
        return toReturn;
    }
    
    public void deleteContratistaEntity(Long id)
    {
        LOGGER.log(Level.INFO, "Inicia el proceso de borrar contratista con id={0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "termina el proceso de borrar contratista con id={0}", id);
    }
}
