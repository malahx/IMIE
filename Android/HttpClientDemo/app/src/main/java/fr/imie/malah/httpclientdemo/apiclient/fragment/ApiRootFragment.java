package fr.imie.malah.httpclientdemo.apiclient.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import fr.imie.malah.httpclientdemo.R;
import fr.imie.malah.httpclientdemo.utils.Constants;

/**
 * A simple {@link Fragment} subclass.
 */
public class ApiRootFragment extends Fragment {

    public static final int TXT_API = R.id.txtApi;

    private EditText txtApi;

    public String getApiRoot() {
        return txtApi.getText().toString();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_api_root, container, false);
        txtApi = view.findViewById(TXT_API);
        txtApi.setText(Constants.LOCAL_POSTS);
        return view;
    }
}
