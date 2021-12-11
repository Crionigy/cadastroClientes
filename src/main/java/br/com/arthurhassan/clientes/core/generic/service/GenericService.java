package br.com.arthurhassan.clientes.core.generic.service;

import br.com.arthurhassan.clientes.core.generic.entity.GenericEntityImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public interface GenericService<T extends GenericEntityImpl<PK>, PK> extends Serializable {

    public abstract T findById(PK id);

    public abstract T update(T entity);

    public abstract T add(T entity);

    public abstract void delete(PK id);

    public abstract void delete(List<T> entity);

    public abstract Page<T> getPage(Pageable pageable);

    public abstract int count(T entity);

}
