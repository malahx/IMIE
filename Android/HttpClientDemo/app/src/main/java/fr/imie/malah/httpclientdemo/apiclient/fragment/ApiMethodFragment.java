package fr.imie.malah.httpclientdemo.apiclient.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import fr.imie.malah.httpclientdemo.R;
import fr.imie.malah.httpclientdemo.apiclient.model.TypeMethod;

public class ApiMethodFragment extends Fragment {

    public static final int BTN_CREATE = R.id.btnCreate;
    public static final int BTN_READ = R.id.btnRead;
    public static final int BTN_DELETE = R.id.btnDelete;
    public static final int BTN_UPDATE = R.id.btnUpdate;

    private Button btnCreate;
    private Button btnUpdate;
    private Button btnDelete;
    private Button btnRead;

    private Listener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_api_method, container, false);
        btnCreate = initBtn(view, BTN_CREATE, TypeMethod.CREATE);
        btnUpdate = initBtn(view, BTN_UPDATE, TypeMethod.UPDATE);
        btnDelete = initBtn(view, BTN_DELETE, TypeMethod.DELETE);
        btnRead = initBtn(view, BTN_READ, TypeMethod.READ);
        return view;
    }

    private Button initBtn(View view, int id, final TypeMethod type) {
        Button button = view.findViewById(id);
        button.setOnClickListener(v -> {
            if (listener != null) {
                listener.fireMethod(type);
            }
        });
        return button;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public interface Listener {
        void fireMethod(TypeMethod type);
    }

}
