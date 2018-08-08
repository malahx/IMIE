package fr.imie.malah.tests.unitaire.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.imie.malah.tests.unitaire.api.model.MultiplyResult;
import fr.imie.malah.tests.unitaire.domain.Calc;
import lombok.AllArgsConstructor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

import static fr.imie.malah.tests.unitaire.api.Api.*;

@AllArgsConstructor
public class CalcClient implements Calc {

    public static final String URL = "http://localhost:8080";

    private OkHttpClient okHttpClient;

    private ObjectMapper objectMapper;

    @Override
    public int multiply(int number, int factor) {

        Request request = new Request.Builder()
                .url(URL + MULTIPLY.replace("{" + NUMBER + "}", "1").replace("{" + FACTOR + "}", "2"))
                .get()
                .build();

        try {
            Response response = okHttpClient.newCall(request).execute();
            MultiplyResult multiplyResult = objectMapper.readValue(response.body().string(), MultiplyResult.class);
            return multiplyResult.getValue();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
