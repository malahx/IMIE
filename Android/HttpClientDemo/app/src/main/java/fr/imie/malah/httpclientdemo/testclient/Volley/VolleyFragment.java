package fr.imie.malah.httpclientdemo.testclient.Volley;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import fr.imie.malah.httpclientdemo.R;

public class VolleyFragment extends Fragment {

    private Button btnVolley;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_volley, container, false);
        btnVolley = view.findViewById(R.id.btnVolley);
        btnVolley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoVolley();
            }
        });
        return view;
    }

    private void gotoVolley() {
        Intent intent = new Intent(getActivity(), VolleyActivity.class);
        getActivity().startActivity(intent);
    }

}
