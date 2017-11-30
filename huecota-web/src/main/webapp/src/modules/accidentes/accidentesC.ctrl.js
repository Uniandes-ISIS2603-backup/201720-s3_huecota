/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("AccidenteModule");
    mod.constant("accidentesContextC", "accidentes");
    mod.constant("clientesContext", "api/clientes");
    mod.controller('AccidenteCtrl2', ['$scope', '$http', 'clientesContext','$state', 'accidentesContextC' ,
        function ($scope, $http, clientesContext, $state, accidentesContextC) {
            $http.get(clientesContext + '/' + $state.params.clienteId  + '/'+ accidentesContextC ).then(function (response) {
                $scope.accidentesRecords = response.data;
            });   
        }
    ]);
})(window.angular);