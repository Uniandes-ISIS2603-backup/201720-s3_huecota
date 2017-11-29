(function (ng) {
    var mod = ng.module("CerradoModule");
    mod.constant("cerradoContext", "api/estadosCerrado");
    mod.controller('cerradoDeleteCtrl', ['$scope', '$http', 'cerradoContext', '$state',
        function ($scope, $http, cerradoContext, $state) {
            var idState = $state.params.stateId;
            $scope.deleteState = function () {
                $http.delete(cerradoContext + '/' + idState, {}).then(function (response) {
                    $state.go('cerradoList', {stateId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);