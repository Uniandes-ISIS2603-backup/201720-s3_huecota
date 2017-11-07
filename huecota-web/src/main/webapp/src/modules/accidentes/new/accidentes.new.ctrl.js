(function (ng) {
    var mod = ng.module("AccidenteModule");
    mod.constant("accidentesContext", "api/accidentes");
    mod.controller('AccidenteNewCtrl', ['$scope', '$http', 'accidentesContext', '$state', '$rootScope',
        function ($scope, $http, accidentesContext, $state, $rootScope)
		{
            $rootScope.edit = false;
            $scope.createAccidente = function ()
			{
                $http.post(accidentesContext, {
                    fecha: $scope.fechaAccidente,
                    descripcion: $scope.descripcionAccidente
               
                }).then(function (response) {
                    
                    $state.go('accidentesList', {accidenteId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);
