package br.com.arthurhassan.clientes.module.cliente.api;

import br.com.arthurhassan.clientes.core.generic.resource.GenericResourceImpl;
import br.com.arthurhassan.clientes.module.cliente.model.Cliente;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteResource extends GenericResourceImpl<Cliente, Long>{
}
