package fr.imie.malah.httpclientdemo.testclient.Volley;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import fr.imie.malah.httpclientdemo.utils.Constants;
import fr.imie.malah.httpclientdemo.testclient.fragments.DefaultPostListFragment;
import fr.imie.malah.httpclientdemo.utils.JsonUtils;

public class VolleyPostListFragment extends DefaultPostListFragment implements Response.Listener<String>, Response.ErrorListener {

    private RequestQueue requestQueue;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest = new StringRequest(Constants.POSTS, this, this);
        requestQueue.add(stringRequest);
    }

    @Override
    public void onResponse(String response) {
        fireInitData(JsonUtils.fromJson(response));
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        throw new RuntimeException(error);
    }
}
