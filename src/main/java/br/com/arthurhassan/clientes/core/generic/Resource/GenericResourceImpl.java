package br.com.arthurhassan.clientes.core.generic.Resource;


import br.com.arthurhassan.clientes.core.exceptions.InvalidParamException;
import br.com.arthurhassan.clientes.core.generic.Entity.GenericEntityImpl;
import br.com.arthurhassan.clientes.core.generic.Service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@SuppressWarnings({ "unchecked", "rawtypes" })
@ResponseBody
public class GenericResourceImpl<T extends GenericEntityImpl<PK>, PK> implements GenericResource<T,PK>{

    @Autowired
    private GenericService<T, PK> genericService;

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getPage(Pageable pageable) {
        return ResponseEntity.ok().body(genericService.getPage(pageable));
    }

    @Override
    @GetMapping(path="{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity findById(@PathVariable("id") PK id) {
        try {
            return ResponseEntity.ok().body(genericService.findById(id));
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, getClass().getSimpleName().replace("Resource", "") + "/" + id.toString());
        }

    }

    @Override
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity add(@RequestBody T entity) {
        try {
            genericService.add(entity);

            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}").buildAndExpand(entity.getId()).toUri();

            return ResponseEntity.created(uri).body(entity);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getLocalizedMessage());
        }
    }

    @Override
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@RequestBody T entity) {
        if(entity.getId() == null){
            throw new InvalidParamException(true, "Id");
        }

        try {
            genericService.update(entity);
            return ResponseEntity.ok().body(entity);
        } catch (Exception e){
            String reason = getClass().getSimpleName().replace("Resource", "") + "/" + entity.getId().toString();
            throw new ResponseStatusException(HttpStatus.CONFLICT, reason);
        }
    }

    @Override
    @DeleteMapping(path="{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@PathVariable("id") PK id) {
        try {
            genericService.delete(id);
            return new ResponseEntity("Sucesso ao apagar!", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("Erro ao apagar!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@RequestBody List<T> entity){
        try {
            genericService.delete(entity);
            return new ResponseEntity("Sucesso ao apagar!", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("Erro ao apagar!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}