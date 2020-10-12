package br.com.arthurhassan.clientes.services;

import br.com.arthurhassan.clientes.dto.EnderecoDTO;
import br.com.arthurhassan.clientes.models.Cliente;
import br.com.arthurhassan.clientes.models.Endereco;
import br.com.arthurhassan.clientes.repositories.EnderecoRepository;
import br.com.arthurhassan.clientes.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository repository;

    public List<Endereco> findAll() {
        return repository.findAll();
    }

    public Endereco save(Endereco entity) {
        return repository.save(entity);
    }

    public List<EnderecoDTO> recuperarEnderecoPorCliente (Long idCliente) {
        List<Endereco> enderecos = repository.findByCliente(new Cliente(idCliente));

        return geraDtoTelefone(enderecos);
    }

    private List<EnderecoDTO> geraDtoTelefone(List<Endereco> enderecos) {
        List<EnderecoDTO> dto = ObjectMapperUtils.mapAll(enderecos, EnderecoDTO.class);

        return dto;
    }
}
