(function (ng) {
    var mod = ng.module("CerradoModule");
    mod.constant("CerradoContext", "api/estadosCerrado");
    mod.controller('cerradoCtrl', ['$scope', '$http', 'CerradoContext', '$state',
        function ($scope, $http, CerradoContext, $state) {
            console.info("Dar estados cerrados");
            $http.get(CerradoContext).then(function (response) {
                $scope.estadosRecords = response.data;
            });
            
            if (($state.params.stateId !== undefined)) {
                $http.get(CerradoContext + '/' + $state.params.stateId).then(function (response) {
                    $scope.estadosRecords = response.data.estadosAbierto;
                    $scope.currentEstado = response.data;
                });
            }
        }
    ]);
}
)(angular);