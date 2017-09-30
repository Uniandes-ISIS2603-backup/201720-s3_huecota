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
package co.edu.uniandes.nocompila.huecota.ejb;

import co.edu.uniandes.nocompila.huecota.entities.AbiertoEntity;
import co.edu.uniandes.nocompila.huecota.entities.CalificacionEntity;
import co.edu.uniandes.nocompila.huecota.entities.CerradoEntity;
import co.edu.uniandes.nocompila.huecota.entities.DireccionEntity;
import co.edu.uniandes.nocompila.huecota.entities.EnProgresoEntity;
import co.edu.uniandes.nocompila.huecota.entities.HuecoEntity;
import co.edu.uniandes.nocompila.huecota.entities.ImagenEntity;
import co.edu.uniandes.nocompila.huecota.exceptions.BusinessLogicException;
import co.edu.uniandes.nocompila.huecota.persistence.HuecoPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author ISIS2603
 */
@Stateless
public class HuecoLogic {

    private static final Logger LOGGER = Logger.getLogger(HuecoLogic.class.getName());

    @Inject
    private HuecoPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    /**
     *
     * @param hueco
     * @return
     * @throws BusinessLogicException
     */
    public HuecoEntity createHueco(HuecoEntity hueco) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de Hueco");
        // Invoca la persistencia para crear el Hueco
        if(getHueco(hueco.getId()) != null){
            throw new BusinessLogicException("El hueco con el id ingresado por parametro ya existe");
        }
        persistence.create(hueco);
        LOGGER.info("Termina proceso de creación de Hueco");
        return hueco;
    }

    /**
     * 
     * Obtener todos los Huecos existentes en la base de datos.
     *
     * @return una lista de Huecos.
     */
    public List<HuecoEntity> getHuecos() {
        LOGGER.info("Inicia proceso de consultar todas las Huecoes");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        List<HuecoEntity> Huecos = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas las Huecoes");
        return Huecos;
    }
    
    /**
     * 
     * Obtener el hueco con el id por parametro existente en la base de datos.
     * @param id
     * @return el hueco con el id por parámetro.
     */
    public HuecoEntity getHueco(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar un hueco con id={0}", id);
        HuecoEntity hueco = persistence.find(id);
        if (hueco == null) {
            LOGGER.log(Level.SEVERE, "El hueco con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar un hueco con id={0}", id);
        return hueco;
    }
    
    /**
     * 
     * Actualizar el hueco con el id por parametro por el nuevo hueco por parametro.
     * @param id
     * @param hueco
     * @return el hueco actualizado.
     * @throws BusinessLogicException
     */
    public HuecoEntity updateBook(Long id, HuecoEntity hueco) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar el hueco con id={0}", id);
        if (getHueco(id) == null) {
            throw new BusinessLogicException("El hueco con el id por parametro es inválido");
        }
        HuecoEntity newEntity = persistence.update(hueco);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar el hueco con id={0}", hueco.getId());
        return newEntity;
    }
    
    /**
     * 
     * Elimina el hueco con el id por parametro existente en la base de datos.
     * @param id
     */
    public void deleteBook(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar el hueco con id={0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar el hueco con id={0}", id);
    }
      
/**
 * CRUD de la relacion con ImagenEntity
 */ 
    
    /**
     * Obtiene una colección de instancias de ImagenEntity asociadas a una
     * instancia de hueco
     *
     * @param huecoId Identificador de la instancia de Hueco
     * @return Colección de instancias de ImagenEntity asociadas a la instancia
     * de hueco
     * 
     */
    public List<ImagenEntity> getFotos(Long huecoId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todas las fotos del hueco con id = {0}", huecoId);
        return getHueco(huecoId).getFotos();
    }   
    
    /**
     * Obtiene una instancia de ImagenEntity asociada a una instancia de Hueco
     *
     * @param huecoId Identificador de la instancia de Hueco
     * @param fotoId Identificador de la instancia de Imagen
     * @return null si no tiene fotos, la foto
     * 
     */
    public ImagenEntity getFoto(Long huecoId, Long fotoId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar una foto del hueco con id = {0}", huecoId);
        List<ImagenEntity> list = getHueco(huecoId).getFotos();
        ImagenEntity foto = new ImagenEntity();
        foto.setId(fotoId);
        int index = list.indexOf(foto);
        if (index >= 0) {
            return list.get(index);
        }
        return null;
    }
    
    /**
     * Asocia una foto existente a un hueco
     *
     * @param huecoId Identificador de la instancia de Hueco
     * @param fotoId Identificador de la instancia de Imagen
     * @return Instancia de ImagenEntity que fue asociada a Hueco
     * 
     */
    public ImagenEntity addFoto(Long huecoId, Long fotoId) {
        LOGGER.log(Level.INFO, "Inicia proceso de asociar una foto al hueco con id = {0}", huecoId);
        HuecoEntity hueco = getHueco(huecoId);
        ImagenEntity foto = new ImagenEntity();
        foto.setId(fotoId);
        hueco.getFotos().add(foto);
        return getFoto(huecoId, fotoId);
    }
    
    /**
     * Remplaza las instancias de Foto asociadas a una instancia de Hueco
     *
     * @param huecoId Identificador de la instancia de Hueco
     * @param listaFotos Colección de instancias de ImagenEntity a asociar a instancia
     * de Hueco
     * @return Nueva colección de ImagenEntity asociada a la instancia de Hueco
     * 
     */
    public List<ImagenEntity> replaceFotos(Long huecoId, List<ImagenEntity> listaFotos) {
        LOGGER.log(Level.INFO, "Inicia proceso de reemplazar una coleccion de fotos del hueco con id = {0}", huecoId);
        HuecoEntity hueco = getHueco(huecoId);
        hueco.setFotos(listaFotos);
        return hueco.getFotos();
    }
    
    /**
     * Desasocia una Foto existente de un Hueco existente
     *
     * @param huecoId Identificador de la instancia de Hueco
     * @param fotoId Identificador de la instancia de Imagen
     * 
     */
    public void removeFoto(Long huecoId, Long fotoId) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar una foto del hueco con id = {0}", huecoId);
        HuecoEntity hueco = getHueco(huecoId);
        ImagenEntity foto = new ImagenEntity();
        foto.setId(fotoId);
        hueco.getFotos().remove(foto);
    }

 /**
 * CRUD de la relacion con CalificacionEntity
 */    
    
    /**
     * Obtiene una colección de instancias de CalificacionEntity asociadas a una
     * instancia de Hueco
     *
     * @param huecoId Identificador de la instancia de Hueco
     * @return Colección de instancias de CalificacionEntity asociadas a la instancia
     * de Hueco
     * 
     */
    public List<CalificacionEntity> getCalificaciones(Long huecoId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todas las calificaciones del hueco con id = {0}", huecoId);
        return getHueco(huecoId).getCalificaciones();
    }

    /**
     * Obtiene una instancia de CalificacionEntity asociada a una instancia de Hueco
     *
     * @param huecoId Identificador de la instancia de Hueco
     * @param calificacionId Identificador de la instancia de Calificacion
     * @return null si no tiene calificaciones, la calificacion
     * 
     */
    public CalificacionEntity getCalificacion(Long huecoId, Long calificacionId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar una calificacion del hueco con id = {0}", huecoId);
        List<CalificacionEntity> list = getHueco(huecoId).getCalificaciones();
        CalificacionEntity calificacion = new CalificacionEntity();
        calificacion.setId(calificacionId);
        int index = list.indexOf(calificacion);
        if (index >= 0) {
            return list.get(index);
        }
        return null;
    }
    
    /**
     * Asocia una calificacion existente a un hueco
     *
     * @param huecoId Identificador de la instancia de Hueco
     * @param calificacionId Identificador de la instancia de Calificacion
     * @return Instancia de CalificacionEntity que fue asociada a Hueco
     * 
     */
    public CalificacionEntity addCalificacion(Long huecoId, Long calificacionId) {
        LOGGER.log(Level.INFO, "Inicia proceso de asociar una calificacion al hueco con id = {0}", huecoId);
        HuecoEntity hueco = getHueco(huecoId);
        CalificacionEntity calificacion = new CalificacionEntity();
        calificacion.setId(calificacionId);
        hueco.getCalificaciones().add(calificacion);
        return getCalificacion(huecoId, calificacionId);
    }
    
    /**
     * Remplaza las instancias de Calificacion asociadas a una instancia de Hueco
     *
     * @param huecoId Identificador de la instancia de Hueco
     * @param listaCalificaciones Colección de instancias de calificacionEntity a asociar a instancia
     * de Hueco
     * @return Nueva colección de calificacionEntity asociada a la instancia de Hueco
     * 
     */
    public List<CalificacionEntity> replaceCalificaciones(Long huecoId, List<CalificacionEntity> listaCalificaciones) {
        LOGGER.log(Level.INFO, "Inicia proceso de reemplazar una coleccion de calificaciones del hueco con id = {0}", huecoId);
        HuecoEntity hueco = getHueco(huecoId);
        hueco.setCalificaciones(listaCalificaciones);
        return hueco.getCalificaciones();
    }
    
    /**
     * Desasocia una Calificacion existente de un Hueco existente
     *
     * @param huecoId Identificador de la instancia de Hueco
     * @param calificacionId Identificador de la instancia de Calificacion
     * 
     */
    public void removeCalificacion(Long huecoId, Long calificacionId) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar una calificacion del hueco con id = {0}", huecoId);
        HuecoEntity hueco = getHueco(huecoId);
        CalificacionEntity calificacion = new CalificacionEntity();
        calificacion.setId(calificacionId);
        hueco.getCalificaciones().remove(calificacion);
    }
    
/**
 * Getter y Setter de la relacion con DireccionEntity
 */  
    
    /**
     * Obtiene una instancia de DireccionEntity asociada a una instancia de Hueco
     *
     * @param huecoId Identificador de la instancia de Hueco
     * @return null si no tiene direccion, la direccion
     * 
     */
    public DireccionEntity getDireccion(Long huecoId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar la direccion del hueco con id = {0}", huecoId);
        DireccionEntity direccion = getHueco(huecoId).getDireccion();
        return direccion;
    }
    
    /**
     * Remplaza la instancia de Direccion asociadas a una instancia de Hueco
     *
     * @param huecoId Identificador de la instancia de Hueco
     * @param direccion entidad de instancias de DireccionEntity a asociar a instancia
     * de Hueco
     * @return Nueva entidad direccion de DireccionEntity asociada a la instancia de Hueco
     * 
     */
    public DireccionEntity replaceDireccion(Long huecoId, DireccionEntity direccion) {
        LOGGER.log(Level.INFO, "Inicia proceso de reemplazar la direccion del hueco con id = {0}", huecoId);
        HuecoEntity hueco = getHueco(huecoId);
        hueco.setDireccion(direccion);
        return hueco.getDireccion();
    }
    
/**
 * Getter y Setter de la relacion con AbiertoEntity
 */
    
    /**
     * Obtiene una instancia de AbiertoEntity asociada a una instancia de Hueco
     *
     * @param huecoId Identificador de la instancia de Hueco
     * @return null si no tiene estadoAbierto, el estadoAbierto
     * 
     */
    public AbiertoEntity getEstadoAbierto(Long huecoId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar el estado abierto del hueco con id = {0}", huecoId);
        AbiertoEntity estadoAbierto = getHueco(huecoId).getEstadoAbierto();
        return estadoAbierto;
    }
    
    /**
     * Remplaza la instancia de AbiertoEntity asociadas a una instancia de Hueco
     *
     * @param huecoId Identificador de la instancia de Hueco
     * @param estadoAbierto entidad de instancias de AbiertoEntity a asociar a instancia
     * de Hueco
     * @return Nueva entidad estadoAbierto de AbiertoEntity asociada a la instancia de Hueco
     * 
     */
    public AbiertoEntity replaceEstadoAbierto(Long huecoId, AbiertoEntity estadoAbierto) {
        LOGGER.log(Level.INFO, "Inicia proceso de reemplazar el estado abierto del hueco con id = {0}", huecoId);
        HuecoEntity hueco = getHueco(huecoId);
        hueco.setEstadoAbierto(estadoAbierto);
        return hueco.getEstadoAbierto();
    }
    
/**
 * Getter y Setter de la relacion con CerradoEntity
 */
    
    /**
     * Obtiene una instancia de CerradoEntity asociada a una instancia de Hueco
     *
     * @param huecoId Identificador de la instancia de Hueco
     * @return null si no tiene estadoCerrado, el estadoCerrado
     * 
     */
    public CerradoEntity getEstadoCerrado(Long huecoId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar el estado cerrado del hueco con id = {0}", huecoId);
        CerradoEntity estadoCerrado = getHueco(huecoId).getEstadoCerrado();
        return estadoCerrado;
    }
    
    /**
     * Remplaza la instancia de CerradoEntity asociadas a una instancia de Hueco
     *
     * @param huecoId Identificador de la instancia de Hueco
     * @param estadoCerrado entidad de instancias de CerradoEntity a asociar a instancia
     * de Hueco
     * @return Nueva entidad estadoCerrado de estadoCerrado asociada a la instancia de Hueco
     * 
     */
    public CerradoEntity replaceEstadoCerrado(Long huecoId, CerradoEntity estadoCerrado) {
        LOGGER.log(Level.INFO, "Inicia proceso de reemplazar el estado cerrado del hueco con id = {0}", huecoId);
        HuecoEntity hueco = getHueco(huecoId);
        hueco.setEstadoCerrado(estadoCerrado);
        return hueco.getEstadoCerrado();
    }
    
/**
 * Getter y Setter de la relacion con EnProgresoEntity
 */
    
    /**
     * Obtiene una instancia de EnProgresoEntity asociada a una instancia de Hueco
     *
     * @param huecoId Identificador de la instancia de Hueco
     * @return null si no tiene estadoEnProgreso, el estadoEnProgreso
     * 
     */
    public EnProgresoEntity getEstadoEnProceso(Long huecoId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar el estado en progreso del hueco con id = {0}", huecoId);
        EnProgresoEntity estadoEnProgreso = getHueco(huecoId).getEstadoEnProgreso();
        return estadoEnProgreso;
    }
    
    /**
     * Remplaza la instancia de EnProgresoEntity asociadas a una instancia de Hueco
     *
     * @param huecoId Identificador de la instancia de Hueco
     * @param estadoEnProgreso entidad de instancias de EnProgresoEntity a asociar a instancia
     * de Hueco
     * @return Nueva entidad estadoEnProgreso de estadoEnProgreso asociada a la instancia de Hueco
     * 
     */
    public EnProgresoEntity replaceEstadoCerrado(Long huecoId, EnProgresoEntity estadoEnProgreso) {
        LOGGER.log(Level.INFO, "Inicia proceso de reemplazar el estado en progreso del hueco con id = {0}", huecoId);
        HuecoEntity hueco = getHueco(huecoId);
        hueco.setEstadoEnProgreso(estadoEnProgreso);
        return hueco.getEstadoEnProgreso();
    }
    
/**
 * Getter y Setter de el atributo descripcion
 */
    
    /**
     * Obtiene el atributo descripcion de una instancia de Hueco
     *
     * @param huecoId Identificador de la instancia de Hueco
     * @return null si no tiene descripcion, la descripcion
     * 
     */
    public String getDescripcion(Long huecoId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar la descripcion del hueco con id = {0}", huecoId);
        String descripcion = getHueco(huecoId).getDescripcion();
        return descripcion;
    }
    
    /**
     * Remplaza la descripcion de una instancia de Hueco
     *
     * @param huecoId Identificador de la instancia de Hueco
     * @param descripcion atributo a asociar a instancia
     * de Hueco
     * 
     */
    public void replaceDescripcion(Long huecoId, String descripcion) {
        LOGGER.log(Level.INFO, "Inicia proceso de reemplazar la descripcion del hueco con id = {0}", huecoId);
        HuecoEntity hueco = getHueco(huecoId);
        hueco.setDescripcion(descripcion);
    }
}
