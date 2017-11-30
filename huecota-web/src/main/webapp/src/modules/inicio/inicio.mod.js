(function(ng){
    var mod = ng.module("inicioModule", ['ui.router']);
    mod.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){
        var basePath = 'src/modules/inicio/';
        $urlRouterProvider.otherwise("/inicio");
        $stateProvider.state('inicio',{
            url: '/inicio',
            views: {
                'totalView': {
                    templateUrl: basePath + 'inicio.html'
                }
            }
        });
    }]);
})(window.angular);