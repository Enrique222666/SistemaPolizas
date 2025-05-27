package mx.edu.uacm.is.slt.as.sistpolizas.repository;

import mx.edu.uacm.is.slt.as.sistpolizas.model.Beneficiario;
import mx.edu.uacm.is.slt.as.sistpolizas.model.IdBeneficiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BeneficiarioRepository extends JpaRepository<Beneficiario, IdBeneficiario> {
    List<Beneficiario> findByNombresApellidos(String nombres, String primerApellido, String segundoApellido);
    List<Beneficiario> findByNombresApellido(String nombres, String primerApellido);
    List<Beneficiario> findByFechaNacimiento(String fechaNacimiento);

}
