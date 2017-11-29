(function (ng) {
    var mod = ng.module("AbiertoModule");
    mod.constant("AbiertoContext", "api/estadosAbierto");
    mod.controller('abiertoNewCtrl', ['$scope', '$http', 'AbiertoContext', '$state', '$rootScope',
        function ($scope, $http, AbiertoContext, $state, $rootScope) {
            $rootScope.edit = false;
            $scope.createState = function () {
                $http.post(AbiertoContext, {
                    fechaDeAbierto: $scope.abiertoFecha
                }).then(function (response) {
                    $state.go('abiertoList', {stateId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);