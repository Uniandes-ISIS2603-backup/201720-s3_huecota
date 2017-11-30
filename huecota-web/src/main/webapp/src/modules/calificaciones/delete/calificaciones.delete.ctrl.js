(function (ng) {
    var mod = ng.module("calificacionModule");
    mod.constant("calificacionesContext", "api/calificaciones");
    mod.controller('calificacionesDeleteCtrl', ['$scope', '$http', 'calificacionesContext', '$state',
        function ($scope, $http, calificacionesContext, $state) {
            var idCalificacion = $state.params.calificacionId;
            $scope.deleteCalificacion = function () {
                $http.delete(calificacionesContext + '/' + idCalificacion, {}).then(function (response) {
                    $state.go('calificacionesList', {calificacionId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);


