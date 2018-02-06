package fr.imie.malah.httpclientdemo.apiclient.manager.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by malah on 12/12/17.
 */

public class ClientManagerResult {

    private Object result;
    private Class<?> clazz;

    public ClientManagerResult(String result) throws JSONException {
        this.result = result.startsWith("[") ? new JSONArray(result) : new JSONObject(result);
        this.clazz = this.result.getClass();
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }
}
