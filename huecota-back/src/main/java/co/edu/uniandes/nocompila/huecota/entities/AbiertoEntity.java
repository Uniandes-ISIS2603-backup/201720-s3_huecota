/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.entities;

import java.io.Serializable;

/**
 *
 * @author jpr.arango10
 */
public class AbiertoEntity extends BaseEntity implements Serializable{
    
    /**
     * Número de huecos en estado abierto.
     */
    private int numeroDeHuecos;

    /**
     * Retorna el número de huecos en estado abierto.
     * @return numeroDeHuecos
     */
    public int getNumeroDeHuecos() {
        return numeroDeHuecos;
    }

    /**
     * Fija un número de huecos en estado abierto.
     * @param numeroDeHuecos 
     */
    public void setNumeroDeHuecos(int numeroDeHuecos) {
        this.numeroDeHuecos = numeroDeHuecos;
    }
}
