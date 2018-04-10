package fr.imie.malah.testjni;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("native-lib");
    }

    private TextView lblJavaResult;
    private Button btnJavaCalc;
    private TextView lblCResult;
    private Button btnCCalc;
    private TextView lblsame;

    boolean[] javaPrimes = new boolean[1000000];
    boolean[] cPrimes = new boolean[1000000];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblJavaResult = findViewById(R.id.lblResult);
        btnJavaCalc = findViewById(R.id.btn);
        lblCResult = findViewById(R.id.lblCTime);
        btnCCalc = findViewById(R.id.btnC);
        lblsame = findViewById(R.id.lblIsSame);

        btnJavaCalc.setOnClickListener((View v) -> {
            long begin = System.currentTimeMillis();
            fillSieve();
            long time = System.currentTimeMillis() - begin;

            lblJavaResult.setText(Long.toString(time) + "ms");
        });

        btnCCalc.setOnClickListener((View v) -> {
            long begin = System.currentTimeMillis();
            cPrimes = calc();
            long time = System.currentTimeMillis() - begin;

            lblCResult.setText(Long.toString(time) + "ms");
            lblsame.setText(isSame() ? "YES" : "NO");
        });

    }

    public void fillSieve() {
        Arrays.fill(javaPrimes, true);
        javaPrimes[0] = javaPrimes[1] = false;
        for (int i = 2; i < javaPrimes.length; i++) {
            if (javaPrimes[i]) {
                for (int j = 2; i * j < javaPrimes.length; j++) {
                    javaPrimes[i * j] = false;
                }
            }
        }
    }

    public native boolean[] calc();

    public boolean isSame() {
        for (int i = 0; i < javaPrimes.length; i++) {
            if (javaPrimes[i] != cPrimes[i]) {
                return false;
            }
        }
        return true;
    }
}
