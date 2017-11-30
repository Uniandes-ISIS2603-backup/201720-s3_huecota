/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("AccidenteModule", ['ui.router']);
    mod.constant("accidentesContext", "api/accidentes");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/accidentes/';
            $urlRouterProvider.otherwise("/accidentesList");

            $stateProvider.state('accidentes', {
                url: '/accidentes',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'accidentes.html',
                        controller: 'AccidenteCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('accidentesList', {
                url: '/list',
                parent: 'accidentes',
                views: {
                    'listView': {
                        templateUrl: basePath + 'accidentes.list.html',
                        controller: 'AccidenteCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('accidentesForm', {
                url: '/form',
                parent: 'accidentes',
                views: {
                    'formView': {
                        templateUrl: basePath + '/new/accidentes.form.html',
                        controller: 'AccidenteNewCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('accidentesUpdate', {
                url: '/update/{accidenteId:int}',
                parent: 'accidentes',
                param: {
                    accidenteId: null
                },
                views: {
                    'listView': {
                        templateUrl: basePath + '/update/accidentes.update.html',
                        controller: 'AccidenteUpdateCtrl',
						controllerAs: 'ctrl'
                    }
                }
            }).state('accidentesDelete', {
                url: '/delete/{accidenteId:int}',
                parent: 'accidentes',
                param: {
                    accidenteId: null
                },
                views: {
                    'listView': {
                        templateUrl: basePath + '/delete/accidentes.delete.html',
                        controller: 'AccidenteDeleteCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });   
        }]);
})(window.angular);