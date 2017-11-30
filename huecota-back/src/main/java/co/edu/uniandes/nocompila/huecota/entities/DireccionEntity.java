/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.entities;


/**
 *
 * @author ma.puentes
 */


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

@Entity
public class DireccionEntity extends BaseEntity implements Serializable
{
	@PodamExclude
    @OneToOne
    private ContratistaEntity contratista;
    
    @PodamExclude
    @OneToOne
    private HuecoEntity hueco;
	
	
	/**
	 * Atributo de tipo Integer que representa el tipo de via en una dirección.
	 */
	private String tipoVia;
	/**
	 * Atributo de tipo Integer que representa el numero en una dirección.
	 */
	private Integer numero;
	/**
	 * Atributo de tipo String que representa la letra en una dirección.
	 */
	private String letra;
	/**
	 * Atributo de tipo Integer que representa el cuadrante en una dirección.
	 */
	private Integer cuadrante;
	/**
	 * Atributo de tipo String que representa la concatenacion de todos loa tributos de la dirección.
	 */
	private String direccionRaw;

	public ContratistaEntity getContratista() {
		return contratista;
	}

	public void setContratista(ContratistaEntity contratista) {
		this.contratista = contratista;
	}

	public HuecoEntity getHueco() {
		return hueco;
	}

	public void setHueco(HuecoEntity hueco) {
		this.hueco = hueco;
	}


	public String getTipoVia()
	{
		return tipoVia;
	}

	public void setTipoVia(String tipoVia)
	{
		this.tipoVia = tipoVia;
	}

	public Integer getNumero()
	{
		return numero;
	}

	public void setNumero(Integer numero)
	{
		this.numero = numero;
	}

	public String getLetra()
	{
		return letra;
	}

	public void setLetra(String letra)
	{
		this.letra = letra;
	}

	public Integer getCuadrante()
	{
		return cuadrante;
	}

	public void setCuadrante(Integer cuadrante)
	{
		this.cuadrante = cuadrante;
	}

	public String getDireccionRaw()
	{
		return direccionRaw;
	}

	public void setDireccionRaw(String direccionRaw)
	{
		this.direccionRaw = direccionRaw;
	}
	
}

