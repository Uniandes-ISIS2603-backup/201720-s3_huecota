(function (ng) {
    
    var mod = ng.module("huecosModule");
    
    mod.controller("huecosCtrl", ['$scope','$state', '$stateParams', '$http', 'huecosContext', function ($scope, $state, $stateParams, $http, context) {
            
            $scope.records = {};
            
            $http.get(context).then(function (response) {
                $scope.records = response.data;
            });
 
    }])
})


