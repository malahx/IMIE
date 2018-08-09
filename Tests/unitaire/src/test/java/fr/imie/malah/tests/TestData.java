package fr.imie.malah.tests;

import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.http.RealResponseBody;
import okio.Buffer;

public class TestData {

    public static Response createResponse(String message, Request request) {
        return new Response.Builder()
                .body(new RealResponseBody("application/json", 10, new Buffer()))
                .request(request)
                .protocol(Protocol.HTTP_1_1)
                .code(200)
                .message(message)
                .build();
    }
}
