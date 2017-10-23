/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.resources;

import co.edu.uniandes.nocompila.huecota.dtos.ClienteDTO;
import co.edu.uniandes.nocompila.huecota.ejb.AccidenteLogic;
import co.edu.uniandes.nocompila.huecota.entities.ClienteEntity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author ma.puentes
 */
@Consumes("application/json")
@Produces("application/json")
public class AccidenteClienteResource
{
	 @Inject
    private AccidenteLogic accidenteLogic;
    
	 
	 private List<ClienteDTO> clienteEntity2DTO(List<ClienteEntity> entityList)
    {
        List<ClienteDTO> list = new ArrayList();
        for(ClienteEntity entity : entityList)
        {
            list.add(new ClienteDTO(entity));
        }
        
        return list;
    }
    /**
     * Obtiene  una colección de instancias de CalificacionDTO asociados a un hueco
     * @param huecosid identificador de la instancia de hueco.
     * @return Coleccion de instancias de calificacionDTO asociadas al hueco.
     */
    @GET
    public List<ClienteDTO> listClientes(Long AccidenteId)
    {
        return clienteEntity2DTO(accidenteLogic.getClientes(AccidenteId));
    }
    
       
    @POST
    @Path("{accidenteId: \\d+}")
    public ClienteDTO addCliente(@PathParam("accidenteId") Long accidenteId, ClienteEntity cliente)
    {
        return new ClienteDTO(accidenteLogic.addCliente(accidenteId,cliente));
    }
	
}
