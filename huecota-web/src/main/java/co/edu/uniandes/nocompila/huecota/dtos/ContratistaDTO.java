/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.dtos;

import co.edu.uniandes.nocompila.huecota.entities.ContratistaEntity;

/**
 *
 * @author lc.garavito
 */
public class ContratistaDTO 
{
    private String name;
    
    private Long id;
    
    public ContratistaDTO()
    {
        
    }
    
    public ContratistaDTO( ContratistaEntity entity )
    {
        name = entity.getName();
        id = entity.getId();
    }
    
    public  String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    
    public Long getId()
    {
        return id;
    }
    
    public void setId(Long id)
    {
        this.id = id;
    }
    
    public ContratistaEntity toEntity()
    {
        ContratistaEntity toReturn = new ContratistaEntity();
        toReturn.setId(this.id);
        toReturn.setName(this.name);
        return toReturn;
    }
}
