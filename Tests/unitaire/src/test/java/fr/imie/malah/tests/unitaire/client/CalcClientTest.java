package fr.imie.malah.tests.unitaire.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.imie.malah.tests.unitaire.api.model.MultiplyResult;
import okhttp3.*;
import okhttp3.internal.http.RealResponseBody;
import okio.Buffer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

import static fr.imie.malah.tests.unitaire.api.Api.*;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CalcClientTest {

    private CalcClient calcClient;

    @Mock
    private OkHttpClient mockOkHttpClient;

    @Mock
    private Call mockCall;

    @Mock
    private ObjectMapper mockObjectMapper;

    @Before
    public void setUp() {
        calcClient = new CalcClient(mockOkHttpClient, mockObjectMapper);
    }

    @Test
    public void shouldRetrieveMultiply() throws IOException {

        Request request = new Request.Builder()
                .url(CalcClient.URL + MULTIPLY.replace("{" + NUMBER + "}", "1").replace("{" + FACTOR + "}", "2"))
                .get()
                .build();
        Response response = new Response.Builder()
                .body(new RealResponseBody("application/json", 10, new Buffer()))
                .request(request)
                .protocol(Protocol.HTTP_1_1)
                .code(200)
                .message("{value: 2}")
                .build();

        when(mockOkHttpClient.newCall(any())).thenReturn(mockCall);
        when(mockCall.execute()).thenReturn(response);
        when(mockObjectMapper.readValue(anyString(), any(Class.class))).thenReturn(MultiplyResult.builder().value(2).build());

        int multiply = calcClient.multiply(1, 2);

        verify(mockOkHttpClient).newCall(any());
        verify(mockCall).execute();
        verify(mockObjectMapper).readValue(response.body().string(), MultiplyResult.class);

        assertThat(multiply).isEqualTo(2);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowRunTimeExceptionWhenRetrieveMultiplyWithAnError() throws IOException {

        Request request = new Request.Builder()
                .url(CalcClient.URL + MULTIPLY.replace("{" + NUMBER + "}", "1").replace("{" + FACTOR + "}", "2"))
                .get()
                .build();
        Response response = new Response.Builder()
                .body(new RealResponseBody("application/json", 10, new Buffer()))
                .request(request)
                .protocol(Protocol.HTTP_1_1)
                .code(200)
                .message("{value: 2}")
                .build();

        when(mockOkHttpClient.newCall(any())).thenReturn(mockCall);
        when(mockCall.execute()).thenThrow(new IOException());

        calcClient.multiply(1, 2);
    }

}