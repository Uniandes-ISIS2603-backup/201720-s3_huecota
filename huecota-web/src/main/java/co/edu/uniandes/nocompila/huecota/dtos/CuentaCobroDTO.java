/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.dtos;

import co.edu.uniandes.nocompila.huecota.entities.CuentaCobroEntity;

/**
 *
 * @author lc.garavito
 */
public class CuentaCobroDTO
{
    private Long id;
    
    private String name;
    
    private double precio;
    
    public CuentaCobroDTO()
    {
    }
    
    public CuentaCobroDTO(CuentaCobroEntity entity)
    {
        this.id = entity.getId();
        this.name = entity.getName();
        this.precio = entity.getPrecio();
    }
    
    private String getName()
    {
        return name;
    }
    
    private void setName(String name)
    {
        this.name = name;
    }
    
    private Long getId()
    {
        return id;
    }
    
    public void setId(Long id)
    {
        this.id = id;
    }
    
    public double getPrecio()
    {
        return precio;
    }
    
    public void setPrecio(double precio)
    {
        this.precio = precio;
    }
    
    public CuentaCobroEntity toEntity()
    {
        CuentaCobroEntity toReturn = new CuentaCobroEntity();
        toReturn.setId(id);
        toReturn.setName(name);
        toReturn.setPrecio(precio);
        return toReturn;
    }
}
