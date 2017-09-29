/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.ejb;

import co.edu.uniandes.nocompila.huecota.entities.CuentaCobroEntity;
import co.edu.uniandes.nocompila.huecota.persistence.CuentaCobroPersistence;
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
public class CuentaCobroLogic
{
    private static final Logger LOGGER = Logger.getLogger(CuentaCobroLogic.class.getName());
    
    @Inject
    private CuentaCobroPersistence persistence;
    
    public CuentaCobroEntity crearCuentaCobro(CuentaCobroEntity entity)
    {
        LOGGER.info("Inicia el proceso de creación de una cuenta de cobro");
        CuentaCobroEntity toReturn = persistence.create(entity);
        LOGGER.info("Finaliza el proceso de creación de una cuenta de cobro");
        return toReturn;
    }
    
    public CuentaCobroEntity getCuentaCobro(Long id)
    {
        LOGGER.info("Inicia el proceso de consultar una cuenta de cobro");
        CuentaCobroEntity toReturn = persistence.find(id);
        LOGGER.info("Termina el proceso de consultar una cuenta de cobro");
        return toReturn;
    }
    
    public List<CuentaCobroEntity> getCuentasCobros()
    {
        LOGGER.info("Inicia el proceso de consultar todas las cuentas de cobro");
        List<CuentaCobroEntity> toReturn = persistence.findAll();
        LOGGER.info("Termina el proceso de consultar todas las cuentas de cobro");
        return toReturn;
    }
    
    public CuentaCobroEntity updateCuentaCobro(CuentaCobroEntity entity)
    {
        LOGGER.log(Level.INFO, "Inicia el proceso de actualizar la cuenta de cobro con id={0}", entity.getId());
        CuentaCobroEntity toReturn = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina el proceso de actualizar la cuenta de cobro con id={0}", entity.getId());
        return toReturn;
    }
    
    public void deleteCuentaCobroEntity(Long id)
    {
        LOGGER.log(Level.INFO, "Inicia el proceso de borrar cuenta de cobro con id={0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "termina el proceso de borrar cuenta de cobro con id={0}", id);
    }
}