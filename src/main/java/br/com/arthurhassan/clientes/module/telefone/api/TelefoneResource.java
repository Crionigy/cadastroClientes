package br.com.arthurhassan.clientes.module.telefone.api;

import br.com.arthurhassan.clientes.core.generic.resource.GenericResourceImpl;
import br.com.arthurhassan.clientes.module.telefone.model.Telefone;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/telefones")
public class TelefoneResource extends GenericResourceImpl<Telefone, Long> {

}
