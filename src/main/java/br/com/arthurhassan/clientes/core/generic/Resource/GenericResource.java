package br.com.arthurhassan.clientes.core.generic.Resource;

import br.com.arthurhassan.clientes.core.generic.Entity.GenericEntityImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface GenericResource<T extends GenericEntityImpl<PK>, PK>{

    ResponseEntity getPage(Pageable pageable);

    ResponseEntity findById(@PathVariable("id") PK id);

    ResponseEntity add(@RequestBody T entity);

    ResponseEntity update(@RequestBody T entity);

    ResponseEntity delete(@PathVariable("id") PK id);

    ResponseEntity delete(@RequestBody List<T> entity);
}
