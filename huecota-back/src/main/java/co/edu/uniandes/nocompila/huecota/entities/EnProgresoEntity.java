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
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author jpr.arango10
 */
@Entity
public class EnProgresoEntity extends BaseEntity implements Serializable{
    
    /**
     * Fecha de inicio de tapado del hueco.
     */
    @Temporal(TemporalType.DATE)
    private Date fechaDeInicio;
    
    @PodamExclude
    @OneToOne    
    private List<HuecoEntity> huecos;

    /**
     * Retorna la fecha de inicio.
     * @return fechaDeInicio
     */
    public Date getFechaDeInicio() {
        return fechaDeInicio;
    }

    /**
     * Fija una fecha de inicio del tapado del hueco.
     * @param fechaDeInicio 
     */
    public void setFechaDeInicio(Date fechaDeInicio) {
        this.fechaDeInicio = fechaDeInicio;
    }

    public List<HuecoEntity> getHuecos() {
        return huecos;
    }

    public void setHuecos(List<HuecoEntity> huecos) {
        this.huecos = huecos;
    }
}
