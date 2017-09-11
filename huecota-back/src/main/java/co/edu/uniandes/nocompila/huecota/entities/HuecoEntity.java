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
import javax.persistence.Entity;

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
        private String fotos;
        
        /**
         * Atributo que representa la dirección de un hueco.
         */
        private String direccion;
        
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
         * @return las fotos del hueco
         */
        public String getFotos()
        {
            return fotos;
        }
        
        /**
         * setter del atributo fotos
         * @param fotos que se van a agregar
         */
        public void setFotos(String fotos)
        {
            this.fotos = fotos;
        }
        
        /**
         * getter del atributo direccion.
         * @return la direccion del hueco
         */
        public String getDireccion()
        {
            return direccion;
        }
        
        /**
         * setter del atributo direccion
         * @param direccion que se va a agregar
         */
        public void setDireccion(String direccion)
        {
            this.direccion = direccion;
        }
}
