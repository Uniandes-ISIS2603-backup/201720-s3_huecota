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
public class AbiertoDTO {
    
    private Long id;
    
    private int numeroDeHuecos;
    
    public AbiertoDTO(){
        
    }
    
    public AbiertoDTO(AbiertoEntity state){
        this.id = (state.getId());
        this.numeroDeHuecos = state.getNumeroDeHuecos();
    }
    
    public Long getId(){
        return id;
    }
    
    public void setId(Long id){
        this.id = id;
    }

    public int getNumeroDeHuecos() {
        return numeroDeHuecos;
    }

    public void setNumeroDeHuecos(int numeroDeHuecos) {
        this.numeroDeHuecos = numeroDeHuecos;
    }
    
    public AbiertoEntity toEntity(){
        AbiertoEntity entity = new AbiertoEntity();
        entity.setId(this.id);
        entity.setNumeroDeHuecos(numeroDeHuecos);
        return entity;
    }
}
