package br.com.arthurhassan.clientes.models;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "TELEFONES")
@Table(name = "TELEFONES")
@SequenceGenerator(allocationSize = 1, name = "SEQ_TELEFONES", sequenceName = "SEQ_TELEFONES")
public class Telefone {

    @Id
    @Column(name="ID_TLEFONE")
    @GeneratedValue(generator = "SEQ_TELEFONE", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name="NUMERO_TELEFONE")
    private String numero_telefone;

    @Column(name="DDD")
    private String DDD;

    @Column(name="OPERADORA")
    private String operadora;

    @ManyToOne
    private Cliente cliente;

    public Telefone() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero_telefone() {
        return numero_telefone;
    }

    public void setNumero_telefone(String numero_telefone) {
        this.numero_telefone = numero_telefone;
    }

    public String getDDD() {
        return DDD;
    }

    public void setDDD(String DDD) {
        this.DDD = DDD;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getOperadora() {
        return operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telefone telefone = (Telefone) o;
        return id.equals(telefone.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Telefone{" +
                "id=" + id +
                ", numero_telefone='" + numero_telefone + '\'' +
                ", DDD=" + DDD +
                ", cliente=" + cliente +
                '}';
    }
}
