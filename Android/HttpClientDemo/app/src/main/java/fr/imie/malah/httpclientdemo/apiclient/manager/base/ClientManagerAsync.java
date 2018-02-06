package fr.imie.malah.httpclientdemo.apiclient.manager.base;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

import fr.imie.malah.httpclientdemo.apiclient.manager.model.ClientManagerResult;
import fr.imie.malah.httpclientdemo.apiclient.model.TypeMethod;

/**
 * Created by malah on 12/12/17.
 */

public abstract class ClientManagerAsync extends ClientManager {

    protected abstract String get(String url);
    protected abstract String post(String url, JSONObject jsonObject);
    protected abstract String put(String url, JSONObject jsonObject);
    protected abstract String delete(String url);

    @Override
    public void readRequest(ClientManagerListener listener, String url) {
        new ClientAsyncTask(listener, TypeMethod.READ).execute(url);
    }

    @Override
    public void createRequest(ClientManagerListener listener, String url, Map<String, String> data) {
        new ClientAsyncTask(listener, TypeMethod.CREATE, convert(data)).execute(url);
    }

    @Override
    public void updateRequest(ClientManagerListener listener, String url, Map<String, String> data) {
        new ClientAsyncTask(listener, TypeMethod.UPDATE, convert(data)).execute(url);
    }

    @Override
    public void deleteRequest(ClientManagerListener listener, String url) {
        new ClientAsyncTask(listener, TypeMethod.DELETE).execute(url);
    }

    public class ClientAsyncTask extends AsyncTask<String, Void, String> {

        private JSONObject jsonObject;
        private ClientManagerListener listener;
        private TypeMethod typeMethod;

        public ClientAsyncTask(ClientManagerListener listener, TypeMethod typeMethod) {
            this.listener = listener;
            this.typeMethod = typeMethod;
        }

        public ClientAsyncTask(ClientManagerListener listener, TypeMethod typeMethod, JSONObject jsonObject) {
            this.listener = listener;
            this.typeMethod = typeMethod;
            this.jsonObject = jsonObject;
        }

        @Override
        protected String doInBackground(String... urls) {
            switch (typeMethod) {
                case READ:
                    return ClientManagerAsync.this.get(urls[0]);
                case CREATE:
                    return ClientManagerAsync.this.post(urls[0], jsonObject);
                case UPDATE:
                    return ClientManagerAsync.this.put(urls[0], jsonObject);
                case DELETE:
                    return ClientManagerAsync.this.delete(urls[0]);
                default:
                    throw new RuntimeException("wrong method");
            }
        }

        @Override
        protected void onPostExecute(String result) {
            try {
                ClientManagerResult clientManagerResult;
                if (result.startsWith("[")) {
                    clientManagerResult = new ClientManagerResult(result);
                } else {
                    clientManagerResult = new ClientManagerResult(result);
                }
                listener.fireResponse(clientManagerResult);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
