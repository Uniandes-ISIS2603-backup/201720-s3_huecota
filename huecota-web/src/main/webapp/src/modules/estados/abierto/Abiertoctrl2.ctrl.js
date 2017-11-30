/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("AbiertoModule");
    mod.constant("AbiertoContext", "estadosAbiertos");
    mod.constant("huecosContext", "api/huecos");
    mod.controller('abiertoCtrl2', ['$scope', '$http', 'huecosContext','$state', 'AbiertoContext' ,
        function ($scope, $http, huecosContext, $state, AbiertoContext) {
            $http.get(huecosContext + '/' + $state.params.huecoId  + '/'+ AbiertoContext ).then(function (response) {
                $scope.estadosRecords = response.data;
            });   
        }
    ]);
})(window.angular);