/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.dtos;

import co.edu.uniandes.nocompila.huecota.entities.AbiertoEntity;
/**
 *
 * @author jpr.arango10
 */
public class AbiertoDetailDTO extends AbiertoDTO{
    
    public AbiertoDetailDTO(){
}
        public AbiertoDetailDTO(AbiertoEntity entity) 
    {
        super(entity);
    }

    @Override
    public AbiertoEntity toEntity() 
    {
        AbiertoEntity HuecoE = super.toEntity();
        return HuecoE;
    }
    
}
