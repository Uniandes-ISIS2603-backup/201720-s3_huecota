/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

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
    
    @PodamExclude
    @OneToOne(orphanRemoval = true)
    private List<HuecoEntity> huecos;
    
    @PodamExclude
    @OneToOne(orphanRemoval = true)
    private List<CuentaCobroEntity> cuentaCobro;

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

    public List<HuecoEntity> getHuecos() {
        return huecos;
    }

    public void setHuecos(List<HuecoEntity> huecos) {
        this.huecos = huecos;
    }

    public List<CuentaCobroEntity> getCuentaCobro() {
        return cuentaCobro;
    }

    public void setCuentaCobro(List<CuentaCobroEntity> cuentaCobro) {
        this.cuentaCobro = cuentaCobro;
    }
    
    
    
    
}
