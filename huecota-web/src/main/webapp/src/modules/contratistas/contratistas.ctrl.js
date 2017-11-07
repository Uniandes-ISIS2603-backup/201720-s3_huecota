(function(ng) {
    var mod = ng.module("contratistaModule");
    mod.constant("contratistasContext", "api/contratistas");
    mod.controller('contratistaCtrl', ['$scope', '$http', 'contratistasContext', function($scope, $http, contratistasContext){
            $http.get(contratistasContext).then(function(response){
                $scope.contratistasRecords = response.data;
            });
    }]);
})(window.angular);