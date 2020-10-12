package br.com.arthurhassan.clientes.models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "CLIENTES")
@Table(name = "CLIENTES")
@SequenceGenerator(allocationSize = 1, name = "SEQ_CLIENTE", sequenceName = "SEQ_CLIENTE")
public class Cliente {
    @Id
    @Column(name="ID_CLIENTE")
    @GeneratedValue(generator = "SEQ_CLIENTE", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name="NOME")
    private String nome;

    @Column(name="INSCRICAO_CLIENTE")
    private String inscricao;

    public Cliente() {

    }

    public Cliente(Long id) {
        this.id = id;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id.equals(cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", inscricao='" + inscricao + '\'' +
                '}';
    }
}
