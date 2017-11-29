(function (ng) {
    var mod = ng.module("EnProgresoModule");
    mod.constant("enProgresoContext", "api/estadosEnProgreso");
    mod.controller('enProgresoUpdateCtrl', ['$scope', '$http', 'enProgresoContext', '$state', '$rootScope',
        function($scope, $http, enProgresoContext, $state, $rootScope){
            $rootScope.edit=true;
            $scope.data = {};
            var idState = $state.params.stateId;
            $http.get(enProgresoContext + '/' + idState).then(function(response){
                var estado = response.data;
                $scope.enProgresoFecha = estado.fechaInicio;
            });
            $scope.createState = function(){
                $http.put(enProgresoContext + '/' + idState, {
                        fechaInicio: $scope.enProgresoFecha
                    }).then(function (response) {
                        $state.go('enProgresoList', {stateId: response.data.id}, {reload: true});
                });
            };
        }]);
})(window.angular);