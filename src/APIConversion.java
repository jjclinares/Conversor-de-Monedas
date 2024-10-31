//Realiza la solicitud a la API para obtener la tasa de cambio.
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class APIConversion {

    public static void apiConversion(String currency1, String currency2, float amountToChange) throws IOException, InterruptedException {
        String apiKey = "c6f1c496455ea49040829f32";
        HttpClient client = HttpClient.newHttpClient();

        // Solicitud API
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + currency1 + "/" + currency2 +"/"+ amountToChange))
                .build();

        // Enviamos la solicitud
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Procesamos la respuesta JSON
        Gson gson = new Gson();
        Map<String, Object> responseMap = gson.fromJson(response.body(), Map.class);

        // Extraer la tasa de cambio
        double exchangeRate = (double) responseMap.get("conversion_rate");

        // Calcular el monto convertido
        double convertedAmount = exchangeRate * amountToChange;

        // Imprimir el resultado

        System.out.println("El valor ingresado"+" "+ amountToChange +" "+currency1);
        System.out.println("a una tasa de cambio de:" +" "+ exchangeRate);
        System.out.println("Representan al Momento de la consulta:"+" " +convertedAmount +" "+ currency2);
        System.out.println( "En el mercado de valores Global");


        // Guardar el resultado en un archivo JSON
        BaseDeDatos.guardarConversionEnJSON(
                currency1,
                currency2,
                exchangeRate,
                convertedAmount,
                amountToChange);
    }
}

