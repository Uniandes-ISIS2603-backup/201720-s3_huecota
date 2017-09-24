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
public class CerradoDTO {
    
    private Long id;
    
    public CerradoDTO(){
        
    }
    
    public CerradoDTO(CerradoEntity cliente){
        this.id = (cliente.getId());
    }
    
    public Long getId(){
        return id;
    }
    
    public void setId(Long id){
        this.id = id;
    }
    
    public CerradoEntity toEntity(){
        CerradoEntity entity = new CerradoEntity();
        entity.setId(this.id);
        return entity;
    }
}
