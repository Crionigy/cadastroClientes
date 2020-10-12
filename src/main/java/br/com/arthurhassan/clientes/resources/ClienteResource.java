package br.com.arthurhassan.clientes.resources;

import br.com.arthurhassan.clientes.dto.ClienteDTO;
import br.com.arthurhassan.clientes.models.Cliente;
import br.com.arthurhassan.clientes.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/clientes")
public class ClienteResource {
    @Autowired
    private ClienteService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity recuperarTodos() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity novoCliente(@RequestBody Cliente entity) {
        try {
            service.save(entity);

            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}").buildAndExpand(entity.getId()).toUri();

            return ResponseEntity.created(uri).body(entity);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getLocalizedMessage());
        }
    }
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveCliente(@RequestBody Cliente entity) {
        if(entity.getId() == null){
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Mensagem de erro");
        }
        try {
            service.save(entity);
            return ResponseEntity.ok().body(entity);
        } catch (Exception e){
            return  ResponseEntity.badRequest().body(e.getLocalizedMessage());
        }
    }

    @GetMapping(path="{idCliente}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ClienteDTO recuperarCliente(@PathVariable("idCliente") Long idCliente) {

        return service.findClienteDTO(idCliente);

    }

    @DeleteMapping(path="{idCliente}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteCliente(@PathVariable("idCliente") Long idCliente) {
        Cliente cliente = service.findById(idCliente);

        if(cliente ==  null) {
            return ResponseEntity.status(400).body("Cliente não encontrado!");
        }
        service.deleteCliente(cliente);
        return ResponseEntity.ok().body(cliente);
    }

    @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteClientes(@RequestBody List<Cliente> entity) {

        service.deleteClientes(entity);
        return ResponseEntity.ok().body(entity);
    }
}
