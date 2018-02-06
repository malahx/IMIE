package fr.imie.malah.httpclientdemo.apiclient;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import fr.imie.malah.httpclientdemo.R;
import fr.imie.malah.httpclientdemo.apiclient.fragment.ApiMethodFragment;
import fr.imie.malah.httpclientdemo.apiclient.fragment.ApiRootFragment;
import fr.imie.malah.httpclientdemo.apiclient.fragment.ClientSelectorFragment;
import fr.imie.malah.httpclientdemo.utils.Constants;

import static fr.imie.malah.httpclientdemo.apiclient.fragment.ApiMethodFragment.Listener;

import fr.imie.malah.httpclientdemo.apiclient.model.TypeMethod;

public class ApiClientActivity extends AppCompatActivity implements Listener {

    public static final int FRG_SELECTOR = R.id.frgSelector;
    public static final int FRG_API_METHOD = R.id.frgApiMethod;
    public static final int FRG_API_ROOT = R.id.frgApiRoot;
    private ClientSelectorFragment frgSelector;
    private ApiMethodFragment frgMethod;
    private ApiRootFragment frgRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_client);

        frgSelector = (ClientSelectorFragment) getFragmentManager().findFragmentById(FRG_SELECTOR);
        frgRoot = (ApiRootFragment) getFragmentManager().findFragmentById(FRG_API_ROOT);
        frgMethod = (ApiMethodFragment) getFragmentManager().findFragmentById(FRG_API_METHOD);
        frgMethod.setListener(this);
    }

    @Override
    public void fireMethod(TypeMethod type) {
        Intent intent = new Intent(this, ApiClientGetActivity.class);
        intent.putExtra(Constants.SELECT, frgSelector.getType());
        intent.putExtra(Constants.API_ROOT, frgRoot.getApiRoot());
        intent.putExtra(Constants.API_METHOD, type);
        startActivity(intent);
    }
}
