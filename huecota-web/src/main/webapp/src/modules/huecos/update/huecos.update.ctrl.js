(
        function (ng) {
            var mod = ng.module("huecosModule");
            mod.constant("huecosContext", "api/huecos");
            mod.controller('huecosUpdateCtrl', ['$scope', '$http', 'huecosContext', '$state', 'booksContext', '$rootScope', '$filter',
                function ($scope, $http, huecosContext, $state, booksContext, $rootScope, $filter) {
                    $rootScope.edit = true;

                    var idhueco = $state.params.huecoId;

                    // Este arreglo guardara los ids de los books asociados y por asociar al autor.
                    var idsBook = [];

                    // Este arreglo mostrará los books una vez esten filtrados visualmente por lo que el autor ya tiene asociado.
                    $scope.allBooksShow = [];

                    //Consulto el hueco a editar.
                    $http.get(huecosContext + '/' + idhueco).then(function (response) {
                        var hueco = response.data;
                        $scope.huecoDescripcion = hueco.descripcion;
                        $scope.huecoDireccion = hueco.direccion;
                        $scope.huecoImagen = hueco.imagen;
                    });

                    /*
                     * Esta función recibe como param los books que tiene el autor para hacer un filtro visual con todos los books que existen.
                     * @param {type} books
                     * @returns {undefined}
                     */
                    $scope.getBooks = function (books) {
                        $http.get(booksContext).then(function (response) {
                            $scope.Allbooks = response.data;
                            $scope.bookshueco = books;

                            var filteredBooks = $scope.Allbooks.filter(function (Allbooks) {
                                return $scope.bookshueco.filter(function (bookshueco) {
                                    return bookshueco.id == Allbooks.id;
                                }).length == 0
                            });

                            $scope.allBooksShow = filteredBooks;

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
                        idsBook.push("" + data);
                    };

                    $scope.dropDelete = function (ev) {
                        ev.preventDefault();
                        var data = ev.dataTransfer.getData("text");
                        ev.target.appendChild(document.getElementById(data));
                        //Para remover el book que no se va asociar, por eso se usa el splice que quita el id del book en el array idsBook
                        var index = idsBook.indexOf(data);
                        if (index > -1) {
                            idsBook.splice(index, 1);
                        }
                    };

                    $scope.createhueco = function () {
                        /*Se llama a la función newBooks() para buscar cada uno de los ids de los books
                         en el array que tiene todos los books y así saber como queda la lista final de los books asociados al autor.
                         */
                        $scope.newBooks();
                        $http.put(huecosContext + "/" + idhueco, {
                            name: $scope.huecoName,
                            birthDate: $scope.huecoBirthDate,
                            description: $scope.huecoDescription,
                            image: $scope.huecoImage
                        }).then(function (response) {
                            if (idsBook.length >= 0) {
                                $http.put(huecosContext + "/" + response.data.id + "/books", $scope.allBookshueco).then(function (response) {
                                });
                            }
                            //hueco created successfully
                            $state.go('huecosList', {huecoId: response.data.id}, {reload: true});
                        });
                    };

                    $scope.newBooks = function () {
                        $scope.allBookshueco = [];
                        for (var ite in idsBook) {
                            for (var all in $scope.Allbooks) {
                                if ($scope.Allbooks[all].id === parseInt(idsBook[ite])) {
                                    $scope.allBookshueco.push($scope.Allbooks[all]);
                                }
                            }
                        }
                    };
                }
            ]);
        }
)(window.angular);