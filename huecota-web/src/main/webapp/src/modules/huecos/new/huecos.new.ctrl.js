(function (ng) {
    var mod = ng.module("huecosModule");
    mod.constant("huecosContext", "api/huecos");
    mod.controller('huecosNewCtrl', ['$scope', '$http', 'huecosContext', '$state', 'huecosContext', '$rootScope',
        function ($scope, $http, huecosContext, $state, huecosContext, $rootScope) {
            $rootScope.edit = false;
            $scope.createhueco = function () {
                $http.post(huecosContext, {
                    descripcion: $scope.huecoDescripcion,
                    direccion: $scope.huecoDireccion,
                    imagen: $scope.huecoImagen
                }).then(function (response) {
                    //hueco created successfully
                    $state.go('huecosList', {huecoId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);