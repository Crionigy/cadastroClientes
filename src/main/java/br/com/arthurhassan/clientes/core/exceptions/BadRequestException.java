package br.com.arthurhassan.clientes.core.exceptions;

import lombok.Getter;

@Getter
public class BadRequestException extends RuntimeException{

    private final Object[] args;

    private final String messageName;

    public BadRequestException(String messageName, Object[] args){
        super(messageName);
        this.messageName = messageName;
        this.args = args;
    }
}
