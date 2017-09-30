/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.dtos;

import co.edu.uniandes.nocompila.huecota.entities.EnProgresoEntity;
import co.edu.uniandes.nocompila.huecota.entities.HuecoEntity;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author jpr.arango10
 */
public class EnProgresoDetailDTO extends EnProgresoDTO{
    
    private List<HuecoDTO> huecos;    
    
    public EnProgresoDetailDTO(){
        super();
    }
    
    public EnProgresoDetailDTO(EnProgresoEntity entity) {
        super(entity);
        if(entity != null){
            huecos = new ArrayList();
            for(HuecoEntity entityHueco : entity.getHuecos()){
                huecos.add(new HuecoDTO(entityHueco));
            }
        }        
    }

    @Override
    public EnProgresoEntity toEntity() 
    {
        EnProgresoEntity entity = super.toEntity();
        if (huecos != null) {
        List<HuecoEntity> huecoEntity = new ArrayList();
            for (HuecoDTO dtoBook : huecos) {
                huecoEntity.add(dtoBook.toEntity());
            }
            entity.setHuecos(huecoEntity);
        }
        return entity;
    }
    
}
