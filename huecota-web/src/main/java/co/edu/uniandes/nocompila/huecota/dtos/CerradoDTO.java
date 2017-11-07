/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.dtos;

import co.edu.uniandes.nocompila.huecota.entities.CerradoEntity;
import java.util.Date;
/**
 *
 * @author jpr.arango10
 */
public class CerradoDTO {
    
    private Long id;
    
    private String causa;
    
    private String comentario;
    
    private String fechaDeCerrado;
    
    public CerradoDTO(){
        
    }
    
    public CerradoDTO(CerradoEntity state){
        this.id = (state.getId());
        this.comentario = state.getComentario();
        this.causa = state.getCausa();
        this.fechaDeCerrado = state.getFechaDeCerrado();
    }

    public String getFechaDeCerrado() {
        return fechaDeCerrado;
    }

    public void setFechaDeCerrado(String fechaDeCerrado) {
        this.fechaDeCerrado = fechaDeCerrado;
    }
    
    public Long getId(){
        return id;
    }
    
    public void setId(Long id){
        this.id = id;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    public CerradoEntity toEntity(){
        CerradoEntity entity = new CerradoEntity();
        entity.setId(this.id);
        entity.setCausa(causa);
        entity.setComentario(comentario);
        entity.setFechaDeCerrado(fechaDeCerrado);
        return entity;
    }
}
