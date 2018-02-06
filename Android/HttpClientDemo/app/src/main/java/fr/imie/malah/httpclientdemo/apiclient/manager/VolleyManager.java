package fr.imie.malah.httpclientdemo.apiclient.manager;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;

import java.util.Map;

import fr.imie.malah.httpclientdemo.apiclient.manager.base.ClientManager;
import fr.imie.malah.httpclientdemo.apiclient.manager.base.ClientManagerListener;
import fr.imie.malah.httpclientdemo.apiclient.manager.model.ClientManagerResult;

/**
 * Created by malah on 12/12/17.
 */

public class VolleyManager extends ClientManager {

    private RequestQueue requestQueue;

    public VolleyManager(Context context) {
        requestQueue = Volley.newRequestQueue(context);
    }

    @Override
    public void readRequest(ClientManagerListener listener, String url) {
        VolleyAsync volleyAsync = new VolleyAsync(listener);
        StringRequest stringRequest = new StringRequest(url, volleyAsync, volleyAsync);
        requestQueue.add(stringRequest);
    }

    @Override
    public void createRequest(ClientManagerListener listener, String url, Map<String, String> data) {
        throw new RuntimeException("not finished ...");
    }

    @Override
    public void updateRequest(ClientManagerListener listener, String url, Map<String, String> data) {
        throw new RuntimeException("not finished ...");
    }

    @Override
    public void deleteRequest(ClientManagerListener listener, String url) {
        throw new RuntimeException("not finished ...");
    }

    private class VolleyAsync implements Response.Listener<String>, Response.ErrorListener {

        private ClientManagerListener listener;

        public VolleyAsync(ClientManagerListener listener) {
            this.listener = listener;
        }

        @Override
        public void onErrorResponse(VolleyError error) {
            throw new RuntimeException(error);
        }

        @Override
        public void onResponse(String response) {
            try {
                listener.fireResponse(new ClientManagerResult(response));
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
