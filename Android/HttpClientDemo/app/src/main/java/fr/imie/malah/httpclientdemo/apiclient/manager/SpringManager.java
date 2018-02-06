package fr.imie.malah.httpclientdemo.apiclient.manager;

import org.json.JSONObject;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import fr.imie.malah.httpclientdemo.apiclient.manager.base.ClientManagerAsync;

/**
 * Created by malah on 12/12/17.
 */

public class SpringManager extends ClientManagerAsync {

    @Override
    protected String get(String url) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        return restTemplate.getForObject(url, String.class);
    }

    @Override
    protected String post(String url, JSONObject jsonObject) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        return restTemplate.postForObject(url, jsonObject.toString(), String.class);
    }

    @Override
    protected String put(String url, JSONObject jsonObject) {
        return null;
    }

    @Override
    protected String delete(String url) {
        return null;
    }
}
