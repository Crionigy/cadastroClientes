package br.com.arthurhassan.clientes.module.cliente.repository;

import br.com.arthurhassan.clientes.core.generic.repository.GenericRepository;
import br.com.arthurhassan.clientes.module.cliente.model.Cliente;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends GenericRepository<Cliente, Long> {
}
