(
        function (ng) {
            var mod = ng.module("huecosModule");
            mod.constant("huecosContext", "api/huecos");
            mod.controller('huecosUpdateCtrl', ['$scope', '$http', 'huecosContext', '$state', 'huecosContext', '$rootScope', '$filter',
                function ($scope, $http, huecosContext, $state, huecosContext, $rootScope, $filter) {
                    $rootScope.edit = true;

                    var idhueco = $state.params.huecoId;

                    // Este arreglo guardara los ids de los huecos asociados y por asociar al direccion.
                    var idsHueco = [];

                    // Este arreglo mostrará los huecos una vez esten filtrados visualmente por lo que el direccion ya tiene asociado.
                    $scope.allHuecosShow = [];

                    //Consulto el hueco a editar.
                    $http.get(huecosContext + '/' + idhueco).then(function (response) {
                        var hueco = response.data;
                        $scope.huecoId = hueco.id;
                        $scope.huecoDescripcion = hueco.descripcion;
                        $scope.huecoDireccion = hueco.direccion;
                    });

                    /*
                     * Esta función recibe como param los huecos que tiene el direccion para hacer un filtro visual con todos los huecos que existen.
                     * @param {type} huecos
                     * @returns {undefined}
                     */
                    $scope.getHuecos = function (huecos) {
                        $http.get(huecosContext).then(function (response) {
                            $scope.Allhuecos = response.data;
                            $scope.huecosDireccion = huecos;

                            var filteredHuecos = $scope.Allhuecos.filter(function (Allhuecos) {
                                return $scope.huecosDireccion.filter(function (huecosDireccion) {
                                    return huecosDireccion.id == Allhuecos.id;
                                }).length == 0
                            });

                            $scope.allHuecosShow = filteredHuecos;

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
                        //Cuando un hueco se añade al direccion, se almacena su id en el array idsHueco
                        idsHueco.push("" + data);
                    };

                    $scope.dropDelete = function (ev) {
                        ev.preventDefault();
                        var data = ev.dataTransfer.getData("text");
                        ev.target.appendChild(document.getElementById(data));
                        //Para remover el hueco que no se va asociar, por eso se usa el splice que quita el id del hueco en el array idsHueco
                        var index = idsHueco.indexOf(data);
                        if (index > -1) {
                            idsHueco.splice(index, 1);
                        }
                    };

                    $scope.createhueco = function () {
                        /*Se llama a la función newHuecos() para buscar cada uno de los ids de los huecos
                         en el array que tiene todos los huecos y así saber como queda la lista final de los huecos asociados al direccion.
                         */
                        $scope.newHuecos();
                        $http.put(huecosContext + "/" + idhueco, {
                            name: $scope.huecoName,
                            birthDate: $scope.huecoBirthDate,
                            description: $scope.huecoDescription,
                            image: $scope.huecoImage
                        }).then(function (response) {
                            if (idsHueco.length >= 0) {
                                $http.put(huecosContext + "/" + response.data.id + "/huecos", $scope.allHuecoshueco).then(function (response) {
                                });
                            }
                            //hueco created successfully
                            $state.go('huecosList', {huecoId: response.data.id}, {reload: true});
                        });
                    };

                    $scope.newHuecos = function () {
                        $scope.allHuecoshueco = [];
                        for (var ite in idsHueco) {
                            for (var all in $scope.Allhuecos) {
                                if ($scope.Allhuecos[all].id === parseInt(idsHueco[ite])) {
                                    $scope.allHuecoshueco.push($scope.Allhuecos[all]);
                                }
                            }
                        }
                    };
                }
            ]);
        }
)(window.angular);