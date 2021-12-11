package br.com.arthurhassan.clientes.module.endereco.api;

import br.com.arthurhassan.clientes.core.generic.resource.GenericResourceImpl;
import br.com.arthurhassan.clientes.module.endereco.model.Endereco;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enderecos")
public class EnderecoResource extends GenericResourceImpl<Endereco, Long> {

}
