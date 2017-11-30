(function (ng) {
    var mod = ng.module("calificacionModule", ['huecosModule','ui.router']);
    mod.constant("calificacionesContext", "calificaciones");
    mod.constant("huecosContext", "api/huecos");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/calificaciones/';
            $urlRouterProvider.otherwise("/calificacionesList");

            $stateProvider.state('calificaciones', {
                url: '/calificaciones',
                abstract: true,
                parent:'huecosDetail',
                views: {
                    'childrenView': {
                        templateUrl: basePath + 'calificaciones.html'
                    }
                }
            }).state('calificacionesList', {
                url: '/list',
                parent: 'calificaciones',
                param: {
                    huecosId: null
                },
                views: {
                    'listView': {
                        templateUrl: basePath + 'calificaciones.list.html',
                        controller: 'calificacionCtrl',
                        controllerAs:'ctrl'
                    }
                }
            }).state('calificacionesCreate', {
                url:'/createCalificacion',
                parent: 'huecosDetail',
                param: {
                    huecosId: null
                },
                views: {
                    'detailView':{
                        templateUrl: basePath + '/new/calificaciones.new.html',
                        controller: 'calificacionNewCtrl'
                    }
                }
            }).state('calificacionesDelete', {
                url: '/delete/{calificacionId;int}',
                parent: 'calificaciones',
                param: {
                    calificacionId:null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/delete/calificaciones.delete.html',
                        controller: 'calificacionesDeleteCtrl'
                    }
                }
            }).state('calificacionesUpdate', {
                url: '/update/{calificacionId;int}',
                parent: 'calificaciones',
                param: {
                    calificacionId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/update/calificaciones.update.html',
                        controller: 'calificacionesUpdateCtrl'
                    }
                }
            });
        }]);
})(window.angular);