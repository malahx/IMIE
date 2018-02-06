package fr.imie.malah.httpclientdemo.apiclient.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class ReadRefreshService extends Service {

    private Listener listener;
    private IBinder binder = new LocalBinder();

    private Thread refresh = new Thread(() -> refresh());

    private void refresh() {
        while (true) {
            try {
                Thread.sleep(5000);
                if (listener != null) {
                    listener.refresh();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        refresh.start();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }


    public class LocalBinder extends Binder {

        public ReadRefreshService getService() {
            return ReadRefreshService.this;
        }

    }

    public interface Listener {
        void refresh();
    }
}
