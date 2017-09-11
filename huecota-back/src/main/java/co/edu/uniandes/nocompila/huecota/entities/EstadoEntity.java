/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.entities;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author jpr.arango10
 */
public class EstadoEntity extends BaseEntity implements Serializable{
    
    /**
     * Fecha en que se hizo el cambio de estado.
     */
    private Date fechaDeCambio;

    /**
     * Retorna la fecha de cambio.
     * @return fecha.
     */
    public Date getFechaDeCambio() {
        return fechaDeCambio;
    }

    /**
     * Fija la fecha de cambio.
     * @param fechaDeCambio 
     */
    public void setFechaDeCambio(Date fechaDeCambio) {
        this.fechaDeCambio = fechaDeCambio;
    }
    
}
