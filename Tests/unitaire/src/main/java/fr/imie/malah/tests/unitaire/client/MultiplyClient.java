package fr.imie.malah.tests.unitaire.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.imie.malah.tests.unitaire.api.model.Result;
import fr.imie.malah.tests.unitaire.domain.Multiply;
import lombok.AllArgsConstructor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

import static fr.imie.malah.tests.unitaire.api.Api.*;

@AllArgsConstructor
public class MultiplyClient implements Multiply {

    public static final String URL = "http://127.0.0.1:8080";

    private OkHttpClient okHttpClient;

    private ObjectMapper objectMapper;

    @Override
    public int multiply(int number, int factor) {

        String url = URL + MULTIPLY.replace("{" + NUMBER + "}", String.valueOf(number)).replace("{" + FACTOR + "}", String.valueOf(factor));
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        try {
            Response response = okHttpClient.newCall(request).execute();
            String json = response.body().string();
            Result result = objectMapper.readValue(json, Result.class);
            return result.getValue();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
