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
package co.edu.uniandes.baco.huecota.resources;

import co.edu.uniandes.baco.huecota.ejb.HuecoLogic;
import co.edu.uniandes.baco.huecota.dtos.HuecoDetailDTO;
import co.edu.uniandes.baco.huecota.entities.HuecoEntity;
import co.edu.uniandes.baco.huecota.exceptions.BusinessLogicException;
import co.edu.uniandes.baco.huecota.persistence.HuecoPersistence;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * Clase que implementa el recurso REST correspondiente a "Huecos".
 *
 * Note que la aplicación (definida en RestConfig.java) define la ruta "/api" y
 * este recurso tiene la ruta "Huecos". Al ejecutar la aplicación, el
 * recurso será accesibe a través de la ruta "/api/Huecos"
 *
 * @author ISIS2603
 *
 */
@Path("huecos")
@Produces("application/json")
@Consumes("application/json")
@Stateless
public class HuecoResource {

    @Inject
    HuecoLogic huecotaLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.

    private static final Logger LOGGER = Logger.getLogger(HuecoResource.class.getName());

    /**
     * POST http://localhost:8080/huecota-web/api/huecotas
     *
     * @param Hueco correponde a la representación java del objeto json
     * enviado en el llamado.
     * @return Devuelve el objeto json de entrada que contiene el id creado por
     * la base de datos y el tipo del objeto java. Ejemplo: { "type":
     * "HuecoDetailDTO", "id": 1, atributo1 : "valor" }
     * @throws BusinessLogicException
     */
    @POST
    public HuecoDetailDTO createHueco(HuecoDetailDTO Hueco) throws BusinessLogicException {
        // Convierte el DTO (json) en un objeto Entity para ser manejado por la lógica.
        HuecoEntity HuecoEntity = Hueco.toEntity();
        // Invoca la lógica para crear la Hueco nueva
        HuecoEntity nuevoHueco = huecotaLogic.createHueco(HuecoEntity);
        // Como debe retornar un DTO (json) se invoca el constructor del DTO con argumento el entity nuevo
        return new HuecoDetailDTO(nuevoHueco);
    }

    /**
     * GET para todas las Huecoes.
     * http://localhost:8080/huecota-web/api/huecotas
     *
     * @return la lista de todas las Huecoes en objetos json DTO.
     * @throws BusinessLogicException
     */
    @GET
    public List<HuecoDetailDTO> getHuecos() throws BusinessLogicException {
        return listEntity2DetailDTO(huecotaLogic.getHuecos());
    }

   
    /**
     * PUT http://localhost:8080/huecota-web/api/huecotas/1 Ejemplo
     * json { "id": 1, "atirbuto1": "Valor nuevo" }
     *
     * @param id corresponde a la Hueco a actualizar.
     * @param huecota corresponde  al objeto con los cambios que se van a
     * realizar.
     * @return La Hueco actualizada.
     * @throws BusinessLogicException
     *
     * En caso de no existir el id de la Hueco a actualizar se retorna un
     * 404 con el mensaje.
     */
    @PUT
    @Path("{id: \\d+}")
    public HuecoDetailDTO updateHueco(@PathParam("id") Long id, HuecoDetailDTO huecota) throws BusinessLogicException, UnsupportedOperationException {
          throw new UnsupportedOperationException("Este servicio  no está implementado");
      
    }

    /**
     * DELETE http://localhost:8080/huecota-web/api/huecotas/{id}
     *
     * @param id corresponde a la Hueco a borrar.
     * @throws BusinessLogicException
     *
     * En caso de no existir el id de la Hueco a actualizar se retorna un
     * 404 con el mensaje.
     *
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteHueco(@PathParam("id") Long id) throws BusinessLogicException {
         throw new UnsupportedOperationException("Este servicio no está implementado");
    }

    /**
     *
     * lista de entidades a DTO.
     *
     * Este método convierte una lista de objetos HuecoEntity a una lista de
     * objetos HuecoDetailDTO (json)
     *
     * @param entityList corresponde a la lista de Huecoes de tipo Entity
     * que vamos a convertir a DTO.
     * @return la lista de Huecoes en forma DTO (json)
     */
    private List<HuecoDetailDTO> listEntity2DetailDTO(List<HuecoEntity> entityList) {
        List<HuecoDetailDTO> list = new ArrayList<>();
        for (HuecoEntity entity : entityList) {
            list.add(new HuecoDetailDTO(entity));
        }
        return list;
    }

}
