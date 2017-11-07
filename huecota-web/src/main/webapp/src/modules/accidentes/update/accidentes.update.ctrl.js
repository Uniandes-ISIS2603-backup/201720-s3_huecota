(function (ng) {
    var mod = ng.module("AccidenteModule");
    mod.constant("accidentesContext", "api/accidentes");
    mod.controller('AccidenteUpdateCtrl', ['$scope', '$http', 'accidentesContext', '$state', 'accidentesContext', '$rootScope',
        function ($scope, $http, accidentesContext, $state, $rootScope)
		{
			
            var accidenteId = $state.params.accidenteId;
            $scope.updateAccidente = function ()
			{
                $http.put(accidentesContext + "/" + accidenteId,
				{
                    fecha: $scope.fechaAccidente,
                    descripcion: $scope.descripcionAccidente
                }).then(function (response)
				{
                       //Author updated successfully
                   $state.go('accidentesList', {accidenteId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);
