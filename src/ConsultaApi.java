import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi {

    public ConsultaApi() {
        // Constructor vacío
    }

    public Divisa consultaDivisa(String divisaA, String divisaB) {

        String direccion = "https://v6.exchangerate-api.com/v6/c549c77196bf74533e1aeeab/latest/" + divisaA;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        Gson gson = new Gson();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JsonObject jsonResponse = gson.fromJson(response.body(), JsonObject.class);
            JsonObject conversion = jsonResponse.getAsJsonObject("conversion_rates");

            if (conversion != null && conversion.has(divisaB)) {
                double tasaConversion = conversion.get(divisaB).getAsDouble();
                return new Divisa(divisaA, divisaB, tasaConversion);
            } else {
                throw new IllegalArgumentException("No se encontró la tasa de conversión para " + divisaB);
            }

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error al conectar con la API: " + e.getMessage(), e);
        }
    }
}
