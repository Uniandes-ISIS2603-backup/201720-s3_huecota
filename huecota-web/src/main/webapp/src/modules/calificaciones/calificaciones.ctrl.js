(function (ng) {
    var mod = ng.module("calificacionModule");
    mod.constant("calificacionesContext", "calificaciones");
    mod.constant("huecosContext", "api/huecos");
    mod.controller('calificacionCtrl', ['$scope', '$http', 'huecosContext', 'calificacionesContext', '$state',
        function ($scope, $http, huecosContext ,calificacionesContext, $state) {
            $http.get(huecosContext + '/' + $state.params.huecoId + '/' + calificacionesContext).then(function (response){
                $scope.calificacionesRecords = response.data;
            });
        }
    ]);
}
)(window.angular);
