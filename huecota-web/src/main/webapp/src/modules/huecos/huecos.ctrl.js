(function (ng) {
    var mod = ng.module("huecosModule");
    mod.constant("huecosContext", "api/huecos");
    mod.controller('huecosCtrl', ['$scope', '$http', 'huecosContext', '$state',
        function ($scope, $http, huecosContext, $state) {
            $http.get(huecosContext).then(function (response) {
                $scope.huecosRecords = response.data;
            });
            if (($state.params.huecosId !== undefined)&& ($state.params.huecosId !== null)) {
                $http.get(huecosContext + '/' + $state.params.huecosId).then(function (response) {
                    $scope.currentHueco = response.data;
                });
            }
        }
    ]);
}
)(window.angular);