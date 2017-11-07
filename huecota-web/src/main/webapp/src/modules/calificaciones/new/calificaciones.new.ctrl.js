(function (ng) {
    var mod = ng.module("calificacionModule");
    mod.constant("calificacionesContext", "api/calificaciones");
    mod.controller('calificacionNewCtrl', ['$scope', '$http', 'calificacionesContext', '$state', '$rootScope',
        function ($scope, $http, calificacionesContext, $state, $rootScope) {
            $rootScope.edit = false;
            
            $scope.data={};
            $scope.createCalificacion = function () {
                $http.post(calificacionesContext, {
                    nota: $scope.nota,
                    comentario: $scope.comentario
                }).then(function (response) {
                    $state.go('calificacionesList', {calificacionId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);
