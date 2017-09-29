/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author c.martinezc1
 */
@Entity
public class PuntoEntity extends BaseEntity implements Serializable {
   
    
    private int cantidad;
    
    @Temporal(TemporalType.DATE)
    private Date fecha;
   
    @ManyToOne
    @PodamExclude
    private ClienteEntity cliente;
    
    public PuntoEntity(){
        
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
    
    public ClienteEntity getCliente(){
        return cliente;
    }
    
    public void setCliente(ClienteEntity cliente){
        this.cliente = cliente;
    }

}
