(function (ng) {
    var mod = ng.module("calificacionModule", ['ui.router']);
    mod.constant("calificacionesContext", "api/calificaciones");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/calificaciones/';
            $urlRouterProvider.otherwise("/calificacionesList");

            $stateProvider.state('calificaciones', {
                url: '/calificaciones',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'calificaciones.html',
                        controller: 'calificacionCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('calificacionesList', {
                url: '/list',
                parent: 'calificaciones',
                views: {
                    'listView': {
                        templateUrl: basePath + 'calificaciones.list.html'
                    }
                }
            }).state('calificacionDetail', {
                url: '/{calificacionId:int}/detail',
                parent: 'calificaciones',
                param: {
                    calificacionId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + 'calificaciones.detail.html',
                        controller: 'calificacionCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('calificacionesCreate', {
                url: '/create',
                parent: 'calificaciones',
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/calificaciones.new.html',
                        controller: 'calificacionNewCtrl'
                    }
                }
            }).state('calificacionUpdate', {
                url: '/update/{calificacionId:int}',
                parent: 'calificaciones',
                param: {
                    calificacionId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/calificaciones.new.html',
                        controller: 'calificacionUpdateCtrl'
                    }
                }
            }).state('calificacionDelete', {
                url: '/delete/{calificacionId:int}',
                parent: 'calificaciones',
                param: {
                    authorId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/delete/calificacion.delete.html',
                        controller: 'calificacionDeleteCtrl'
                    }
                }
            });
        }]);
})(window.angular);