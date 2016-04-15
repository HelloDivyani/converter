package com.example.android.easyconverting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public Button pressureButton ,temperatureButton,timeButton,lengthButton,rectButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ClickPressure();
        ClickTemperature();
        ClickLength();
        ClickRect();
        ClickTime();


    }
    public void ClickPressure()
    {
        pressureButton = (Button)findViewById(R.id.PressureConversion);
        pressureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent pressureIntent = new Intent(MainActivity.this, pressure.class);
                startActivity(pressureIntent);

            }
        });
    }
    public void ClickTime()
    {
        timeButton = (Button)findViewById(R.id.timeConversion);
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent timeIntent = new Intent(MainActivity.this, time1.class);
                startActivity(timeIntent);

            }
        });
    } public void ClickLength()
    {
        lengthButton = (Button)findViewById(R.id.lenAreaVolConversion);
        lengthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent lengthIntent = new Intent(MainActivity.this, length.class);
                startActivity(lengthIntent);

            }
        });
    } public void ClickRect()
    {
        rectButton = (Button)findViewById(R.id.rectPolConversion);
        rectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent rectIntent = new Intent(MainActivity.this, rect.class);
                startActivity(rectIntent);

            }
        });
    } public void ClickTemperature()
    {
        temperatureButton = (Button)findViewById(R.id.TemperatureConversion);
        temperatureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent temperatureIntent = new Intent(MainActivity.this, temperature.class);
                startActivity(temperatureIntent);

            }
        });
    }

}
