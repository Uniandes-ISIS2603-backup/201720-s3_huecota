/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.entities;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author lc.garavito
 */
@Entity
public class CuentaCobroEntity extends BaseEntity implements Serializable
{
    /**
     * Valor de la cuenta de cobro.
     */
    private double precio;
    
    /**
     * Retorna el precio de la cuenta de cobro.
     * @return precio de la cuenta de cobro.
     */
    public double getPrecio()
    {
        return precio;
    }
    
    /**
     * Modifica el valor de la cuenta de cobro.
     * @param precio nuevo valor de la cuenta de cobro.
     */
    public void setPrecio(double precio)
    {
        this.precio = precio;
    }
}
