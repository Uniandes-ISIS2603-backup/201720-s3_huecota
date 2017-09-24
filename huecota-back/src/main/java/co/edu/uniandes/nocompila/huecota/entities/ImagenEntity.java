/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.entities;


import java.io.Serializable;
import javax.persistence.Entity;
/**
 *
 * @author le.viana
 */
@Entity
public class ImagenEntity  extends BaseEntity implements Serializable{
    
        private String tipoArchivo;
        
        private Integer tamanio;
        
        private String foto;

        /**
         * getter para el tipo de archivo
         * @return tipoArchivo
         */
        public String getTipoArchivo()
        {
            return this.tipoArchivo;
        }
        
        /**
         * setter para el tipo de archivo.
         * @param tipoArchivo, tipo de archivo asigando.
         */
        public void setTipoArchivo(String tipoArchivo)
        {
            this.tipoArchivo = tipoArchivo;
        }
        
        /**
         * getter de tamanio
         * @return  tamanio
         */
        public Integer getTamanio()
        {
            return this.tamanio;
        }
        
        /**
         * setter de tamanio de la imagen
         * @param tamanio asignado.
         */
        public void setTamanio(Integer tamanio)
        {
            this.tamanio = tamanio;
        }
        
        /**
         * getter de la ruta de la foto.
         * @return ruta de la foto.
         */
        public String getFoto()
        {
            return this.foto;
        }
        
        /**
         * setter de la ruta de la foto
         * @param foto ruta asignada.
         */
        public void setFoto(String foto)
        {
            this.foto = foto;
        }
    
}
