(function (ng) {
    var mod = ng.module("EnProgresoModule", ['ui.router']);
    mod.constant("enProgresoContext", "api/estadosEnProgreso");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/estados/enProgreso/';
            $urlRouterProvider.otherwise("/enProgresoList");

            $stateProvider.state('enProgresos', {
                url: '/enProgresos',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'EnProgreso.html',
                        controller: 'enProgresoCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('enProgresoList', {
                url: '/list',
                parent: 'enProgresos',
                views: {
                    'listView': {
                        templateUrl: basePath + 'EnProgreso.List.html',
                        controller: 'enProgresoCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('enProgresoDetail', {
                url: '/{stateId:int}/detail',
                parent: 'enProgresos',
                param: {
                    stateId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + 'EnProgreso.Detail.html',
                        controller: 'enProgresoCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('enProgresosCreate', {
                url: '/create',
                parent: 'enProgresos',
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/EnProgreso.new.html',
                        controller: 'enProgresoNewCtrl'
                    }
                }
            }).state('enProgresosUpdate', {
                url: '/update',
                parent: 'enProgresos',
                param: {
                    authorId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + 'update/enProgresos.update.html',
                        controller: 'enProgresoUpdateCtrl'
                    }
                }
            }).state('enProgresosDelete', {
                url: '/delete/{stateId:int}',
                parent: 'enProgresos',
                param: {
                    stateId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/delete/EnProgreso.delete.html',
                        controller: 'enProgresoDeleteCtrl'
                    }
                }
            });   
        }]);
})(window.angular);