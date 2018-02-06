package fr.imie.malah.httpclientdemo.apiclient.manager.base;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

import fr.imie.malah.httpclientdemo.apiclient.manager.HttpClientManager;
import fr.imie.malah.httpclientdemo.apiclient.manager.SpringManager;
import fr.imie.malah.httpclientdemo.apiclient.manager.VolleyManager;
import fr.imie.malah.httpclientdemo.apiclient.model.ClientType;

/**
 * Created by malah on 12/12/17.
 */

public abstract class ClientManager {

    public static ClientManager getManager(ClientType client, Context context) {
        switch (client) {
            case HTTP_CLIENT:
                return new HttpClientManager();
            case VOLLEY:
                return new VolleyManager(context);
            case SPRING:
                return new SpringManager();
            default:
                throw new RuntimeException("wrong client type");
        }
    }

    public abstract void readRequest(ClientManagerListener listener, String url);

    public abstract void createRequest(ClientManagerListener listener, String url, Map<String, String> data);

    public abstract void updateRequest(ClientManagerListener listener, String url, Map<String, String> data);

    public abstract void deleteRequest(ClientManagerListener listener, String url);

    protected JSONObject convert(Map<String, String> data) {
        JSONObject jsonObject = new JSONObject();
        data.forEach((k,v) -> {
            try {
                jsonObject.put(k,v);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        });
        return jsonObject;
    }

}
