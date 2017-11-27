(function(ng) {
    var mod = ng.module('contratistaModule');
    mod.constant("contratistasContext", "api/contratistas");
    mod.controller('contratistaNewCtrl', ['$scope', '$http', 'contratistasContext', '$state', '$rootScope',
    function ($scope, $http, contratistasContext, $state, $rootScope){
        $rootScope.edit = false;
        $scope.createContratista = function () {
            $http.post(contratistasContext, $scope.data).then(function (response) {
                $state.go('contratistasList', {contratistaId: response.data.id}, {reload: true});
            });
        };
    }]);
})(window.angular);