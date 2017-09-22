/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.dtos;

import co.edu.uniandes.nocompila.huecota.entities.ClienteEntity;

/**
 *
 * @author c.martinezc1
 */
public class ClienteDTO {
   
    private Long id;
    
    public ClienteDTO(){
        
    }
    
    public ClienteDTO(ClienteEntity cliente){
        this.id = (cliente.getId());
    }
    
    public Long getId(){
        return id;
    }
    
    public void setId(Long id){
        this.id = id;
    }
    
    public ClienteEntity toEntity(){
        ClienteEntity entity = new ClienteEntity();
        entity.setId(this.id);
        return entity;
    }
}
