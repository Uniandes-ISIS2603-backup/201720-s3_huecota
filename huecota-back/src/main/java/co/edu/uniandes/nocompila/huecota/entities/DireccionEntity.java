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
/**
 *
 * @author ma.puentes
 */
@Entity
public class DireccionEntity extends BaseEntity implements Serializable
{

	/**
	 * Atributo de tipo Integer que representa el tipo de via en una dirección.
	 */
	private Integer tipoVia;
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

	
	public Integer getTipoVia() {
		return tipoVia;
	}

	public void setTipoVia(Integer tipoVia) {
		this.tipoVia = tipoVia;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
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

	public String getDireccionRaw() {
		return direccionRaw;
	}

	public void setDireccionRaw(String direccionRaw)
	{
		this.direccionRaw = direccionRaw;
	}
	
}

