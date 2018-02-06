package fr.imie.malah.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private MyService service;

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder iBinder) {
            MyService.LocalBinder binder = (MyService.LocalBinder) iBinder;
            service = binder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            service = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Threading threading = new Threading(this);
//        threading.demoThread();
//        threading.demoTask();

        this.findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, MyService.class);
                intent.putExtra(MyService.PARAM, "value 2");
                MainActivity.this.startService(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        // Création
        Intent intent = new Intent(this, MyService.class);
        intent.putExtra(MyService.PARAM, "value 1");
//        this.startService(intent);
        this.bindService(intent, serviceConnection, BIND_AUTO_CREATE);

    }

    @Override
    protected void onStop() {
        super.onStop();
        this.unbindService(serviceConnection);
    }
}
