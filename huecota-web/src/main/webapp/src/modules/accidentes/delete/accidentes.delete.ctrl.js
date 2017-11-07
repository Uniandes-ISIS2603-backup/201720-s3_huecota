(function (ng) {
    var mod = ng.module("AccidenteModule");
    mod.constant("accidentesContext", "api/accidentes");
    mod.controller('AccidenteDeleteCtrl', ['$scope', '$http', 'accidentesContext', '$state', 'accidentesContext', '$rootScope',
        function ($scope, $http, accidentesContext, $state, $rootScope)
		{
            var accidenteId = $state.params.accidenteId;
            $scope.deleteAccidente = function ()
			{
                $http.delete(accidentesContext + '/' + accidenteId, {}).then(function (response)
				{
                    $state.go('accidentesList', {accidenteId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);
