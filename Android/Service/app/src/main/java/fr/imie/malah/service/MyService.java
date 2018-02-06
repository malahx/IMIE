package fr.imie.malah.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by malah on 08/01/18.
 */

public class MyService extends Service {


    public static final String PARAM = "toto";
    private volatile String displayValue;
    private IBinder binder = new LocalBinder();
    private Thread myThread = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(3000);
                    //                    Toast.makeText(MyService.this, threadId, Toast.LENGTH_SHORT).show();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });

    @Override
    public void onCreate() {
        // Appelé à la céation
        super.onCreate();
        myThread.start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Appelé a la start service
        int i = super.onStartCommand(intent, flags, startId);
        this.displayValue = intent.getStringExtra(PARAM);
        return i;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        this.displayValue = intent.getStringExtra(PARAM);
        return binder;
    }


    public class LocalBinder extends Binder {

        public MyService getService() {
            return MyService.this;
        }

    }

    public String getDisplayValue() {
        return displayValue;
    }
}
