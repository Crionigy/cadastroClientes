package br.com.arthurhassan.clientes.services;

import br.com.arthurhassan.clientes.dto.ClienteDTO;
import br.com.arthurhassan.clientes.dto.EnderecoDTO;
import br.com.arthurhassan.clientes.dto.TelefoneDTO;
import br.com.arthurhassan.clientes.models.Cliente;
import br.com.arthurhassan.clientes.models.Endereco;
import br.com.arthurhassan.clientes.models.Telefone;
import br.com.arthurhassan.clientes.repositories.ClienteRepository;
import br.com.arthurhassan.clientes.repositories.EnderecoRepository;
import br.com.arthurhassan.clientes.repositories.TelefoneRepository;
import br.com.arthurhassan.clientes.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private TelefoneRepository telefoneRepository;

    public Cliente findById(Long id) {
        return repository.findById(id).get();
    }

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Cliente save(Cliente entity) throws Exception {

        if(validaCpfCnpj(entity)) {
            throw new Exception("Inscrição ja cadastrada no sistema!");
        }  else {
            return repository.save(entity);
        }
    }

    public ClienteDTO findClienteDTO(Long id) {

        Cliente entity = repository.findById(id).get();
        List<Endereco> enderecos = enderecoRepository.findByCliente(new Cliente(id));
        List<Telefone> telefones = telefoneRepository.findByCliente(new Cliente(id));

        return geraDTO(entity, geraDtoEndereco(enderecos), geraDtoTelefone(telefones));
    }

    public void deleteCliente(Cliente cliente) {
        repository.delete(cliente);
    }

    public void deleteClientes(List<Cliente> entity) {
        entity.forEach(cliente -> {
            repository.deleteById(cliente.getId());
        });
    }

    private ClienteDTO geraDTO(Cliente entity, List<EnderecoDTO> enderecos, List<TelefoneDTO> telefones) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(entity.getId());
        dto.setInscricao(entity.getInscricao());
        dto.setNome(entity.getNome());
        dto.setEnderecos(enderecos);
        dto.setTelefones(telefones);

        return  dto;
    }

    private boolean validaCpfCnpj(Cliente entity) {
        List<Cliente> clientes = repository.findAll();
        boolean existeRegistro = false;

        for(Cliente cliente: clientes){
            if(cliente.getInscricao().equals(entity.getInscricao())) {

                existeRegistro = true;
            } else {
                existeRegistro = false;
            }
        }

        return existeRegistro;
    }

    private List<TelefoneDTO> geraDtoTelefone(List<Telefone> telefones) {
        List<TelefoneDTO> dto = ObjectMapperUtils.mapAll(telefones, TelefoneDTO.class);

        return dto;
    }

    private List<EnderecoDTO> geraDtoEndereco(List<Endereco> enderecos) {
        List<EnderecoDTO> dto = ObjectMapperUtils.mapAll(enderecos, EnderecoDTO.class);

        return dto;
    }

}
