/*
MIT License

Copyright (c) 2017 Universidad de los Andes - ISIS2603

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package co.edu.uniandes.nocompila.huecota.dtos;

import co.edu.uniandes.nocompila.huecota.entities.CalificacionEntity;
import co.edu.uniandes.nocompila.huecota.entities.HuecoEntity;
import co.edu.uniandes.nocompila.huecota.entities.ImagenEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ch.patino
 */
public class HuecoDetailDTO extends HuecoDTO {

    /*
    * Relacion uno a muchos con Imagen
     */
    private List<ImagenDTO> fotos;

    /*
    * Relacion con una Direccion
     */
    private DireccionDTO direccion;

    /*
    * Relacion con un estado Abierto
     */
    private AbiertoDTO estadoAbierto;

    /*
    * Relacion con un estado EnProgreso
     */
    private EnProgresoDTO estadoEnProgreso;

    /*
    * Relacion con un estado Cerrado
     */
    private CerradoDTO estadoCerrado;

    /*
    * Relacion de uno a muchos con Calificacion
     */
    private List<CalificacionDTO> calificaciones;

    /**
     * Constructor por defecto
     */
    public HuecoDetailDTO() {
        super();
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    public HuecoDetailDTO(HuecoEntity entity) {
        super(entity);
        if (entity.getDireccion() != null) {
            this.direccion = new DireccionDTO(entity.getDireccion());
        } else {
            entity.setDireccion(null);
        }
        if (entity.getCalificaciones() != null) {
            calificaciones = new ArrayList<CalificacionDTO>();
            for (CalificacionEntity entityCalificaciones : entity.getCalificaciones()) {
                calificaciones.add(new CalificacionDTO(entityCalificaciones));
            }
        }
        if (entity.getFotos() != null) {
            fotos = new ArrayList<ImagenDTO>();
            for (ImagenEntity entityFotos : entity.getFotos()) {
                fotos.add(new ImagenDTO(entityFotos));
            }
        }
        if (entity.getEstadoAbierto() != null) {
            this.estadoAbierto = new AbiertoDTO(entity.getEstadoAbierto());
        } else {
            entity.setEstadoAbierto(null);
        }
        if (entity.getEstadoCerrado() != null) {
            this.estadoCerrado = new CerradoDTO(entity.getEstadoCerrado());
        } else {
            entity.setEstadoCerrado(null);
        }
        if (entity.getEstadoEnProgreso() != null) {
            this.estadoEnProgreso = new EnProgresoDTO(entity.getEstadoEnProgreso());
        } else {
            entity.setEstadoEnProgreso(null);
        }
    }

    /**
     * Transformar un DTO a un Entity
     *
     * @return
     */
    @Override
    public HuecoEntity toEntity() {
        HuecoEntity HuecoE = super.toEntity();
        if (this.getDireccion() != null) {
            HuecoE.setDireccion(this.getDireccion().toEntity());
        }
        if (this.getEstadoAbierto() != null) {
            HuecoE.setEstadoAbierto(this.getEstadoAbierto().toEntity());
        }
        if (this.getEstadoCerrado() != null) {
            HuecoE.setEstadoCerrado(this.getEstadoCerrado().toEntity());
        }
        if (this.getEstadoEnProgreso() != null) {
            HuecoE.setEstadoEnProgreso(this.getEstadoEnProgreso().toEntity());
        }
        if (getFotos() != null) {
            List<ImagenEntity> FotosEntity = new ArrayList<ImagenEntity>();
            for (ImagenDTO dtoImagen : getFotos()) {
                FotosEntity.add(dtoImagen.toEntity());
            }
            HuecoE.setFotos(FotosEntity);
        }
        if (getCalificaciones() != null) {
            List<CalificacionEntity> CalificacionesEntity = new ArrayList<CalificacionEntity>();
            for (CalificacionDTO dtoCalificacion : getCalificaciones()) {
                CalificacionesEntity.add(dtoCalificacion.toEntity());
            }
            HuecoE.setCalificaciones(CalificacionesEntity);
        }
        return HuecoE;
    }

    /**
     * Getter de todos los atributos
     */
    public List<ImagenDTO> getFotos() {
        return fotos;
    }

    public DireccionDTO getDireccion() {
        return direccion;
    }

    public AbiertoDTO getEstadoAbierto() {
        return estadoAbierto;
    }

    public EnProgresoDTO getEstadoEnProgreso() {
        return estadoEnProgreso;
    }

    public CerradoDTO getEstadoCerrado() {
        return estadoCerrado;
    }

    public List<CalificacionDTO> getCalificaciones() {
        return calificaciones;
    }

    /**
     * Setter de todos los atributos
     */
    public void setFotos(List<ImagenDTO> fotos) {
        this.fotos = fotos;
    }

    public void setDireccion(DireccionDTO direccion) {
        this.direccion = direccion;
    }

    public void setEstadoAbierto(AbiertoDTO estadoAbierto) {
        this.estadoAbierto = estadoAbierto;
    }

    public void setEstadoEnProgreso(EnProgresoDTO estadoEnProgreso) {
        this.estadoEnProgreso = estadoEnProgreso;
    }

    public void setEstadoCerrado(CerradoDTO estadoCerrado) {
        this.estadoCerrado = estadoCerrado;
    }

    public void setCalificaciones(List<CalificacionDTO> calificaciones) {
        this.calificaciones = calificaciones;
    }
}
