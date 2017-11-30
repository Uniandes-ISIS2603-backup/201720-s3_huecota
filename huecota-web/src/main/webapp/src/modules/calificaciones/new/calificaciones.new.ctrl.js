(function (ng){
    var mod = ng.module("calificacionModule");
    mod.constant("calificacionesContext", "calificaciones");
    mod.constant("huecosContext", "api/huecos");
    mod.controller('calificacionNewCtrl',['$scope', '$http','calificacionesContext','$state', 'huecosContext','$rootScope',
        function($scope,$http,calificacionesContext,$state,huecosContext,$rootScope){
            $rootScope.edit = false;
            
            var idHueco = $state.params.huecoId;
            
            $scope.createCalificacion = function(){
              $http.post(huecosContext + '/' + idHueco + '/' + calificacionesContext, {
                  name: $scope.caliTitulo,
                  nota: $scope.caliNota,
                  comentario: $scope.caliComentario
              }).then(function(response){
                  $state.go('calificacionesList',{id: response.data.id}, {reload:true});
              });
          };
        }]);
})(window.angular);