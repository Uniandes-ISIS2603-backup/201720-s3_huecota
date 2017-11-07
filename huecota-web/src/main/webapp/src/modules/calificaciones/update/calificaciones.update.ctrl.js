(
        function (ng) {
            var mod = ng.module("calificacionModule");
            mod.constant("calificacionesContext", "api/calificaciones");
            mod.controller('calificacionUpdateCtrl', ['$scope', '$http', 'calificacionesContext', '$state', '$rootScope', '$filter',
                function ($scope, $http, calificacionesContext, $state, $rootScope, $filter) {
                    $rootScope.edit = true;

                    var idCalificacion = $state.params.calificacionId;

                    //Consulto el autor a editar.
                    $http.get(calificacionesContext + '/' + idCalificacion).then(function (response) {
                        var calificacion = response.data;
                        $scope.calificacionNota = calificacion.nota;
                        $scope.calificacionComentario = calificacion.comentario;
                    });


                    $scope.createCalificacion = function () {
                        $http.put(calificacionesContext + "/" + idCalificacion, {
                            nota: $scope.calificacionNota,
                            comentario: $scope.calificacionComentario
                        }).then(function (response) {
                            $state.go('calificacionesList', {calificacionId: response.data.id}, {reload: true});
                        });
                    };

                }
            ]);
        }
)(window.angular);