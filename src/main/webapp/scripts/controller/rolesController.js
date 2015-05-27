/**
 * 
 */
angular
		.module('lceApp')
		.controller(
				'RolesCtrl',
				[
						'$scope',
						'rolesHttpFacade',
						'$location',
						'ListaServiceRoles',
						function($scope, rolesHttpFacade, $location,
								ListaServiceRoles) {
//							$scope.appTitle = "Roles";
							$scope.nuevaEntidadRol = function() {
								$location.path("/addRol");
							};
							$scope.listarRoles = function() {
								rolesHttpFacade
										.buscarListaRoles()
										.success(
												function(data, status, headers,
														config) {
													console.log(data);
													ListaServiceRoles.setLista(data);
													console.log(ListaServiceRoles.getLista());
													$scope.testListaRoles = ListaServiceRoles.getLista();
												})
										.error(
												function(data, status, headers,
														config) {
													switch (status) {
													case 401: {
														$scope.message = "You must be authenticated!"
														break;
													}
													case 500: {
														$scope.message = "Something went wrong!";
														break;
													}
													}
													console.log(data, status);
												});
							}
						} ])
		.controller(
				'AddRolesCtrl',
				[
						'$scope',
						'rolesHttpFacade',
						'$location',					
						'ListaServiceRoles',					
						function($scope, rolesHttpFacade,location,ListaServiceRoles) {
							$scope.tituloForm = "Editar Entidad Rol";
							$scope.entidad = {};
							$scope.agregarRol = function() {
								rolesHttpFacade
										.guardarRol($scope.entidad)
										.success(
												function(data, status, headers,
														config) {
													ListaServiceRoles.add($scope.entidad);
													location.path("/inicial");
												})
										.error(
												function(data, status, headers,
														config) {
													switch (status) {
													case 401: {
														$scope.message = "You must be authenticated!"
														break;
													}
													case 500: {
														$scope.message = "Something went wrong!";
														break;
													}
													}
													console.log(data, status);
												});
							}
						} ]);
