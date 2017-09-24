/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.dtos;

import co.edu.uniandes.nocompila.huecota.entities.EnProgresoEntity;
/**
 *
 * @author jpr.arango10
 */
public class EnProgresoDTO {
    
    private Long id;
    
    public EnProgresoDTO(){
        
    }
    
    public EnProgresoDTO(EnProgresoEntity cliente){
        this.id = (cliente.getId());
    }
    
    public Long getId(){
        return id;
    }
    
    public void setId(Long id){
        this.id = id;
    }
    
    public EnProgresoEntity toEntity(){
        EnProgresoEntity entity = new EnProgresoEntity();
        entity.setId(this.id);
        return entity;
    }
}
