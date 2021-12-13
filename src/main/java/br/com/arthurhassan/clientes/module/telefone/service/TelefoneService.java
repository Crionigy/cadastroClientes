package br.com.arthurhassan.clientes.module.telefone.service;

import br.com.arthurhassan.clientes.core.generic.service.GenericService;
import br.com.arthurhassan.clientes.core.generic.service.GenericServiceImpl;
import br.com.arthurhassan.clientes.module.telefone.model.Telefone;
import org.springframework.stereotype.Service;

@Service
public class TelefoneService extends GenericServiceImpl<Telefone, Long> implements GenericService<Telefone, Long> {

}
