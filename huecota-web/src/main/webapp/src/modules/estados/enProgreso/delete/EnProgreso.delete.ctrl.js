(function (ng) {
    var mod = ng.module("EnProgresoModule");
    mod.constant("enProgresoContext", "api/estadosEnProgreso");
    mod.controller('enProgresoDeleteCtrl', ['$scope', '$http', 'enProgresoContext', '$state',
        function ($scope, $http, enProgresoContext, $state) {
            var idState = $state.params.stateId;
            $scope.deleteState = function () {
                $http.delete(enProgresoContext + '/' + idState, {}).then(function (response) {
                    $state.go('enProgresoList', {stateId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);