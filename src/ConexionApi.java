import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.attribute.UserDefinedFileAttributeView;

public class ConexionApi {

    public static DatosApi datosMonedas(String moneda1, String moneda2){

        String clave = "8c942c064c65c079d038f6a4";
        URI uri = URI.create("https://v6.exchangerate-api.com/v6/"+clave+"/pair/"+moneda1+"/"+moneda2);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            Gson gson = new Gson();
            return new Gson().fromJson(response.body(), DatosApi.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontre esa pelicula");
        }
    }
    //Example Request: https://v6.exchangerate-api.com/v6/8c942c064c65c079d038f6a4/latest/USD
    //https://v6.exchangerate-api.com/v6/clave/pair/EUR/USD
}
