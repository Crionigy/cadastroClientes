package br.com.arthurhassan.clientes.core.exceptions;

import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;
import java.util.Locale;

@RestControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler
{
    private final MessageSource messageSource;

    private String exceptionPropetie;

    public ResponseExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
        this.exceptionPropetie = messageSource.getMessage("exception", null, Locale.ROOT);
    }

    @ExceptionHandler({BadRequestException.class})
    protected ResponseEntity handleBadRequestException(BadRequestException exception, Locale locale){
        String messageName =  this.exceptionPropetie + exception.getMessageName();
        Object[] args = exception.getArgs();

        String message = messageSource.getMessage(messageName, args, locale);
        return ResponseEntity.badRequest().body(message);
    }

    @ExceptionHandler({ResponseStatusException.class})
    protected ResponseEntity handleResponseStatusException(ResponseStatusException exception, Locale locale){
        String messageName = this.exceptionPropetie + exception.getStatus().name().toLowerCase(Locale.ROOT);
        String[] splitReason = exception.getReason().split("/");
        Object[] args = Arrays.stream(splitReason).toArray();

        String message = messageSource.getMessage(messageName, args, locale);
        return ResponseEntity.status(exception.getStatus()).body(message);
    }
}
