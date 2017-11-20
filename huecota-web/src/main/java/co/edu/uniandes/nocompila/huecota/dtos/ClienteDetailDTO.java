/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.dtos;

import co.edu.uniandes.nocompila.huecota.entities.AccidenteEntity;
import co.edu.uniandes.nocompila.huecota.entities.CalificacionEntity;
import co.edu.uniandes.nocompila.huecota.entities.ClienteEntity;
import co.edu.uniandes.nocompila.huecota.entities.HuecoEntity;
import co.edu.uniandes.nocompila.huecota.entities.PuntoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author c.martinezc1
 */
public class ClienteDetailDTO extends ClienteDTO{
    
    public ClienteDetailDTO(){
        
    }
    
    private List<PuntoDTO> puntos;
    
    private List<HuecoDTO> huecos;
    
    private List<CalificacionDTO> calificaciones;
    
    private List<AccidenteDTO> accidentes;
    
    public ClienteDetailDTO(ClienteEntity entity){
        super(entity);
        if (entity.getPuntos() != null) {
            puntos = new ArrayList<PuntoDTO>();
            for (PuntoEntity entityPunto : entity.getPuntos()) {
                puntos.add(new PuntoDTO(entityPunto));
            }
        }
        if (entity.getHuecos() != null) {
            huecos = new ArrayList<HuecoDTO>();
            for (HuecoEntity entityHueco : entity.getHuecos()) {
                huecos.add(new HuecoDTO(entityHueco));
            }
        }
        if (entity.getCalificaciones() != null) {
            calificaciones = new ArrayList<CalificacionDTO>();
            for (CalificacionEntity entityCalificacion : entity.getCalificaciones()) {
                calificaciones.add(new CalificacionDTO(entityCalificacion));
            }
        }
        if (entity.getAccidentes() != null) {
            accidentes = new ArrayList<AccidenteDTO>();
            for (AccidenteEntity entityAccidente : entity.getAccidentes()) {
                accidentes.add(new AccidenteDTO(entityAccidente));
            }
        }
    }
    
    public List<PuntoDTO> getPuntos(){
        return puntos;
    }
    
    public void setPuntos(List<PuntoDTO> puntos){
        this.puntos = puntos;
    }
    
    public List<HuecoDTO> getHuecos(){
        return huecos;
    }
    
    public void setHuecos(List<HuecoDTO> huecos){
        this.huecos = huecos;
    }
    
    public List<CalificacionDTO> getCalificaciones(){
        return calificaciones;
    }
    
    public void setCalificaciones(List<CalificacionDTO> calificaciones){
        this.calificaciones = calificaciones;
    }
    
    public List<AccidenteDTO> getAccidentes(){
        return accidentes;
    }
    
    public void setAccidentes(List<AccidenteDTO> accidentes){
        this.accidentes = accidentes;
    }
    
    
    @Override
    public ClienteEntity toEntity(){
        ClienteEntity entity = super.toEntity();
        if (getPuntos() != null) {
            List<PuntoEntity> pEntity = new ArrayList<PuntoEntity>();
            for (PuntoDTO pDto : getPuntos()) {
                pEntity.add(pDto.toEntity());
            }
            entity.setPuntos(pEntity);
        }
        if (getAccidentes() != null) {
            List<AccidenteEntity> aEntity = new ArrayList<AccidenteEntity>();
            for (AccidenteDTO aDto : getAccidentes()) {
                aEntity.add(aDto.toEntity());
            }
            entity.setAccidentes(aEntity);
        }
        if (getHuecos() != null) {
            List<HuecoEntity> hEntity = new ArrayList<HuecoEntity>();
            for (HuecoDTO hDto : getHuecos()) {
                hEntity.add(hDto.toEntity());
            }
            entity.setHuecos(hEntity);
        }
        if (getCalificaciones() != null) {
            List<CalificacionEntity> cEntity = new ArrayList<CalificacionEntity>();
            for (CalificacionDTO cDto : getCalificaciones()) {
                cEntity.add(cDto.toEntity());
            }
            entity.setCalificaciones(cEntity);
        }
        return entity;
    }
}
