package br.com.arthurhassan.clientes.module.telefone.api.dto;

import br.com.arthurhassan.clientes.module.cliente.model.Cliente;
import br.com.arthurhassan.clientes.module.telefone.model.Telefone;

public class TelefoneDTO {

    private String numero_telefone;

    private String DDD;

    private String operadora;

    private Long cliente_id;

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

    public String getOperadora() {
        return operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }

    public Telefone transformIntoObject() {
        return new Telefone(numero_telefone, DDD, operadora, new Cliente(cliente_id));
    }
}
