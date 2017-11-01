/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("clienteModule");
    mod.constant("clientesContext", "api/clientes");
    mod.controller('clienteCtrl', ['$scope', '$http', 'clientesContext', '$state',
        function ($scope, $http, clientesContext, $state) {
            $http.get(clientesContext).then(function (response) {
                $scope.clientesRecords = response.data;
            });

            if ($state.params.clienteId !== undefined) {
                $http.get(clientesContext + '/' + $state.params.clienteId).then(function (response) {
                    $scope.puntosRecords = response.data.punto;
                    $scope.currentCliente = response.data;
                });
            }
        }
    ]);
}
)(angular);

