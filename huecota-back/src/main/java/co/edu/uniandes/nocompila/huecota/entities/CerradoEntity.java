/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.entities;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author jpr.arango10
 */
@Entity
public class CerradoEntity extends BaseEntity implements Serializable {
    
    /**
     * Causa de cerramiento.
     */
    private String causa;
    
    /**
     * Comentario del cambio de estado.
     */
    private String comentario;

    /**
     * Retorna el comentario asociado al hueco cerrado.
     * @return comentario
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * Fija un comentario al hueco cerrado.
     * @param comentario 
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     * Retorna la causa del cerramiento del hueco.
     * @return causa
     */
    public String getCausa() {
        return causa;
    }

    /**
     * Fija una causa de cerramiento del hueco.
     * @param causa 
     */
    public void setCausa(String causa) {
        this.causa = causa;
    }
}
