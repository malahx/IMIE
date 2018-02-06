package fr.imie.malah.httpclientdemo.apiclient.manager;

import android.support.annotation.NonNull;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import fr.imie.malah.httpclientdemo.apiclient.manager.base.ClientManagerAsync;

/**
 * Created by malah on 12/12/17.
 */
public class HttpClientManager extends ClientManagerAsync {

    @Override
    protected String get(String url) {
        return execute(new HttpGet(url));
    }

    @Override
    protected String post(String url, JSONObject jsonObject) {
        HttpPost requestBase = new HttpPost(url);
        requestBase.setHeader("Content-type", "application/json");
        try {
            requestBase.setEntity(new StringEntity(jsonObject.toString(), "UTF8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return execute(requestBase);
    }

    @Override
    protected String put(String url, JSONObject jsonObject) {
        HttpPut requestBase = new HttpPut(url);
        requestBase.setHeader("Content-type", "application/json");
        try {
            requestBase.setEntity(new StringEntity(jsonObject.toString(), "UTF8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return execute(requestBase);
    }

    @Override
    protected String delete(String url) {
        return execute(new HttpDelete(url));
    }

    @NonNull
    private String execute(HttpRequestBase requestBase) {
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse httpResponse = httpclient.execute(requestBase);
            InputStream inputStream = httpResponse.getEntity().getContent();
            if (inputStream != null) {
                return convertInputStreamToString(inputStream);
            } else {
                throw new RuntimeException("Did not work!");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String convertInputStreamToString(InputStream inputStream) throws IOException {
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
