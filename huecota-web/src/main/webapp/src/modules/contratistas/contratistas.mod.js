(function(ng){
    var mod = ng.module("contratistaModule", ['ui.router']);
    mod.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){
            var basePath = 'src/modules/contratistas/';
            $urlRouterProvider.otherwise("/contratistasList");
            $stateProvider.state('contratistasList', {
                url: '/contratistas/list',
                views: {
                    'mainView': {
                        templateUrl: basePath + 'contratistas.list.html',
                        controller: 'contratistaCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
    }]);
})(window.angular);