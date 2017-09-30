/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
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
    private int numeroDeHuecos;
    
    @PodamExclude
    @OneToOne(orphanRemoval = true)
    private List<HuecoEntity> huecos;

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

    public List<HuecoEntity> getHuecos() {
        return huecos;
    }

    public void setHuecos(List<HuecoEntity> huecos) {
        this.huecos = huecos;
    }
    
    
}
