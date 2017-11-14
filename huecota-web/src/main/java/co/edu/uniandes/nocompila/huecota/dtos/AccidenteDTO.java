/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.dtos;

import co.edu.uniandes.nocompila.huecota.entities.AccidenteEntity;
import java.util.List;
import co.edu.uniandes.nocompila.huecota.entities.ClienteEntity;
import java.util.ArrayList;

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
	/**
	 * Descripcion del accidente.
	 */
	private String descripcion;
	
	/**
	 * Lista de ciudadanos
	 */
	
	private List<ClienteDTO> clientes;
	
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
		this.clientes = entidadADTO(Accidente.getClientes());
		
		
    }
	private List<ClienteDTO> entidadADTO(List<ClienteEntity> entityList)
	{
        List<ClienteDTO> list = new ArrayList();
        for (ClienteEntity entity : entityList)
		{
            list.add(new ClienteDTO(entity));
        }
        return list;
    }
	private List<ClienteEntity> DTOAentity(List<ClienteDTO> dtoList)
	{
        List<ClienteEntity> list = new ArrayList();
        for (ClienteDTO dtoActual : dtoList)
		{
            list.add(dtoActual.toEntity());
        }
        return list;
    }

	public List<ClienteDTO> getClientes() {
		return clientes;
	}

	public void setClientes(List<ClienteDTO> clientes) {
		this.clientes = clientes;
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
		entity.setClientes(DTOAentity(this.clientes));
        return entity;
    }
	    
}

