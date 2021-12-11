package br.com.arthurhassan.clientes.core.generic.Entity;

import br.com.arthurhassan.clientes.module.cliente.model.Cliente;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;

@MappedSuperclass
@JsonIgnoreProperties({"delete", "audDthInc", "audDthAtu"})
public class GenericEntityImpl<PK> implements GenericEntity<PK>, Serializable {

    private static final long serialVersionUID = 1L;


    public GenericEntityImpl(){super();}

    @Column(name="AUD_DTH_ATU")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar audDthAtu;

    @Column(name="AUD_DTH_INC")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar audDthInc;

    @Transient
    private boolean delete = false;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return getId().equals(cliente.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    @JsonIgnore
    public PK getId() {
        return null;
    }
}
