package br.com.arthurhassan.clientes.core.generic.repository;

import br.com.arthurhassan.clientes.core.generic.Entity.GenericEntityImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<T extends GenericEntityImpl<PK>, PK> extends JpaRepository<T, PK> {
}
