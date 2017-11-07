(function (ng) {
    var mod = ng.module("clienteModule");
    mod.constant("clientesContext", "api/clientes");
    mod.controller('clienteNewCtrl', ['$scope', '$http', 'clientesContext', '$state', 'puntosContext', '$rootScope',
        function ($scope, $http, clientesContext, $state, puntosContext, $rootScope) {
            $rootScope.edit = false;
            $scope.createCliente = function () {
                $http.post(clientesContext, {
                    nombre: $scope.clienteNombre,
                    cedula: $scope.clienteCedula
                }).then(function (response) {
                    $state.go('clientesList', {clienteId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(angular);