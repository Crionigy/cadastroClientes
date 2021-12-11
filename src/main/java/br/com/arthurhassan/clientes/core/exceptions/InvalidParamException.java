package br.com.arthurhassan.clientes.core.exceptions;

public class InvalidParamException extends BadRequestException{

    public InvalidParamException(String param) {
        super("invalid_param", new Object[]{param} );
    }

    public InvalidParamException(Boolean isNull, String param) {
        super("null_param", new Object[]{param} );
    }
}
