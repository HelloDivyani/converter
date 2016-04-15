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

public class pressure extends AppCompatActivity {
        Spinner pressureSpinner;
        String imc_met=null;
    String display;

    ArrayAdapter<CharSequence> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure2);
        pressureSpinner =(Spinner)findViewById(R.id.pressure_spinner);
        adapter = ArrayAdapter.createFromResource(this,R.array.pressureQuantites,R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pressureSpinner.setAdapter(adapter);
        pressureSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            //imc_net stores the item name selected by user
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),parent.getItemAtPosition(position)+"selected",Toast.LENGTH_LONG).show();
                imc_met=pressureSpinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {



            }
        });
    }
    public  void  ClickConvert(View view)
    {
        double bar,atm,pa,torr;

        EditText pressureAmount =(EditText)findViewById(R.id.enter_pressure);

       Editable number = pressureAmount.getText();
        String s=pressureAmount.getText().toString();
        double no = Float.parseFloat(s);


        if(imc_met.equals("Pascal(Pa)")) {
            bar = no * 0.000005;
            atm = no * 9.869 * 0.0000001;
            torr = no * 0.0075;

            display = number + "Pa = " + bar + " bar" + "\n" + number + "Pa = " + atm +" atm"+ "\n" + number + "Pa = " + torr+"  Torr";
            displaymessage(display);
        }
        else if(imc_met.equals("Atmosphere(atm)"))
        {
            pa= no*101325;
            torr=no*760;
            bar=no*1.013;
            display=number+"atm = "+pa+" pascal"+"\n"+number+"atm = "+torr+" torr"+"\n"+number+"atm = "+bar+" bar";
            displaymessage(display);
        }
        else if(imc_met.equals("Bar"))
        {
            pa=no*100000;
            atm=no*0.987;
            torr=no*750.062;
            display=number+"bar = "+pa+" pascal"+"\n"+number+"bar = "+atm+" atm"+"\n"+number+"bar = "+torr+" torr";
            displaymessage(display);

        }
        else if(imc_met.equals("Torr"))
        {
            pa=no*133.322;
            atm=no*0.00132;
            bar=no*0.00133;
            display=number+"torr = "+pa+" pascal"+"\n"+number+" torr = "+atm+" atm"+"\n"+number+" torr = "+bar+" bar";
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
