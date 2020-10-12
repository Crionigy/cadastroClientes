angular.module('clientes').filter('name', function(){
    return function(input){
        let listaDeNomes = input.split(' '),
        nomesFormatados = listaDeNomes.map(nome => {
            return nome.charAt(0).toUpperCase() + nome.substring(1).toLowerCase();
        })

        return nomesFormatados.join(' ');
    };
});