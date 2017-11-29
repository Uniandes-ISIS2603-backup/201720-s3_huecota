(function (ng) {
    var mod = ng.module("AbiertoModule");
    mod.constant("AbiertoContext", "api/estadosAbierto");
    mod.controller('abiertoDeleteCtrl', ['$scope', '$http', 'AbiertoContext', '$state',
        function ($scope, $http, AbiertoContext, $state) {
            var idState = $state.params.stateId;
            $scope.deleteState = function () {
                $http.delete(AbiertoContext + '/' + idState, {}).then(function (response) {
                    $state.go('abiertoList', {stateId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);