package com.example.igor.lv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button temperatureButton;
    Button distanceButton;
    Button weightButton;
    Button volumeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpUi();
        setUpOnClicks();
    }

    public void setUpUi(){
        temperatureButton = (Button) findViewById(R.id.temperatureButton);
        distanceButton = (Button) findViewById(R.id.distanceButton);
        weightButton = (Button) findViewById(R.id.weightButton);
        volumeButton = (Button) findViewById(R.id.volumeButton);
    }

    public void setUpOnClicks(){
        temperatureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TemperatureConversion.class);
                startActivity(intent);
            }
        });
        distanceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DistanceConversion.class);
                startActivity(intent);
            }
        });
        weightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WeightConversion.class);
                startActivity(intent);
            }
        });
        volumeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VolumeConversion.class);
                startActivity(intent);
            }
        });
    }
}
