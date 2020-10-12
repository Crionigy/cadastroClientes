package br.com.arthurhassan.clientes.services;

import br.com.arthurhassan.clientes.dto.TelefoneDTO;
import br.com.arthurhassan.clientes.models.Cliente;
import br.com.arthurhassan.clientes.models.Telefone;
import br.com.arthurhassan.clientes.repositories.TelefoneRepository;
import br.com.arthurhassan.clientes.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelefoneService {
    @Autowired
    private TelefoneRepository repository;

    public List<Telefone> findAll() {
        return repository.findAll();
    }

    public Telefone save(Telefone entity) {
        return repository.save(entity);
    }

    public List<TelefoneDTO> recuperarTelefonePorCliente (Long idCliente) {
        List<Telefone> telefones = repository.findByCliente(new Cliente(idCliente));

        return geraDtoTelefone(telefones);
    }

    private List<TelefoneDTO> geraDtoTelefone(List<Telefone> telefones) {
        List<TelefoneDTO> dto = ObjectMapperUtils.mapAll(telefones, TelefoneDTO.class);

        return dto;
    }
}
