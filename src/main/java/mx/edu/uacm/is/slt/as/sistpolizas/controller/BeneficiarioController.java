package mx.edu.uacm.is.slt.as.sistpolizas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import mx.edu.uacm.is.slt.as.sistpolizas.model.Beneficiario;
import mx.edu.uacm.is.slt.as.sistpolizas.Simuladores.BaseDeDatosSimulada;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/beneficiarios")
public class BeneficiarioController {

    public BeneficiarioController() {
    }

    @GetMapping
    public List<Beneficiario> getBeneficiarios() {
        System.err.println("OBTENIENDO BENEFICIARIOS");
        return BaseDeDatosSimulada.getBeneficiarios();
    }
    
    @GetMapping("/{fechaNacimiento}/{polizaClave}/{nombres}/{primerApellido}/{segundoApellido}")
    public Beneficiario getBeneficiario(@PathVariable String nombres, @PathVariable String primerApellido, @PathVariable(required = false) String segundoApellido, @PathVariable String fechaNacimiento, @PathVariable String polizaClave) {
        return BaseDeDatosSimulada.getBeneficiario(nombres,primerApellido, segundoApellido, fechaNacimiento, polizaClave);
    } 
    
    @PostMapping("/{fechaNacimiento}/{polizaClave}/{nombres}/{primerApellido}/{segundoApellido}")
    public Beneficiario agrgarBeneficiario(@RequestBody Beneficiario beneficiario) {
        return BaseDeDatosSimulada.agregarBeneficiario(beneficiario);
    }    
}
