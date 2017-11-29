/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author jpr.arango10
 */
@Entity
public class AbiertoEntity extends BaseEntity implements Serializable{
    
    /**
     * Número de huecos en estado abierto.
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaDeAbierto;
    
    @PodamExclude
    @OneToOne(orphanRemoval = true)
    private List<HuecoEntity> huecos;

    /**
     * Retorna el número de huecos en estado abierto.
     * @return numeroDeHuecos
     */
    public Date getFechaDeAbierto() {
        return fechaDeAbierto;
    }

    /**
     * Fija un número de huecos en estado abierto.
     * @param fechaDeAbierto 
     */
    public void setFechaDeAbierto(Date fechaDeAbierto) {
        this.fechaDeAbierto = fechaDeAbierto;
    }

    public List<HuecoEntity> getHuecos() {
        return huecos;
    }

    public void setHuecos(List<HuecoEntity> huecos) {
        this.huecos = huecos;
    }
    
    
}
