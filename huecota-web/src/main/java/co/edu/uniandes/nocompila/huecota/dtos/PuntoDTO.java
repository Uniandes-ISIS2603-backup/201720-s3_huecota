/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.dtos;

import co.edu.uniandes.nocompila.huecota.entities.PuntoEntity;
import java.util.Date;

/**
 *
 * @author c.martinezc1
 */
public class PuntoDTO {
    
    private Long id;
    
    private int cantidad;
    
    private Date fecha;
    
    public PuntoDTO(){
        
    }
    
    public PuntoDTO(PuntoEntity punto){
        this.id = (punto.getId());
        this.cantidad = (punto.getCantidad());
        this.fecha = (punto.getFecha());
    }
    
    public Long getId(){
        return id;
    }
    
    public void setId(Long id){
        this.id = id;
    }
    
    public int getCantidad(){
        return cantidad;
    }
    
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    
    public Date getFecha(){
        return fecha;
    }
    
    public void setFecha(Date fecha){
        this.fecha = fecha;
    }
    
    public PuntoEntity toEntity(){
        PuntoEntity entity = new PuntoEntity();
        entity.setId(this.id);
        entity.setCantidad(this.cantidad);
        entity.setFecha(this.fecha);
        return entity;
    }
}
