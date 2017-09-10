# s2_huecota


# Integrantes

Nombre 		     | Código    | Usuario

Miguel Angel Puentes | 201616771 | ma.puentes

Juan Pablo Rocha | 201611835 | jpr.arango10

Luis Ernesto Viana  | 201618266 | le.viana

Camilo Martinez Castro | | c.martinezc1

Carlos Humberto Patino | |ch.patino

Luis Carlos Garavito Romero | | lc.garavito

# API REST

# Tabla de contenidos
-  [API](#api-de-la-aplicación-Huecota)
  - [Recurso estados](#recurso-estados)
    - [GET /estados](#GET-/estados)
    - [GET /estados/{id}](#GET-/estados/{id})
    - [POST /estados](#POST-/estados)
    - [PUT /estados/{id}](#PUT-/estados/{id})
    - [DELETE /estados/{id}](#DELETE-/estados/{id})

### Representación Minimum
```javascript
{
    fechaDeCambio: '' /*Tipo Date*/,
}
```

### Representación Detail
```javascript
{
    fechaDeCambio: '' /*Tipo Date*/,
}
```

#### GET /estados
Retorna una colección de objetos Estados en representación detallada.
#### Parámetros
N/A
#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Estado en [representaciones Detail](#recurso-estado)
404|No existe un objeto estado con el ID solicitado|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error

#### GET /estados/{id}
Retorna una colección de objetos Estados en representación detallada.
#### Parámetros
Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Estado a consultar|Sí|Integer
#### Respuesta
Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Estado en [representaciones Detail](#recurso-estado)
404|No existe un objeto estado con el ID solicitado|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error

#### POST /estados
Es el encargado de crear objetos Estados.
#### Parámetros
Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
body|body|Objeto Estado que será creado|Sí|[Representación Detail](#recurso-estado)
#### Respuesta
Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Estado ha sido creado|[Representación Detail](#recurso-estado)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo crear el objeto Estado|Mensaje de error

#### PUT /estados/{id}
Es el encargado de actualizar objetos Estado
#### Parámetros
Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Estado a actualizar|Sí|Integer
body|body|Objeto Estado nuevo|Sí|[Representación Detail](#recurso-estado)
#### Respuesta
Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Estado actualizado|[Representación Detail](#recurso-estado)
412|business exception, no se cumple con las reglas de negocio|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo actualizar el objeto Estado|Mensaje de error

#### DELETE /estados/{id}
Elimina un objeto Estado.
#### Parámetros
Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Estado a eliminar|Sí|Integer
#### Respuesta
Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto eliminado|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

[Volver arriba](#tabla-de-contenidos)


