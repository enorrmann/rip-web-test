/**
 * 
 */
angular
		.module('lceApp')
		.controller(
				'PaisesCtrl',
				[
						'$scope',
						'paisesHttpFacade',
						'$location',
						'ListaServicePaises',
						function($scope, paisesHttpFacade, $location,
								ListaServicePaises) {
							console.log($scope.appTitle);
							$scope.nuevaEntidadPais = function() {
								$location.path("/addPais");
							};
							$scope.eliminarEntidadPais = function() {
								$location.path("/delPais");
							};
							$scope.actualizarEntidadPais = function() {
								$location.path("/updatePais");
							};
							$scope.listarPaises = function() {
								paisesHttpFacade
										.buscarListaPaises()
										.success(
												function(data, status, headers,
														config) {
													console.log(data);
													ListaServicePaises.setLista(data);
													console.log(ListaServicePaises.getLista());
													$scope.testListaPaises = ListaServicePaises.getLista();
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
				'AddPaisesCtrl',
				[
						'$scope',
						'paisesHttpFacade',
						'$location',					
						'ListaServicePaises',					
						function($scope, paisesHttpFacade,location,ListaServicePaises) {
							$scope.tituloForm = "Editar Entidad Pais";
							$scope.entidad = {};
							$scope.agregarPais = function() {
								paisesHttpFacade
										.guardarPais($scope.entidad)
										.success(
												function(data, status, headers,
														config) {
													ListaServicePaises.add($scope.entidad);
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
						} ])
		.controller(
				'DeletePaisesCtrl',
				[
						'$scope',
						'paisesHttpFacade',
						'$location',					
						'ListaServicePaises',					
						function($scope, paisesHttpFacade,location,ListaServicePaises) {
							$scope.tituloForm = "Eliminar Entidad Pais";
							$scope.entidad = {};
							$scope.eliminarPais = function() {
								paisesHttpFacade
										.borrarPais($scope.entidad.id)
										.success(
												function(data, status, headers,
														config) {
													ListaServicePaises.add($scope.entidad);
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
						} ])
		.controller(
				'UpdatePaisesCtrl',
				[
						'$scope',
						'paisesHttpFacade',
						'$location',					
						'ListaServicePaises',					
						function($scope, paisesHttpFacade,location,ListaServicePaises) {
							$scope.tituloForm = "Actualizar Entidad Pais";
							$scope.entidad = {};
							$scope.actualizarPais = function() {
								paisesHttpFacade
										.actualizarPais($scope.entidad)
										.success(
												function(data, status, headers,
														config) {
													ListaServicePaises.add($scope.entidad);
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
