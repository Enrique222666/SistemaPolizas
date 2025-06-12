package mx.edu.uacm.is.slt.as.sistpolizas.repository;

import java.util.Date;
import mx.edu.uacm.is.slt.as.sistpolizas.model.Beneficiario;
import mx.edu.uacm.is.slt.as.sistpolizas.model.IdBeneficiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BeneficiarioRepository extends JpaRepository<Beneficiario, IdBeneficiario> {
    List<Beneficiario> findById_NombresAndId_PrimerApellidoAndId_SegundoApellido(String nombres, String primerApellido, String segundoApellido);
    List<Beneficiario> findById_NombresAndId_PrimerApellido(String nombres, String primerApellido);
    List<Beneficiario> findByIdFechaNacimiento(Date fechaNacimiento);

}
