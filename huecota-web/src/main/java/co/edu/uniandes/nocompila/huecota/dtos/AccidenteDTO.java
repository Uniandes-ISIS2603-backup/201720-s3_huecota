/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.dtos;

import co.edu.uniandes.nocompila.huecota.entities.AccidenteEntity;
import java.util.Date;

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
	private Date fecha;

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
    }

    /**
	 * Retorna el identificador del accidente.
     * @return id
     */
    public Long getId() 
    {
        return id;
    }
	/**
	 * Retorna la fecha del accidente.
	 * @return fecha
	 */
	public Date getDireccion()
	{
		return fecha;
	}

    /**
	 * Cambia el id por el id que recibe por parámetro.
     * @param id id a cambiar
     */
    public void setId(Long id) 
    {
        this.id = id;
    }
	/**
	 * Cambia la fecha por la fehca que recibe por parámetro.
     * @param fecha fecha a cambiar
     */
	public void setDate(Date fecha) 
    {
        this.fecha = fecha;
    }

    /**
     * Convertir DTO a Entity
     * @return Un Entity con los valores del DTO
     */
    public AccidenteEntity toEntity() 
    {
        AccidenteEntity entity = new AccidenteEntity();
        entity.setId(this.id);
		entity.setFecha(this.fecha);
        return entity;
    }
	    
}

