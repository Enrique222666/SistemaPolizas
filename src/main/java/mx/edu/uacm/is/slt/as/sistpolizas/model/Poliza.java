package mx.edu.uacm.is.slt.as.sistpolizas.model;

import jakarta.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "polizas")
public class Poliza {

    @Id
    private String clave;

    private int tipo;

    private double monto;

    private String descripcion;

    private String curpCliente;

    public Poliza() {
    }

    public Poliza(String clave, int tipo, double monto, String descripcion, String curpCliente) {
        this.clave = clave;
        this.tipo = tipo;
        this.monto = monto;
        this.descripcion = descripcion;
        this.curpCliente = curpCliente;
    }

    public Poliza(boolean existe) {
        this.clave = null;
        this.tipo = 0;
        this.monto = 0;
        this.descripcion = null;
        this.curpCliente = null;
    }

    public boolean compare(Poliza poliza) {
        return Objects.equals(this.clave, poliza.clave)
                && this.tipo == poliza.tipo
                && this.monto == poliza.monto
                && Objects.equals(this.descripcion, poliza.descripcion)
                && Objects.equals(this.curpCliente, poliza.curpCliente);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.clave);
        hash = 23 * hash + this.tipo;
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.monto) ^ (Double.doubleToLongBits(this.monto) >>> 32));
        hash = 23 * hash + Objects.hashCode(this.descripcion);
        hash = 23 * hash + Objects.hashCode(this.curpCliente);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Poliza other = (Poliza) obj;
        if (this.tipo != other.tipo) {
            return false;
        }
        if (Double.doubleToLongBits(this.monto) != Double.doubleToLongBits(other.monto)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.curpCliente, other.curpCliente)) {
            return false;
        }
        return Objects.equals(this.clave, other.clave);
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCurpCliente() {
        return curpCliente;
    }

    public void setCurpCliente(String curpCliente) {
        this.curpCliente = curpCliente;
    }

}
