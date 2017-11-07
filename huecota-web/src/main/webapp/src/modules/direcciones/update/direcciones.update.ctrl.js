(function (ng) {
    var mod = ng.module("DireccionModule");
    mod.constant("direccionesContext", "api/direcciones");
    mod.controller('DireccionUpdateCtrl', ['$scope', '$http', 'direccionesContext', '$state', '$rootScope',
        function ($scope, $http, direccionesContext, $state, $rootScope)
		{
			
            var direccionId = $state.params.direccionId;
            $scope.updateDireccion= function ()
			{
                $http.put(direccionesContext + "/" + direccionId,
				{
                    tipoVia: $scope.tipoViaDireccion,
                    numero: $scope.numeroDireccion,
					letra: $scope.letraDireccion,
					cuadrante: $scope.cuadranteDireccion,
					direccionRaw: $scope.direccionRaw
					
                }).then(function (response)
				{
                       //Author updated successfully
                   $state.go('direccionesList', {direccionId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);
