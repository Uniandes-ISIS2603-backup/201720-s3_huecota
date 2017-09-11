/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;

/**
 *
 * @author c.martinezc1
 */
@Entity
public class PuntoEntity extends BaseEntity implements Serializable {
    @id
    private Long id;
    
    private int cantidad;
    
    private Date fecha;
    
    public Long getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getCantidad(){
        return cantidad;
    }
    
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    
    public Date getFecha(){
        return date;
    }
    
    public void setFecha(Date fecha){
        this.fecha = fecha;
    }
}
