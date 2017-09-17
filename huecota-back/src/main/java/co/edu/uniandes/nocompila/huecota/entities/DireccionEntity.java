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
	private Long x;
	private Long y;
	private Long z;
	private Integer idZona;
	private String direccionRaw;

	public Long getX() {
		return x;
	}

	public Long getY() {
		return y;
	}

	public Long getZ() {
		return z;
	}

	public Integer getIdZona() {
		return idZona;
	}

	public String getDireccionRaw() {
		return direccionRaw;
	}

	public void setX(Long x) {
		this.x = x;
	}

	public void setY(Long y) {
		this.y = y;
	}

	public void setZ(Long z) {
		this.z = z;
	}

	public void setIdZona(Integer idZona) {
		this.idZona = idZona;
	}

	public void setDireccionRaw(String direccionRaw) {
		this.direccionRaw = direccionRaw;
	}
	
	  
	
	
}

