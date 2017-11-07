(function (ng) {
    var mod = ng.module("EnProgresoModule");
    mod.constant("EnProgresoContext", "api/estadosEnProgreso");
    mod.controller('enProgresoCtrl', ['$scope', '$http', 'EnProgresoContext', '$state',
        function ($scope, $http, EnProgresoContext, $state) {
            console.info("Dar estados en progreso");
            $http.get(EnProgresoContext).then(function (response) {
                $scope.estadosRecords = response.data;
            });
            
            if (($state.params.stateId !== undefined)) {
                $http.get(EnProgresoContext + '/' + $state.params.stateId).then(function (response) {
                    $scope.estadosRecords = response.data.estadosAbierto;
                    $scope.currentEstado = response.data;
                });
            }
            
            //borrado
                        this.deleteRecord = function(estado){
                    return $http.delete(EnProgresoContext + "/" + estado.id)
                            .then(function () {
                                // $http.delete es una promesa
                                // cuando termine bien, cambie de estado
                                var index = $scope.entrenadorRecords.indexOf(estado);                               
                                if (index > -1) {
                                    $scope.entrenadorRecords.splice(index, 1);
                                }
                            });
            }

        }
    ]);
}
)(angular);