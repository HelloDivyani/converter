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

public class rect extends AppCompatActivity {
    Spinner energySpinner;
    String imc_met=null;
    String display;

    ArrayAdapter<CharSequence> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rect);
        energySpinner =(Spinner)findViewById(R.id.energy_spinner);
        adapter = ArrayAdapter.createFromResource(this,R.array.energyQuantites,R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        energySpinner.setAdapter(adapter);
        energySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            //imc_net stores the item name selected by user
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + "selected", Toast.LENGTH_LONG).show();
                imc_met = energySpinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });
    }
    public  void  ClickConvert(View view)
    {
        //rect ia actually for measuring energy conversion
        //cal is clorie,eV is electronVolt,ergs is Ergs,kwh is kiloWattHour
        double cal,eV,ergs,joules,kwh;
        EditText energyAmount =(EditText)findViewById(R.id.enter_energy);

        Editable number = energyAmount.getText();
        String s=energyAmount.getText().toString();
        double no = Float.parseFloat(s);


        if(imc_met.equals("Calories")) {
            eV=no*26131952998320000000.00;
            ergs=no*41868000.00;
            joules=no*4.187;
            kwh=no*0.000001;
            display = number + " cal = " +eV + " eV" + "\n" + number + " cal = " +ergs +" ergs"+"\n" + number + " cal = " +joules+" joules"+"\n" + number + " cal = " +kwh+" kwh";
            displaymessage(display);
        }
        else if(imc_met.equals("ElectronVolts"))
        {
            ergs=no*1.60217733*0.0000000000001;
            cal=no*2.6131952590564*1000000000*1000000000;
            joules=no*1.602176565*0.0000000000000000001;
            kwh=no*4.450490241667*0.000000000000000000000000001;


            display = number + " eV = " +cal + " cal" + "\n" + number + " eV = " +ergs +" ergs"+"\n" + number + " eV = " +joules+" joules"+"\n" + number + " eV = " +kwh+" kwh";
            displaymessage(display);
        }
        else if(imc_met.equals("Ergs"))
        {
            eV=no*624150964712.04;
            cal=no*2.39*0.000000000001;
            joules=no*0.00000001;
            kwh=no*2.778*0.000000000000001;

            display = number + " ergs = " +cal + " cal" + "\n" + number + " ergs = " +eV +" eV"+"\n" + number + " ergs = " +joules+" joules"+"\n" + number + " ergs = " +kwh+" kwh";
            displaymessage(display);

        }
        else if(imc_met.equals("Joules"))
        {
            eV=no*6.241509*1000000000*100000000;
            ergs=no*10000000;
            cal=no*0.000239;
            kwh=no*2.778*0.00000001;

            display = number + " joules = " +cal + " cal" + "\n" + number + " joules = " +ergs +" ergs"+"\n" + number + " joules = " +eV+" eV"+"\n" + number + " joules = " +kwh+" kwh";
            displaymessage(display);
        }
        else if(imc_met.equals("KiloWattHour"))
        {
            cal=no*860.421;
            eV=no*2.2469434729634*1000000000*1000000000*10000000;
            ergs=no*36000000*1000;
            joules=no*3600000;



            display = number + " kwh = " +cal + " cal" + "\n" + number + " kwh = " +ergs +" ergs"+"\n" + number + " kwh = " +joules+" joules"+"\n" + number + " kwh = " +eV+" eV";
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
