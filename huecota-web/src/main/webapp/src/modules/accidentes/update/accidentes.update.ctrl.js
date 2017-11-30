(function (ng) {
    var mod = ng.module("AccidenteModule");
    mod.constant("accidentesContext", "api/accidentes");
	mod.controller('AccidenteUpdateCtrl', ['$scope', '$http', 'accidentesContext', '$state', '$rootScope',
        function($scope, $http, accidentesContext, $state, $rootScope)
		{
            $rootScope.edit = true;
            var idAccidente = $state.params.accidenteId;
            $http.get(accidentesContext + '/' + idAccidente).then(function(response){
                var accidente = response.data;
                $scope.fechaAccidente = accidente.fecha;
				$scope.descripcionAccidente = accidente.descripcion;
            });
            $scope.updateAccidente = function() {
            $http.put(accidentesContext + '/' + idAccidente).then(function(response)
			{
				fecha: $scope.fechaAccidente;
				descripcion: $scope.descripcionAccidente;
                $state.go('accidentesList', {accidenteId: idAccidente}, {reload: true});
            });
        };
    }]);
})(window.angular);
