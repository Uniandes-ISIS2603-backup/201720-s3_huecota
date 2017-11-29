(function(ng){
    var mod = angular.module("contratistaModule");
    mod.constant("contratistasContext", "api/contratistas");
    mod.constant("cuentasContext", "cuentascobro");
    mod.controller('contratistaDeleteCuentaCtrl', ['$scope', '$http', 'contratistasContext', 'cuentasContext', '$state', function($scope, $http, contratistasContext, cuentasContext, $state){
            var idContratista = $state.params.contratistaId;
            var idCuenta = $state.params.cuentaId;
            $scope.idContratista = $state.params.contratistaId;
            $scope.deleteCuenta = function(){
                $http.delete(contratistasContext + '/' + idContratista + '/' + cuentasContext + '/' + idCuenta, {}).then(function(response){
                    $state.go('contratistaDetail', {contratistaId: idContratista}, {reload: true});
                });
            };
    }]);
})(window.angular);