/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.dtos;

import co.edu.uniandes.nocompila.huecota.entities.AccidenteEntity;

/**
 *
 * @author ma.puentes
 */
public class AccidenteDTO
{
	
	
	/**
	 * Identificador del accidente.
	 */
	
    private Long id;
	/**
	 * Fecha del accidente
	 */
	private String fecha;
	private String descripcion;
    /**
     * Constructor por defecto
     */
    public AccidenteDTO() 
    {
		
    }

    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param Accidente: Es la entidad que se va a convertir a DTO
     */
    public AccidenteDTO(AccidenteEntity Accidente) 
    {
        this.id = Accidente.getId();
		this.fecha = Accidente.getFecha();
		this.descripcion = Accidente.getDescripcion();
		
    }

	public String getFecha()
	{
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    /**
     * Convertir DTO a Entity
     * @return Un Entity con los valores del DTO
     */
    public AccidenteEntity toEntity() 
    {
        AccidenteEntity entity = new AccidenteEntity();
        entity.setId(this.id);
		entity.setDescripcion(this.descripcion);
		entity.setFecha(this.fecha);
        return entity;
    }
	    
}

