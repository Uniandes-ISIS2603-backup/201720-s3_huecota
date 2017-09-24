/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.dtos;

import co.edu.uniandes.nocompila.huecota.entities.AbiertoEntity;
/**
 *
 * @author jpr.arango10
 */
public class EnProgresoDTO {
    
    private Long id;
    
    public EnProgresoDTO(){
        
    }
    
    public EnProgresoDTO(AbiertoEntity cliente){
        this.id = (cliente.getId());
    }
    
    public Long getId(){
        return id;
    }
    
    public void setId(Long id){
        this.id = id;
    }
    
    public AbiertoEntity toEntity(){
        AbiertoEntity entity = new AbiertoEntity();
        entity.setId(this.id);
        return entity;
    }
}
