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

import co.edu.uniandes.nocompila.huecota.entities.HuecoEntity;

/**
 * HuecoDTO Objeto de transferencia de datos de Huecoes. Los DTO
 * contienen las represnetaciones de los JSON que se transfieren entre el
 * cliente y el servidor.
 *
 * @author ch.patino
 */
public class HuecoDTO 
{

    private Long id;

    /**
     * Constructor por defecto
     */
    public HuecoDTO() 
    {
    }

    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param Hueco: Es la entidad que se va a convertir a DTO
     */
    public HuecoDTO(HuecoEntity Hueco) 
    {
        this.id = Hueco.getId();
    }

    /**
     * @return id
     */
    public Long getId() 
    {
        return id;
    }

    /**
     * @param id id a cambiar
     */
    public void setId(Long id) 
    {
        this.id = id;
    }

    /**
     * Convertir DTO a Entity
     *
     * @return Un Entity con los valores del DTO
     */
    public HuecoEntity toEntity() 
    {
        HuecoEntity entity = new HuecoEntity();
        entity.setId(this.id);
        return entity;
    }
    
}
