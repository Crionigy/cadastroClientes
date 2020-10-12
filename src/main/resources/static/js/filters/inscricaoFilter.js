angular.module('clientes').filter('inscricao', function(){
    return function(input){
        
        if(!input) {
            return;    
        }

        input = input.replace(/[^\d]/g, "");

        if(input.length == 11) {
            return input.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/, "$1.$2.$3-$4");
        } else {
            return input.replace(/^(\d{2})(\d{3})(\d{3})(\d{4})(\d{2})/, "$1 $2 $3/$4-$5")
        }      
          
    };
});