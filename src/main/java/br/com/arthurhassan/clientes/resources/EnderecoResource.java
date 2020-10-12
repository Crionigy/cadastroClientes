package br.com.arthurhassan.clientes.resources;

import br.com.arthurhassan.clientes.dto.EnderecoDTO;
import br.com.arthurhassan.clientes.models.Endereco;
import br.com.arthurhassan.clientes.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/enderecos")
public class EnderecoResource {
    @Autowired
    private EnderecoService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity save(@RequestBody Endereco entity) {
        service.save(entity);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(entity.getId()).toUri();

        return ResponseEntity.created(uri).body(entity);
    }

    @GetMapping(path="{idCliente}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EnderecoDTO>> recuperarEnderecoPorCliente(@PathVariable("idCliente") Long idCliente) {

        return ResponseEntity.ok().body(service.recuperarEnderecoPorCliente(idCliente));
    }
}
