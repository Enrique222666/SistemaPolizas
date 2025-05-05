package mx.edu.uacm.is.slt.as.sistpolizas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import mx.edu.uacm.is.slt.as.sistpolizas.model.Cliente;
import mx.edu.uacm.is.slt.as.sistpolizas.Simuladores.BaseDeDatosSimulada;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    public ClienteController() {
    }

    @GetMapping
    public List<Cliente> getClientes() {
        System.err.println("OBTENIENDO CLIENTES");
        return BaseDeDatosSimulada.getClientes();
    }
    
    @GetMapping("/{curp}")
    public static Cliente getClienteByCurp(@PathVariable String curp){
        return BaseDeDatosSimulada.getClienteByCurp(curp);
    }
    
    @PostMapping("/{curp}/{direccion}/{fecha_nacimiento}/{nombres}/{primerApellido}/{segundoApellido}")
    public static Cliente agregarCliente(@RequestBody Cliente cliente){
        return BaseDeDatosSimulada.agregarCliente(cliente);
    }

    @PutMapping("/{curp}/{direccion}/{fecha_nacimiento}/{nombres}/{primerApellido}/{segundoApellido}")
    public static Cliente editarCliente(@RequestBody Cliente cliente, @PathVariable String curp){
        return BaseDeDatosSimulada.editarCliente(cliente, curp);
    }
}
