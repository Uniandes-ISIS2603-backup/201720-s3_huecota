(function (ng) {
    var mod = ng.module("imagenModule");
    mod.constant("imagenesContext", "api/imagenes");
    mod.controller('imagenesDeleteCtrl', ['$scope', '$http', 'imagenesContext', '$state',
        function ($scope, $http, imagenesContext, $state) {
            var idImagen = $state.params.imagenId;
            $scope.deleteImagen = function () {
                $http.delete(imagenesContext + '/' + idImagen, {}).then(function (response) {
                    $state.go('imagenesList', {imagenId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);