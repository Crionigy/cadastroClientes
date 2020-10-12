angular.module('clientes').factory('clientesApi', function($http, config) {
    var _getClientes = function () {
        return $http.get(config.baseUrl + "/clientes");
    },

    _apagarCliente = function(id) {
        return $http.delete(config.baseUrl + "/clientes/" + id);
    },

    _apagarClientes = function(clientes) {
        return $http.delete(config.baseUrl + "/clientes", {params: [{id: 22},{id: 23},{id: 24}]});
    },
    
    _salvarEditarCliente = function(cliente) {
        return $http.post(config.baseUrl + "/clientes", cliente);
    };

    return {
        getClientes: _getClientes,
        apagarCliente: _apagarCliente,
        apagarClientes: _apagarClientes,
        salvarEditarCliente: _salvarEditarCliente
    };
});