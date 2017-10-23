/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import uk.co.jemos.podam.common.PodamExclude;
/**
 *
 * @author ma.puentes
 */
@Entity
public class AccidenteEntity  extends BaseEntity implements Serializable
{
	/**
	 * Atributo que representa un cliente para la clase accidente.
	 */
	@PodamExclude
    @ManyToMany
    private List<ClienteEntity> clientes;
	
	/**
	 * Atributo que representa un cliente para la clase accidente.
	 */
    @PodamExclude
    @ManyToOne
	 private HuecoEntity hueco;

	/**
	 * Atributo que representa la fecha del accidente.
	 */
//    @Temporal(TemporalType.DATE)
	private String fecha;

	private String descripcion;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	public List<ClienteEntity> getClientes() {
		return clientes;
	}

	public void setClientes(List<ClienteEntity> clientes) {
		this.clientes = clientes;
	}
	public void addCliente(ClienteEntity cliente)
	{
		this.clientes.add(cliente);
	}

	public HuecoEntity getHueco() {
		return hueco;
	}

	public void setHueco(HuecoEntity hueco) {
		this.hueco = hueco;
	}
	
	/**
	 * Método que retorna la fecha.
	 * @return 
	 */
	public String getFecha()
	{
		return fecha;
	}
	/**
	 * M{etodo que cambia la fecha de la clase pro la que recibe por parámetro.
	 * @param pFecha 
	 */
	public void setFecha(String pFecha)
	{
		this.fecha = pFecha;
	}
	
	
}
