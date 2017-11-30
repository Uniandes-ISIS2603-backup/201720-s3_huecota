/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("puntoModule");
    mod.constant("puntosContext", "puntos");
    mod.constant("clientesContext", "api/clientes");
    mod.controller('puntoCtrl', ['$scope', '$http', 'clientesContext','$state', 'puntosContext',
        function ($scope, $http, clientesContext, $state, puntosContext) {
            $http.get(clientesContext + '/' + $state.params.clienteId  + '/'+ puntosContext ).then(function (response) {
                $scope.puntosRecords = response.data;
            });
            if ($state.params.puntoId !== undefined) {
                $http.get(clientesContext + '/' + $state.params.clienteId +'/' + puntosContext + '/' + $state.params.puntoId).then(function (response) {
                    $scope.currentPunto = response.data;
                });
            }    
        }
    ]);
}
)(window.angular);