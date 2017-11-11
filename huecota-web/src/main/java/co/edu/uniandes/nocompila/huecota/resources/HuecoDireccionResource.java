/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.resources;

import co.edu.uniandes.nocompila.huecota.ejb.HuecoLogic;
import co.edu.uniandes.nocompila.huecota.dtos.DireccionDTO;
import co.edu.uniandes.nocompila.huecota.entities.DireccionEntity;
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
 * @author ch.patino
 */
@Consumes("application/json")
@Produces("application/json")
public class HuecoDireccionResource {

    @Inject
    private HuecoLogic huecoLogic;

    /**
     * Convierte una DireccionEntity a una DireccionDTO
     *
     * @param entity DireccionEntity a convertir.
     * @return DireccionDTO.
     */
    private DireccionDTO direccionEntity2DTO(DireccionEntity entity) {
        return new DireccionDTO(entity);
    }

    /**
     * Convierte una DireccionDTO a una DireccionEntity
     *
     * @param dto DireccionDTO a convertir.
     * @return DireccionEntity convertida.
     */
    private DireccionEntity direccionDTO2Entity(DireccionDTO dto) {
        return dto.toEntity();
    }

    /**
     * Obtiene una instancia de direccion asociada a un hueco.
     *
     * @param huecosid identificador de la instancia hueco.
     * @return direccion que pertenece a un hueco.
     */
    @GET
    @Path("{direccionId: \\d+}")
    public DireccionDTO getDireccion(@PathParam("huecosid") Long huecosid) {
        return new DireccionDTO(huecoLogic.getDireccion(huecosid));
    }

    @POST
    @Path("{direccionId: \\d+}")
    public DireccionDTO addDireccion(@PathParam("huecosid") Long huecosid, @PathParam("direccionId") Long direccionId) {
        return new DireccionDTO(huecoLogic.addDireccion(huecosid, direccionId));
    }

    /**
     *
     * @param huecosid
     * @param direccion
     * @return
     */
    @PUT
    public DireccionDTO remplazarDireccion(@PathParam("huecosid") Long huecosid, DireccionDTO direccion) {
        return direccionEntity2DTO(huecoLogic.replaceDireccion(huecosid, direccionDTO2Entity(direccion)));
    }

    /**
     *
     * @param huecosid
     * @param direccionid
     */
    @DELETE
    @Path("{direccionId: \\d+}")
    public void removeDirecciones(@PathParam("huecosid") Long huecosid, @PathParam("direccionid") Long direccionid) {
        huecoLogic.removeDireccion(huecosid, direccionid);
    }
}
