package fr.imie.malah.sensor;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.Set;

import static android.bluetooth.BluetoothDevice.ACTION_FOUND;
import static android.bluetooth.BluetoothDevice.EXTRA_DEVICE;
import static android.hardware.SensorManager.SENSOR_DELAY_NORMAL;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private static final int REQUEST_ENABLE_BT = 2;

    private SensorManager sensorManager;
    private Sensor imu;
    private Sensor light;
    private BluetoothAdapter bluetoothAdapter;
    private BroadcastReceiver receiver;

    private void btEnabled() {
        Set<BluetoothDevice> pairedDevices = bluetoothAdapter.getBondedDevices();
        
        pairedDevices.forEach(d -> {
            String name = d.getName();
        });

        Intent discover = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        discover.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 5000);
        startActivity(discover);
        IntentFilter filter = new IntentFilter(ACTION_FOUND);
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        light = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        imu = sensorManager.getDefaultSensor(Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR);

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        if (bluetoothAdapter != null && !bluetoothAdapter.isEnabled()) {
            Intent enableBt = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            this.startActivityForResult(enableBt, REQUEST_ENABLE_BT);
        } else {
            btEnabled();
        }

        receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if (ACTION_FOUND.equals(action)) {
                    BluetoothDevice device = intent.getParcelableExtra(EXTRA_DEVICE);
                    String name = device.getName();
                }
            }
        };
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, imu, SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, light, SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.equals(imu)) {
            String result = String.format("x:%s, y:%s, z:%s", event.values[0], event.values[1], event.values[2]);
            Log.d("IMU sensor", result);
        } else if (event.sensor.equals(light)) {
            Log.d("LIGHT sensor", String.valueOf(event.values[0]));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (REQUEST_ENABLE_BT == requestCode) {
            if (resultCode == RESULT_OK && bluetoothAdapter.isEnabled()) {
                btEnabled();
            }
        }
    }

}
