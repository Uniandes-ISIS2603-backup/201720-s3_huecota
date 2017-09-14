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
public class ContratistaEntity extends BaseEntity implements  Serializable
{
    /**
     * Nombre del contratista.
     */
    private String name;
    
    /**
     * Retorna el nombre del contratista.
     * @return nombre del contratista.
     */
    public  String getName()
    {
        return name;
    }
    
    /**
     * Modifica el nombre del contratista.
     * @param name nuevo nombre del contratista.
     */
    public void setName(String name)
    {
        this.name = name;
    }
}
