angular.module('lceApp')
	.factory('rolesHttpFacade',['$http',
		function ($http) {
			var _getAll = function () {
				return $http.get("/libreta-calificaciones/ui/entidadtest/ent-roles");
			};
			var _get = function (id) {
				return $http.get("/libreta-calificaciones/ui/entidadtest/ent-roles/" + id);
			};
			var _save = function (ent) {
				return $http.post("/libreta-calificaciones/ui/entidadtest", ent);
			};
			var _update = function (rol) {
				return $http.put("/libreta-calificaciones/ui/entidadtest/ent-roles", ent);
			};
			var _delete = function (id) {
				return $http.post("/libreta-calificaciones/ui/entidadtest/ent-roles/"+id);
			};
			var _lista = [];
			return {
				buscarListaRoles: _getAll,
				buscarRol: _get,
				guardarRol: _save,
				actualizarRol: _update,
				borrarRol: _delete
			};
		}
]).factory('ListaServiceRoles', function(){
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