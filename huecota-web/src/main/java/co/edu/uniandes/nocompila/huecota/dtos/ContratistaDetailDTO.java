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
public class ContratistaDetailDTO extends ContratistaDTO
{
    public ContratistaDetailDTO()
    {
    }
    
    public ContratistaDetailDTO(ContratistaEntity entity)
    {
        super(entity);
    }
    
    public ContratistaEntity toEntity()
    {
        ContratistaEntity toReturn = super.toEntity();
        return toReturn;
    }
}
