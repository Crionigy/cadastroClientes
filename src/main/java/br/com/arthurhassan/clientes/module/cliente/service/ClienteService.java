package br.com.arthurhassan.clientes.module.cliente.service;

import br.com.arthurhassan.clientes.core.generic.service.GenericService;
import br.com.arthurhassan.clientes.core.generic.service.GenericServiceImpl;
import br.com.arthurhassan.clientes.module.cliente.model.Cliente;
import org.springframework.stereotype.Service;

@Service
public class ClienteService extends GenericServiceImpl<Cliente, Long> implements GenericService<Cliente, Long> {
}
