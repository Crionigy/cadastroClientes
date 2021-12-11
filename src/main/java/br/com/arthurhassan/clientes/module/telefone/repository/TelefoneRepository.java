package br.com.arthurhassan.clientes.module.telefone.repository;

import br.com.arthurhassan.clientes.core.generic.repository.GenericRepository;
import br.com.arthurhassan.clientes.module.telefone.model.Telefone;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoneRepository extends GenericRepository<Telefone, Long> {
}
