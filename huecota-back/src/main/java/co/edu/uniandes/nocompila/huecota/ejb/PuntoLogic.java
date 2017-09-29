/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.ejb;

import co.edu.uniandes.nocompila.huecota.entities.ClienteEntity;
import co.edu.uniandes.nocompila.huecota.exceptions.BusinessLogicException;
import co.edu.uniandes.nocompila.huecota.entities.PuntoEntity;
import co.edu.uniandes.nocompila.huecota.persistence.PuntoPersistence;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;
/**
 *
 * @author c.martinezc1
 */
@Stateless
public class PuntoLogic {
    private static final Logger LOGGER = Logger.getLogger(PuntoLogic.class.getName());

    @Inject
    private PuntoPersistence persistence;
    
    @Inject
    private ClienteLogic clienteLogic;
    
    public PuntoEntity createPunto(Long clienteid, PuntoEntity punto)throws BusinessLogicException{
       LOGGER.info("Inicia proceso de crear punto");
        ClienteEntity cliente = clienteLogic.getCliente(clienteid);
        punto.setCliente(cliente);
        return persistence.create(punto);
    }
    
    public List<PuntoEntity> getPuntos(Long clienteid) throws BusinessLogicException{
        LOGGER.info("Inicia proceso de consultar todos los puntos");
        ClienteEntity cliente = clienteLogic.getCliente(clienteid);
        if (cliente.getPuntos().isEmpty()) {
            throw new BusinessLogicException("El libro que consulta aún no tiene reviews");
        }
        return cliente.getPuntos();
    }
    
    public PuntoEntity getPunto(Long clienteid, Long puntoid)throws BusinessLogicException{
       try {
            return persistence.find(clienteid, puntoid);
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public void deletePunto(Long clienteid,Long puntoid) throws BusinessLogicException{
        LOGGER.info("Inicia proceso de borrar review");
        PuntoEntity old = getPunto(clienteid, puntoid);
        persistence.delete(old.getId());
    }
    
     public PuntoEntity updatePunto(Long clienteid, PuntoEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de actualizar punto");
        ClienteEntity cliente = clienteLogic.getCliente(clienteid);
        entity.setCliente(cliente);
        return persistence.update(entity);
    }
}
