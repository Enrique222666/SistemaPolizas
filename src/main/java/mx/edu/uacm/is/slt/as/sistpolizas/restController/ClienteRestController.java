package mx.edu.uacm.is.slt.as.sistpolizas.restController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

import mx.edu.uacm.is.slt.as.sistpolizas.model.Cliente;
import mx.edu.uacm.is.slt.as.sistpolizas.repository.ClienteRepository;
import mx.edu.uacm.is.slt.as.sistpolizas.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("api/v1")
public class ClienteRestController {

    @Autowired
    ClienteService clienteService;
    
    public ClienteRestController() {
    }

    @GetMapping("/clientes")
    public List<Cliente> getClientes() {
        return clienteService.getClientes();
    }
    
    @GetMapping("/cliente/{curp}")
    public Optional<Cliente> getClienteByCurp(@PathVariable String curp){
        return clienteService.getClienteByCurp(curp);
    }
    
    @PostMapping("/cliente/{curp}/{direccion}/{fecha_nacimiento}/{nombres}/{primerApellido}/{segundoApellido}")
    public Optional<Cliente> agregarCliente(@RequestBody Cliente cliente){
        return clienteService.agregarCliente(cliente);
    }


}
