(function(ng){
    var mod = ng.module("contratistaModule", ['ui.router']);
    mod.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){
            var basePath = 'src/modules/contratistas/';
            $urlRouterProvider.otherwise("contratistasList");
            $stateProvider.state('contratistasList', {
                url: '/contratistas/list',
                views: {
                    'mainView': {
                        templateUrl: basePath + 'contratistas.list.html',
                        controller: 'contratistaCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('contratistaCreate', {
                url: '/contratistas/create',
                views: {
                    'mainView': {
                        templateUrl: basePath + 'contratistas.create.html',
                        controller: 'contratistaCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('contratistaEdit', {
                url: '/contratistas/:contratistaId',
                param: {
                    contratistaId: null
                },
                views: {
                    'mainView': {
                        templateUrl: basePath + 'contratista.create.html',
                        controller: 'contratistaCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
    }]);
})(window.angular);