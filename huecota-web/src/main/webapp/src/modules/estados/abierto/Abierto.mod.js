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
                        templateUrl: basePath + 'Abierto.List.html',
                        controller: 'abiertoCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('abiertoDetail', {
                url: '/{stateId:int}/detail',
                parent: 'abiertos',
                param: {
                    stateId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + 'Abierto.Detail.html',
                        controller: 'abiertoCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('abiertosCreate', {
                url: '/create',
                parent: 'abiertos',
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/Abierto.new.html',
                        controller: 'abiertoNewCtrl'
                    }
                }
            }).state('abiertosUpdate', {
                url: '/update/{stateId:int}',
                parent: 'abiertos',
                param: {
                    stateId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/Abierto.new.html',
                        controller: 'abiertoUpdateCtrl'
                    }
                }
            }).state('abiertosDelete', {
                url: '/delete/{stateId:int}',
                parent: 'abiertos',
                param: {
                    authorId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/delete/Abierto.delete.html',
                        controller: 'abiertoDeleteCtrl'
                    }
                }
            });   
        }]);
})(window.angular);