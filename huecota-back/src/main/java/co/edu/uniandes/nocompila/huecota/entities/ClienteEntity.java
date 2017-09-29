/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;
/**
 *
 * @author c.martinezc1
 */
@Entity
public class ClienteEntity extends BaseEntity implements Serializable{
    
    
    private int cedula ;
    
    private int huecosRegistrados;
    
    private String nombre;
    
    @PodamExclude
    @OneToMany(cascade = CascadeType.REMOVE,orphanRemoval = true )
    private List<PuntoEntity> puntos;
    
    @PodamExclude
    @OneToMany 
    private List<CalificacionEntity> calificaciones;
    
    @PodamExclude
    @ManyToMany
    private List<HuecoEntity> huecos;
    
    @PodamExclude
    @ManyToMany
    private List<AccidenteEntity> accidentes;
    
    public ClienteEntity(){
        
    }
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
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public List<PuntoEntity> getPuntos(){
        return puntos;
    }
    
    public void setPuntos(List<PuntoEntity> puntos){
        this.puntos = puntos;
    }
    
    public List<HuecoEntity> getHuecos(){
        return huecos;
    }
    
    public void setHuecos(List<HuecoEntity> huecos){
        this.huecos = huecos;
    }
    
    public List<AccidenteEntity> getAccidentes(){
        return accidentes;
    }
    
    public void setAccidentes(List<AccidenteEntity> accidentes){
        this.accidentes = accidentes;
    }
    
    public List<CalificacionEntity> getCalificaciones(){
        return calificaciones;
    }
    
    public void setCalificaciones(List<CalificacionEntity> calificaciones){
        this.calificaciones = calificaciones;
    }
}
