/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.dtos;

import co.edu.uniandes.nocompila.huecota.entities.ClienteEntity;

/**
 *
 * @author c.martinezc1
 */
public class ClienteDTO {
   
    private Long id;
    
    private String nombre;
    
    private int cedula;
    
    private int huecosRegistrados;
    
    public ClienteDTO(){
        
    }
    
    public ClienteDTO(ClienteEntity cliente){
        this.id = (cliente.getId());
        this.nombre = cliente.getNombre();
        this.cedula = cliente.getCedula();
    }
    
    public Long getId(){
        return id;
    }
    
    public void setId(Long id){
        this.id = id;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public int getCedula(){
        return cedula;
    }
    
    public void setCedula(int cedula){
        this.cedula = cedula;
    }
    
    public int getHuecosR(){
        return huecosRegistrados;
    }
    
    public void setHuecosR(int huecosRegistrados){
        this.huecosRegistrados = huecosRegistrados;
    }
    
    public ClienteEntity toEntity(){
        ClienteEntity entity = new ClienteEntity();
        entity.setId(this.id);
        entity.setCedula(this.cedula);
        entity.setNombre(this.nombre);
        entity.setHuecosRegistrados(huecosRegistrados);
        return entity;
    }
}
