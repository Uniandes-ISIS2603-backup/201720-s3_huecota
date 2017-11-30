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
                        controller: 'DireccionCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('direccionesList', {
                url: '/list',
                parent: 'direcciones',
				param: {
                    direccionId: null
                },
                views: {
                    'listView': {
                        templateUrl: basePath + 'direcciones.list.html',
                        controller: 'DireccionCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('direccionesForm', {
                url: '/form',
                parent: 'direcciones',
				views: {
                    'listView': {
                        templateUrl: basePath + '/new/direcciones.form.html',
                        controller: 'DireccionNewCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('direccionesUpdate', {
                url: '/update/{direccionId:int}',
                parent: 'direcciones',
                param: {
                    direccionId: null
                },
                views: {
                    'listView': {
                        templateUrl: basePath + '/update/direcciones.update.html',
                        controller: 'DireccionUpdateCtrl',
						controllerAs: 'ctrl'
                    }
                }
            }).state('direccionesDelete', {
                url: '/delete/{direccionId:int}',
                parent: 'direcciones',
                param: {
                    direccionId: null
                },
                views: {
                    'listView': {
                        templateUrl: basePath + '/delete/direcciones.delete.html',
                        controller: 'DireccionDeleteCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });   
        }]);
})(window.angular);