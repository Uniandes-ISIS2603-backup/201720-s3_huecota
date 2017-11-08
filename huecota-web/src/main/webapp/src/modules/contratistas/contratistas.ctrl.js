(function(ng) {
    var mod = ng.module("contratistaModule");
    mod.constant("contratistasContext", "api/contratistas");
    mod.controller('contratistaCtrl', ['$scope', '$http', 'contratistasContext', '$state', function($scope, $http, contratistasContext, $state){
            $http.get(contratistasContext).then(function(response){
                $scope.contratistasRecords = response.data;
            });
            if(($state.params.contratistaId !== null) && ($state.params.contratistaId !== undefined)){
                $http.get(contratistasContext + '/' + $state.params.contratistaId).then(function(response){
                    $scope.cuentasRecords = response.data.cuentasCobro;
                    $scope.currentContratista = response.data;
                });
            }
    }]);
})(window.angular);