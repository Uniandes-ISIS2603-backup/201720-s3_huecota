/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("clienteModule", ['ui.router']);
    mod.constant("clientesContext", "api/clientes");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/clientes/';
            var basePathPuntos = 'src/modules/puntos/';
            $urlRouterProvider.otherwise("/clientesList");

            $stateProvider.state('clientes', {
                url: '/clientes',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'clientes.html',
                        controller: 'clienteCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('clientesList', {
                url: '/list',
                parent: 'clientes',
                views: {
                    'listView': {
                        templateUrl: basePath + 'clientes.list.html',
                        controller: 'clienteCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('clienteDetail', {
                url: '/{clienteId:int}/detail',
                parent: 'clientes',
                param: {
                    authorId: null
                },
                views: {
                    'listView': {
                        templateUrl: basePathPuntos + 'puntos.list.html',
                        controller: 'clienteCtrl',
                        controllerAs: 'ctrl'
                    },
                    'detailView': {
                        templateUrl: basePath + 'clientes.detail.html',
                        controller: 'clienteCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('clientesCreate', {
                url: '/create',
                parent: 'clientes',
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/clientes.new.html',
                        controller: 'clienteNewCtrl'
                    }
                }
            }).state('clientesUpdate', {
                url: '/update',
                parent: 'clientes',
                param: {
                    authorId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/update/clientes.update.html',
                        controller: 'clienteUpdateCtrl'
                    }
                }
            }).state('clientesDelete', {
                url: '/delete',
                parent: 'clientes',
                param: {
                    authorId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/delete/clientes.delete.html',
                        controller: 'clienteDeleteCtrl'
                    }
                }
            });   
        }]);
})(window.angular);