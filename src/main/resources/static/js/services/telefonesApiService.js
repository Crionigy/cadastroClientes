angular.module('clientes').factory('telefonesApi', function($http, config) {
    var _getTelefones = function () {
        return $http.get(config.baseUrl + "/telefones");
    },

    _recuperarTelefonesPorCliente = function(id) {
        return $http.get(config.baseUrl + "/telefones/" + id);
    },

    _apagarTelefone = function(id) {
        return $http.delete(config.baseUrl + "/telefones/", id);
    },

    _apagarTelefones = function(ids) {
        return $http.delete(config.baseUrl + "/telefones", ids);
    };

    return {
        getTelefones: _getTelefones,
        apagarTelefone: _apagarTelefone,
        apagarTelefones: _apagarTelefones,
        recuperarTelefonesPorCliente: _recuperarTelefonesPorCliente
    };
});