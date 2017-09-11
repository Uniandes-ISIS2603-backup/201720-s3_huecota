/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.ejb;

import co.edu.uniandes.baco.huecota.persistence.ClientePersistence;
import co.edu.uniandes.baco.huecota.exceptions.BusinessLogicException;

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
    private static final Logger LOGGER = Logger.getLogger(HuecoLogic.class.getName());

    @Inject
    private ClientePersistence persistence;
    
    public ClienteEntity createCliente(ClienteEntity cliente)throws BusinessLogicException{
        if(persistence.find(cliente.getCedula())!= null) throw BusinessLogicException;
        else persistence.create(cliente);
        return entity;
    }
    
    public List<ClienteEntity> getClientes(){
        List<CLienteEntity> clientes = persistence.findAll();
        
        return clientes;
    }
    
    public ClienteEntity getCliente(int id)throws BusinessLogicException{
        return persistence.find(id);
    }
}
