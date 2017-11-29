(function(ng){
    var mod = ng.module("contratistaModule");
    mod.constant("contratistasContext", "api/contratistas");
    mod.constant("cuentasContext", "cuentascobro");
    mod.controller('contratistaUpdateCuentaCtrl', ['$scope', '$http', 'contratistasContext', 'cuentasContext', '$state', '$rootScope',
        function($scope, $http, contratistasContext, cuentasContext, $state, $rootScope){
            $rootScope.edit = true;
            $scope.data = {};
            var idContratista = $state.params.contratistaId;
            var idCuenta = $state.params.cuentaId;
            $http.get(contratistasContext + '/' + idContratista + '/' + cuentasContext + '/' + idCuenta).then(function(response){
                var cuenta = response.data;
                $scope.data.precio = cuenta.precio;
            });
            $scope.createCuenta = function() {
            $http.put(contratistasContext + '/' + idContratista + '/' + cuentasContext + '/' + idCuenta, $scope.data).then(function(response){
                $state.go('contratistaDetail', {contratistaId: idContratista}, {reload: true});
            });
        };
    }]);
})(window.angular);