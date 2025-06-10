package mx.edu.uacm.is.slt.as.sistpolizas.AuxiliarF;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.UUID;

public class Convertir {

    /**
     * Convierte un String a LocalDate usando el formato ISO (yyyy-MM-dd).
     * @param fechaStr la cadena con la fecha
     * @return LocalDate o null si hay error
     */
    public static LocalDate stringALocalDate(String fechaStr) {
        try {
            return LocalDate.parse(fechaStr, DateTimeFormatter.ISO_LOCAL_DATE);
        } catch (DateTimeParseException e) {
            System.err.println("Formato de fecha inválido: " + fechaStr);
            return null;
        }
    }

    /**
     * Convierte un String a int.
     * @param numeroStr la cadena con el número
     * @return int o 0 si hay error
     */
    public static int stringAInt(String numeroStr) {
        try {
            return Integer.parseInt(numeroStr);
        } catch (NumberFormatException e) {
            System.err.println("Número entero inválido: " + numeroStr);
            return 0;
        }
    }

    /**
     * Convierte un String a float.
     * @param numeroStr la cadena con el número
     * @return float o 0.0f si hay error
     */
    public static float stringAFloat(String numeroStr) {
        try {
            return Float.parseFloat(numeroStr);
        } catch (NumberFormatException e) {
            System.err.println("Número decimal inválido: " + numeroStr);
            return 0.0f;
        }
    }


}
