angular.module('clientes').directive('removeClick', function() {
    return {
        link: function(scope, element, attrs, ctrl) {
            scope.remove = function(campo) {

                if(campo){
                    campo.removido = true;
                }

                element.removeClass();
                element.remove();
            };
        }
    };
});