/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.ejb;

import co.edu.uniandes.nocompila.huecota.persistence.ClientePersistence;
import co.edu.uniandes.nocompila.huecota.exceptions.BusinessLogicException;
import co.edu.uniandes.nocompila.huecota.entities.ClienteEntity;

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
}
