package fr.imie.malah.httpclientdemo.apiclient;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageButton;

import fr.imie.malah.httpclientdemo.R;
import fr.imie.malah.httpclientdemo.apiclient.fragment.GetFragment;
import fr.imie.malah.httpclientdemo.apiclient.manager.DataArchitectureBackup;
import fr.imie.malah.httpclientdemo.apiclient.manager.base.ClientManager;
import fr.imie.malah.httpclientdemo.apiclient.model.ClientType;
import fr.imie.malah.httpclientdemo.apiclient.model.TypeMethod;
import fr.imie.malah.httpclientdemo.apiclient.service.ReadRefreshService;
import fr.imie.malah.httpclientdemo.apiclient.service.RefreshType;
import fr.imie.malah.httpclientdemo.utils.Constants;

public class ApiClientGetActivity extends AppCompatActivity implements ReadRefreshService.Listener {

    public static final int BTN_VIEW = R.id.btnView;
    public static final int TXT_ID = R.id.txtId;
    public static final int FRG_GET = R.id.frgGet;

    public RefreshType refreshType = RefreshType.FULL;

    private ReadRefreshService readRefreshService;

    private ImageButton btnView;
    private GetFragment getFragment;
    private EditText txtId;

    private String api_root;
    private ClientType clientType;

    private ClientManager clientManager;
    private TypeMethod apiMethod;

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder iBinder) {
            ReadRefreshService.LocalBinder binder = (ReadRefreshService.LocalBinder) iBinder;
            readRefreshService = binder.getService();
            readRefreshService.setListener(ApiClientGetActivity.this);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            readRefreshService.setListener(null);
            readRefreshService = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get);

        txtId = findViewById(TXT_ID);
        btnView = findViewById(BTN_VIEW);
        getFragment = (GetFragment) getFragmentManager().findFragmentById(FRG_GET);

        api_root = getIntent().getStringExtra(Constants.API_ROOT);
        clientType = (ClientType) getIntent().getExtras().get(Constants.SELECT);
        apiMethod = (TypeMethod) getIntent().getExtras().get(Constants.API_METHOD);

        clientManager = ClientManager.getManager(clientType, this);
        switch (apiMethod) {
            case READ:
                clientManager.readRequest(getFragment, api_root);
                break;
            case CREATE:
                break;
            case DELETE:
                break;
            case UPDATE:
                break;
            default:
                throw new RuntimeException("wrong method");
        }
        clientManager.readRequest(new DataArchitectureBackup(this), api_root);


        btnView.setOnClickListener(v -> {
            String id = txtId.getText().toString();
            refreshType = id.isEmpty() ? RefreshType.FULL : RefreshType.DETAIL;
            clientManager.readRequest(getFragment,
                    String.format("%s/%s", api_root, id));
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, ReadRefreshService.class);
        this.bindService(intent, serviceConnection, BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        this.unbindService(serviceConnection);
    }

    @Override
    public void refresh() {
        String id = txtId.getText().toString();
        if (RefreshType.DETAIL.equals(refreshType) && !id.isEmpty()) {
            clientManager.readRequest(getFragment,
                    String.format("%s/%s", api_root, id));
        } else {
            refreshType = RefreshType.FULL;
            clientManager.readRequest(getFragment, api_root);
        }
    }
}
