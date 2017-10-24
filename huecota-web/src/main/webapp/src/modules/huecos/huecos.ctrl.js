(function (ng) {
    var mod = ng.module("huecosModule");
    mod.constant("huecosContext", "api/huecos");
    mod.controller('huecosCtrl', ['$scope', '$http', 'huecosContext', '$state',
        function ($scope, $http, huecosContext, $state) {
            $http.get(huecosContext).then(function (response) {
                $scope.huecosRecords = response.data;
            });
            
            if ($state.params.huecoId !== undefined) {
                $http.get(huecosContext + '/' + $state.params.huecoId).then(function (response) {
                    $scope.currentHueco = response.data;
                });
            }
        }
    ]);
}
)(angular);