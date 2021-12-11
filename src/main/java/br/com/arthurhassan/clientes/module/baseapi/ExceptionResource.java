package br.com.arthurhassan.clientes.module.baseapi;

import br.com.arthurhassan.clientes.core.exceptions.BadRequestException;
import br.com.arthurhassan.clientes.core.exceptions.InvalidParamException;
import br.com.arthurhassan.clientes.module.endereco.model.Endereco;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


/*
* Controller utilizado para testar as exceções
* */

@RestController
@RequestMapping("/api")
public class ExceptionResource {

    @GetMapping("/test/{param}")
    public ResponseEntity testExceptionWithParam(@PathVariable String param){
        if(param.equals("Secret")){
            return ResponseEntity.ok().body("Congratulations! You have found this secret message!");
        }else{
            throw new InvalidParamException(param);
        }
    }

    @GetMapping("/test")
    public ResponseEntity testSimpleException(){
        throw new BadRequestException("no_access", new Object[]{});
    }

    @GetMapping("/status")
    public ResponseEntity testStatusException(){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, Endereco.class.getSimpleName() + "/" + "1");
    }
}