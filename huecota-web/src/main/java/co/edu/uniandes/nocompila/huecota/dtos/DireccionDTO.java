/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.dtos;

/**
 *
 * @author ma.puentes
 */

import co.edu.uniandes.nocompila.huecota.entities.DireccionEntity;

/**
 *
 * @author ma.puentes
 */
public class DireccionDTO
{
	
    private Long id;
	
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

    /**
     * Constructor por defecto
     */
    public DireccionDTO() 
    {
		
    }

    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param Direccion: Es la entidad que se va a convertir a DTO
     */
    public DireccionDTO(DireccionEntity pDireccion) 
    {
        this.id = pDireccion.getId();
		this.tipoVia = pDireccion.getTipoVia();
		this.letra = pDireccion.getLetra();
		this.numero = pDireccion.getNumero();
		this.cuadrante = pDireccion.getCuadrante();
		this.direccionRaw =pDireccion.getDireccionRaw();
		
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

    

    /**
     * Convertir DTO a Entity
     *
     * @return Un Entity con los valores del DTO
     */
    public DireccionDTO toEntity() 
    {
        DireccionDTO entity = new DireccionDTO();
        entity.setId(this.id);
		entity.setTipoVia(this.tipoVia);
		entity.setCuadrante(this.cuadrante);
		entity.setLetra(this.letra);
		entity.setNumero(this.numero);
		entity.setDireccionRaw(this.direccionRaw);
        return entity;
    }
    
}


