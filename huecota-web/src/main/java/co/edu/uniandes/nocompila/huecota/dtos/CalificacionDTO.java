/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.dtos;

import co.edu.uniandes.nocompila.huecota.entities.CalificacionEntity;



/**
 *
 * @author le.viana
 */
public class CalificacionDTO {
    
    private Long id;
    
    private String name;
    
    private Integer nota;
    
    private String comentario;
    
    /**
     * Constructor por defecto.
     */
    public CalificacionDTO(){}
    
    
    /**
     * Convierte Entity a DTO
     * (Crea un nuevo DTO con los valores que recibe en la entidad que viene de argumento.)
     * @param calificacion la entidad que se va a convertir a DTO.
     */
    public CalificacionDTO(CalificacionEntity calificacion)
    {
        this.id = calificacion.getId();
        this.name = calificacion.getName();
        this.nota = calificacion.getNota();
        this.comentario = calificacion.getComentario();
    }
    
    /**
     * 
     * @return id
     */
    public Long getId(){
        return id;
    }
    
    /**
     * 
     * @param id id to set.
     */
    public void setId(Long id){
        this.id = id;
    }
    
    /**
     * 
     * @return name
     */
    public String getName(){
        return name;
    }
    
    /**
     * 
     * @param name to set.
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * 
     * @return to get.
     */
    public Integer getNota(){
        
        return nota;
    }
    
    /**
     * 
     * @param nota to set.
     */
    public void setNota(Integer nota){
        
        this.nota = nota;
    }
    
    /**
     * 
     * @return comentario to get
     */
    public String getComentario()
    {
        return comentario;
    }
    
    public void setComentario(String comentario)
    {
        this.comentario = comentario;
    }
    /**
     * Convertir DTO a Entity
     * @return  un Entity  con los valores del DTO.
     */
    public CalificacionEntity toEntity()
    {
        CalificacionEntity entity = new CalificacionEntity();
        entity.setId(id);
        entity.setName(name);
        entity.setNota(nota);
        entity.setComentario(comentario);
        return entity;
    }
}
