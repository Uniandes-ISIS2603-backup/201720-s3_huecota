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

# API REST recurso Estado

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

# API REST recurso Calificacion

# Tabla de contenidos
-  [API](#api-de-la-aplicación-Huecota)
  - [Recurso calificaciones](#recurso-calificaciones)
    - [GET /calificaciones](#GET-/calificaciones)
    - [GET /calificaciones/{id}](#GET-/calificaciones/{id})
    - [POST /calificaciones](#POST-/calificaciones)
    - [PUT /calificaciones/{id}](#PUT-/calificaciones/{id})
    - [DELETE /calificaciones/{id}](#DELETE-/calificaciones/{id})

### Representación Minimum
```javascript
{
    nota: '' /*Tipo Integer*/,
    comentario: '' /*Tipo String*/
}
```

### Representación Detail
```javascript
{
    nota: '' /*Tipo Integer*/,
    comentario: '' /*Tipo String*/
}
```

#### GET /calificaciones
Retorna una colección de objetos Calificaciones en representación detallada.
#### Parámetros
N/A
#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Estado en [representaciones Detail](#recurso-estado)
404|No existe un objeto estado con el ID solicitado|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error

#### GET /calificaciones/{id}
Retorna una colección de objetos Calificaciones en representación detallada.
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


#### POST /calificaciones
Es el encargado de crear objetos Calificaciones.
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

#### PUT /calificaciones/{id}
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

#### DELETE /calificaciones/{id}
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

# API REST recursos Contratista y CuentaCobre

# Tabla de contenidos
-  [Introducción](#introducción)
-  [API](#api-de-la-aplicación-books)
  -  [Recurso Contratista](#Recurso-contratista)
    - [GET /contratistas](#GET-/contratistas)
    - [GET /contratistas/{id}](#GET-/contratistas/{id})
    - [POST /contratistas](#POST-/contratistas)
    - [PUT /contratistas/{id}](#PUT-/contratistas/{id})
    - [DELETE /contratistas/{id}](#DELETE-/contratistas/{id})
    - [GET /contratistas/{id}/cuentasCobro](#GET-/contratistas/{id}/cuentasCobro)
    - [GET /contratistas/{id}/cuentasCobro/{cuentasid}](#GET-/contratistas/{id}/cuentasCobro/{cuentasid})
    - [POST /contratistas/{id}/cuentasCobro](#POST-/contratistas/{id}/cuentasCobro)
    - [PUT /contratistas/{id}/cuentasCobro/{cuentasid}](#PUT-/contratistas/{id}/cuentasCobro/{cuentasid})
    - [DELETE /contratistas/{id}/cuentasCobro/{cuentasid}](#DELETE-/contratistas/{id}/cuentasCobro/{cuentasid})

# API Rest
## Introducción
La comunicación entre cliente y servidor se realiza intercambiando objetos JSON. Para cada entidad se hace un mapeo a JSON, donde cada uno de sus atributos se transforma en una propiedad de un objeto JSON. Todos los servicios se generan en una URL. Por defecto, todas las entidades tienen un atributo `id`, con el cual se identifica cada registro:

```javascript
{
    id: '',
    attribute_1: '',
    attribute_2: '',
    ...
    attribute_n: ''
}
```

Cuando se transmite información sobre un registro específico, se realiza enviando un objeto con la estructura mencionada en la sección anterior.
La única excepción se presenta al solicitar al servidor una lista de los registros en la base de datos, que incluye información adicional para manejar paginación de lado del servidor en el header `X-Total-Count` y los registros se envían en el cuerpo del mensaje como un arreglo.

La respuesta del servidor al solicitar una colección presenta el siguiente formato:

```javascript
[{}, {}, {}, {}, {}, {}]
```

## API de la aplicación huecota
### Recurso Contratista
El objeto Contratista tiene 2 representaciones JSON:	

#### Representación Minimum
```javascript
{
    id: '' /*Tipo Long*/,
    name: '' /*Tipo String*/,
}
```

#### Representación Detail
```javascript
{
    // todo lo de la representación Minimum más los objetos Minimum con relación simple.
    editorial: {
    id: '' /*Tipo Long*/,
    name: '' /*Tipo String*/    }
}
```

#### GET /contratistas

Retorna una colección de objetos Contratista en representación Detail.
Un Contratista en la colección puede tener asociadas varios objetos de tipo: CentaCobro

#### Parámetros

#### N/A

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de [representaciones Detail](#recurso-contratistas)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error

#### GET /contratistas/{id}

Retorna un objeto Contratista en representación Detail.
Un Contratista en la colección puede tener asociadas varios objetos de tipo: CentaCobro

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Contratista a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Contratista en [representaciones Detail](#recurso-contratistas)
404|No existe un objeto Contratista con el ID solicitado|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error

#### POST /contratistas

Es el encargado de crear objetos Contratista.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
body|body|Objeto Contratista que será creado|Sí|[Representación Detail](#recurso-contratistas)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Contratista ha sido creado|[Representación Detail](#recurso-contratistas)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo crear el objeto Book|Mensaje de error

#### PUT /contratistas/{id}

Es el encargado de actualizar objetos Contratista.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Contratista a actualizar|Sí|Integer
body|body|Objeto Book nuevo|Sí|[Representación Detail](#recurso-contratistas)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Contratista actualizado|[Representación Detail](#recurso-contratistas)
412|business exception, no se cumple con las reglas de negocio|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo actualizar el objeto Book|Mensaje de error

#### DELETE /contratistas/{id}

Elimina un objeto Contratista.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Contratista a eliminar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto eliminado|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### GET /contratistas/{id}/cuentasCobro

Retorna una colección de objetos CuentasCobro asociados a un objeto Contratista en representación Detail.

#### Parámetros

#### N/A

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de [representaciones Detail](#recurso-cuentasCobro)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error

#### GET /contratistas/{id}/cuentasCobro/{cuentasid}

Retorna un objeto CuentaCobro asociado a un objeto Contratista en representació Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Book a consultar|Sí|Integer
cuentasid|Path|ID del objeto CuentaCobro a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto CuentaCobro en [representación Detail](#recurso-cuentasCobro)
404|No existe un objeto CuentaCobro con el ID solicitado asociado al objeto Contratista indicado |Mensaje de error
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### POST /contratistas/{id}/cuentasCobro/{cuentasid}

Asocia un objeto Cuenta Cobro a un objeto Contratista.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|PathParam|ID del objeto Contratista al cual se asociará el objeto CuentaCobro|Sí|Integer
cuentasid|PathParam|ID del objeto CuentaCobro a asociar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Objeto CuentaCobro asociado|[Representación Detail de CuentaCobro](#recurso-cuentasCobro)
500|No se pudo asociar el objeto CuentaCobro|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### PUT /contratistas/{id}/cuentasCobro/{cuentasid}

Es el encargado de reemplazar un objeto CuentaCobro asociado a un objeto Contratista.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Contratista cuya CuentaCobro será remplazada|Sí|Integer
cuentasid|PathParam|Objeto CuentaCobro nuevo|Sí|[Representación Detail](#recurso-contratistas)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto CuentaCobro actualizado|[Representación Detail](#recurso-cuentasCobro)
412|business exception, no se cumple con las reglas de negocio|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo actualizar el objeto Book|Mensaje de error

#### DELETE /contratistas/{id}/cuentasCobro/{cuentasid}

Remueve un objeto CuentaCobro de la colección en un objeto Contratista.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Contratista asociado al objeto CuentaCobro|Sí|Integer
cuentasid|Path|ID del objeto CuentaCobro a remover|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto removido|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

[Volver arriba](#tabla-de-contenidos)

# API REST recurso Hueco

# Tabla de contenidos
-  [Introducción](#introducción)
-  [API](#api-de-la-aplicación-huecos)
  - [Recurso Hueco](#recurso-hueco)
    - [GET /huecos](#GET-/huecos)
    - [GET /huecos/{id}](#GET-/huecos/{id})
    - [POST /huecos](#POST-/huecos)
    - [PUT /huecos/{id}](#PUT-/huecos/{id})
    - [DELETE /huecos/{id}](#DELETE-/huecos/{id})

# API Rest
## Introducción
La comunicación entre cliente y servidor se realiza intercambiando objetos JSON. Para cada entidad se hace un mapeo a JSON, donde cada uno de sus atributos se transforma en una propiedad de un objeto JSON. Todos los servicios se generan en la URL /huecota.api/api/. Por defecto, todas las entidades tienen un atributo `id`, con el cual se identifica cada registro:

```javascript
{
    id: '',
    attribute_1: '',
    attribute_2: '',
    ...
    attribute_n: ''
}
```

Cuando se transmite información sobre un registro específico, se realiza enviando un objeto con la estructura mencionada en la sección anterior.
La única excepción se presenta al solicitar al servidor una lista de los registros en la base de datos, que incluye información adicional para manejar paginación de lado del servidor en el header `X-Total-Count` y los registros se envían en el cuerpo del mensaje como un arreglo.

La respuesta del servidor al solicitar una colección presenta el siguiente formato:

```javascript
[{}, {}, {}, {}, {}, {}]
```

## API de la aplicación Huecotá
### Recurso Hueco
El objeto Hueco tiene 2 representaciones JSON:	

#### Representación Minimum
```javascript
{
    id: '' /*Tipo Long*/,
    estado actual: '' /*Tipo Estado*/,
    description: '' /*Tipo String*/,
    fotos: '' /*Tipo Lista<String>*/,
    direccion: '' /*Tipo String*/
}
```

#### Representación Detail
```javascript
{
    // todo lo de la representación Minimum más los objetos Minimum con relación simple.
    editorial: {
    id: '' /*Tipo Long*/}
}
```



#### GET /hueco

Retorna una colección de objetos Hueco en representación Detail.
Cada Hueco en la colección tiene los siguientes objetos: Estado.

#### Parámetros

#### N/A

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de [representaciones Detail](#recurso-hueco)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error

#### GET /huecos/{id}

Retorna una colección de objetos Hueco en representación Detail.
Cada Hueco en la colección tiene los siguientes objetos: Estado.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Hueco a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Hueco en [representaciones Detail](#recurso-hueco)
404|No existe un objeto Hueco con el ID solicitado|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error

#### POST /huecos

Es el encargado de crear objetos Hueco.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
body|body|Objeto Hueco que será creado|Sí|[Representación Detail](#recurso-hueco)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Hueco ha sido creado|[Representación Detail](#recurso-hueco)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo crear el objeto Hueco|Mensaje de error

#### PUT /huecos/{id}

Es el encargado de actualizar objetos Hueco.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Hueco a actualizar|Sí|Integer
body|body|Objeto Hueco nuevo|Sí|[Representación Detail](#recurso-hueco)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Hueco actualizado|[Representación Detail](#recurso-hueco)
412|business exception, no se cumple con las reglas de negocio|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo actualizar el objeto Hueco |Mensaje de error

#### DELETE /hueco/{id}

Elimina un objeto Hueco.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Hueco a eliminar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto eliminado|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

[Volver arriba](#tabla-de-contenidos)

# API REST recursos Ciudad Y Punto

# Tabla de contenidos
-  [Introducción](#introducción)
-  [API](#api-de-Huecota)
  - [Recurso Cliente](#recurso-cliente)
    - [GET /clietes](#GET-/clientes)
    - [GET /clientes/{id}](#GET-/clientes/{id})
    - [POST /clientes](#POST-/clientes)
    - [PUT /clientes/{id}](#PUT-/clientes/{id})
    - [DELETE /clientes/{id}](#DELETE-/clientes/{id})
    - [GET clientes/{clientesid}/puntos](#GET-clientes/{clientesid}/puntos)
    - [GET clientes/{clientesid}/puntos/{puntosid}](#GET-clientes/{clientesid}/puntos/{puntosid})
    - [POST clientes/{clientesid}/puntos](#POST-clientes/{clientesid}/puntosid)
    - [PUT clientes/{clientesid}/puntos/{puntosid}](#PUT-clientes/{clientesid}/puntos/{puntosid})
    - [DELETE clientes/{clientesid}/puntos/{puntosid}](#DELETE-clientes/{clientesid}/puntos/{puntosid}])
   
  - [Recurso Punto](#recurso-punto)
    
  
# API Rest
## Introducción
La comunicación entre cliente y servidor se realiza intercambiando objetos JSON. Para cada entidad se hace un mapeo a JSON, donde cada uno de sus atributos se transforma en una propiedad de un objeto JSON. Todos los servicios se generan en la URL /books_absviews.api/api/. Por defecto, todas las entidades tienen un atributo `id`, con el cual se identifica cada registro:

```javascript
{
    id: '',
    attribute_1: '',
    attribute_2: '',
    ...
    attribute_n: ''
}
```

Cuando se transmite información sobre un registro específico, se realiza enviando un objeto con la estructura mencionada en la sección anterior.
La única excepción se presenta al solicitar al servidor una lista de los registros en la base de datos, que incluye información adicional para manejar paginación de lado del servidor en el header `X-Total-Count` y los registros se envían en el cuerpo del mensaje como un arreglo.

La respuesta del servidor al solicitar una colección presenta el siguiente formato:

```javascript
[{}, {}, {}, {}, {}, {}]
```

## API de la aplicación huecota
### Recurso Book
El objeto Cliente tiene 2 representaciones JSON:	

#### Representación Minimum
```javascript
{
    id: '' /*Tipo Long*/,
    name: '' /*Tipo String*/,
 }
```

#### Representación Detail
```javascript
{
    // todo lo de la representación Minimum más los objetos Minimum con relación simple.
    puntos: {
    id: '' /*Tipo Long*/,
    puntos: '' /*Tipo Integer*/    }
}
```



#### GET /clientes

Retorna una colección de objetos Cliente en representación Detail.
Cada Cliente en la colección tiene embebidos los siguientes objetos: Punto.

#### Parámetros

#### N/A

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de [representaciones Detail](#recurso-cliente)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error

#### GET /clientes/{id}

Retorna una colección de objetos Cliente en representación Detail.
Cada Cliente en la colección tiene los siguientes objetos: Punto.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Cliente a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Cliente en [representaciones Detail](#recurso-clientes)
404|No existe un objeto Cliente con el ID solicitado|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error

#### POST /clietes

Es el encargado de crear objetos Cliente.

#### Parámetros

Nombre|
:--|:--|:--|:--|:--
body|body|Objeto Cliente que será creado|Sí|[Representación Detail](#recurso-cliente)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Cliente ha sido creado|[Representación Detail](#recurso-cliente)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo crear el objeto Cliente|Mensaje de error

#### PUT /clientes/{id}

Es el encargado de actualizar objetos Cliente.

#### Parámetros

Nombre
:--|:--|:--|:--|:--
id|Path|ID del objeto Cliente a actualizar|Sí|Integer
body|body|Objeto Cliente nuevo|Sí|[Representación Detail](#recurso-cliente)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Cliente actualizado|[Representación Detail](#recurso-cliente)
412|business exception, no se cumple con las reglas de negocio|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo actualizar el objeto Cliente|Mensaje de error

#### DELETE /clientes/{id}

Elimina un objeto Cliente.

#### Parámetros

Nombre
:--|:--|:--|:--|:--
id|Path|ID del objeto Cliente a eliminar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto eliminado|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### GET clientes/{clientesid}/puntos

Retorna una colección de objetos Punto asociados a un objeto Cliente en representación Detail.

#### Parámetros

Nombre
:--|:--|:--|:--|:--
id|Path|ID del objeto Cliente a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de objetos Punto en [representación Detail](#recurso-punto)
500|Error consultando categories |Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### GET clientes/{clientesid}/puntos/{puntosid}

Retorna un objeto Punto asociados a un objeto Cliente en representación Detail.

#### Parámetros

Nombre
:--|:--|:--|:--|:--
clientesid|Path|ID del objeto Cliente a consultar|Sí|Integer
puntosid|Path|ID del objeto Punto a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Punto en [representación Detail](#recurso-punto)
404|No existe un objeto Punto con el ID solicitado asociado al objeto Cliente indicado |Mensaje de error
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### POST clientes/{clientesid}/puntos

Asocia un objeto Punto a un objeto Cliente.

#### Parámetros

Nombre
:--|:--|:--|:--|:--
clientes|PathParam|ID del objeto Cliente al cual se asociará el objeto Punto|Sí|Integer
puntosid|PathParam|ID del objeto Punto a asociar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Objeto Punto asociado|[Representación Detail de Punto](#recurso-punto)
500|No se pudo asociar el objeto Punto|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### PUT clientes/{clientesid}/punto/{puntoid}

Es el encargado de remplazar la colección de objetos Punto asociada a un objeto Cliente.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
clientesid|Path|ID del objeto Cliente cuya colección será remplazada|Sí|Integer
puntosid|PathParam|ID del objeto Punto a asociar|Sí|Integer
body|body|Objeto Punto|Sí|[Representación Detail](#recurso-punto)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Se remplazó el objeto|Objeto Punto en [Representación Detail](#recurso-punto)
500|No se pudo remplazar la colección|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### DELETE clientes/{clientesid}/puntos/{puntosid}

Remueve un objeto Punto de la colección en un objeto Cliente.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
clientes|Path|ID del objeto Cliente asociado al objeto Punto|Sí|Integer
puntosid|Path|ID del objeto Punto a remover|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto removido|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error




### Recurso Punto
El objeto Punto tiene 2 representaciones JSON:	

#### Representación Minimum
```javascript
{
    puntos: '' /*Tipo Integer*/,
    
}
```
#### Representación Detail
```javascript
{
    // todo lo de la representación Minimum más los objetos Minimum con relación simple.
    puntos: {
    fecha: '' /*Tipo Date*/,
    cantidad: '' /*Tipo Integer*/    }
}
```

[Volver arriba](#tabla-de-contenidos)

# API:REST;HUECOTÁ - DISEÑO ( ACCIDENTE )
-  [API](#API-HUECOTÁ) : @Author: ma.puentes

/**
* El recurso accidente cuenta con un identificador único. También, se sabe que un accidente tiene un atributo de tipo Direccion que indica
* la dirección donde ocurrió.
*/
  - [Recurso Accidente](#recurso-author)

    - [GET /accidentes](#GET-/accidentes)
    - [GET /accidentes/{id}](#GET-/accidentes/{id})
    - [GET /accidentes/{id}/direccion](#GET-accidentes/{id}/direccion)
    - [GET /accidentes/direccion/{id}](#GET-accidentes/direccion/{id})
    - [POST /accidentes](#POST-/accidentes)
    - [POST /accidentes/{id}/direccion/](#POST-accidentes/{id}/direccion)
    - [PUT /accidentes/{id}](#PUT-/accidentes/{id})
    - [PUT /accidentes/{id}/direccion](#PUT-accidentes/{id}/direccion)
    - [DELETE /accidentes/{id}](#DELETE-/accidentes/{id})
    
  

### RECURSO ACCIDENTE
El objeto accidente tiene 1 representacion JSON:	

#### Representación 1

{
    id: '' /*Tipo Long*/,
    direccion: '' /*Tipo String*/
    ciudadano: '' /*Tipo Ciudadano*/
}
   
#### GET /accidentes/

Retorna una coleccion de objetos tipo accidente en representación Detail.
Cada accidente tiene id,direccion y ciudadano.

#### Parámetros

N/A

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Respuesta coleccion de accidentes [representaciones Detail](#recurso-accidente)
404|No existe algun objeto accidente|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error


#### GET /accidentes/{id}

Retorna un objeto tipo accidente en representación Detail.
Cada accidente tiene id,direccion y ciudadano.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto accidente a buscar|Sí|Long


#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto accidente como respuesta [representaciones Detail](#recurso-accidente)
404|No existe el objeto accidente con id asociado|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error


#### GET /accidentes/{id}/direccion

Retorna un objeto tipo direccion en representación Detail.
Cada accidente tiene id,direccion y ciudadano.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto accidente a buscar|Sí|Long


#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto direccion asociado al accidente con id dado [representaciones Detail](#recurso-direccion)
404|No existe objeto direccion asociada al accidente con id dado|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error



#### GET /accidentes/direccion/{id}

Retorna una coleccion en representación Detail de objetos tipo accidente asociados a una direccion con id dado.
Cada accidente tiene id,direccion y ciudadano.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID de la direccion|Sí|Long


#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Coleccion de objetos tipo accidente asociados a una direccion con id dado [representaciones Detail](#recurso-accidente)
404|No existe algun objeto de tipo accidente asociada a la direccion con id dado|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error

#### POST /accidentes

Es el encargado de crear objetos accidente.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
body|body|Objeto accidente que será creado|Sí|[Representación Detail](#recurso-accidente)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto accidente ha sido creado|[Representación Detail](#recurso-accidente)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo crear el objeto accidente|Mensaje de error


#### POST /accidentes/{id}/direccion/

Es el encargado de agregar una direccion a un determinado accidente.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|identificador del accidente al que se va a asociar una direccion|Sí|[Representación Detail](#recurso-accidente)
body|body|Objeto direccion que será asociado a un accidente|Sí|[Representación Detail](#recurso-direccion)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto direccion ha sido asociado a un accidente con id dado|[Representación Detail](#recurso-accidente)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo crear el objeto direccion|Mensaje de error


#### PUT /accidentes/{id}/

Es el encargado de actualizar objetos tipo accidente.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto accidente a actualizar|Sí|Long


#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto accidente actualizado|[Representación Detail](#recurso-accidente)
412|business exception, no se cumple con las reglas de negocio|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo actualizar el objeto accidente | Mensaje de error


#### PUT /accidentes/{id}/direccion

Es el encargado de actualizar un objeto tipo direccion a un accidente con id dado.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto accidente al cual se le va a actualizar su direccion|Sí|Long
body|body|Objeto direccion que será actualizado|Sí|[Representación Detail](#recurso-direccion)


#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto direccion del accidente asociado al id se ha actualizado|[Representación Detail](#recurso-direccion)
412|business exception, no se cumple con las reglas de negocio|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo actualizar el objeto direccion del accidente asociado | Mensaje de error


#### DELETE /accidentes/{id}

Elimina el objeto tipo accidente con id dado.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto accidente a eliminar|Sí|String

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto eliminado|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

[Volver arriba](#tabla-de-contenidos)


