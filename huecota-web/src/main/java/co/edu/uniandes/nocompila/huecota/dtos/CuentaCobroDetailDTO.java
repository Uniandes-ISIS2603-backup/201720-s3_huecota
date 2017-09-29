/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.dtos;

import co.edu.uniandes.nocompila.huecota.entities.CuentaCobroEntity;

/**
 *
 * @author lc.garavito
 */
public class CuentaCobroDetailDTO extends CuentaCobroDTO
{
    public CuentaCobroDetailDTO()
    {
    }
    
    public CuentaCobroDetailDTO(CuentaCobroEntity entity)
    {
        super (entity);
    }
    
    public CuentaCobroEntity toEntity()
    {
        CuentaCobroEntity toReturn = super.toEntity();
        return toReturn;
    }
}
