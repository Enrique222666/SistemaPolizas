package mx.edu.uacm.is.slt.as.sistpolizas.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class IdBeneficiario implements Serializable {

    private String nombres;
    private String primerApellido;
    private String segundoApellido;
    private LocalDate fechaNacimiento;
    private String clavePoliza;

    public IdBeneficiario() {
    }

    public IdBeneficiario(String nombres, String primerApellido, String segundoApellido, LocalDate fechaNacimiento, String clavePoliza) {
        this.nombres = nombres;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.clavePoliza = clavePoliza;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombre(String nombre) {
        this.nombres = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getClavePoliza() {
        return clavePoliza;
    }

    public void setClavePoliza(String clavePoliza) {
        this.clavePoliza = clavePoliza;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombres, primerApellido, segundoApellido, fechaNacimiento, clavePoliza);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        IdBeneficiario other = (IdBeneficiario) obj;
        return Objects.equals(nombres, other.nombres)
            && Objects.equals(primerApellido, other.primerApellido)
            && Objects.equals(segundoApellido, other.segundoApellido)
            && Objects.equals(fechaNacimiento, other.fechaNacimiento)
            && Objects.equals(clavePoliza, other.clavePoliza);
    }
}
