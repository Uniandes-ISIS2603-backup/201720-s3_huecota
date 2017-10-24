(function (ng) {
    var mod = ng.module("calificacionModule");
    mod.constant("calificacionesContext", "calificaciones");
    mod.constant("huecosContext","api/huecos");
    mod.controller('reviewsCtrl', ['$scope', '$http', 'huecosContext', '$state', 'calificacionesContext',
        function ($scope, $http,huecosContext,$state,calificacionesContext) {
            $http.get(huecosContext + '/' + $state.params.huecoId + '/' + calificacionesContext).then(function (response) {
                $scope.calificacionesRecords = response.data;
            });
        }]);
});

