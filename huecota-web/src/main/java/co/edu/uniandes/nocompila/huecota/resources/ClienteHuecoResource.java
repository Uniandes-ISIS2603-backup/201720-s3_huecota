/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.resources;

import co.edu.uniandes.nocompila.huecota.dtos.HuecoDTO;
import co.edu.uniandes.nocompila.huecota.ejb.ClienteLogic;
import co.edu.uniandes.nocompila.huecota.entities.HuecoEntity;
import co.edu.uniandes.nocompila.huecota.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author c.martinezc1
 */
public class ClienteHuecoResource {
    
    @Inject
    private ClienteLogic clienteLogic;
    
    /**
     * Convierte una lista de CalificacionEntity a una lista de CalificacionDTO
     * @param entityList Lista de CalificacionEntity a convertir.
     * @return Lista de CalificacionDTO.
     */
    private List<HuecoDTO> huecosListEntity2DTO(List<HuecoEntity> entityList)
    {
        List<HuecoDTO> list = new ArrayList();
        for(HuecoEntity entity : entityList)
        {
            list.add(new HuecoDTO(entity));
        }
        
        return list;
    }
    
    /**
     * Convierte una lista de CalificacionDTO a una lista CalificacionEntity
     * @param dtos Lista de CalificacionDTO a convertir.
     * @return Lista de CalificacionEntity convertida.
     */
    private List<HuecoEntity> huecosListDTO2Entity(List<HuecoDTO> dtos)
    {
        List<HuecoEntity> list = new ArrayList();
        for(HuecoDTO dto : dtos)
        {
            list.add(dto.toEntity());
        }
        
        return list;
    }
    
    /**
     * Obtiene  una colección de instancias de CalificacionDTO asociados a un hueco
     * @param clienteid identificador de la instancia de hueco.
     * @return Coleccion de instancias de calificacionDTO asociadas al hueco.
     */
    @GET
    public List<HuecoDTO> listHuecos(@PathParam("clienteid") Long clienteid)
    {
        try {
            return huecosListEntity2DTO(clienteLogic.listaHueco(clienteid));
        } catch (BusinessLogicException ex) {
            Logger.getLogger(ClienteAccidenteResource.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    /**
     * Obtiene una instancia de calificacion asociada a un hueco.
     * @param clienteid identificador de la instancia hueco.
     * @param huecoId identificador de la calificacion-
     * @return calificacion que pertenece a un hueco.
     */
    @GET
    @Path("{huecoId: \\d+}")
    public HuecoDTO getHueco(@PathParam("clienteid") Long clienteid, @PathParam("huecoId") Long huecoId)
    {
        try {
            return new HuecoDTO(clienteLogic.getHueco(clienteid, huecoId));
        } catch (BusinessLogicException ex) {
            Logger.getLogger(ClienteAccidenteResource.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    @POST
    @Path("{huecoId: \\d+}")
    public HuecoDTO addHueco(@PathParam("clienteid") Long clienteid, @PathParam("huecoId") Long huecoId)
    {
        return new HuecoDTO(clienteLogic.addHueco(clienteid, huecoId));
    }
    
    @PUT
    @Path("{huecoId: \\d+}")
    public List<HuecoDTO> remplazarHueco(@PathParam("clienteid") Long clienteid,List<HuecoDTO> huecos)
    {
        return huecosListEntity2DTO(clienteLogic.replaceHuecos(clienteid, huecosListDTO2Entity(huecos)));
    }
    
    
    @DELETE
    @Path("{huecoId: \\d+}")
    public void removeHueco(@PathParam("clienteId") Long clienteId, @PathParam("huecoId") Long huecoId)
    {
        clienteLogic.removeHueco(clienteId, huecoId);
    }
}
