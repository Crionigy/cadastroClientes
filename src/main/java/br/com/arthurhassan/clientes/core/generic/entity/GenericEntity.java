package br.com.arthurhassan.clientes.core.generic.entity;

import org.springframework.data.domain.Persistable;

public interface GenericEntity<PK> extends Persistable<PK> {

    public PK getId();
}
