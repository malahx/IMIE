package fr.imie.malah.tests.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.imie.malah.tests.api.model.Result;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

import static fr.imie.malah.tests.TestData.createResponse;
import static fr.imie.malah.tests.api.Api.*;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MultiplyClientTest {

    private MultiplyClient multiplyClient;

    @Mock
    private OkHttpClient mockOkHttpClient;

    @Mock
    private Call mockCall;

    @Mock
    private ObjectMapper mockObjectMapper;

    @Before
    public void setUp() {
        multiplyClient = new MultiplyClient(mockOkHttpClient, mockObjectMapper);
    }

    @Test
    public void shouldRetrieveMultiply() throws IOException {

        Request request = new Request.Builder()
                .url(MultiplyClient.URL + MULTIPLY.replace("{" + NUMBER + "}", "1").replace("{" + FACTOR + "}", "2"))
                .get()
                .build();
        Response response = createResponse("{value: 2}", request);

        when(mockOkHttpClient.newCall(any())).thenReturn(mockCall);
        when(mockCall.execute()).thenReturn(response);
        when(mockObjectMapper.readValue(anyString(), any(Class.class))).thenReturn(Result.builder().value(2).build());

        int multiply = multiplyClient.multiply(1, 2);

        verify(mockOkHttpClient).newCall(any());
        verify(mockCall).execute();
        verify(mockObjectMapper).readValue(response.body().string(), Result.class);

        assertThat(multiply).isEqualTo(2);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowRunTimeExceptionWhenRetrieveMultiplyWithAnError() throws IOException {

        when(mockOkHttpClient.newCall(any())).thenReturn(mockCall);
        when(mockCall.execute()).thenThrow(new IOException());

        multiplyClient.multiply(1, 2);
    }

}