(function (ng) {
    var mod = ng.module("huecosModule");
    mod.constant("huecosContext", "api/huecos");
    mod.controller('huecosNewCtrl', ['$scope', '$http', 'huecosContext', '$state', 'huecosContext', '$rootScope',
        function ($scope, $http, huecosContext, $state, huecosContext, $rootScope) {
            $rootScope.edit = false;
            $scope.createhueco = function () {
                $http.post(huecosContext, {
                    id: $scope.huecoId,
                    descripcion: $scope.huecoDescripcion
                }).then(function (response) {
                    //hueco created successfully
                    $state.go('huecosList', {huecosId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);