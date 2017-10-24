(function (ng) {
    var mod = ng.module("huecoModule", ['ui.router']);
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
                        controller: 'huecoCtrl',
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
            }).state('huecoDetail', {
                url: '/{huecoId:int}/detail',
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
                        controller: 'huecoCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }]);
})(window.angular);
