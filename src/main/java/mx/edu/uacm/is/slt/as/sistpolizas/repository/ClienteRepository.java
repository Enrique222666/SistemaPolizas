package mx.edu.uacm.is.slt.as.sistpolizas.repository;

import java.util.Optional;
import mx.edu.uacm.is.slt.as.sistpolizas.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String>{
    Optional<Cliente> findByNombresApellidos(String nombres, String primerApellido, String segundoApellido);
    Optional<Cliente> findByNombresApellido(String nombres, String primerApellido);

}
