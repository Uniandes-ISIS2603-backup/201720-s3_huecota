(function (ng) {
    var mod = ng.module("contratistaModule");
    mod.constant("contratistasContext", "api/contratistas");
    mod.controller('contratistaUpdateCtrl', ['$scope', '$http', 'contratistasContext', '$state', '$rootScope',
        function($scope, $http, contratistasContext, $state, $rootScope){
            $rootScope.edit=true;
            $scope.data = {};
            var idContratista = $state.params.contratistaId;
            $http.get(contratistasContext + '/' + idContratista).then(function(response){
                var contratista = response.data;
                $scope.data.name = contratista.name;
            });
            $scope.createContratista = function(){
                $http.put(contratistasContext + '/' + idContratista, $scope.data).then(function(response){
                    $state.go('contratistasList', {contratistaId: response.data.id}, {reload: true});
                });
            };
        }]);
})(window.angular);