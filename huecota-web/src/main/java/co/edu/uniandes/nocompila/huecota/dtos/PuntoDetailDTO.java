/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.dtos;

import co.edu.uniandes.nocompila.huecota.entities.PuntoEntity;

/**
 *
 * @author c.martinezc1
 */
public class PuntoDetailDTO extends PuntoDTO{
    public PuntoDetailDTO(){
        
    }
    
    public PuntoDetailDTO(PuntoEntity entity){
        super(entity);
    }
    
    @Override
    public PuntoEntity toEntity(){
        PuntoEntity entity = super.toEntity();
        return entity;
    }
}
