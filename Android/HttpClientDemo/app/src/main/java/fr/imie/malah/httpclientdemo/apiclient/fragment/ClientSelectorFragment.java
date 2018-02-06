package fr.imie.malah.httpclientdemo.apiclient.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import fr.imie.malah.httpclientdemo.R;
import fr.imie.malah.httpclientdemo.apiclient.model.ClientType;

public class ClientSelectorFragment extends Fragment {

    private RadioButton rbtnHttpClient;
    private RadioButton rbtnVolley;
    private RadioButton rbtnSpring;

    public ClientType getType() {
        return rbtnSpring.isChecked() ?
                ClientType.SPRING :
                rbtnVolley.isChecked() ?
                        ClientType.VOLLEY :
                        ClientType.HTTP_CLIENT;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_api_client_selector, container, false);
        rbtnHttpClient = view.findViewById(R.id.rbtnHttpClient);
        rbtnVolley = view.findViewById(R.id.rbtnVolley);
        rbtnSpring = view.findViewById(R.id.rbtnSpring);
        return view;
    }

}
