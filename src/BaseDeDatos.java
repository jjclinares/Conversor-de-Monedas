//Procesa la respuesta de la API para mostrar el resultado.
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class BaseDeDatos {
    private static final String FILE_PATH = "conversion_result.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // Guardar la conversión en un archivo JSON
    public static void guardarConversionEnJSON(String currency1, String currency2, double exchangeRate, double convertedAmount, double amountToChange) {
        try {
            // Leer conversiones existentes en el archivo JSON
            List<Map<String, Object>> conversiones = cargarConversiones();

            // Crear un mapa con los datos de la conversión actual
            Map<String, Object> conversionData = new HashMap<>();
            conversionData.put("valor_a_convertir", amountToChange);
            conversionData.put("moneda_de_origen", currency1);
            conversionData.put("moneda_destino", currency2);
            conversionData.put("tasa_cambio", exchangeRate);
            conversionData.put("monto_convertido", convertedAmount);

            // Agregar la nueva conversión a la lista de conversiones
            conversiones.add(conversionData);

            // Guardar todas las conversiones en el archivo JSON
            try (FileWriter writer = new FileWriter(FILE_PATH)) {
                gson.toJson(conversiones, writer);
                System.out.println("Resultado de la conversión guardado en " + FILE_PATH);
            } catch (IOException e) {
                System.out.println("Error al guardar el archivo JSON: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error al procesar y guardar la conversión: " + e.getMessage());
        }
    }

    private static List<Map<String, Object>> cargarConversiones() {
        List<Map<String, Object>> conversiones = new ArrayList<>();

        // Leer el archivo JSON si existe y cargar las conversiones previas
        try (FileReader reader = new FileReader(FILE_PATH)) {
            // Cambiar la lectura del archivo a un arreglo
            Map<String, Object>[] data = gson.fromJson(reader, Map[].class);
            if (data != null) {
                conversiones.addAll(Arrays.asList(data));
            }
        } catch (IOException e) {
            System.out.println("No se encontraron conversiones previas o error de lectura.");
            // Aquí podrías inicializar el archivo con un arreglo vacío si no existe
            try (FileWriter writer = new FileWriter(FILE_PATH)) {
                writer.write("[]"); // Inicializa el archivo con un arreglo vacío
            } catch (IOException ex) {
                System.out.println("Error al inicializar el archivo JSON: " + ex.getMessage());
            }
        }

        return conversiones;
    }
}

