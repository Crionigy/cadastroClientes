package br.com.arthurhassan.clientes.models;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "ENDERECOS")
@Table(name = "ENDERECOS")
@SequenceGenerator(allocationSize = 1, name = "SEQ_ENDERECO", sequenceName = "SEQ_ENDERECO")
public class Endereco {

    @Id
    @Column(name="ID_ENDERECO")
    @GeneratedValue(generator = "SEQ_ENDERECO", strategy = GenerationType.SEQUENCE)
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

    @ManyToOne
    private Cliente cliente;

    public Endereco() {

    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return id.equals(endereco.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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
