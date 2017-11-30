(function (ng) {
    var mod = ng.module("calificacionModule");
    mod.constant("calificacionesContextC", "calificaciones");
    mod.constant("clientesContext", "api/clientes");
    mod.controller('calificacionesCtrl2', ['$scope', '$http', 'clientesContext','$state', 'calificacionesContextC' ,
        function ($scope, $http, clientesContext, $state, calificacionesContextC) {
            $http.get(clientesContext + '/' + $state.params.clienteId  + '/'+ calificacionesContextC ).then(function (response) {
                $scope.calificacionesRecords = response.data;
            });   
        }
    ]);
})(window.angular);