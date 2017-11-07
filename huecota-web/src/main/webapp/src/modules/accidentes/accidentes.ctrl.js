/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng)
{
    var mod = ng.module("AccidenteModule");
    mod.constant("accidentesContext", "api/");
    mod.controller('AccidenteCtrl', ['$scope', '$http', 'accidentesContext', '$state',
        function ($scope, $http, accidentesContext, $state)
		{
            $http.get(accidentesContext).then(function (response)
			{
                $scope.accidentesRecords = response.data;
            });
           
        }
    ]);
}
)(angular);

