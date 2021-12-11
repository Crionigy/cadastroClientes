package br.com.arthurhassan.clientes.module.cliente.api.dto;


import br.com.arthurhassan.clientes.module.cliente.model.Cliente;

public class ClienteDTO {

    private String nome;

    private String inscricao;

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

    public Cliente transformIntoObject() {
        return new Cliente(nome, inscricao);
    }

}
