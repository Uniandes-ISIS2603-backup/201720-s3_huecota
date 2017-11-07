/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng)
{
    var mod = ng.module("DireccionModule");
    mod.constant("direccionesContext", "api/");
    mod.controller('DireccionCtrl', ['$scope', '$http', 'direccionesContext', '$state',
        function ($scope, $http, direccionesContext, $state)
		{
            $http.get(direccionesContext).then(function (response)
			{
                $scope.direccionesRecords = response.data;
            });

            
        }
    ]);
}
)(angular);

