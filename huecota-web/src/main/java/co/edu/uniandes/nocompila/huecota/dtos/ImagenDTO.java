/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.dtos;

import co.edu.uniandes.nocompila.huecota.entities.ImagenEntity;

/**
 *
 * @author le.viana
 */
public class ImagenDTO {
    
    private String tipoArchivo;
    
    private Integer tamanio;
    
    private String foto;
    
    private String name;
    
    private Long id;
    
    public ImagenDTO(){}
    
    
    public ImagenDTO(ImagenEntity imagen)
    {
        if(imagen != null)
        {
        this.foto = imagen.getFoto();
        this.tamanio = imagen.getTamanio();
        this.tipoArchivo = imagen.getTipoArchivo();
        this.id = imagen.getId();
        this.name = imagen.getName();
        }
    }

    public String getTipoArchivo() {
        return tipoArchivo;
    }

    public void setTipoArchivo(String tipoArchivo) {
        this.tipoArchivo = tipoArchivo;
    }

    public Integer getTamanio() {
        return tamanio;
    }

    public void setTamanio(Integer tamanio) {
        this.tamanio = tamanio;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * Convertir DTO a Entity
     * @return  un Entity  con los valores del DTO.
     */
    public ImagenEntity toEntity()
    {
        ImagenEntity entity = new ImagenEntity();
        entity.setId(id);
        entity.setName(name);
        entity.setFoto(foto);
        entity.setTamanio(tamanio);
        entity.setTipoArchivo(tipoArchivo);
        
        return entity;
    }
}
