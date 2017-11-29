(function (ng) {
    var mod = ng.module("AbiertoModule");
    mod.constant("AbiertoContext", "api/estadosAbierto");
    mod.controller('abiertoUpdateCtrl', ['$scope', '$http', 'AbiertoContext', '$state', '$rootScope',
        function($scope, $http, AbiertoContext, $state, $rootScope){
            $rootScope.edit=true;
            $scope.data = {};
            var idState = $state.params.stateId;
            $http.get(AbiertoContext + '/' + idState).then(function(response){
                var estado = response.data;
                $scope.abiertoFecha = estado.fechaDeAbierto;
            });
            $scope.createState = function(){
                $http.put(AbiertoContext + '/' + idState, {
                        fechaDeAbierto: $scope.abiertoFecha
                    }).then(function (response) {
                        $state.go('abiertoList', {stateId: response.data.id}, {reload: true});
                });
            };
        }]);
})(window.angular);