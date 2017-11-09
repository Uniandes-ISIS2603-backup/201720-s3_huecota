(function(ng) {
    var mod = ng.module("contratistaModule");
    mod.constant("contratistasContext", "api/contratistas");
    mod.controller('contratistaDeleteCtrl', ['$scope', '$http', 'contratistasContext', '$state', function($scope, $http, contratistasContext, $state) {
            var idContratista = $state.params.contratistaId;
            $scope.deleteContratista = function() {
                $http.delete(contratistasContext + '/' + idContratista, {}).then(function(response){
                    $state.go('contratistasList', {contratistaId: response.data.id}, {reload: true});
                });
            };
    }]);
})(window.angular);