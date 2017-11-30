/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.resources;

import co.edu.uniandes.nocompila.huecota.ejb.HuecoLogic;
import co.edu.uniandes.nocompila.huecota.dtos.AbiertoDTO;
import co.edu.uniandes.nocompila.huecota.entities.AbiertoEntity;
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
public class HuecoEstadoAbiertoResource {

    @Inject
    private HuecoLogic huecoLogic;

    /**
     * Convierte una AbiertoEntity a una AbiertoDTO
     *
     * @param entity AbiertoEntity a convertir.
     * @return AbiertoDTO.
     */
    private AbiertoDTO AbiertoEntity2DTO(AbiertoEntity entity) {
        return new AbiertoDTO(entity);
    }

    /**
     * Convierte una AbiertoDTO a una AbiertoEntity
     *
     * @param dto AbiertoDTO a convertir.
     * @return AbiertoEntity convertida.
     */
    private AbiertoEntity AbiertoDTO2Entity(AbiertoDTO dto) {
        return dto.toEntity();
    }

    /**
     * Obtiene una instancia de Abierto asociada a un hueco.
     *
     * @param huecosid identificador de la instancia hueco.
     * @return Abierto que pertenece a un hueco.
     */
    @GET
    @Path("{AbiertoId: \\d+}")
    public AbiertoDTO getAbierto(@PathParam("huecosid") Long huecosid) {
        return new AbiertoDTO(huecoLogic.getEstadoAbierto(huecosid));
    }

    @POST
    @Path("{AbiertoId: \\d+}")
    public AbiertoDTO addAbierto(@PathParam("huecosid") Long huecosid, @PathParam("AbiertoId") Long AbiertoId) {
        return new AbiertoDTO(huecoLogic.addEstadoAbierto(huecosid, AbiertoId));
    }

    /**
     *
     * @param huecosid
     * @param Abierto
     * @return
     */
    @PUT
    public AbiertoDTO remplazarAbierto(@PathParam("huecosid") Long huecosid, AbiertoDTO Abierto) {
        return AbiertoEntity2DTO(huecoLogic.replaceEstadoAbierto(huecosid, AbiertoDTO2Entity(Abierto)));
    }

    /**
     *
     * @param huecosid
     * @param Abiertoid
     */
    @DELETE
    @Path("{AbiertoId: \\d+}")
    public void removeAbierto(@PathParam("huecosid") Long huecosid, @PathParam("Abiertoid") Long Abiertoid) {
        huecoLogic.removeEstadoAbierto(huecosid, Abiertoid);
    }
}
