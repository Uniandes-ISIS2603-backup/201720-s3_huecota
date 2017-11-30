(function (ng) {
    var mod = ng.module("imagenModule" ['huecoModule' ,'ui.router']);
    mod.constant("imagenesContext", "imagenes");
    mod.constant("huecosContext" ,"apo/huecos");
    
    mod.config(['$stateProvider' ,'$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath= 'src/modules/imagenes';
            $urlRouterProvider.otherwise("/imagenesList");
            
            $stateProvider.state('imagenes', {
                url: '/imagenes',
                abstract:true,
                parent:'huecoDetail',
                views: {
                    childrenView: {
                        templateUrl: basePath + 'imagenes.html'
                    }
                }
            }).state('imagenesList' , {
                url: '/list',
                parent: 'imagenes',
                views: {
                    listView: {
                        templateUrl: basePath + 'imagenes.list.html',
                        controller:'imagenesCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
    }]);
})(window.angular);