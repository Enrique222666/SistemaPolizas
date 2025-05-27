package mx.edu.uacm.is.slt.as.sistpolizas.service;

import mx.edu.uacm.is.slt.as.sistpolizas.model.Beneficiario;
import mx.edu.uacm.is.slt.as.sistpolizas.model.IdBeneficiario;
import mx.edu.uacm.is.slt.as.sistpolizas.repository.BeneficiarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BeneficiarioService {

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    // Crear o actualizar
    public Beneficiario agregarBeneficiario(Beneficiario beneficiario) {
        return beneficiarioRepository.save(beneficiario);
    }

    // Obtener todos
    public List<Beneficiario> getBeneficiarios() {
        return beneficiarioRepository.findAll();
    }

    // Buscar por ID
    public Optional<Beneficiario> getBeneficiario(IdBeneficiario id) {
        return beneficiarioRepository.findById(id);
    }

        public List<Beneficiario> getBeneficiariosByNombresApellidos(String nombres, String primerApellido, String segundoApellido){
        return beneficiarioRepository.findByNombresApellidos(nombres, primerApellido, segundoApellido);
    }

    public List<Beneficiario> getBeneficiariosByNombresApellido(String nombres, String primerApellido){
        return beneficiarioRepository.findByNombresApellido(nombres, primerApellido);
    }
    
    public List<Beneficiario> getBeneficiariosByFechaNacimiento(String fechaNacimiento){
        return beneficiarioRepository.findByFechaNacimiento(fechaNacimiento);
    }
    
    // Eliminar por ID
    public void deleteBeneficiarios(IdBeneficiario id) {
        beneficiarioRepository.deleteById(id);
    }
}
