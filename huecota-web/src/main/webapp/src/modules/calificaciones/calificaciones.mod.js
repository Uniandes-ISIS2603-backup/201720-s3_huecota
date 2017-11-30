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
            });
        }]);
})(window.angular);