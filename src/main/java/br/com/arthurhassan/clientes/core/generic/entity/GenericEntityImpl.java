package br.com.arthurhassan.clientes.core.generic.entity;

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

    @Transient
    private boolean isNew = true;

    @Override
    public boolean isNew() {
        return isNew;
    }

    @PrePersist
    @PostLoad
    void markNotNew() {
        this.isNew = false;
    }

    public GenericEntityImpl(){super();}

    @Column(name="AUD_DTH_ATU")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar audDthAtu;

    @Column(name="AUD_DTH_INC")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar audDthInc;

    public Calendar getAudDthAtu() {
        return audDthAtu;
    }

    public Calendar getAudDthInc() {
        return audDthInc;
    }

    public void setAudDthAtu(Calendar audDthAtu) {
        this.audDthAtu = audDthAtu;
    }

    public void setAudDthInc(Calendar audDthInc) {
        this.audDthInc = audDthInc;
    }

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
    public PK getId() {
        return null;
    }
}
