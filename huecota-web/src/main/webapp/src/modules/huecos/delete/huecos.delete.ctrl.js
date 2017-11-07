(function (ng) {
    var mod = ng.module("huecosModule");
    mod.constant("huecosContext", "api/huecos");
    mod.controller('huecosDeleteCtrl', ['$scope', '$http', 'huecosContext', '$state',
        function ($scope, $http, huecosContext, $state) {
            var idhueco = $state.params.huecoId;
            $scope.deletehueco = function () {
                $http.delete(huecosContext + '/' + idhueco, {}).then(function (response) {
                    $state.go('huecosList', {huecoId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);