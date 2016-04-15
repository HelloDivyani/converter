package com.example.android.easyconverting;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class temperature extends AppCompatActivity {
    Spinner temperatureSpinner;
    String imc_met=null;
    String display;

    ArrayAdapter<CharSequence> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);
        temperatureSpinner =(Spinner)findViewById(R.id.temperature_spinner);
        adapter = ArrayAdapter.createFromResource(this,R.array.temperatureQuantites,R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temperatureSpinner.setAdapter(adapter);
        temperatureSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + "selected", Toast.LENGTH_LONG).show();
                imc_met = temperatureSpinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });
    }
    public  void  ClickConvert(View view)
    {
        //cel is for celsius and far is for farenheit
        double kelvin,cel,far;

        EditText temperatureAmount =(EditText)findViewById(R.id.enter_temperature);

        Editable number = temperatureAmount.getText();
        String s=temperatureAmount.getText().toString();
        double no = Float.parseFloat(s);


        if(imc_met.equals("Degree Fahrenheit(F)")) {
            cel=(no-32)*(5.0/9.0);
            kelvin=((no-32)/1.8)+273;
            display = number + "degree F = " + cel + " degree C" + "\n" + number + "degree F = " + kelvin +" degree K";
            displaymessage(display);
        }
        else if(imc_met.equals("Degree Celsius(C)"))
        {
            kelvin=no+273;
            far=1.8*no+32;
            display=number+" degree C = "+kelvin+" degree K"+"\n"+number+"degree C = "+far+" degree F";
            displaymessage(display);
        }
        else if(imc_met.equals("Degree Kelvin(K)"))
        {
            cel=no-273;
            far=1.8*(no-273)+32;

            display=number+" degree K= "+cel+" degree C"+"\n"+number+"degree K = "+far+" degree F";
            displaymessage(display);

        }
        else
        {
            displaymessage("Invalid entry");
        }




    }
    public void displaymessage(String message)  {
        TextView show1 = (TextView) findViewById(R.id.data);
        show1.setText(message);
    }
}
