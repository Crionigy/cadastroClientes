package br.com.arthurhassan.clientes.core.generic.resource;

import br.com.arthurhassan.clientes.core.generic.entity.GenericEntityImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface GenericResource<T extends GenericEntityImpl<PK>, PK>{

    ResponseEntity getPage(Pageable pageable);

    ResponseEntity findById(@PathVariable("id") PK id);

    ResponseEntity add(@RequestBody T entity);

    ResponseEntity update(@RequestBody T entity);

    ResponseEntity deleteOne(@PathVariable("id") PK id);

    ResponseEntity deleteAll(@RequestBody List<PK> entity);
}
