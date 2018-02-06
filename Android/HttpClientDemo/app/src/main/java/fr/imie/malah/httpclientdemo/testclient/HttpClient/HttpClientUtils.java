package fr.imie.malah.httpclientdemo.testclient.HttpClient;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by malah on 11/12/17.
 */

public class HttpClientUtils {

    public static String get(String url) {
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse httpResponse = httpclient.execute(new HttpGet(url));
            InputStream inputStream = httpResponse.getEntity().getContent();
            if (inputStream != null) {
                return convertInputStreamToString(inputStream);
            } else {
                throw new RuntimeException("Did not work!");
            }
        } catch (Exception e) {
            throw new RuntimeException("InputStream");
        }
    }

    private static String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line);
        }
        inputStream.close();
        return sb.toString();
    }
}
