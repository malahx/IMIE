package fr.imie.malah.httpclientdemo.testclient.Spring;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import fr.imie.malah.httpclientdemo.R;

public class SpringFragment extends Fragment {

    private Button btnSpring;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_spring, container, false);
        btnSpring = view.findViewById(R.id.btnSpring);
        btnSpring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoSpring();
            }
        });
        return view;
    }

    private void gotoSpring() {
        Intent intent = new Intent(getActivity(), SpringActivity.class);
        getActivity().startActivity(intent);
    }
}
