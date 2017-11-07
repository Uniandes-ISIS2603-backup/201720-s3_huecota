(function (ng) {
    var mod = ng.module("AbiertoModule", ['ui.router']);
    mod.constant("abiertoContext", "api/estadosAbierto");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/estados/abierto/';
            $urlRouterProvider.otherwise("/abiertoList");

            $stateProvider.state('abiertos', {
                url: '/abiertos',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'Abierto.html',
                        controller: 'abiertoCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('abiertoList', {
                url: '/list',
                parent: 'abiertos',
                views: {
                    'listView': {
                        templateUrl: basePath + 'Abierto.html',
                        controller: 'abiertoCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('abiertosCreate', {
                url: '/create',
                parent: 'abiertos',
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/abiertos.new.html',
                        controller: 'abiertoNewCtrl'
                    }
                }
            }).state('abiertosUpdate', {
                url: '/update',
                parent: 'abiertos',
                param: {
                    authorId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/update/abiertos.update.html',
                        controller: 'abiertoUpdateCtrl'
                    }
                }
            }).state('abiertosDelete', {
                url: '/delete',
                parent: 'abiertos',
                param: {
                    authorId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/delete/abiertos.delete.html',
                        controller: 'abiertoDeleteCtrl'
                    }
                }
            });   
        }]);
})(window.angular);