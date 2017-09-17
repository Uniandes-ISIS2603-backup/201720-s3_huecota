/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
/**
 *
 * @author c.martinezc1
 */
@Entity
public class ClienteEntity extends BaseEntity implements Serializable{
    
    
    
    private int cedula ;
    
    private int huecosRegistrados;
    
    private String nombre;
    
    
    public int getCedula(){
        return cedula;
    }
    
    public void setCedula(int cedula){
        this.cedula = cedula;
    }
    
    public int gethuecosRegistrados(){
        return huecosRegistrados;
    }
    
    public void setHuecosRegistrados(int huecosRegistrados){
        this.huecosRegistrados = huecosRegistrados;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void nombre(String nombre){
        this.nombre = nombre;
    }
}
