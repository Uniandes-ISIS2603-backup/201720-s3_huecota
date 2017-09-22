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
public class ClienteDetailDTO extends ClienteDTO{
    
    public ClienteDetailDTO(){
        
    }
    
    public ClienteDetailDTO(ClienteEntity entity){
        super(entity);
    }
    
    @Override
    public ClienteEntity toEntity(){
        ClienteEntity entity = super.toEntity();
        return entity;
    }
}
