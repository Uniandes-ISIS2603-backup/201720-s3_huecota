(function (ng) {
    var mod =ng.module("imagenModule");
        mod.constant("imagenesContext", "imagenes");
        mod.constant("huecosContext","api/huecos");
        mod.controller('imagenesCtrl', ['$scope', '$http', 'huecosContext', '$state', 'imagenesContext',
            function ($scope, $http, huecosContext, $state, imagenesContext) {
                $http.get(huecosContext + '/' + $state.params.huecoId + '/' + imagenesContext).then(function (response) {
                    $scope.imagenesRecords = response.data;
                })
            }])
})

