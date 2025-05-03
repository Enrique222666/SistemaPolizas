/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.uacm.is.slt.as.sistpolizas;

public class Beneficiario {
    private String nombres;
    private String primerApellido;
    private String segundoApellido;
    private String fechaNacimiento;
    private String poliza; // Clave o número de la póliza
    private double porcentaje; // Porcentaje de beneficio (por ejemplo, 50.0)
    // Constructor
    public Beneficiario(String nombres, String primerApellido, String segundoApellido,
    String fechaNacimiento, String poliza, double porcentaje) {
        this.nombres = nombres;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.poliza = poliza;
        this.porcentaje = porcentaje;
    }
    
    // Getters y Setters
    public String getNombres() {
        return nombres;
    }
    
    public void setNombres(String nombres) {
        this.nombres = nombres;
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
 
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
 
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
 
    public String getPoliza() {
        return poliza;
    }
 
    public void setPoliza(String poliza) {
        this.poliza = poliza;
    }
 
    public double getPorcentaje() {
        return porcentaje;
    }
 
    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }
}