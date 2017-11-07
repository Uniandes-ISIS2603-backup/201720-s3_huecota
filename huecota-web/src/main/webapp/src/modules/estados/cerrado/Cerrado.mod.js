(function (ng) {
    var mod = ng.module("CerradoModule", ['ui.router']);
    mod.constant("cerradoContext", "api/estadosCerrado");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/estados/cerrado/';
            $urlRouterProvider.otherwise("/cerradoList");

            $stateProvider.state('cerrados', {
                url: '/cerrados',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'Cerrado.html',
                        controller: 'cerradoCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('cerradoList', {
                url: '/list',
                parent: 'cerrados',
                views: {
                    'listView': {
                        templateUrl: basePath + 'Cerrado.List.html',
                        controller: 'cerradoCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('cerradoDetail', {
                url: '/{stateId:int}/detail',
                parent: 'cerrados',
                param: {
                    stateId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + 'Cerrado.Detail.html',
                        controller: 'cerradoCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('cerradosCreate', {
                url: '/create',
                parent: 'cerrados',
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/Cerrado.new.html',
                        controller: 'cerradoNewCtrl'
                    }
                }
            }).state('cerradosUpdate', {
                url: '/update',
                parent: 'cerrados',
                param: {
                    authorId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + 'update/cerrados.update.html',
                        controller: 'cerradoUpdateCtrl'
                    }
                }
            }).state('cerradosDelete', {
                url: '/delete',
                parent: 'cerrados',
                param: {
                    authorId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/delete/cerrados.delete.html',
                        controller: 'cerradoDeleteCtrl'
                    }
                }
            });   
        }]);
})(window.angular);