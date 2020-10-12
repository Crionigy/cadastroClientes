package br.com.arthurhassan.clientes.repositories;

import br.com.arthurhassan.clientes.dto.TelefoneDTO;
import br.com.arthurhassan.clientes.models.Cliente;
import br.com.arthurhassan.clientes.models.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {

    List<Telefone> findByCliente (@Param("cliente") Cliente cliente);

}
