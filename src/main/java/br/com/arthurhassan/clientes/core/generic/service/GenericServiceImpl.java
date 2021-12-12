package br.com.arthurhassan.clientes.core.generic.service;

import br.com.arthurhassan.clientes.core.generic.entity.GenericEntityImpl;
import br.com.arthurhassan.clientes.core.generic.repository.GenericRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.Calendar;
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
    public Page<T> getPage(Pageable pageable) {
        return genericRepository.findAll(pageable);
    }

    @Override
    public T findById(PK id) {
        return genericRepository.findById(id).get();
    }

    @Override
    public T update(T entity) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        T updatedEntetity = findById(entity.getId());
        objectMapper.readerForUpdating(updatedEntetity).readValue(objectMapper.writeValueAsString(entity));
        return genericRepository.save(updatedEntetity);
    }

    @Override
    public T add(T entity) {
        entity.setAudDthInc(Calendar.getInstance());
        return genericRepository.save(entity);
    }

    @Override
    public void deleteOne(PK id) {
        T entity = findById(id);
        genericRepository.delete(entity);
    }

    @Override
    public void deleteAll(List<PK> entity) {
        List<T> toDeleteEntitys = genericRepository.findAllById(entity);
        genericRepository.deleteAll(toDeleteEntitys);
    }

    @Override
    public long count(T entity) {
        return genericRepository.count();
    }

}
