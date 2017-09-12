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
    private double precio;
    public double getPrecio()
    {
        return precio;
    }
    public void setPrecio(double precio)
    {
        this.precio = precio;
    }
}
