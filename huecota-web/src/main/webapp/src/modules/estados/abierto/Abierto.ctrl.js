(function (ng) {
    var mod = ng.module("AbiertoModule");
    mod.constant("AbiertoContext", "api/estadosAbierto");
    mod.controller('abiertoCtrl', ['$scope', '$http', 'AbiertoContext', '$state',
        function ($scope, $http, AbiertoContext, $state) {
            console.info("Dar estados abiertos");
            $http.get(AbiertoContext).then(function (response) {
                $scope.estadosRecords = response.data;
            });
            
            if (($state.params.stateId !== undefined)) {
                $http.get(AbiertoContext + '/' + $state.params.stateId).then(function (response) {
                    $scope.estadosRecords = response.data.estadosAbierto;
                    $scope.currentEstado = response.data;
                });
            }

        }
    ]);
}
)(angular);