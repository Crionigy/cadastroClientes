angular.module("clientes").config(function($routeProvider) {
    $routeProvider.when("/listaClientes", {
        templateUrl: "view/clientes/listaClientes.html",
        controller: "clientesCtrl"
    });
    $routeProvider.when("/cadastroClientes", {
        templateUrl: "view/clientes/cadastroClientes.html",
        controller: "clientesCtrl"
    });
    $routeProvider.when("/listaEnderecos", {
        templateUrl: "view/enderecos/listaEnderecos.html",
        controller: "enderecoCtrl"
    });
    $routeProvider.when("/cadastroEnderecos", {
        templateUrl: "view/enderecos/cadastroEnderecos.html",
        controller: "enderecoCtrl"
    });
    $routeProvider.when("/listaTelefones", {
        templateUrl: "view/telefones/listaTelefones.html",
        controller: "telefoneCtrl"
    });
    $routeProvider.when("/cadastroTelefones", {
        templateUrl: "view/telefones/cadastroTelefones.html",
        controller: "telefoneCtrl"
    });
    $routeProvider.when("/mainHome", {
        templateUrl: "view/main/mainHome.html"
    });
    $routeProvider.otherwise({redirectTo: "/mainHome"});
});