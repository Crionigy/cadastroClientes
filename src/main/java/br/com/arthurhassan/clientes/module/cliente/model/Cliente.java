package br.com.arthurhassan.clientes.module.cliente.model;

import br.com.arthurhassan.clientes.core.generic.entity.GenericEntityImpl;
import br.com.arthurhassan.clientes.module.endereco.model.Endereco;
import br.com.arthurhassan.clientes.module.telefone.model.Telefone;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "CLIENTES")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cliente extends GenericEntityImpl<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="CLIENTE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="NOME")
    private String nome;

    @Column(name="INSCRICAO_CLIENTE")
    private String inscricao;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private Set<Telefone> telefones = new HashSet<Telefone>();

    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private Set<Endereco> enderecos = new HashSet<Endereco>();

    //Getters & Setters
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getInscricao() {
        return inscricao;
    }

    public void setInscricao(String inscricao) {
        this.inscricao = inscricao;
    }

    public Set<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(Set<Telefone> telefones) {
        this.telefones = telefones;
    }

    public Set<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Set<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    //Constructors
    public Cliente(Long id) {
        this.id = id;
    }

    public Cliente(String nome, String inscricao) {
        this.nome = nome;
        this.inscricao = inscricao;
    }

    public Cliente(Cliente newCliente) {
       this.nome = newCliente.getNome();
       this.inscricao = newCliente.getInscricao();
    }

    //Overrides
    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", inscricao='" + inscricao + '\'' +
                ", telefones=" + telefones +
                ", enderecos=" + enderecos +
                '}';
    }
}
