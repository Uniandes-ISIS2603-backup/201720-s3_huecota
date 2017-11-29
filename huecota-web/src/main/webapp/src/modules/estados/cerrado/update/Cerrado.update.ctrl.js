(function (ng) {
    var mod = ng.module("CerradoModule");
    mod.constant("cerradoContext", "api/estadosCerrado");
    mod.controller('cerradoUpdateCtrl', ['$scope', '$http', 'cerradoContext', '$state', '$rootScope',
        function($scope, $http, cerradoContext, $state, $rootScope){
            $rootScope.edit=true;
            $scope.data = {};
            var idState = $state.params.stateId;
            $http.get(cerradoContext + '/' + idState).then(function(response){
                var estado = response.data;
                $scope.cerradoCausa = estado.causa;
                $scope.cerradoComentario = estado.comentario;
                $scope.cerradoFecha = estado.fechaDeCerrado;
            });
            $scope.createState = function(){
                $http.put(cerradoContext + '/' + idState, {
                        causa: $scope.cerradoCausa,
                        comentario: $scope.cerradoComentario,
                        fechaDeCerrado : $scope.cerradoFecha
                    }).then(function (response) {
                        $state.go('cerradoList', {stateId: response.data.id}, {reload: true});
                });
            };
        }]);
})(window.angular);