/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.uacm.is.slt.as.sistpolizas.model;

/**
 *
 * @author morfeo
 */

public class polizas {


private String clave;	// Clave única de la póliza
private String tipo;	// Tipo de seguro: auto, vida o médico private double monto;		// Monto asegurado
private String descripcion; // Descripción del seguro
private Cliente cliente;	// Cliente asegurado (relación con otra clase)


// Constructor
public polizas(String clave, String tipo, double monto, String descripcion, Cliente cliente) { this.clave = clave;
this.tipo = tipo;
this.monto = monto;
this.descripcion = descripcion; this.cliente = cliente;
}


// Getters y Setters
public String getClave() { return clave;
}


public void setClave(String clave) { this.clave = clave;
}


public String getTipo() {

return tipo;
}


public void setTipo(String tipo) {
// Validar tipos permitidos
if (tipo.equalsIgnoreCase("auto") || tipo.equalsIgnoreCase("vida") || tipo.equalsIgnoreCase("médico")) { this.tipo = tipo;
} else {
throw new IllegalArgumentException("Tipo de seguro no válido. Debe ser auto, vida o médico.");
}
}


public double getMonto() { return monto;
}


public void setMonto(double monto) { this.monto = monto;
}


public String getDescripcion() { return descripcion;
}


public void setDescripcion(String descripcion) { this.descripcion = descripcion;

}


public Cliente getCliente() { return cliente;
}


public void setCliente(Cliente cliente) { this.cliente = cliente;
}
}
