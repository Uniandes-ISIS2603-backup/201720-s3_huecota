(function(ng){
    var mod = ng.module("contratistaModule", ['ui.router']);
    mod.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){
            var basePath = 'src/modules/contratistas/';
            var basePathCuentas = 'src/modules/cuentascobro/';
            $urlRouterProvider.otherwise("/contratistasList");
            $stateProvider.state('contratistas', {
                url: '/contratistas',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'contratistas.html',
                        controller: 'contratistaCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('contratistasList', {
                url: '/list',
                parent: 'contratistas',
                views: {
                    'listView': {
                        templateUrl: basePath + 'contratistas.list.html'
                    }
                }
            }).state('contratistaDetail', {
                url: '/{contratistaId:int}/detail',
                parent: 'contratistas',
                param: {
                    contratistaId: null
                },
                views: {
                    'listView': {
                        templateUrl: basePathCuentas + 'cuentascobro.list.html',
                        controller: 'contratistaCtrl',
                        controllerAs: 'ctrl'
                    },
                    'detailView': {
                        templateUrl: basePath + 'contratistas.detail.html',
                        controller: 'contratistaCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
    }]);
})(window.angular);