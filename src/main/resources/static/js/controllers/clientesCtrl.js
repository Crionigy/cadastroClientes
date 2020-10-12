angular.module('clientes').controller('clientesCtrl', function($scope, clientesApi, telefonesApi, enderecosApi) {

    var me = $scope;

    me.cadastroTelefones = [{
        ddd: null,
        numero_telefone: null,
        operadora: null
    }];

    me.cadastroEnderecos = [{
        bairro: null,
        cep: null,
        municipio: null,
        estado: null,
        rua: null,
    }];

    var listarClientes = function() {
        
        clientesApi.getClientes().then(function(response){
            me.clientes = response.data;
        });
    },

    deletarUmCliente = function(clientes) {
        
        clientesApi.apagarCliente(clientes[0].id).then(function(response){
            listarClientes();
        });
    },
    
    salvarCliente = function(cliente){
        clientesApi.salvarEditarCliente(cliente).then(function(response){
            listarClientes();
        });
    };

    me.adicionarNovoTelefone = function() {
        let item = {
            ddd: null,
            numero_telefone: null,
            operadora: null
        },
        existeTelefones = $scope.cliente.telefones;

        if(!existeTelefones){
            $scope.cliente.telefones = [];
        }

        $scope.cliente.telefones.push(item);
    }

    me.adicionarNovoEndereco = function() {
        let item = {
            bairro: null,
            cep: null,
            municipio: null,
            estado: null,
            rua: null,
        },
        existeEnderecos = $scope.cliente.enderecos;

        if(!existeEnderecos){
            $scope.cliente.enderecos = [];
        }

        $scope.cliente.enderecos.push(item);
    }

    me.apagarClientes = function(clientes) {
        let clientesSelecionados;

        if(!clientes){
            return;
        }

        clientesSelecionados = clientes.filter( el => el.selecionado);

        deletarUmCliente(clientesSelecionados);
        
    }

    me.carregarEnderecos = function(cliente) {
        if(!cliente.enderecos){
            enderecosApi.recuperarEnderecosPorCliente(cliente.id).then(function(response){
                cliente.enderecos = response.data;
            });
        }
    }

    me.carregarTelefones = function(cliente) {
        if(!cliente.telefones){
            telefonesApi.recuperarTelefonesPorCliente(cliente.id).then(function(response){
                cliente.telefones = response.data;
            });
        }
    }

    me.isClienteSelecionado = function(clientes) {
        return clientes ? !clientes.some( el => el.selecionado): true;
    }

    me.ordenarPor = function(campo) {
        me.criterioDeOrdenacao = campo;
        me.direcaoDaOrdenacao = !me.direcaoDaOrdenacao;
    }

    me.getTelefonesFiltrados = function(cliente) {
        telefones = 

        tel
    }

    me.getEnderecosFiltrados = function(cliente) {
        
    }

    me.salvarCliente = function(cliente) {
        cliente.telefones = me.getTelefonesFiltrados(cliente);
        cliente.enderecos = me.getEnderecosFiltrados(cliente);
    }

    listarClientes();
});