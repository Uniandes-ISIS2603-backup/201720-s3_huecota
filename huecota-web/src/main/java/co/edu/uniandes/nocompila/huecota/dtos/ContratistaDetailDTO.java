/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.dtos;

import co.edu.uniandes.nocompila.huecota.entities.ContratistaEntity;
import co.edu.uniandes.nocompila.huecota.entities.CuentaCobroEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lc.garavito
 */
public class ContratistaDetailDTO extends ContratistaDTO
{
    private List<CuentaCobroDTO> cuentasCobro;
    
    public ContratistaDetailDTO()
    {
    }
    
    public ContratistaDetailDTO(ContratistaEntity entity)
    {
        super(entity);
        if(entity.getCuentasCobro()!=null)
        {
            cuentasCobro=new ArrayList<CuentaCobroDTO>();
            for(CuentaCobroEntity cuentasEntity : entity.getCuentasCobro())
                cuentasCobro.add(new CuentaCobroDTO(cuentasEntity));
        }
    }
    
    @Override
    public ContratistaEntity toEntity()
    {
        ContratistaEntity toReturn = super.toEntity();
        if(cuentasCobro!=null)
        {
            List<CuentaCobroEntity> cuentasEntity = new ArrayList<CuentaCobroEntity>();
            for(CuentaCobroDTO dtoCuenta : cuentasCobro)
                cuentasEntity.add(dtoCuenta.toEntity());
            toReturn.setCuentasCobro(cuentasEntity);
        }
        return toReturn;
    }
    
    public List<CuentaCobroDTO> getCuentasCobro()
    {
        return cuentasCobro;
    }
    
    public void setCuentasCobro(List<CuentaCobroDTO> cuentascobro)
    {
        this.cuentasCobro = cuentasCobro;
    }
}
