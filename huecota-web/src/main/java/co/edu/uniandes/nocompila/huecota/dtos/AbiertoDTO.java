/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.dtos;

import co.edu.uniandes.nocompila.huecota.entities.AbiertoEntity;
import java.util.Date;
/**
 *
 * @author jpr.arango10
 */
public class AbiertoDTO {
    
    private Long id;
    
    private Date fechaDeAbierto;
    
    public AbiertoDTO(){
        
    }
    
    public AbiertoDTO(AbiertoEntity state){
        this.id = (state.getId());
        this.fechaDeAbierto = state.getFechaDeAbierto();
    }
    
    public Long getId(){
        return id;
    }
    
    public void setId(Long id){
        this.id = id;
    }

    public Date getFechaDeAbierto() {
        return fechaDeAbierto;
    }

    public void setFechaDeAbierto(Date fechaDeAbierto) {
        this.fechaDeAbierto = fechaDeAbierto;
    }
    
    public AbiertoEntity toEntity(){
        AbiertoEntity entity = new AbiertoEntity();
        entity.setId(this.id);
        entity.setFechaDeAbierto(fechaDeAbierto);
        return entity;
    }
}
