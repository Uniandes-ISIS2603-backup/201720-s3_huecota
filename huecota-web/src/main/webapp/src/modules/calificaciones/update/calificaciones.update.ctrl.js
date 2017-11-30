(function (ng) {
    var mod = ng.module("calificacionModule");
    mod.constant("calificacionesContext", "api/calificaciones");
    mod.controller('CalificacionUpdateCtrl', ['$scope', '$http', 'calificacionesContext', '$state', '$rootScope',
        function ($scope, $http, calificacionesContext, $state, $rootScope)
		{
			
            var calificacionId = $state.params.calificacionId;
            $scope.updateCalificacion= function ()
            {
                $http.put(calificacionesContext + "/" + calificacionId,
                {
                    nota: $scope.nota,
                    comentario: $scope.comentario
                }).then(function (response)
                {
                       
                   $state.go('calificacionesList', {calificacionId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);
