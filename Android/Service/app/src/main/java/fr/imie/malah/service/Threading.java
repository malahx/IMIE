package fr.imie.malah.service;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

/**
 * Created by malah on 08/01/18.
 */

public class Threading {

    private volatile Context context;

    public Context getContext() {
        return context;
    }

    public Threading(Context context) {
        this.context = context;
    }

    public void demoThread() {
        String threadId = String.valueOf(Thread.currentThread().getId());
        Toast.makeText(context, threadId, Toast.LENGTH_SHORT).show();

        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    String threadId = String.valueOf(Thread.currentThread().getId());
//                    Toast.makeText(Threading.this.getContext(), threadId, Toast.LENGTH_SHORT).show();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        myThread.start();
    }

    public void demoTask() {
        AsyncTask myAsyncTask = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    Thread.sleep(3000);
                    String threadId = String.valueOf(Thread.currentThread().getId());
//                    Toast.makeText(Threading.this.getContext(), threadId, Toast.LENGTH_SHORT).show();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }
        };
        myAsyncTask.execute();
    }

}
