/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("DireccionModule", ['ui.router']);
    mod.constant("direccionesContext", "api/direcciones");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/direcciones/';
            $urlRouterProvider.otherwise("/direccionesList");

            $stateProvider.state('direcciones', {
                url: '/direcciones',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'direcciones.html',
                        controller: 'direccionCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('direccionesList', {
                url: '/list',
                parent: 'direcciones',
                views: {
                    'listView': {
                        templateUrl: basePath + 'direcciones.list.html',
                        controller: 'direccionCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });   
        }]);
})(window.angular);