/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.ejb;

import co.edu.uniandes.nocompila.huecota.entities.EnProgresoEntity;
import co.edu.uniandes.nocompila.huecota.exceptions.BusinessLogicException;
import co.edu.uniandes.nocompila.huecota.persistence.EnProgresoPersistence;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jpr.arango10
 */
@Stateless
public class EnProgresoLogic{
    
    private static final Logger LOGGER = Logger.getLogger(ClienteLogic.class.getName());

    @Inject
    private EnProgresoPersistence persistence;

    public EnProgresoEntity createState(EnProgresoEntity state) throws BusinessLogicException{
        persistence.create(state);
        return state;
    }

    public List<EnProgresoEntity> getStates() {
        List<EnProgresoEntity> states = persistence.findAll();
        return states;
    }
    
    public EnProgresoEntity getState(Long id) throws BusinessLogicException {
        return persistence.find(id);
    }

    public void deleteState(Long id) {
        persistence.delete(id);
                
    }    
}
