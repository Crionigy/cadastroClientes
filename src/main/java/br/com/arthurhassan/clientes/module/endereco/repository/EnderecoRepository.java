package br.com.arthurhassan.clientes.module.endereco.repository;

import br.com.arthurhassan.clientes.core.generic.repository.GenericRepository;
import br.com.arthurhassan.clientes.module.endereco.model.Endereco;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends GenericRepository<Endereco, Long> {

}
