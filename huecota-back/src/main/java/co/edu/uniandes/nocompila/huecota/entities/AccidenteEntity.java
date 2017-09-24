/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 *
 * @author ma.puentes
 */
@Entity
public class AccidenteEntity  extends BaseEntity implements Serializable
{
    @Temporal(TemporalType.DATE)
	private Date fecha;
	
	public Date getFecha()
	{
		return fecha;
	}
	public void setFecha(Date pFecha)
	{
		this.fecha = pFecha;
	}
	
	
}
