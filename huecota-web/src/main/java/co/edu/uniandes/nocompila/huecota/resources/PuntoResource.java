/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.resources;

import co.edu.uniandes.nocompila.huecota.dtos.PuntoDTO;
import co.edu.uniandes.nocompila.huecota.ejb.PuntoLogic;
import co.edu.uniandes.nocompila.huecota.entities.PuntoEntity;
import co.edu.uniandes.nocompila.huecota.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author c.martinezc1
 */
@Path("/clientes/{id}/puntos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class PuntoResource {
    @Inject
    PuntoLogic puntoLogic;
    
    private static final Logger LOGGER = Logger.getLogger(PuntoResource.class.getName());

    /**
     * POST http://localhost:8080/huecota-web/api/clientes/{id}/puntos
     *
     * @param punto correponde a la representación java del objeto json
     * enviado en el llamado.
     * @param clienteid
     * @return Devuelve el objeto json de entrada que contiene el id creado por
     * la base de datos y el tipo del objeto java. Ejemplo: { "type":
     * "HuecoDetailDTO", "id": 1, atributo1 : "valor" }
     * @throws BusinessLogicException
     */
    @POST
    public PuntoDTO createPunto(PuntoDTO punto,@PathParam("id") Long clienteid) throws BusinessLogicException {
        // Convierte el DTO (json) en un objeto Entity para ser manejado por la lógica.
        PuntoEntity entity = punto.toEntity();
        // Invoca la lógica para crear el cliente nuev
        PuntoEntity nuevoHueco = puntoLogic.createPunto(clienteid,entity);
        // Como debe retornar un DTO (json) se invoca el constructor del DTO con argumento el entity nuevo
        return new PuntoDTO(nuevoHueco);
    }
    
    /**
     * GET para todas los clientes.
     * http://localhost:8080/huecota-web/api/clientes/{id}/puntos
     *
     * @param clienteid
     * @return la lista de todas los clientes en objetos json DTO.
     * @throws BusinessLogicException
     */
    @GET
    public List<PuntoDTO> getPuntos(@PathParam("id") Long clienteid) throws BusinessLogicException {
        return listEntity2DTO(puntoLogic.getPuntos(clienteid));
    }
    
     /**
     *
     * lista de entidades a DTO.
     *
     * Este método convierte una lista de objetos ClienteEntity a una lista de
     * objetos CLienteDetailDTO (json)
     *
     * @param entityList corresponde a la lista de clientes de tipo Entity
     * que vamos a convertir a DTO.
     * @return la lista de clientes en forma DTO (json)
     */
    private List<PuntoDTO> listEntity2DTO(List<PuntoEntity> entityList) {
        List<PuntoDTO> list = new ArrayList();
        for (PuntoEntity entity : entityList) {
            list.add(new PuntoDTO(entity));
        }
        return list;
    }
    
    /**
     * GET para un cliente.
     * http://localhost:8080/huecota-web/api/clientes/{id}/puntos/{id}
     *
     * @return el cliente en objeto json DTO.
     * @throws BusinessLogicException
     */
    @GET
    @Path("{id: \\d+}")
    public PuntoDTO getPunto(@PathParam("clienteid") Long clienteid,@PathParam("id") Long puntoid) throws BusinessLogicException{
        PuntoDTO dto = new PuntoDTO(puntoLogic.getPunto(clienteid,puntoid));
        return dto;
    }
    
    /**
     * DELETE http://localhost:8080/huecota-web/api/clientes/{id}/puntos/{id}
     *
     * @param id corresponde al cliente a borrar.
     * @throws BusinessLogicException
     *
     * En caso de no existir el id de el cleitne a actualizar se retorna un
     * 404 con el mensaje.
     *
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deletePunto(@PathParam("id") Long clienteid,@PathParam("id") Long id) throws BusinessLogicException {
        PuntoEntity entity = puntoLogic.getPunto(clienteid, id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /cliente/" + clienteid + "/puntos/" + id + " no existe.", 404);
        }
        puntoLogic.deletePunto(clienteid, id);
    }
    
    @PUT
    @Path("{id: \\d+}")
    public PuntoDTO updatePunto(@PathParam("clienteid") Long clienteid, @PathParam("id") Long id, PuntoDTO punto) throws BusinessLogicException {
        punto.setId(id);
        PuntoEntity entity = puntoLogic.getPunto(clienteid, id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /cliente/" + clienteid + "/puntos/" + id + " no existe.", 404);
        }
        return new PuntoDTO(puntoLogic.updatePunto(clienteid, punto.toEntity()));

    }
}
