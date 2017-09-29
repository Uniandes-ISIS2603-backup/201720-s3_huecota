/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.ejb;

import co.edu.uniandes.nocompila.huecota.entities.CerradoEntity;
import co.edu.uniandes.nocompila.huecota.exceptions.BusinessLogicException;
import co.edu.uniandes.nocompila.huecota.persistence.CerradoPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jpr.arango10
 */
@Stateless
public class CerradoLogic{
    
    private static final Logger LOGGER = Logger.getLogger(ClienteLogic.class.getName());

    @Inject
    private CerradoPersistence persistence;

    public CerradoEntity createState(CerradoEntity state) throws BusinessLogicException{
        persistence.create(state);
        return state;
    }

    public List<CerradoEntity> getStates() {
        List<CerradoEntity> states = persistence.findAll();
        return states;
    }
    
    public CerradoEntity getState(Long id) throws BusinessLogicException {
        return persistence.find(id);
    }

    public void deleteState(Long id) {
        persistence.delete(id);
                
    }
    
    public CerradoEntity updateState(CerradoEntity entity){
        LOGGER.log(Level.INFO, "Inicia el proceso de actualizar el estado con id={0}", entity.getId());
        CerradoEntity toReturn = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina el proceso de actualizar el estado con id={0}", entity.getId());
        return toReturn;
    }
}
