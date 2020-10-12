package br.com.arthurhassan.clientes.dto;

import br.com.arthurhassan.clientes.models.Endereco;
import br.com.arthurhassan.clientes.models.Telefone;

import java.util.List;

public class ClienteDTO {

    private Long id;

    private String nome;

    private String inscricao;

    private List<EnderecoDTO> enderecos;

    private List<TelefoneDTO> telefones;

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

    public List<TelefoneDTO> getTelefones() {
        return telefones;
    }

    public void setEnderecos(List<EnderecoDTO> enderecos) {
        this.enderecos = enderecos;
    }

    public List<EnderecoDTO> getEnderecos() {
        return enderecos;
    }

    public void setTelefones(List<TelefoneDTO> telefones) {
        this.telefones = telefones;
    }
}
