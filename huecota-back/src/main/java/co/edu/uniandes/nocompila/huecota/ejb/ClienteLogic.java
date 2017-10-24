/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.ejb;

import co.edu.uniandes.nocompila.huecota.entities.AccidenteEntity;
import co.edu.uniandes.nocompila.huecota.persistence.ClientePersistence;
import co.edu.uniandes.nocompila.huecota.exceptions.BusinessLogicException;
import co.edu.uniandes.nocompila.huecota.entities.ClienteEntity;
import co.edu.uniandes.nocompila.huecota.entities.HuecoEntity;
import co.edu.uniandes.nocompila.huecota.entities.PuntoEntity;

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
public class ClienteLogic {
    private static final Logger LOGGER = Logger.getLogger(ClienteLogic.class.getName());

    @Inject
    private ClientePersistence persistence;
    
    public ClienteEntity createCliente(ClienteEntity cliente)throws BusinessLogicException{
        
        persistence.create(cliente);
        return cliente;
    }
    
    public List<ClienteEntity> getClientes(){
        List<ClienteEntity> clientes = persistence.findAll();
        
        return clientes;
    }
    
    public ClienteEntity getCliente(Long id)throws BusinessLogicException{
        return persistence.find(id);
    }
    
    public void deleteCliente(Long id){
        persistence.delete(id);
    }

    public ClienteEntity updateCliente(Long id, ClienteEntity entity){
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar cliente con id={0}", id);
        ClienteEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar cliente con id={0}", entity.getId());
        return newEntity;
    }
    
    public List<PuntoEntity> listaPunto(Long clienteId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos los puntos del cliente con id = {0}", clienteId);
        return getCliente(clienteId).getPuntos();
    }
    
    public PuntoEntity getPunto(Long clienteId, Long accidenteId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar un punto del cliente con id = {0}", clienteId);
        List<PuntoEntity> list = getCliente(clienteId).getPuntos();
        PuntoEntity puntoEntity = new PuntoEntity();
        puntoEntity.setId(accidenteId);
        int index = list.indexOf(puntoEntity);
        if (index >= 0) {
            return list.get(index);
        }
        return null;
    }
    
     public PuntoEntity addPunto(Long clienteId, Long puntoId) {
        try {
            LOGGER.log(Level.INFO, "Inicia proceso de asociar un punto a un cliente con id = {0}", clienteId);
            ClienteEntity bookEntity = getCliente(clienteId);
            PuntoEntity puntoEntity = new PuntoEntity();
            puntoEntity.setId(puntoId);
            bookEntity.getPuntos().add(puntoEntity);
            return getPunto(clienteId, puntoId);
        } catch (BusinessLogicException ex) {
            Logger.getLogger(ClienteLogic.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Remplaza las instancias de Author asociadas a una instancia de Book
     *
     * @param clienteId Identificador de la instancia de Book
     * @param list Colección de instancias de AuthorEntity a asociar a instancia
     * de Book
     * @return Nueva colección de AuthorEntity asociada a la instancia de Book
     * 
     */
    public List<PuntoEntity> replacePuntos(Long clienteId, List<PuntoEntity> list) {
        try {
            LOGGER.log(Level.INFO, "Inicia proceso de reemplazar un punto del cliente con id = {0}", clienteId);
            ClienteEntity bookEntity = getCliente(clienteId);
            bookEntity.setPuntos(list);
            return bookEntity.getPuntos();
        } catch (BusinessLogicException ex) {
            Logger.getLogger(ClienteLogic.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Desasocia un Author existente de un Book existente
     *
     * @param clienteId Identificador de la instancia de Book
     * @param puntoId Identificador de la instancia de Author
     * 
     */
    public void removePunto(Long clienteId, Long puntoId) {
        try {
            LOGGER.log(Level.INFO, "Inicia proceso de borrar un punto del cliente con id = {0}", clienteId);
            ClienteEntity entity = getCliente(clienteId);
            PuntoEntity puntoEntity = new PuntoEntity();
            puntoEntity.setId(puntoId);
            entity.getPuntos().remove(puntoEntity);
        } catch (BusinessLogicException ex) {
            Logger.getLogger(ClienteLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public List<AccidenteEntity> listaAccidente(Long clienteId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos los accidentes del cliente con id = {0}", clienteId);
        return getCliente(clienteId).getAccidentes();
    }
    
    public AccidenteEntity getAccidente(Long clienteId, Long accidenteId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar un accidente del cliente con id = {0}", clienteId);
        List<AccidenteEntity> list = getCliente(clienteId).getAccidentes();
        AccidenteEntity accidenteEntity = new AccidenteEntity();
        accidenteEntity.setId(accidenteId);
        int index = list.indexOf(accidenteEntity);
        if (index >= 0) {
            return list.get(index);
        }
        return null;
    }
    
     public AccidenteEntity addAccidente(Long clienteId, Long accidenteId) {
        try {
            LOGGER.log(Level.INFO, "Inicia proceso de asociar un accidente al cliente con id = {0}", clienteId);
            ClienteEntity clienteEntity = getCliente(clienteId);
            AccidenteEntity accidenteEntity = new AccidenteEntity();
            accidenteEntity.setId(accidenteId);
            clienteEntity.getAccidentes().add(accidenteEntity);
            return getAccidente(clienteId, accidenteId);
        } catch (BusinessLogicException ex) {
            Logger.getLogger(ClienteLogic.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Remplaza las instancias de Author asociadas a una instancia de Book
     *
     * @param clienteId Identificador de la instancia de Book
     * @param list Colección de instancias de AuthorEntity a asociar a instancia
     * de Book
     * @return Nueva colección de AuthorEntity asociada a la instancia de Book
     * 
     */
    public List<AccidenteEntity> replaceAccidentes(Long clienteId, List<AccidenteEntity> list) {
        try {
            LOGGER.log(Level.INFO, "Inicia proceso de reemplazar un accidente del cliente con id = {0}", clienteId);
            ClienteEntity clienteEntity = getCliente(clienteId);
            clienteEntity.setAccidentes(list);
            return clienteEntity.getAccidentes();
        } catch (BusinessLogicException ex) {
            Logger.getLogger(ClienteLogic.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Desasocia un Author existente de un Book existente
     *
     * @param clienteId Identificador de la instancia de Book
     * @param accidenteId Identificador de la instancia de Author
     * 
     */
    public void removeAccidente(Long clienteId, Long accidenteId) {
        try {
            LOGGER.log(Level.INFO, "Inicia proceso de borrar un accidente del cliente con id = {0}", clienteId);
            ClienteEntity entity = getCliente(clienteId);
            AccidenteEntity accidenteEntity = new AccidenteEntity();
            accidenteEntity.setId(accidenteId);
            entity.getAccidentes().remove(accidenteEntity);
        } catch (BusinessLogicException ex) {
            Logger.getLogger(ClienteLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<HuecoEntity> listaHueco(Long clienteId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos los huecos del cliente con id = {0}", clienteId);
        return getCliente(clienteId).getHuecos();
    }
    
    public HuecoEntity getHueco(Long clienteId, Long huecoId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar un hueco del cliente con id = {0}", clienteId);
        List<HuecoEntity> list = getCliente(clienteId).getHuecos();
        HuecoEntity huecoEntity = new HuecoEntity();
        huecoEntity.setId(huecoId);
        int index = list.indexOf(huecoEntity);
        if (index >= 0) {
            return list.get(index);
        }
        return null;
    }
    
     public HuecoEntity addHueco(Long clienteId, Long huecoId) {
        try {
            LOGGER.log(Level.INFO, "Inicia proceso de asociar un hueco al cliente con id = {0}", clienteId);
            ClienteEntity clienteEntity = getCliente(clienteId);
            HuecoEntity huecoEntity = new HuecoEntity();
            huecoEntity.setId(huecoId);
            clienteEntity.getHuecos().add(huecoEntity);
            return getHueco(clienteId, huecoId);
        } catch (BusinessLogicException ex) {
            Logger.getLogger(ClienteLogic.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Remplaza las instancias de Author asociadas a una instancia de Book
     *
     * @param clienteId Identificador de la instancia de Book
     * @param list Colección de instancias de AuthorEntity a asociar a instancia
     * de Book
     * @return Nueva colección de AuthorEntity asociada a la instancia de Book
     * 
     */
    public List<HuecoEntity> replaceHuecos(Long clienteId, List<HuecoEntity> list) {
        try {
            LOGGER.log(Level.INFO, "Inicia proceso de reemplazar un hueco del cliente con id = {0}", clienteId);
            ClienteEntity clienteEntity = getCliente(clienteId);
            clienteEntity.setHuecos(list);
            return clienteEntity.getHuecos();
        } catch (BusinessLogicException ex) {
            Logger.getLogger(ClienteLogic.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Desasocia un Author existente de un Book existente
     *
     * @param clienteId Identificador de la instancia de Book
     * @param huecoId Identificador de la instancia de Author
     * 
     */
    public void removeHueco(Long clienteId, Long huecoId) {
        try {
            LOGGER.log(Level.INFO, "Inicia proceso de borrar un hueco del cliente con id = {0}", clienteId);
            ClienteEntity entity = getCliente(clienteId);
            HuecoEntity huecoEntity = new HuecoEntity();
            huecoEntity.setId(huecoId);
            entity.getHuecos().remove(huecoEntity);
        } catch (BusinessLogicException ex) {
            Logger.getLogger(ClienteLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
