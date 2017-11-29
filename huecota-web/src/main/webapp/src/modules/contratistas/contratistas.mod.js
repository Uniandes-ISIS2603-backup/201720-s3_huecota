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
            }).state('contratistasCreate', {
                url: '/create',
                parent: 'contratistas',
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/contratistas.new.html',
                        controller: 'contratistaNewCtrl'
                    }
                }
            }).state('contratistaDelete', {
                url: '/delete/{contratistaId:int}',
                parent: 'contratistas',
                param: {
                    contratistaId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/delete/contratistas.delete.html',
                        controller: 'contratistaDeleteCtrl'
                    }
                }
            }).state('contratistaUpdate', {
                url:'/update/{contratistaId:int}',
                parent: 'contratistas',
                param: {
                    contratistaId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/contratistas.new.html',
                        controller: 'contratistaUpdateCtrl'
                    }
                }
            }).state('cuentasCobroCreate', {
                url:'/{contratistaId:int}/createcuenta',
                parent: 'contratistas',
                param: {
                    contratistaId: null
                },
                views: {
                    'listView': {
                        templateUrl: basePathCuentas + 'cuentascobro.create.html',
                        controller: 'contratistaCreateCuentaCtrl',
                        controllerAs: 'ctrl'
                    },
                    'detailView': {
                        templateUrl: basePath + 'contratistas.detail.html',
                        controller: 'contratistaCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('cuentasCobroDelete', {
                url:'/{contratistaId:int}/deletecuenta/{cuentaId:int}',
                parent: 'contratistas',
                params: {
                    contratistaId: null,
                    cuentaId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePathCuentas + 'cuentascobro.delete.html',
                        controller: 'contratistaDeleteCuentaCtrl'
                    }
                }
            }).state('cuentasCobroUpdate', {
                url:'/{contratistaId:int}/updatecuenta/{cuentaId:int}',
                parent: 'contratistas',
                params: {
                    contratistaId: null,
                    cuentaId: null
                },
                views: {
                    'listView': {
                        templateUrl: basePathCuentas + 'cuentascobro.create.html',
                        controller: 'contratistaUpdateCuentaCtrl',
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