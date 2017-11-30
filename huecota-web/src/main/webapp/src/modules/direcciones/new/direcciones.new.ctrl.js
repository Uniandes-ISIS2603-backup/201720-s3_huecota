(function (ng) {
    var mod = ng.module("DireccionModule");
    mod.constant("direccionesContext", "api/direcciones");
    mod.controller('DireccionNewCtrl', ['$scope', '$http', 'direccionesContext', '$state', '$rootScope',
        function ($scope, $http, direccionesContext, $state, $rootScope)
		{
            $rootScope.edit = true;
            $scope.createDireccion = function ()
			{
                $http.post(direccionesContext, {
                    tipoVia: $scope.tipoViaDireccion,
                    numero: $scope.numeroDireccion,
					letra: $scope.letraDireccion,
					cuadrante:$scope.cuadranteDireccion,
					direccionRaw: $scope.direccionRaw
               
                }).then(function (response) {
                    
                    $state.go('direccionesList', {direccionId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);
