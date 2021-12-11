package br.com.arthurhassan.clientes.module.cliente.service;

import br.com.arthurhassan.clientes.core.generic.Service.GenericServiceImpl;
import br.com.arthurhassan.clientes.module.cliente.model.Cliente;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl extends GenericServiceImpl<Cliente, Long> implements ClienteService {
}
