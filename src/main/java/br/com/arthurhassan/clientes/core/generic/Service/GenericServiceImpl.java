package br.com.arthurhassan.clientes.core.generic.Service;

import br.com.arthurhassan.clientes.core.exceptions.BadRequestException;
import br.com.arthurhassan.clientes.core.generic.Entity.GenericEntityImpl;
import br.com.arthurhassan.clientes.core.generic.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.io.Serializable;
import java.util.List;

/*
    Superclss com os metodos CRUD para as services da aplicação
        <T> = Modelo que o Service atende
        <PK> = Tipo de chave primaria (Long, Integer...)
*/

public abstract class GenericServiceImpl<T extends GenericEntityImpl<PK>, PK> implements Serializable, GenericService<T, PK> {

    private static final long serialVersionUID = 1L;

    @Autowired
    protected GenericRepository<T, PK> genericRepository;

    @Override
    public T findById(PK id) {
        return genericRepository.findById(id).get();
    }

    @Override
    public T update(T entity) {
        return genericRepository.save(entity);
    }

    @Override
    public T add(T entity) {
        return null;
    }

    @Override
    public void delete(PK id) {

    }

    @Override
    public void delete(List<T> entity) {

    }

    @Override
    public Page<T> getPage(Pageable pageable) {
        return genericRepository.findAll(pageable);
    }

    @Override
    public int count(T entity) {
        return 0;
    }
}
