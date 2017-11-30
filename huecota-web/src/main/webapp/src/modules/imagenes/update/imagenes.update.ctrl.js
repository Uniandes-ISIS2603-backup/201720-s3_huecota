(function (ng) {
    var mod = ng.module("imagenModule");
    mod.constant("imagenesContext", "api/imagenes");
    mod.controller('imagenUpdateCtrl', ['$scope', '$http', 'imagenContext', '$state', '$rootScope',
        function ($scope, $http, imagenesContext, $state, $rootScope)
		{
			
            var imagenId = $state.params.imagenId;
            $scope.updateImagen= function ()
            {
                $http.put(imagenesContext + "/" + imagenId,
                {
                   foto: $scope.ruta
                }).then(function (response)
                {
                       
                   $state.go('imagenesList', {imagenId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);