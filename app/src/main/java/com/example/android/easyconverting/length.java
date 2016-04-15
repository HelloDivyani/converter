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

public class length extends AppCompatActivity {
    Spinner lengthSpinner;
    String imc_met=null;
    String display;

    ArrayAdapter<CharSequence> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);
        lengthSpinner =(Spinner)findViewById(R.id.length_spinner);
        adapter = ArrayAdapter.createFromResource(this,R.array.lengthQuantites,R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lengthSpinner.setAdapter(adapter);
        lengthSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + "selected", Toast.LENGTH_LONG).show();
                imc_met = lengthSpinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });
    }
    public  void  ClickConvert(View view)
    {
        double cm,inches,feet,yards,meters,km,miles,mm;
        EditText lengthAmount =(EditText)findViewById(R.id.enter_length);

        Editable number = lengthAmount.getText();
        String s=lengthAmount.getText().toString();
        double no = Float.parseFloat(s);


        if(imc_met.equals("Centimeters")) {
            inches=no*0.394;
            feet =no*0.03280839;
            yards=no*0.0109;
            meters=no*0.01;
            km=no*0.000001;
            miles=no*6.214*0.0000001;
            mm=no*10;

            display = number + " cm = " + inches + " inches" + "\n" + number + " cm = " + feet +" feets"+"\n" + number + " cm = "+yards+" yards"+"\n" + number + " cm = "+meters+" meters"+"\n" + number + " cm = "+km+" km"+"\n" + number + " cm = "+miles+" miles"+"\n" + number + " cm = "+mm+" mm";
            displaymessage(display);
        }
        else if(imc_met.equals("Inches"))
        {
            cm=no*2.54;
            feet=no*0.0833;
            yards=no*0.0278;
            meters=no*0.0254;
            km=no*2.54*0.000001;
            miles =no*1.578*0.000001;
            mm= no*25.4;
            display = number + " Inches = " + cm + " cm" + "\n" + number + " Inches = " + feet +" feets"+"\n" + number + " Inches = "+yards+" yards"+"\n" + number + " Inches = "+meters+" meters"+"\n" + number + " Inches = "+km+" km"+"\n" + number + " Inches = "+miles+" miles"+"\n" + number + " Inches = "+mm+" mm";
            displaymessage(display);
        }
        else if(imc_met.equals("Feet"))
        {
            cm=no*30.48;
            inches=no*12;
            yards=no*0.333;
            meters=no*0.305;
            km=no*0.000305;
            miles=no*0.000189;
            mm=no*304.8;
            display = number + " feet = " + inches + " inches" + "\n" + number + " feet = " + cm +" cm"+"\n" + number + " feet = "+yards+" yards"+"\n" + number + " feet = "+meters+" meters"+"\n" + number + " feet = "+km+" km"+"\n" + number + " feet = "+miles+" miles"+"\n" + number + " feet = "+mm+" mm";
            displaymessage(display);

        }
        else if(imc_met.equals("Yards"))
        {
            cm=no*91.44;
            inches=no*36;
            feet =no*3;
            meters=no*0.914;
            km=no*0.000914;
            miles=no*0.000568;
            mm=no*914.4;
            display = number + " yards = " + inches + " inches" + "\n" + number + " yards = " + cm +" cm"+"\n" + number + " yards = "+feet+" feet"+"\n" + number + " yards = "+meters+" meters"+"\n" + number +" yards = "+km+" km"+"\n" + number + " yards = "+miles+" miles"+"\n" + number + " yards = "+mm+" mm";
            displaymessage(display);

        }
        else if(imc_met.equals("Meters"))
        {
            cm=no*100;
            inches=no*39.37;
            feet=no*3.2808399;
            yards=no*1.094;
            km=no*0.001;
            miles=no*0.000621;
            mm=no*1000;
            display = number + " m = " + inches + " inches" + "\n" + number + " m = " + cm +" cm"+"\n" + number + " m = "+yards+" yards"+"\n" + number + " m = "+feet+" feet"+"\n" + number + " m = "+km+" km"+"\n" + number + " m = "+miles+" miles"+"\n" + number + " m = "+mm+" mm";
            displaymessage(display);

        }
        else if(imc_met.equals("KiloMeters"))
        {
           cm=no*100000;
            inches=no*39370.079;
            feet=no*3280.84;
            yards=no*1093.61300;
            meters=no*1000;
            miles=no*0.62137;
            mm=no*1000000;
            display = number + " km = " + inches + " inches" + "\n" + number + " km = " + cm +" cm"+"\n" + number + " km = "+yards+" yards"+"\n" + number + " km = "+meters+" meters"+"\n" + number + " km = "+feet+" feet"+"\n" + number + " km = "+miles+" miles"+"\n" + number + " km = "+mm+" mm";
            displaymessage(display);

        }
        else if(imc_met.equals("Miles"))
        {
            cm=no*160934.4;
            inches=no*63360;
            feet=no*5280;
            yards=no*1760;
            meters=no*160.344;
            km=no*1.609;
            mm=no*1609344;
            display = number + " miles = " + inches + " inches" + "\n" + number + " miles = " + cm +" cm"+"\n" + number + " miles = "+yards+" yards"+"\n" + number + " miles = "+meters+" meters"+"\n" + number + " miles = "+km+" km"+"\n" + number + " miles = "+feet+" feet"+"\n" + number + " miles = "+mm+" mm";
            displaymessage(display);

        }
        else if(imc_met.equals("MilliMeters"))
        {
            cm=no*0.1;
            inches=no*0.0394;
            feet=no*0.00328084;
            yards=no*0.00109;
            meters=no*0.001;
            km=no*0.0000001;
            miles=no*6.124*0.00000001;
            display = number + " mm = " + inches + " inches" + "\n" + number + " mm = " + cm +" cm"+"\n" + number + " mm = "+yards+" yards"+"\n" + number + " mm = "+meters+" meters"+"\n" + number + " mm = "+km+" km"+"\n" + number + " mm = "+miles+" miles"+"\n" + number + " mm = "+feet+" feet";
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
