package fr.imie.malah.httpclientdemo.apiclient.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import fr.imie.malah.httpclientdemo.R;
import fr.imie.malah.httpclientdemo.apiclient.ApiClientActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class ApiClientFragment extends Fragment {

    private Button btnApiClient;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_api_client, container, false);

        btnApiClient = view.findViewById(R.id.btnApiClient);
        btnApiClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoApiClient();
            }
        });
        return view;
    }

    private void gotoApiClient() {
        Intent intent = new Intent(getActivity(), ApiClientActivity.class);
        getActivity().startActivity(intent);
    }

}
