/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.dtos;

import co.edu.uniandes.nocompila.huecota.entities.EnProgresoEntity;
/**
 *
 * @author jpr.arango10
 */
public class EnProgresoDetailDTO extends EnProgresoDTO{
    
    public EnProgresoDetailDTO(){
}
        public EnProgresoDetailDTO(EnProgresoEntity entity) 
    {
        super(entity);
    }

    @Override
    public EnProgresoEntity toEntity() 
    {
        EnProgresoEntity HuecoE = super.toEntity();
        return HuecoE;
    }
    
}
