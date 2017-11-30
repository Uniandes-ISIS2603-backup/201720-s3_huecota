/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.rest.application.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author c.martinezc1
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(co.edu.uniandes.nocompila.huecota.mappers.BusinessLogicExceptionMapper.class);
        resources.add(co.edu.uniandes.nocompila.huecota.mappers.UnsupportedOperationExceptionMapper.class);
        resources.add(co.edu.uniandes.nocompila.huecota.mappers.WebApplicationExceptionMapper.class);
        resources.add(co.edu.uniandes.nocompila.huecota.resources.AbiertoResource.class);
        resources.add(co.edu.uniandes.nocompila.huecota.resources.AccidenteResource.class);
        resources.add(co.edu.uniandes.nocompila.huecota.resources.CalificacionResource.class);
        resources.add(co.edu.uniandes.nocompila.huecota.resources.CerradoResource.class);
        resources.add(co.edu.uniandes.nocompila.huecota.resources.ClienteAccidenteResource.class);
        resources.add(co.edu.uniandes.nocompila.huecota.resources.ClienteCalificacionResource.class);
        resources.add(co.edu.uniandes.nocompila.huecota.resources.ClienteHuecoResource.class);
        resources.add(co.edu.uniandes.nocompila.huecota.resources.ClienteResource.class);
        resources.add(co.edu.uniandes.nocompila.huecota.resources.ContratistaResource.class);
        resources.add(co.edu.uniandes.nocompila.huecota.resources.CuentaCobroResource.class);
	resources.add(co.edu.uniandes.nocompila.huecota.resources.DireccionResource.class);
	resources.add(co.edu.uniandes.nocompila.huecota.resources.EnProgresoContratistaResource.class);
        resources.add(co.edu.uniandes.nocompila.huecota.resources.EnProgresoResource.class);
        resources.add(co.edu.uniandes.nocompila.huecota.resources.HuecoDireccionResource.class);
	resources.add(co.edu.uniandes.nocompila.huecota.resources.HuecoResource.class);
	resources.add(co.edu.uniandes.nocompila.huecota.resources.ImagenResource.class);
		resources.add(co.edu.uniandes.nocompila.huecota.resources.PuntoResource.class);
    }
    
}