/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.dtos;

import co.edu.uniandes.nocompila.huecota.entities.PuntoEntity;

/**
 *
 * @author c.martinezc1
 */
public class PuntoDTO {
    
    private Long id;
    
    public PuntoDTO(){
        
    }
    
    public PuntoDTO(PuntoEntity punto){
        this.id = (punto.getId());
    }
    
    public Long getId(){
        return id;
    }
    
    public void setId(Long id){
        this.id = id;
    }
    
    public PuntoEntity toEntity(){
        PuntoEntity entity = new PuntoEntity();
        entity.setId(this.id);
        return entity;
    }
}
