package fr.imie.malah.httpclientdemo.apiclient.manager;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import fr.imie.malah.httpclientdemo.apiclient.manager.base.ClientManagerListener;
import fr.imie.malah.httpclientdemo.apiclient.manager.model.ClientManagerResult;
import fr.imie.malah.httpclientdemo.utils.FileUtils;

/**
 * Created by malah on 12/12/17.
 */

public class DataArchitectureBackup implements ClientManagerListener {

    public static final String FILENAME = "architecture.json";

    private Context context;

    public DataArchitectureBackup(Context context) {
        this.context = context;
    }

    @Override
    public void fireResponse(ClientManagerResult result) {
        FileUtils.save(context, FILENAME, getJsonObject(result));
    }

    private JSONObject getJsonObject(ClientManagerResult result) {
        JSONObject json;
        if (result.getClazz().equals(JSONArray.class)) {
            JSONArray jsonArray = (JSONArray) result.getResult();
            try {
                json = jsonArray.getJSONObject(0);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        } else if (result.getClazz().equals(JSONObject.class)) {
            json = (JSONObject) result.getResult();
        } else {
            throw new RuntimeException("wrong data type");
        }
        return json;
    }
}
