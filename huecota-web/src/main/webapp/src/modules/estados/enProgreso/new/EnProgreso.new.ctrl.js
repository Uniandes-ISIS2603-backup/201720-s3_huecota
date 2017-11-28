(function (ng) {
    var mod = ng.module("EnProgresoModule");
    mod.constant("enProgresoContext", "api/estadosEnProgreso");
    mod.controller('enProgresoNewCtrl', ['$scope', '$http', 'enProgresoContext', '$state', '$rootScope',
        function ($scope, $http, enProgresoContext, $state, $rootScope) {
            $rootScope.edit = false;
            $scope.createState = function () {
                $http.post(enProgresoContext, {
                    fechaInicio: $scope.enProgresoFecha
                }).then(function (response) {
                    $state.go('enProgresoList', {stateId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);