package br.com.arthurhassan.clientes.core.generic.service;

import br.com.arthurhassan.clientes.core.generic.entity.GenericEntityImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public interface GenericService<T extends GenericEntityImpl<PK>, PK> extends Serializable {

    public abstract T findById(PK id);

    public abstract T update(T entity) throws JsonProcessingException;

    public abstract T add(T entity);

    public abstract void deleteOne(PK id);

    public abstract void deleteAll(List<PK> entity);

    public abstract Page<T> getPage(Pageable pageable);

    public abstract long count(T entity);

}
