/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng)
{
    var mod = ng.module("DireccionModule");
    mod.constant("direccionesContext", "api/");
    mod.controller('DireccionCtrl', ['$scope', '$http', 'direccionesContext', '$state',
        function ($scope, $http, direccionesContext, $state) {
            $http.get(direccionesContext).then(function (response) {
                $scope.direccionesRecords = response.data;
            });

            if ($state.params.direccionId !== undefined) {
                $http.get(direccionesContext + '/' + $state.params.direccionId).then(function (response) {
                    $scope.direccionesRecords = response.data.punto;
                    $scope.currentDireccion = response.data;
                });
            }
        }
    ]);
}
)(angular);

