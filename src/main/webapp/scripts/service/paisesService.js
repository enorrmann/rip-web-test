angular.module('lceApp')
	.factory('paisesHttpFacade',['$http',
		function ($http) {
			var _getAll = function () {
				return $http.get("/libreta-calificaciones/ui/entidadtest/ent-paises");
			};
			var _get = function (id) {
				return $http.get("/libreta-calificaciones/ui/entidadtest/ent-paises/" + id);
			};
			var _save = function (ent) {
				return $http.post("/libreta-calificaciones/ui/entidadtest", ent);
			};
			var _update = function (ent) {
				return $http.put("/libreta-calificaciones/ui/entidadtest/update-paises", ent);
			};
			var _delete = function (id) {
				return $http.delete("/libreta-calificaciones/ui/entidadtest/del-paises/" + id);
			};
			var _lista = [];
			return {
				buscarListaPaises: _getAll,
				buscarPais: _get,
				guardarPais: _save,
				actualizarPais: _update,
				borrarPais: _delete
			};
		}
]).factory('ListaServicePaises', function(){
	 var data = [];
    return {
        add: function (e) {
	         return data.push(e);
        },
        getLista: function(){
        	return data;       
        },
        setLista: function(l){
        	data = l;       
        }
    };
});