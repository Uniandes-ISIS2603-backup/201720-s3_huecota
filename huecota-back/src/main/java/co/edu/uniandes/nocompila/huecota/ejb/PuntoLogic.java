/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.ejb;

import co.edu.uniandes.nocompila.huecota.exceptions.BusinessLogicException;
import co.edu.uniandes.nocompila.huecota.entities.PuntoEntity;
import co.edu.uniandes.nocompila.huecota.persistence.PuntoPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
/**
 *
 * @author c.martinezc1
 */
@Stateless
public class PuntoLogic {
    private static final Logger LOGGER = Logger.getLogger(PuntoLogic.class.getName());

    @Inject
    private PuntoPersistence persistence;
    
    public PuntoEntity createPunto(PuntoEntity punto)throws BusinessLogicException{
        persistence.create(punto);
        return punto;
    }
    
    public List<PuntoEntity> getPuntos(){
        List<PuntoEntity> puntos = persistence.findAll();
        
        return puntos;
    }
    
    public PuntoEntity getPunto(Long id)throws BusinessLogicException{
        return persistence.find(id);
    }
    
    public void deletePunto(Long id){
        persistence.delete(id);
    }
    
    public PuntoEntity updatePunto(Long id, PuntoEntity entity){
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar punto con id={0}", id);
        PuntoEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar punto con id={0}", entity.getId());
        return newEntity;
    }
}
