angular.module('clientes').controller('telefoneCtrl', function($scope, telefonesApi) {
      
    var me = $scope;


    var listarTelefones = function() {
        
        telefonesApi.getTelefones().then(function(response){
            me.telefones = response.data;
        });
    },

    deletarUmEndereco = function(enderecos) {
        telefonesApi.apagarCliente(id).then(function(response){
            listarEnderecos();
        });
    },

    deletarVariosEnderecos = function(enderecos) {
        let enderecosApagar = {
            ids: []
        };

        enderecos.forEach( el => enderecosApagar.ids.push(el.id));
        
        telefonesApi.apagarEnderecos(enderecosApagar).then(function(response){
            listarEnderecos();
        });
    };

    me.apagarEnderecos = function(clientes) {
        let enderecosSelecionados;

        if(!clientes){
            return;
        }

        enderecosSelecionados = clientes.filter( el => el.selecionado);

        if(enderecosSelecionados.length !== 1) {
            deletarVariosEnderecos(enderecosSelecionados);
        } else {
            deletarUmEndereco(enderecosSelecionados);
        }
    }

    me.editarEndereco = function(cliente){
        debugger;
    }

    me.isTelefonesSelecionado = function(enderecos) {
        return enderecos ? !enderecos.some( el => el.selecionado): true;
    }

    me.isDeslogadoInvalido= function(enderecos){
        return false;//$scope.clienteForm.$invalid ? true : false;
    }

    me.ordenarPor = function(campo) {
        me.criterioDeOrdenacao = campo;
        me.direcaoDaOrdenacao = !me.direcaoDaOrdenacao;
    }

    listarTelefones();
});