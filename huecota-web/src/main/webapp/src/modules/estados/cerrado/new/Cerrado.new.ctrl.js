(function (ng) {
    var mod = ng.module("CerradoModule");
    mod.constant("cerradoContext", "api/estadosCerrado");
    mod.controller('cerradoNewCtrl', ['$scope', '$http', 'cerradoContext', '$state', '$rootScope',
        function ($scope, $http, cerradoContext, $state, $rootScope) {
            $rootScope.edit = false;
            $scope.createState = function () {
                $http.post(cerradoContext, {
                    causa: $scope.cerradoCausa,
                    comentario: $scope.cerradoComentario,
                    fechaDeCerrado : $scope.cerradoFecha
                }).then(function (response) {
                    $state.go('cerradoList', {stateId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);