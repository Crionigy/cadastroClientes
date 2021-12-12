package br.com.arthurhassan.clientes.module.telefone.model;

import br.com.arthurhassan.clientes.core.generic.entity.GenericEntityImpl;
import br.com.arthurhassan.clientes.module.cliente.model.Cliente;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "TELEFONES")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Telefone extends GenericEntityImpl<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="ID_TELEFONE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="NUMERO_TELEFONE")
    private String numero_telefone;

    @Column(name="DDD")
    private String DDD;

    @Column(name="OPERADORA")
    private String operadora;

    @NotNull
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Override
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

    public Telefone(String numero_telefone, String DDD, String operadora, Cliente cliente) {
        this.numero_telefone = numero_telefone;
        this.DDD = DDD;
        this.operadora = operadora;
        this.cliente = cliente;
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
