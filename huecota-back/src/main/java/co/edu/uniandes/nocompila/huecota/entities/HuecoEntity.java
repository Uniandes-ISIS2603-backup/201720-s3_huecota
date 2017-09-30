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
package co.edu.uniandes.nocompila.huecota.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author ch.patino
 */
@Entity
public class HuecoEntity extends BaseEntity implements Serializable {
   
    // atributos
           
        /**
         * Atributo que representa la descripción de un hueco.
         */
        private String descripcion;
        
        /**
         * Atributo que representa la lista de fotos de un hueco.
         */
        @PodamExclude
        @OneToMany(mappedBy = "hueco", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<ImagenEntity> fotos;
        
        /**
         * Atributo que representa la lista de calificaciones de un hueco.
         */
        @PodamExclude
        @OneToMany(mappedBy = "hueco", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<CalificacionEntity> calificaciones;
        
        /**
         * Atributo que representa la dirección de un hueco.
         */
        @PodamExclude
        @OneToOne
        private DireccionEntity direccion;
        
        /**
         * Atributo que representa el estado abierto de un hueco.
         */
        @PodamExclude
        @OneToOne
        private AbiertoEntity estadoAbierto;
        
        /**
         * Atributo que representa el estado en progreso de un hueco.
         */
        @PodamExclude
        @OneToOne
        private EnProgresoEntity estadoEnProgreso;
        
        /**
         * Atributo que representa el estado cerrado de un hueco.
         */
        @PodamExclude
        @OneToOne
        private CerradoEntity estadoCerrado;
        
        // getters y setters
        
        /**
         * getter del atributo descripcion.
         * @return el estado actual.
         */
        public String getDescripcion()
        {
            return descripcion;
        }
        
        /**
         * setter del atributo descripcion
         * @param descripcion que se va a agregar
         */
        public void setDescripcion(String descripcion)
        {
            this.descripcion = descripcion;
        }
        
        /**
         * getter del atributo fotos.
         * @return Lista de las fotos del hueco
         */
        public List<ImagenEntity> getFotos()
        {
            return fotos;
        }
        
        /**
         * setter del atributo fotos
         * @param fotos lista de fotos que se van a agregar
         */
        public void setFotos(List<ImagenEntity> fotos)
        {
              this.fotos = fotos;
        }
        
        /**
         * getter del atributo calificaciones.
         * @return Lista de las calificaciones del hueco
         */
        public List<CalificacionEntity> getCalificaciones()
        {
              return calificaciones;
        }
        
        /**
         * setter del atributo calificaciones
         * @param calificaciones lista de calificaciones que se van a agregar
         */
        public void setCalificaciones(List<CalificacionEntity> calificaciones)
        {
             this.calificaciones = calificaciones;
        }
        
        /**
         * getter del atributo direccion.
         * @return la direccion del hueco
         */
        public DireccionEntity getDireccion()
        {
            return direccion;
        }
        
        /**
         * setter del atributo direccion
         * @param direccion que se va a agregar
         */
        public void setDireccion(DireccionEntity direccion)
        {
            this.direccion = direccion;
        }
        
        /**
         * getter del atributo estadoAbierto.
         * @return estadoAbierto del hueco
         */
        public AbiertoEntity getEstadoAbierto()
        {
            return estadoAbierto;
        }
        
        /**
         * setter del atributo estadoAbierto
         * @param estadoAbierto que se va a agregar
         */
        public void setEstadoAbierto(AbiertoEntity estadoAbierto)
        {
            this.estadoAbierto = estadoAbierto;
        }
        
        /**
         * getter del atributo estadoEnProgreso.
         * @return estadoEnProgreso del hueco
         */
        public EnProgresoEntity getEstadoEnProgreso()
        {
            return estadoEnProgreso;
        }
        
        /**
         * setter del atributo estadoEnProgreso
         * @param estadoEnProgreso que se va a agregar
         */
        public void setEstadoEnProgreso(EnProgresoEntity estadoEnProgreso)
        {
            this.estadoEnProgreso = estadoEnProgreso;
        }
        
        /**
         * getter del atributo estadoCerrado.
         * @return estadoCerrado del hueco
         */
        public CerradoEntity getEstadoCerrado()
        {
            return estadoCerrado;
        }
        
        /**
         * setter del atributo estadoCerrado
         * @param estadoCerrado que se va a agregar
         */
        public void setEstadoCerrado(CerradoEntity estadoCerrado)
        {
            this.estadoCerrado = estadoCerrado;
        }
        
}
