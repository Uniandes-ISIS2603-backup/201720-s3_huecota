(function (ng){
    var mod = ng.module("imagenModule");
    mod.constant("cimagenesContext", "imagenes");
    mod.constant("huecosContext", "api/huecos");
    mod.controller('imagenNewCtrl',['$scope', '$http','imagenesContext','$state', 'huecosContext','$rootScope',
        function($scope,$http,imagenesContext,$state,huecosContext,$rootScope){
            $rootScope.edit = false;
            
            var idHueco = $state.params.huecoId;
            
            $scope.createImagen = function(){
              $http.post(huecosContext + '/' + idHueco + '/' + imagenesContext, {
                  foto:$scope.foto
              }).then(function(response){
                  $state.go('cimagenesList',{id: response.data.id}, {reload:true});
              });
          };
        }]);
})(window.angular);