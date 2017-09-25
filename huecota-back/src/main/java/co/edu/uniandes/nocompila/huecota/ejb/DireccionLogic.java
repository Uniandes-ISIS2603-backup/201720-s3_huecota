
package co.edu.uniandes.nocompila.huecota.ejb;

import co.edu.uniandes.nocompila.huecota.entities.AccidenteEntity;
import co.edu.uniandes.nocompila.huecota.entities.DireccionEntity;
import co.edu.uniandes.nocompila.huecota.exceptions.BusinessLogicException;
import co.edu.uniandes.nocompila.huecota.persistence.DireccionPersistence;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;


/**
 *
 * @author ma.puentes
 */
@Stateless
public class DireccionLogic
{

    private static final Logger LOGGER = Logger.getLogger(HuecoLogic.class.getName());

    @Inject
    private DireccionPersistence persistence; // Variable para acceder a la persistencia de la aplicaci�n. Es una inyecci�n de dependencias.

    /**
     *
     * @param entity
     * @return
     * @throws BusinessLogicException
     */
    public DireccionEntity createDireccion(DireccionEntity entity) throws BusinessLogicException 
	{
        LOGGER.info("Inicia proceso de creaci�n de una direccion");
        // Invoca la persistencia para crear la direccion
        persistence.create(entity);
        LOGGER.info("Termina proceso de creaci�n de una direccion");
        return entity;
    }

    /**
     * 
     * Obtener todas las Direcciones existentes en la base de datos.
     *
     * @return una lista de direcciones.
     */
    public List<DireccionEntity> getDirecciones()
	{
        LOGGER.info("Inicia proceso de consultar todos las direcciones");
        // Note que, por medio de la inyecci�n de dependencias se llama al m�todo "findAll()" que se encuentra en la persistencia.
        List<DireccionEntity> direcciones = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas las direcciones");
        return direcciones;
    }
	
	public DireccionEntity getDireccion(Long id)
    {
       DireccionEntity answ = persistence.find(id);
       return answ;
    }
	public DireccionEntity updateDireccion(DireccionEntity entity)
    {
        DireccionEntity answ = persistence.update(entity);
        return answ;
    }
	 public void deleteDireccion(Long id)
    {
        persistence.delete(id);
    }
}

