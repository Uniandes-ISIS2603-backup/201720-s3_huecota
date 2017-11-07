/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.resources;

import co.edu.uniandes.nocompila.huecota.dtos.AccidenteDTO;
import co.edu.uniandes.nocompila.huecota.ejb.ClienteLogic;
import co.edu.uniandes.nocompila.huecota.entities.AccidenteEntity;
import co.edu.uniandes.nocompila.huecota.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author c.martinezc1
 */
@Consumes("application/json")
@Produces("application/json")
public class ClienteAccidenteResource {
    @Inject
    private ClienteLogic clienteLogic;
    
    /**
     * Convierte una lista de CalificacionEntity a una lista de CalificacionDTO
     * @param entityList Lista de CalificacionEntity a convertir.
     * @return Lista de CalificacionDTO.
     */
    private List<AccidenteDTO> accidentesListEntity2DTO(List<AccidenteEntity> entityList)
    {
        List<AccidenteDTO> list = new ArrayList();
        for(AccidenteEntity entity : entityList)
        {
            list.add(new AccidenteDTO(entity));
        }
        
        return list;
    }
    
    /**
     * Convierte una lista de CalificacionDTO a una lista CalificacionEntity
     * @param dtos Lista de CalificacionDTO a convertir.
     * @return Lista de CalificacionEntity convertida.
     */
    private List<AccidenteEntity> accidentesListDTO2Entity(List<AccidenteDTO> dtos)
    {
        List<AccidenteEntity> list = new ArrayList();
        for(AccidenteDTO dto : dtos)
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
    public List<AccidenteDTO> listAccidentes(@PathParam("clienteid") Long clienteid)
    {
        try {
            return accidentesListEntity2DTO(clienteLogic.listaAccidente(clienteid));
        } catch (BusinessLogicException ex) {
            Logger.getLogger(ClienteAccidenteResource.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    /**
     * Obtiene una instancia de calificacion asociada a un hueco.
     * @param clienteid identificador de la instancia hueco.
     * @param accidenteId identificador de la calificacion-
     * @return calificacion que pertenece a un hueco.
     */
    @GET
    @Path("{accidenteId: \\d+}")
    public AccidenteDTO getAccidente(@PathParam("clienteid") Long clienteid, @PathParam("accidenteId") Long accidenteId)
    {
        try {
            return new AccidenteDTO(clienteLogic.getAccidente(clienteid, accidenteId));
        } catch (BusinessLogicException ex) {
            Logger.getLogger(ClienteAccidenteResource.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    @POST
    @Path("{accidenteId: \\d+}")
    public AccidenteDTO addAccidente(@PathParam("clienteid") Long clienteid, @PathParam("accidenteId") Long accidenteId)
    {
        return new AccidenteDTO(clienteLogic.addAccidente(clienteid, accidenteId));
    }
    
    @POST
    @Path("{accidenteId: \\d+}")
    public AccidenteDTO addAccidente(AccidenteDTO accidente,@PathParam("clienteid") Long clienteid)
    {
        AccidenteEntity entity = accidente.toEntity();
        AccidenteEntity  nuevo = accidenteLogic.createAccidente(entity);
        return new AccidenteDTO(clienteLogic.addAccidente(clienteid, accidenteId));
    }
    
    @PUT
    public List<AccidenteDTO> remplazarAccidente(@PathParam("clienteid") Long clienteid,List<AccidenteDTO> accidentes)
    {
        return accidentesListEntity2DTO(clienteLogic.replaceAccidentes(clienteid, accidentesListDTO2Entity(accidentes)));
    }
    
    
    @DELETE
    @Path("{accidenteId: \\d+}")
    public void removeAccidentes(@PathParam("clienteId") Long clienteId, @PathParam("accidenteId") Long accidenteId)
    {
        clienteLogic.removeAccidente(clienteId, accidenteId);
    }
    
    
}
