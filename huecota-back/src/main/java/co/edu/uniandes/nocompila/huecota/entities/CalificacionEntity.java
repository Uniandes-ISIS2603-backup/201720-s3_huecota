/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.entities;

import java.io.Serializable;

/**
 *
 * @author le.viana
 */
public class CalificacionEntity extends BaseEntity implements Serializable{
        
    // atributos
        
        /**
         * Atributo que representa una nota dada por un ciudadano a un hueco.
         */
        private Integer nota;
        
        /**
         * Atributo que representa un comentario que un cliente deja para un hueco.
         */
        private String comentario;
        
    // getters y setters
        
        /**
         * getter del atributo nota.
         * @return una nota.
         */
        public Integer getNota()
        {
            return nota;
        }
        
        /**
         * setter del atributo Nota
         * @param nota que se va a agregar
         */
        public void setNota(Integer nota)
        {
            this.nota = nota;
        }
        
        /**
         * getter del atributo comentario.
         * @return un comentario.
         */
        public String getComentario()
        {
            return comentario;
        }
        
        /**
         * setter del atributo comentario.
         * @param comentario que un ciudadano pone.
         */
        public void setComentario(String comentario)
        {
            this.comentario = comentario;
        }
    
}
