/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.dtos;

import co.edu.uniandes.nocompila.huecota.entities.CerradoEntity;
/**
 *
 * @author jpr.arango10
 */
public class CerradoDetailDTO extends CerradoDTO{
    
    public CerradoDetailDTO(){
    }
    public CerradoDetailDTO(CerradoEntity entity) 
    {
        super(entity);
    }

    @Override
    public CerradoEntity toEntity() 
    {
        CerradoEntity HuecoE = super.toEntity();
        return HuecoE;
    }
    
}
