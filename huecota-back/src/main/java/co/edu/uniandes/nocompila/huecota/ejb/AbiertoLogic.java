/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.ejb;

import co.edu.uniandes.nocompila.huecota.entities.AbiertoEntity;
import co.edu.uniandes.nocompila.huecota.exceptions.BusinessLogicException;
import co.edu.uniandes.nocompila.huecota.persistence.AbiertoPersistence;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jpr.arango10
 */
@Stateless
public class AbiertoLogic{
    
    private static final Logger LOGGER = Logger.getLogger(ClienteLogic.class.getName());

    @Inject
    private AbiertoPersistence persistence;

    public AbiertoEntity createState(AbiertoEntity state) throws BusinessLogicException{
        persistence.create(state);
        return state;
    }

    public List<AbiertoEntity> getStates() {
        List<AbiertoEntity> states = persistence.findAll();
        return states;
    }
    
    public AbiertoEntity getState(Long id) throws BusinessLogicException {
        return persistence.find(id);
    }

    public void deleteState(Long id) {
        persistence.delete(id);
    }    
}
