package br.com.arthurhassan.clientes.repositories;

import br.com.arthurhassan.clientes.dto.EnderecoDTO;
import br.com.arthurhassan.clientes.models.Cliente;
import br.com.arthurhassan.clientes.models.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    List<Endereco> findByCliente (@Param("cliente") Cliente cliente);

}
