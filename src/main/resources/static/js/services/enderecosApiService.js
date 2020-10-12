angular.module('clientes').factory('enderecosApi', function($http, config) {
    var _getEnderecos = function () {
        return $http.get(config.baseUrl + "/enderecos");
    },

    _recuperarEnderecosPorCliente = function(id) {
        return $http.get(config.baseUrl + "/enderecos/" + id);
    },

    _apagarEndereco = function(id) {
        return $http.delete(config.baseUrl + "/enderecos/", id);
    },

    _apagarEnderecos = function(ids) {
        return $http.delete(config.baseUrl + "/enderecos", ids);
    };

    return {
        getEnderecos: _getEnderecos,
        apagarEndereco: _apagarEndereco,
        apagarEnderecos: _apagarEnderecos,
        recuperarEnderecosPorCliente: _recuperarEnderecosPorCliente
    };
});