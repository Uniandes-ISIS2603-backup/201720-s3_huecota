(function(ng){
    var mod = ng.module('contratistaModule');
    mod.constant("contratistasContext", "api/contratistas");
    mod.constant("cuentasCobroContext", "cuentascobro");
    mod.controller('contratistaCreateCuentaCtrl', ['$scope', '$http', 'contratistasContext', 'cuentasCobroContext', '$state', '$rootScope',
    function($scope, $http, contratistasContext, cuentasCobroContext, $state, $rootScope){
        $rootScope.edit = false;
        $rootScope.id = $state.params.contratistaId;
        var idcontratista = $state.params.contratistaId;
        $scope.createCuenta = function() {
            $http.post(contratistasContext + '/' + idcontratista + '/' + cuentasCobroContext, $scope.data).then(function(response){
                $state.go('contratistaDetail', {contratistaId: idcontratista}, {reload: true});
            });
        };
    }]);
})(window.angular);