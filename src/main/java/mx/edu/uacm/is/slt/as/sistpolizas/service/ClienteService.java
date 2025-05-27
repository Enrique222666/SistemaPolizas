package mx.edu.uacm.is.slt.as.sistpolizas.service;

import java.util.List;
import java.util.Optional;
import mx.edu.uacm.is.slt.as.sistpolizas.model.Cliente;
import mx.edu.uacm.is.slt.as.sistpolizas.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
        @Autowired
        ClienteRepository clienteRepository;
        
    public List<Cliente> getClientes(){
        return clienteRepository.findAll();
    }
    
    public Optional<Cliente> getClienteByCurp(String curp){
        return  clienteRepository.findById(curp);
    }
    
    public Optional<Cliente> getClienteByNombresApellidos(String nombres, String primerApellido, String segundoApellido){
        return clienteRepository.findByNombresApellidos(nombres, primerApellido, segundoApellido);
    }

    public Optional<Cliente> getClienteByNombresApellido(String nombres, String primerApellido){
        return clienteRepository.findByNombresApellido(nombres, primerApellido);
    }
    
    public Optional<Cliente> agregarCliente(Cliente cliente){
        clienteRepository.save(cliente);
        return  clienteRepository.findById(cliente.getCurp());
        
    }
    
    

}