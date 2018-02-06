package fr.imie.malah.httpclientdemo.testclient.HttpClient;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import fr.imie.malah.httpclientdemo.R;

public class HttpClientFragment extends Fragment {

    private Button btnHttpClient;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_httpclient, container, false);
        btnHttpClient = view.findViewById(R.id.btnHttpClient);
        btnHttpClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoHttpClient();
            }
        });
        return view;
    }

    private void gotoHttpClient() {
        Intent intent = new Intent(getActivity(), HttpClientActivity.class);
        getActivity().startActivity(intent);
    }

}
