package mx.edu.uacm.is.slt.as.sistpolizas.Simuladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import mx.edu.uacm.is.slt.as.sistpolizas.model.*;

public class BaseDeDatosSimulada {

    // Lista que simula la tabla "clientes"
    public static List<Cliente> clientes = new ArrayList<>(Arrays.asList(
            new Cliente(
                    "Ana Maria", "Lopez", "Hernandez",
                    "Av. Siempre Viva 742", "LOHA880101MXN", "1988-01-01"
            ),
            new Cliente(
                    "Ana", "Ramires", "Hernandez",
                    "Av. De Arbol 354", "RAHA810809MXN", "1981-08-09"
            )
    ));

    // Lista que simula la tabla "polizas"
    public static List<Poliza> polizas = new ArrayList<>(Arrays.asList(
            new Poliza("POL001", "vida", 75000.0,
                    "Seguro de vida estándar",
                    clientes.get(0).getCurp()
            ),
            new Poliza("POL002", "vida", 75545.0,
                    "Seguro de vida estándar",
                    clientes.get(1).getCurp()
            ),
            new Poliza("POL003", "auto", 75000.0,
                    "Seguro de vida estándar",
                    clientes.get(1).getCurp()
            )
    ));

    // Lista que simula la tabla "beneficiarios"
    public static List<Beneficiario> beneficiarios = new ArrayList<>(Arrays.asList(
            new Beneficiario(
                    "Carlos", "Lopez", "Martinez",
                    "2000-05-15", polizas.get(0).getClave(), 60.0
            ),
            new Beneficiario(
                    "Lucia", "Lopez", "Martinez",
                    "2002-06-13", polizas.get(0).getClave(), 40.0
            ),
            new Beneficiario(
                    "Joan", "Ramos", "Martinez",
                    "2002-03-25", polizas.get(1).getClave(), 100.0
            ),
            new Beneficiario(
                    "Luis", "Castillo", "Martinez",
                    "2003-09-22", polizas.get(1).getClave(), 100.0
            )
    ));



public static void agregarBeneficiario(String fechaNacimiento, String clavePoliza, double porcentaje,
                                       String nombres, String primerApellido) {
    Poliza poliza = getPolizasByClave(clavePoliza);
    if (poliza == null) {
        throw new RuntimeException("Póliza no encontrada con clave: " + clavePoliza);
    }
    Beneficiario nuevoBeneficiario = new Beneficiario(nombres, primerApellido, "", fechaNacimiento, clavePoliza, porcentaje);
    beneficiarios.add(nuevoBeneficiario);
}

public static Beneficiario agregarBeneficiario(Beneficiario beneficiario) {
    Poliza poliza = getPolizasByClave(beneficiario.getPoliza());
    if (poliza == null) {
        throw new RuntimeException("Póliza no encontrada con clave: " + beneficiario.getPoliza());
    }
    beneficiarios.add(beneficiario);
    return beneficiario;
}

public static Beneficiario getBeneficiario(String nombres, String primerApellido, String segundoApellido, String fechaNacimiento, String polizaClave) {
    for (Beneficiario b : beneficiarios) {
        if (b.getNombres().equalsIgnoreCase(nombres)
                && b.getPrimerApellido().equalsIgnoreCase(primerApellido)
                && (b.getSegundoApellido().equalsIgnoreCase(segundoApellido)
                || segundoApellido == null)
                && b.getFechaNacimiento().equals(fechaNacimiento)
                && b.getPoliza().equalsIgnoreCase(polizaClave)) {
            return b;
        }
    }
    return null;
}


public static List<Beneficiario> getBeneficiarios() {
    return beneficiarios;
}

public static Cliente agregarCliente(Cliente cliente){
    clientes.add(cliente);
    return cliente;
}

public static Cliente editarCliente(Cliente cliente, String curp){
    int id = 0;
    for(Cliente c : clientes){
        id++;
        if(c.getCurp().equalsIgnoreCase(curp)){
            clientes.remove(c);
            break;
        }
    }
    clientes.add(cliente);
    return getClienteByCurp(cliente.getCurp());
}

public  static List<Cliente> getClientes(){
    return clientes;
}


public  static Cliente getClienteByCurp(String curp){
    Cliente c = new Cliente("","","","","","");
    for(Cliente cliente : clientes){
        if (cliente.getCurp().equalsIgnoreCase(curp)) {
            c = cliente;
        }
    }
    return c;
}

public static Poliza agregarPoliza(Poliza poliza) {
    Cliente cliente = getClienteByCurp(poliza.getCurpCliente());
    if (cliente == null) {
        throw new RuntimeException("Cliente no encontrado con CURP: " + poliza.getCurpCliente());
    }
    polizas.add(poliza);
    return poliza;
}

public static Poliza editarPoliza(Poliza poliza, String clave){
   Poliza p = getPolizasByClave(clave);
   p = poliza;
   return getPolizasByClave(clave);
    
}

public static void eliminarPolizaByClave(String clave) {
    int id = 0;
    for (Poliza poliza : polizas) {
        if (poliza.getClave().equalsIgnoreCase(clave)) {
            polizas.remove(id);
            break;
        } else {
            id = id + 1;
        }
    }
}

public static List<Poliza> getPolizas() {
    return polizas;
}

public static Poliza getPolizasByClave(String clave) {
    Poliza pl = new Poliza("", "", 0, "", null);
    for (Poliza poliza : polizas) {
        if (poliza.getClave().equalsIgnoreCase(clave)) {
            pl = poliza;
        }
    }
    return pl;
}

public static List<Poliza> getPolizasByCurp(String curp) {
    List<Poliza> resultado = new ArrayList<>();
    for (Poliza poliza : polizas) {
        if (poliza.getCurpCliente().equalsIgnoreCase(curp)) {
            resultado.add(poliza);
        }
    }
    return resultado;
}

public static List<Poliza> getPolizasByFechaNacimientoBeneficiario(String fechaNacimiento) {
    List<Poliza> resultado = new ArrayList<>();
    for (Beneficiario b : beneficiarios) {
        if (b.getFechaNacimiento().equals(fechaNacimiento)) {
            for (Poliza p : polizas) {
                if (p.getClave().equalsIgnoreCase(b.getPoliza())) {
                    resultado.add(p);
                }
            }
        }
    }
    return resultado;
}

public static List<Poliza> getPolizasByNombre(String nombres, String primerApellido, String segundoApellido) {
    List<Poliza> resultado = new ArrayList<>(Arrays.asList());
    for (Poliza poliza : polizas) {
        Cliente cliente = getClienteByCurp(poliza.getCurpCliente());
        if (cliente.getNombres().equalsIgnoreCase(nombres)
                && cliente.getPrimerApellido().equalsIgnoreCase(primerApellido)
                && (cliente.getSegundoApellido().equalsIgnoreCase(segundoApellido)
                || segundoApellido == null)) {
            resultado.add(poliza);
        }
    }
    return resultado;
}

public static List<Poliza> getPolizasByTipo(String tipo) {
    List<Poliza> resultado = new ArrayList<>(Arrays.asList());
    for (Poliza poliza : polizas) {
        if (poliza.getTipo().equalsIgnoreCase(tipo)) {
            resultado.add(poliza);
        }
    }
    return resultado;
}

public static List<Poliza> getPolizasByBeneficiario(String nombres, String primerApellido) {
    List<Poliza> resultado = new ArrayList<>();
    for (Beneficiario b : beneficiarios) {
        if (b.getNombres().equalsIgnoreCase(nombres)
                && b.getPrimerApellido().equalsIgnoreCase(primerApellido)) {
            for (Poliza p : polizas) {
                if (p.getClave().equalsIgnoreCase(b.getPoliza())) {
                    resultado.add(p);
                }
            }
        }
    }
    return resultado;
}

public static List<Poliza> getPolizasByBeneficiario(String nombres, String primerApellido, String segundoApellido) {
    List<Poliza> resultado = new ArrayList<>();
    for (Beneficiario b : beneficiarios) {
        if (b.getNombres().equalsIgnoreCase(nombres)
                && b.getPrimerApellido().equalsIgnoreCase(primerApellido)
                && (b.getSegundoApellido().equalsIgnoreCase(segundoApellido)
                || segundoApellido == null)) {
            for (Poliza p : polizas) {
                if (p.getClave().equalsIgnoreCase(b.getPoliza())) {
                    resultado.add(p);
                }
            }
        }
    }
    return resultado;
}


}
