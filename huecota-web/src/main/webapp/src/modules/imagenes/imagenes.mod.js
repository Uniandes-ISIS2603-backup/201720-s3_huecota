(function (ng) {
    var mod = ng.module("imagenModule" ['huecoModule' ,'ui.router']);
    mod.constant("imagenesContext", "imagenes");
    mod.constant("huecosContext" ,"api/huecos");
    
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
            }).state('imagenesCreate', {
                url:'/createImagen',
                parent: 'huecosDetail',
                param: {
                    huecosId: null
                },
                views: {
                    'detailView':{
                        templateUrl: basePath + '/new/imagenes.new.html',
                        controller: 'imagenNewCtrl'
                    }
                }
            }).state('imagenesDelete', {
                url: '/delete/{imagenId;int}',
                parent: 'imagenes',
                param: {
                    imagenId:null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/delete/imagenes.delete.html',
                        controller: 'imagenesDeleteCtrl'
                    }
                }
            }).state('imagenesUpdate', {
                url: '/update/{imagenId;int}',
                parent: 'imagenes',
                param: {
                    imagenId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/update/imagenes.update.html',
                        controller: 'imagenesUpdateCtrl'
                    }
                }
            });
    }]);
})(window.angular);