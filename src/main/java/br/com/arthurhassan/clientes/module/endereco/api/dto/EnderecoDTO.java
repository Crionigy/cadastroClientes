package br.com.arthurhassan.clientes.module.endereco.api.dto;

import br.com.arthurhassan.clientes.module.cliente.model.Cliente;
import br.com.arthurhassan.clientes.module.endereco.model.Endereco;

public class EnderecoDTO {

    private String cep;

    private String bairro;

    private String rua;

    private String municipio;

    private String estado;

    private Long cliente_id;

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

    public Long getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Long cliente_id) {
        this.cliente_id = cliente_id;
    }

    public Endereco transformIntoObject() {
        return new Endereco(cep, bairro, rua, municipio, estado, new Cliente(cliente_id));
    }
}
