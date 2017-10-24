/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author lc.garavito
 */
@Entity
public class ContratistaEntity extends BaseEntity implements  Serializable
{
    /**
     * Nombre del contratista.
     */
    private String name;
    
    /**
     * Cuentas de Cobro del contratista.
     */
    @PodamExclude
    @OneToMany(mappedBy = "contratista", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<CuentaCobroEntity> cuentasCobro = new ArrayList<CuentaCobroEntity>();
    
    /**
     * Estado EnProgreso del contratista.
     */
    @PodamExclude
    @OneToOne(orphanRemoval = true)
    private EnProgresoEntity enProgreso;
    
    /**
     * Direccion del hueco a tapar.
     */
    @PodamExclude
    @OneToOne
    private DireccionEntity direccion;

    /**
     * Retorna el nombre del contratista.
     * @return nombre del contratista.
     */
    public  String getName()
    {
        return name;
    }
    
    /**
     * Modifica el nombre del contratista.
     * @param name nuevo nombre del contratista.
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * Retorna las cuentas de cobro del contratista
     * @return Cuentas de cobro del contratista.
     */
    public List<CuentaCobroEntity> getCuentasCobro()
    {
        return cuentasCobro;
    }
    
    /**
     * Modifica las cuentas de cobro del contratista.
     * @param cuentasCobro nuevas cuentas de cobro.
     */
    public void setCuentasCobro(List<CuentaCobroEntity> cuentasCobro)
    {
        this.cuentasCobro = cuentasCobro;
    }
    
    /**
     * Retorna el estado EnProgreso del contratista.
     * @return Estado EnProgreso del contratista.
     */
    public EnProgresoEntity getEnProgreso()
    {
        return enProgreso;
    }
    
    /**
     * Modifica el estado EnProgreso del contratista.
     * @param enProgreso nuevo estado EnProgreso.
     */
    public void setEnProgreso(EnProgresoEntity enProgreso)
    {
        this.enProgreso = enProgreso;
    }

    /**
     * Retorna la Direccion del hueco a tapar.
     * @return Direccion del hueco a tapar.
     */
    public DireccionEntity getDireccion()
    {
        return direccion;
    }

    /**
     * Modifica la Direccion del hueco a tapar
     * @param direccion nueva Direccion.
     */
    public void setDireccion(DireccionEntity direccion)
    {
        this.direccion = direccion;
    }

}
