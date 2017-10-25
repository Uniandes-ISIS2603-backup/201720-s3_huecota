(function (ng) {
    var mod = ng.module("huecosModule", ['ui.router']);
    mod.constant("huecosContext", "api/huecos");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/huecos/';
            $urlRouterProvider.otherwise("/huecosList");

            $stateProvider.state('huecos', {
                url: '/huecos',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'huecos.html',
                        controller: 'huecosCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('huecosList', {
                url: '/list',
                parent: 'huecos',
                views: {
                    'listView': {
                        templateUrl: basePath + 'huecos.list.html'
                    }
                }
            }).state('huecosDetail', {
                url: '/{huecosId:int}/detail',
                parent: 'huecos',
                param: {
                    huecoId: null
                },
                views: {
                    'listView': {
                        templateUrl: basePath + 'huecos.list.html'
                    },
                    'detailView': {
                        templateUrl: basePath + 'huecos.detail.html',
                        controller: 'huecosCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }]);
})(window.angular);
