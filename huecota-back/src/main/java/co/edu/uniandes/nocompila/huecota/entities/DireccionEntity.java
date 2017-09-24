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

	
	private Integer tipoVia;
	private Integer numero;
	private String letra;
	private Integer cuadrante;
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

	public Integer getCuadrante() {
		return cuadrante;
	}

	public void setCuadrante(Integer cuadrante) {
		this.cuadrante = cuadrante;
	}

	public String getDireccionRaw() {
		return direccionRaw;
	}

	public void setDireccionRaw(String direccionRaw) {
		this.direccionRaw = direccionRaw;
	}

	

	
}

