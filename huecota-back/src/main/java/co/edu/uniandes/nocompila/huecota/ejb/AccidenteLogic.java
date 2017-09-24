/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.ejb;

import co.edu.uniandes.nocompila.huecota.entities.AccidenteEntity;
import co.edu.uniandes.nocompila.huecota.exceptions.BusinessLogicException;
import co.edu.uniandes.nocompila.huecota.persistence.AccidentePersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author ma.puentes
 */
@Stateless
public class AccidenteLogic
{

    private static final Logger LOGGER = Logger.getLogger(AccidenteLogic.class.getName());

    @Inject
    private AccidentePersistence persistence; // Variable para acceder a la persistencia de la aplicaci�n. Es una inyecci�n de dependencias.

    /**
     *
     * @param entity
     * @return
     * @throws BusinessLogicException
     */
    public AccidenteEntity createAccidente(AccidenteEntity entity) throws BusinessLogicException 
	{
        LOGGER.info("Inicia proceso de creaci�n de accidente");
        // Invoca la persistencia para crear el accidente
        persistence.create(entity);
        LOGGER.info("Termina proceso de creaci�n de un accidente");
        return entity;
    }

    /**
     * 
     * Obtener todos los accidentes existentes en la base de datos.
     *
     * @return una lista de accidentes.
     */
    public List<AccidenteEntity> getAccidentes()
	{
        LOGGER.info("Inicia proceso de consultar todos los accidentes");
        // Note que, por medio de la inyecci�n de dependencias se llama al m�todo "findAll()" que se encuentra en la persistencia.
        List<AccidenteEntity> accidentes = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas los accidentes");
        return accidentes;
    }
	
	public AccidenteEntity getAccidente(Long id)
    {
       AccidenteEntity answ = persistence.find(id);
        return answ;
    }
	public AccidenteEntity updateAccidente(AccidenteEntity entity)
    {
        AccidenteEntity answ = persistence.update(entity);
        return answ;
    }
	 public void deleteAccidente(Long id)
    {
        persistence.delete(id);
    }
}
