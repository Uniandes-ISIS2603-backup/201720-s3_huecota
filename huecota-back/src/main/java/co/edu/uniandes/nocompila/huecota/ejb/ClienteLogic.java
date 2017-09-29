/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.ejb;

import co.edu.uniandes.nocompila.huecota.persistence.ClientePersistence;
import co.edu.uniandes.nocompila.huecota.exceptions.BusinessLogicException;
import co.edu.uniandes.nocompila.huecota.entities.ClienteEntity;
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
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos los accidentes del cliente con id = {0}", clienteId);
        return getCliente(clienteId).getPuntos();
    }
    
    public PuntoEntity getPunto(Long clienteId, Long accidenteId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar un accidente del cliente con id = {0}", clienteId);
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
            LOGGER.log(Level.INFO, "Inicia proceso de asociar un autor al libro con id = {0}", clienteId);
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
    public void removeAuthor(Long clienteId, Long puntoId) {
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
    
    
}
