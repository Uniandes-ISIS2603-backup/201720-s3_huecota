(function (ng) {
    var mod = ng.module("calificacionModule", ['huecoModule', 'ui.router']);
    mod.constant("calificacionesContext", "calificaciones")
    mod.constant("huecosContext", "api/huecos");
    
    mod.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){
            var basePath = 'src/modules/calificaciones';
            $urlRouterProvider.otherwise("/calificacionesList");
            
            $stateProvider.state('reviews', {
                url: '/calificaciones',
                abstract: true,
                parent: 'huecoDetail',
                views: {
                    childrenView: {
                        templateUrl: basePath + 'calificaciones.html'
                    }
                }
            }).state('calificacionesList', {
                url: '/list',
                parent: 'calificaciones',
                views: {
                    'listView': {
                        templateUrl:basePath + 'calificaciones.list.html',
                        controller: 'calificacionesCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
    }]);
})(window.angular)