(function (ng) {
    var mod = ng.module("AccidenteModule");
    mod.constant("accidentesContext", "api/accidentes");
	mod.controller('AccidenteUpdateCtrl', ['$scope', '$http', 'accidentesContext', '$state', '$rootScope',
        function($scope, $http, accidentesContext, $state, $rootScope)
		{
            $rootScope.edit = true;
            $scope.data = {};
            var idAccidente = $state.params.accidenteId;
            $http.get(accidentesContext + '/' + idAccidente).then(function(response){
                var accidente = response.data;
                $scope.data.fechaAccidente = accidente.fecha;
				$scope.data.descripcionAccidente = accidente.descripcion;
            });
            $scope.updateAccidente = function() {
            $http.put(accidentesContext + '/' + idAccidente, $scope.data).then(function(response)
			{
				fecha: $scope.data.fechaAccidente;
				descripcion: $scope.data.descripcionAccidente;
                $state.go('accidentesList', {accidenteId: idAccidente}, {reload: true});
            });
        };
    }]);
})(window.angular);
