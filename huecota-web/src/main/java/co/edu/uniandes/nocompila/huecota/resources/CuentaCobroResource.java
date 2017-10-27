/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.resources;

import co.edu.uniandes.nocompila.huecota.dtos.CuentaCobroDetailDTO;
import co.edu.uniandes.nocompila.huecota.ejb.CuentaCobroLogic;
import co.edu.uniandes.nocompila.huecota.entities.CuentaCobroEntity;
import co.edu.uniandes.nocompila.huecota.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
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

/**
 *
 * @author lc.garavito
 */
@Produces("application/json")
@Consumes("application/json")
public class CuentaCobroResource 
{
    
    @Inject
    CuentaCobroLogic cuentaCobroLogic;
    
    @POST
    public CuentaCobroDetailDTO createCuentaCobro(@PathParam("idContratista") Long idContratista, CuentaCobroDetailDTO cuentaCobro)
    {
        CuentaCobroEntity entity = cuentaCobro.toEntity();
        CuentaCobroEntity newCuentaCobro = cuentaCobroLogic.crearCuentaCobro(idContratista, entity);
        return new CuentaCobroDetailDTO(newCuentaCobro);
    }
    
    @GET
    public List<CuentaCobroDetailDTO> getCuentasCobros(@PathParam("idContratista") Long idContratista) throws BusinessLogicException
    {
        List<CuentaCobroDetailDTO> toReturn = new ArrayList<CuentaCobroDetailDTO>();
        List<CuentaCobroEntity> list = cuentaCobroLogic.getCuentasCobros(idContratista);
        for ( CuentaCobroEntity entity : list )
        {
            toReturn.add(new CuentaCobroDetailDTO(entity));
        }
        return toReturn;
    }
    
    @GET
    @Path("{id: \\d+}")
    public CuentaCobroDetailDTO getCuentaCobro(@PathParam("id") Long id)
    {
        CuentaCobroEntity entity = cuentaCobroLogic.getCuentaCobro(id);
        if(entity == null)
        {
            throw new WebApplicationException( "El recurso cuenta de cobro: " + id + " no existe",404);
        }
        return new CuentaCobroDetailDTO(entity);
    }
    
    @PUT
    @Path("{id: \\d+}")
    public CuentaCobroDetailDTO updateCuentaCobro(@PathParam("id") Long id, CuentaCobroDetailDTO cuentaCobro)
    {
        cuentaCobro.setId(id);
        CuentaCobroEntity entity = cuentaCobroLogic.getCuentaCobro(id);
        if (entity == null)
            throw new WebApplicationException("El recurso cuenta de cobro: " + id + " no existe.", 404);
        return new CuentaCobroDetailDTO(cuentaCobroLogic.updateCuentaCobro(cuentaCobro.toEntity()));
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void deleteCuentaCobro(@PathParam("id") Long id)
    {
        CuentaCobroEntity entity = cuentaCobroLogic.getCuentaCobro(id);
        if (entity == null)
            throw new WebApplicationException("El recurso cuenta de cobro: " + id + " no existe.", 404);
        cuentaCobroLogic.deleteCuentaCobroEntity(id);
    }
}
