/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author lc.garavito
 */
@Entity
public class CuentaCobroEntity extends BaseEntity implements Serializable
{
    /**
     * Valor de la cuenta de cobro.
     */
    private double precio;
    
    /**
     * Contratista encargado de la cuenta de cobro.
     */
    @PodamExclude
    @ManyToOne
    private ContratistaEntity contratista;
    
    /**
     * EstadoCerrado del hueco tapado.
     */
    @PodamExclude
    @OneToOne
    private CerradoEntity cerrado;
    
    /**
     * Retorna el precio de la cuenta de cobro.
     * @return precio de la cuenta de cobro.
     */
    public double getPrecio()
    {
        return precio;
    }
    
    /**
     * Modifica el valor de la cuenta de cobro.
     * @param precio nuevo valor de la cuenta de cobro.
     */
    public void setPrecio(double precio)
    {
        this.precio = precio;
    }
    
    /**
     * Retorna el contratista encargado de la cuenta de cobro.
     * @return Contratista encargado de la cuenta de cobro.
     */
    public ContratistaEntity getContratista()
    {
        return contratista;
    }
    
    /**
     * Modifica el contratista encargado de la cuenta de cobro.
     * @param contratista nuevo contratista encargado.
     */
    public void setContratista(ContratistaEntity contratista)
    {
        this.contratista = contratista;
    }
    
    /**
     * Retorna el estado Cerrado del hueco asociado.
     * @return estado Cerrado del hueco.
     */
    public CerradoEntity getCerrado()
    {
        return cerrado;
    }
    
    /**
     * Modifica el estado Cerrado del hueco asociado.
     * @param cerrado nuevo estado Cerrado.
     */
    public void setCerrado(CerradoEntity cerrado)
    {
        this.cerrado = cerrado;
    }
}
