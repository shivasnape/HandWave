package com.example.glaube_nikesh.handwave;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.glaube_nikesh.handwave.sensors.CameraGestureSensor;
import com.example.glaube_nikesh.handwave.sensors.ClickSensor;
import com.example.glaube_nikesh.handwave.utilities.LocalOpenCV;
import com.example.glaube_nikesh.handwave.utilities.PermissionUtility;

public class MainActivity extends AppCompatActivity implements CameraGestureSensor.Listener, ClickSensor.Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (PermissionUtility.checkCameraPermission(this)) {
            //The third passing in represents a separate click sensor which is not required if you just want the hand motions
            LocalOpenCV loader = new LocalOpenCV(MainActivity.this, MainActivity.this, MainActivity.this);
        }

    }

    @Override
    public void onSensorClick(ClickSensor caller) {

    }

    @Override
    public void onGestureUp(CameraGestureSensor caller, long gestureLength) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "Hand Motion Up", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public void onGestureDown(CameraGestureSensor caller, long gestureLength) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "Hand Motion Down", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onGestureLeft(CameraGestureSensor caller, long gestureLength) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "Hand Motion Left", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onGestureRight(CameraGestureSensor caller, long gestureLength) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "Hand Motion Right", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        if (PermissionUtility.checkCameraPermission(this)) {
            LocalOpenCV loader = new LocalOpenCV(MainActivity.this, MainActivity.this, MainActivity.this);
        }

    }
}
