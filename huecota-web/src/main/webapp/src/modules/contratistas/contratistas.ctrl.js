(function(ng) {
    var mod = ng.module("contratistaModule");
    mod.constant("contratistasContext", "api/contratistas");
    mod.controller('contratistaCtrl', ['$scope', '$state', '$stateParams', '$http', 'contratistasContext',
    function($scope, $state, $stateParams, $http, contratistasContext){
        $scope.records={};
        $http.get(contratistasContext).then(function(response){
            $scope.records = response.data;
        });
        if($stateParams.contratistaId !== null && $stateParams.contratistaId !== undefined){
            id = $stateParams.contratistaId;
            $http.get(contratistasContext + "/" + id).then(function(response){
                $scope.currentRecord = response.data;
            });
        }else{
            $scope.currentRecord={
                id: undefined,
                name: '',
            };
            $scope.alerts = [];
        }
        
        this.saveRecord = function(id){
            currentRecord = $scope.currentRecord;
            if(id == null){
                return $http.post(contratistasContext, currentRecord).then(function(){
                    $state.go('contratistasList');
                });
            }else{
                return $http.put(contratistasContext + "/" + currentRecord.id, currentRecord).then(function(){
                    $state.go('contratistasList');
                });
            };
        };
        
    }]);
});