package mx.edu.uacm.is.slt.as.sistpolizas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import  java.util.List;

import mx.edu.uacm.is.slt.as.sistpolizas.model.Poliza;
import mx.edu.uacm.is.slt.as.sistpolizas.Simuladores.BaseDeDatosSimulada;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/polizas")
public class PolizaController {
 

    public PolizaController() {
    }
    
    @GetMapping
    public List<Poliza> getPoliza(){
        System.err.println("OBTENIENDO CLIENTES");
       return BaseDeDatosSimulada.getPolizas();
    }
    
    @GetMapping("/{clave}")
    public Poliza getPolizaByClave(@PathVariable String clave){
        return BaseDeDatosSimulada.getPolizasByClave(clave);
    }
  
     @GetMapping("/t/{tipo}")
    public List<Poliza> getPolizaByTipo(@PathVariable String tipo){
        return BaseDeDatosSimulada.getPolizasByTipo(tipo);
    }
    
      @GetMapping("/c/{curp}")
    public List<Poliza> getPolizaByCurp(@PathVariable String curp){
        return BaseDeDatosSimulada.getPolizasByCurp(curp);
    }
    
      @GetMapping({"/c/{nomres}/{primer_apellido}/{segundo_apellido}", "/c/{nomres}/{primer_apellido}/", "/c/{nomres}/{primer_apellido}"})
    public List<Poliza> getPolizaByNobre(@PathVariable String nomres, @PathVariable String primer_apellido, @PathVariable(required = false) String segundo_apellido){
        
        return BaseDeDatosSimulada.getPolizasByNombre(nomres, primer_apellido, segundo_apellido);
    }    
    
      @GetMapping({"/b/{nomres}/{primer_apellido}/{segundo_apellido}", "/b/{nomres}/{primer_apellido}/", "/b/{nomres}/{primer_apellido}"})
    public List<Poliza> getPolizasByBeneficiario(@PathVariable String nomres, @PathVariable String primer_apellido, @PathVariable(required = false) String segundo_apellido){
        
        return BaseDeDatosSimulada.getPolizasByBeneficiario(nomres, primer_apellido, segundo_apellido);
    } 
    
      @GetMapping("/b/{fechaNacimientoBeneficiario}")
    public List<Poliza> getPolizasByFechaNacimientoBeneficiario(@PathVariable String fechaNacimientoBeneficiario){
        
        return BaseDeDatosSimulada.getPolizasByFechaNacimientoBeneficiario(fechaNacimientoBeneficiario);
    }
    
    @PostMapping("/{clave}/{tipo}/{monto}/{descripcion}/{curpCliente}")
    public Poliza agregarPoliza(@RequestBody Poliza poliza){
        Poliza p = BaseDeDatosSimulada.agregarPoliza(poliza);
        return p;
    }
    
    @PutMapping("/{clave}/{tipo}/{monto}/{descripcion}/{curpCliente}")
    public Poliza editarPoliza(@RequestBody Poliza poliza, @PathVariable String clave){
        Poliza p = BaseDeDatosSimulada.editarPoliza(poliza, clave);
        return p;
    }    
    
    @DeleteMapping("/{clave}")
    public Poliza eliminarPolizaByClave(@PathVariable String clave){
        Poliza poliza = BaseDeDatosSimulada.getPolizasByClave(clave);
        BaseDeDatosSimulada.eliminarPolizaByClave(clave);
        return poliza;
    }
}
