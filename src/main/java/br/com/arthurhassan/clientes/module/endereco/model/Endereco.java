package br.com.arthurhassan.clientes.module.endereco.model;


import br.com.arthurhassan.clientes.core.generic.entity.GenericEntityImpl;
import br.com.arthurhassan.clientes.module.cliente.model.Cliente;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "ENDERECOS")
public class Endereco extends GenericEntityImpl<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="ID_ENDERECO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="CEP")
    private String cep;

    @Column(name="BAIRRO")
    private String bairro;

    @Column(name="RUA")
    private String rua;

    @Column(name="MUNICIPIO")
    private String municipio;

    @Column(name="ESTADO")
    private String estado;

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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Endereco(String cep, String bairro, String rua, String municipio, String estado, Cliente cliente) {
        this.cep = cep;
        this.bairro = bairro;
        this.rua = rua;
        this.municipio = municipio;
        this.estado = estado;
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", cep='" + cep + '\'' +
                ", bairro='" + bairro + '\'' +
                ", rua='" + rua + '\'' +
                ", municipio='" + municipio + '\'' +
                ", estado='" + estado + '\'' +
                ", cliente=" + cliente +
                '}';
    }
}
