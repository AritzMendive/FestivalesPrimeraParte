

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;

/**
 * La clase contiene m�odos est�ticos que permiten
 * cargar la agenda de festivales leyendo los datos desde
 * un fichero
 */
public class FestivalesIO {

    
    public static void cargarFestivales(AgendaFestivales agenda) {
        Scanner sc = null;
        try {
            sc = new Scanner(FestivalesIO.class.
                    getResourceAsStream("/festivales.csv"));
            while (sc.hasNextLine()) {
                String lineaFestival = sc.nextLine();
                Festival festival = parsearLinea(lineaFestival);
                agenda.addFestival(festival);
                
            }
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
        
    }

    /**
     * se parsea la l�nea extrayendo sus datos y creando y
     * devolviendo un objeto Festival
     * @param lineaFestival los datos de un festival
     * @return el festival creado
     */
    public static Festival parsearLinea(String lineaFestival) {
       String[] dividir = lineaFestival.trim().split(":");
       String nombre = nombreMayusc(dividir[0].trim());
       String lugar = dividir[1].trim().toUpperCase();
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
       LocalDate fechainicio = LocalDate.parse(dividir[2].trim(), formatter);
       int duracion = Integer.parseInt(dividir[3].trim());
        
        return null;
    }

    private static String nombreMayusc(String linea){
        StringBuilder sb = new StringBuilder();
        String[] palabras = linea.split("\\s+");
        for(String palabra : palabras){
            sb.append(Character.toUpperCase(palabra.charAt(0))).append(palabra.substring(1).toLowerCase()).append(" ");
        }
        return sb.toString().trim();
    }
   
    
    
}
