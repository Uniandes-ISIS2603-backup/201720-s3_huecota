(function (ng) {
    var mod = ng.module("DireccionModule");
    mod.constant("direccionesContext", "api/direcciones");
    mod.controller('DireccionDeleteCtrl', ['$scope', '$http', 'direccionesContext', '$state', '$rootScope',
        function ($scope, $http, direccionesContext, $state, $rootScope)
		{
            var direccionId = $state.params.direccionId;
            $scope.deleteDireccion = function ()
			{
                $http.delete(direccionesContext + '/' + direccionId, {}).then(function (response)
				{
                    $state.go('direccionesList', {direccionId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);
