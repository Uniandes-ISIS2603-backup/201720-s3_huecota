(function (ng) {
    var mod = ng.module("huecosModule", []);
        mod.constant("huecosContext","api/huecos");
        mod.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {
                var basePath = 'src/modules/huecos/';
                
        }]);
    
})(window.angular);


