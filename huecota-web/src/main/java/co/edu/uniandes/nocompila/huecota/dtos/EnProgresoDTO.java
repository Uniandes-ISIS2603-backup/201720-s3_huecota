/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.dtos;

import co.edu.uniandes.nocompila.huecota.entities.EnProgresoEntity;
import java.util.Date;
/**
 *
 * @author jpr.arango10
 */
public class EnProgresoDTO {
    
    private Long id;
    
    private Date fechaDeInicio;
    
    public EnProgresoDTO(){
        
    }
    
    public EnProgresoDTO(EnProgresoEntity state){
        this.id = (state.getId());
        this.fechaDeInicio = state.getFechaDeInicio();
    }
    
    public Long getId(){
        return id;
    }
    
    public void setId(Long id){
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaDeInicio;
    }

    public void setFechaInicio(Date fechaDeInicio) {
        this.fechaDeInicio = fechaDeInicio;
    }
    
    public EnProgresoEntity toEntity(){
        EnProgresoEntity entity = new EnProgresoEntity();
        entity.setId(this.id);
        entity.setFechaDeInicio(fechaDeInicio);
        return entity;
    }
}
