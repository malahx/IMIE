package fr.imie.malah.httpclientdemo.apiclient.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import fr.imie.malah.httpclientdemo.R;
import fr.imie.malah.httpclientdemo.apiclient.adapter.JsonArrayAdapter;
import fr.imie.malah.httpclientdemo.apiclient.adapter.JsonObjectAdapter;
import fr.imie.malah.httpclientdemo.apiclient.manager.base.ClientManagerListener;
import fr.imie.malah.httpclientdemo.apiclient.manager.model.ClientManagerResult;

/**
 * A simple {@link Fragment} subclass.
 */
public class GetFragment extends Fragment implements ClientManagerListener {

    public static final int FRAGMENT_LAYOUT = R.layout.fragment_api_client_get;
    public static final int LST_JSON_DATA = R.id.lstJsonData;

    private ListView lstJsonData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(FRAGMENT_LAYOUT, container, false);
        lstJsonData = view.findViewById(LST_JSON_DATA);
        return view;
    }

    @Override
    public void fireResponse(ClientManagerResult result) {
        if (result.getClazz().equals(JSONArray.class)) {
            JsonArrayAdapter jsonArrayAdapter = getNewJsonArrayAdapter(result);
            lstJsonData.setAdapter(jsonArrayAdapter);
            jsonArrayAdapter.notifyDataSetChanged();
        } else if (result.getClazz().equals(JSONObject.class)) {
            JsonObjectAdapter jsonObjectAdapter = getNewKeyValueAdapter(result);
            lstJsonData.setAdapter(jsonObjectAdapter);
            jsonObjectAdapter.notifyDataSetChanged();
        }
    }

    private JsonObjectAdapter getNewKeyValueAdapter(ClientManagerResult result) {
        List<String> keyList = new ArrayList<>();
        JSONObject jsonObject = (JSONObject) result.getResult();
        jsonObject.keys().forEachRemaining(keyList::add);
        return new JsonObjectAdapter(getContext(), keyList, jsonObject);
    }

    @NonNull
    private JsonArrayAdapter getNewJsonArrayAdapter(ClientManagerResult result) {
        List<JSONObject> jsonObjects = new ArrayList<>();
        JSONArray jsonArray = (JSONArray) result.getResult();
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                jsonObjects.add(jsonArray.getJSONObject(i));
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        return new JsonArrayAdapter(getActivity(), jsonObjects);
    }
}
