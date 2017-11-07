(function (ng) {
    var mod = ng.module("AbiertoModule");
    mod.constant("AbiertoContext", "api/estadosAbierto");
    mod.controller('abiertoCtrl', ['$scope', '$http', 'AbiertoContext', '$state',
        function ($scope, $http, AbiertoContext, $state) {
            console.info("Dar estados abiertos");
            $http.get(AbiertoContext).then(function (response) {
                $scope.estadosRecords = response.data;
            });
            
            //borrado
                        this.deleteRecord = function(estado){
                    return $http.delete(AbiertoContext + "/" + estado.id)
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