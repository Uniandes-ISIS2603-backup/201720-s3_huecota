/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("puntoModule");
    mod.constant("puntosContext", "api/puntos");
    mod.controller('puntCtrl', ['$scope', '$http', 'puntosContext', '$state',
        function ($scope, $http, puntosContext, $state) {
            $http.get(puntosContext).then(function (response) {
                $scope.puntosRecords = response.data;
            });
            
            if ($state.params.puntoId !== undefined) {
                $http.get(puntosContext + '/' + $state.params.puntoId).then(function (response) {
                    $scope.currentPunto = response.data;
                });
            }
        }
    ]);
}
)(angular);


