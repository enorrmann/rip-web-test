angular.module('lceApp', ['ngRoute']).config(function($routeProvider) {
	$routeProvider.when('/inicial', {
		controller : 'GralCtrl',
		templateUrl : 'partials/inicial.html'
	}).when('/addPais', {
		controller : 'AddPaisesCtrl',
		templateUrl : 'partials/paises/alta.html'
	}).when('/delPais', {
		controller : 'DeletePaisesCtrl',
		templateUrl : 'partials/paises/baja.html'
	}).when('/updatePais', {
		controller : 'UpdatePaisesCtrl',
		templateUrl : 'partials/paises/update.html'
	}).when('/addRol', {
		controller : 'AddRolesCtrl',
		templateUrl : 'partials/roles/alta.html'
	}).otherwise({
			redirectTo: "/inicial"
	});
});

angular.module('lceApp').controller('GralCtrl',function($scope){
	$scope.appTitle=" ABM test ";
});
