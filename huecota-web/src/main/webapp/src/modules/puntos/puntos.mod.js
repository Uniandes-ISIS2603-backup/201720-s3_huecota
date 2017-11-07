/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("puntoModule", ['clienteModule','ui.router']);
    mod.constant("puntosContext", "puntos");
    mod.constant("clientesContext", "api/clientes");

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/puntos/';
            $urlRouterProvider.otherwise("/puntosList");

            $stateProvider.state('puntos', {
                url: '/puntos',
                abstract: true,
                parent: 'clienteDetail',
                views: {
                    'mainView': {
                        templateUrl: basePath + 'puntos.html',
                        controller: 'puntoCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('puntosList', {
                url: '/list',
                parent: 'puntos',
                views: {
                    'listView': {
                        templateUrl: basePath + 'puntos.list.html',
                        controller: 'puntoCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('puntoDetail', {
                url: '/{puntoId:int}/detail',
                parent: 'puntos',
                param: {
                    bookId: null
                },
                views: {
                    'listView': {
                        templateUrl: basePath + 'puntos.list.html'
                    },
                    'detailView': {
                        templateUrl: basePath + 'puntos.detail.html',
                        controller: 'puntoCtrl',
                        controllerAs: 'ctrl'
                    }

                }

            });
        }]);
})(window.angular);

