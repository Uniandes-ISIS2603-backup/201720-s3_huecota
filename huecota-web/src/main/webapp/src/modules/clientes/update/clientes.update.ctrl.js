/* global idsPuntos, cliente, punto */

(
        function (ng) {
            var mod = ng.module("clienteModule");
            mod.constant("clientesContext", "api/clientes");
            mod.constant("puntosContext", "api/puntos");
            mod.controller('clienteUpdateCtrl', ['$scope', '$http', 'clientesContext', '$state', 'puntosContext', '$rootScope', '$filter',
                function ($scope, $http, clientesContext, $state, puntosContext, $rootScope) {
                    $rootScope.edit = true;

                    var idCliente = $state.params.clienteId;

                    // Este arreglo guardara los ids de los books asociados y por asociar al autor.
                    var idsPunto = [];

                    // Este arreglo mostrará los books una vez esten filtrados visualmente por lo que el autor ya tiene asociado.
                    $scope.allPuntosShow = [];

                    //Consulto el autor a editar.
                    $http.get(clientesContext + '/' + idCliente).then(function (response) {
                        var cliente = response.data;
                        $scope.clienteNombre = cliente.nombre;
                        $scope.clienteCedula = cliente.cedula;
                        $scope.allPuntosCliente = cliente.puntos;
                        $scope.mergePuntos($scope.allPuntosCliente);
                    });

                    /*
                     * Esta función añade los ids de los books que ya tiene el autor asociado.
                     * @param {type} books: Son los books que ya tiene asociado el autor.
                     * @returns {undefined}
                     */
                    $scope.mergePuntos = function (puntos) {
                        for (var item in puntos) {
                            idsPuntos.push("" + puntos[item].id);
                        }
                        $scope.getPuntos(puntos);
                    };

                    /*
                     * Esta función recibe como param los books que tiene el autor para hacer un filtro visual con todos los books que existen.
                     * @param {type} books
                     * @returns {undefined}
                     */
                    $scope.getPuntos = function (puntos) {
                        $http.get(puntosContext).then(function (response) {
                            $scope.Allpuntos = response.data;
                            $scope.puntoCliente = puntos;

                            var filteredPuntos = $scope.Allpuntos.filter(function (Allpuntos) {
                                return $scope.puntosCliente.filter(function (puntosCliente) {
                                    return puntosCliente.id === Allpuntos.id;
                                }).length === 0;
                            });

                            $scope.allPuntosShow = filteredPuntos;

                        });
                    };


                    //funciones para el drag and drop de HTML5 nativo
                    $scope.allowDrop = function (ev) {
                        ev.preventDefault();
                    };

                    $scope.drag = function (ev) {
                        ev.dataTransfer.setData("text", ev.target.id);
                    };

                    $scope.dropAdd = function (ev) {
                        ev.preventDefault();
                        var data = ev.dataTransfer.getData("text");
                        ev.target.appendChild(document.getElementById(data));
                        //Cuando un book se añade al autor, se almacena su id en el array idsBook
                        idsPunto.push("" + data);
                    };

                    $scope.dropDelete = function (ev) {
                        ev.preventDefault();
                        var data = ev.dataTransfer.getData("text");
                        ev.target.appendChild(document.getElementById(data));
                        //Para remover el book que no se va asociar, por eso se usa el splice que quita el id del book en el array idsBook
                        var index = idsPunto.indexOf(data);
                        if (index > -1) {
                            idsPunto.splice(index, 1);
                        }
                    };

                    $scope.createCliente = function () {
                        /*Se llama a la función newBooks() para buscar cada uno de los ids de los books
                         en el array que tiene todos los books y así saber como queda la lista final de los books asociados al autor.
                         */
                        $scope.newPuntos();
                        $http.put(clientesContext + "/" + idCliente, {
                            nombre: $scope.clienteNombre,
                            cedula: $scope.clienteCedula
                        }).then(function (response) {
                            if (idsPunto.length >= 0) {
                                $http.put(clientesContext + "/" + response.data.id + "/puntos", $scope.allPuntosCeliente).then(function (response) {
                                });
                            }
                            //Author created successfully
                            $state.go('clientesList', {clienteId: response.data.id}, {reload: true});
                        });
                    };

                    $scope.newPuntos = function () {
                        $scope.allPuntosCliente = [];
                        for (var ite in idsPunto) {
                            for (var all in $scope.Allpuntos) {
                                if ($scope.Allpuntos[all].id === parseInt(idsPunto[ite])) {
                                    $scope.allPuntosCliente.push($scope.Allpuntos[all]);
                                }
                            }
                        }
                    };
                }
            ]);
        }
)(angular);