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

public class time1 extends AppCompatActivity {
    Spinner time1Spinner;
    String imc_met=null;
    String display;

    ArrayAdapter<CharSequence> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time1);
        time1Spinner =(Spinner)findViewById(R.id.time1_spinner);
        adapter = ArrayAdapter.createFromResource(this,R.array.timeQuantites,R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        time1Spinner.setAdapter(adapter);
        time1Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),parent.getItemAtPosition(position)+"selected",Toast.LENGTH_LONG).show();
                imc_met=time1Spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {



            }
        });
    }
    public  void  ClickConvert(View view)
    {
        //sec is for seconds
        int days,hours,minute,sec;

        EditText time1Amount =(EditText)findViewById(R.id.enter_time1);

        Editable number = time1Amount.getText();
        String s=time1Amount.getText().toString();
        double no = Float.parseFloat(s);


        if(imc_met.equals("days")) {

            hours=(int)no*24;
            minute=(int)no*24*60;
            sec=(int)no*24*60*60;


            display = number + "days = " +hours + " hours" + "\n" + number + "days = " + minute +" minutes"+ "\n" + number + "days = " +sec+"  seconds";
            displaymessage(display);
        }
        else if(imc_met.equals("hours"))
        {
            days=(int)no/24;
            minute=(int)no*60;
            sec=(int)no*60*60;
            display=number+"Hours = "+days+" Days"+"\n"+number+"Hours = "+minute+" minutes"+"\n"+number+"Hours = "+sec+" seconds";
            displaymessage(display);
        }
        else if(imc_met.equals("minutes"))
        {
            days=(int)(no/(60*24));
            hours=(int)(no/60);
            sec=(int)(no*60);
            display=number+"Minutes = "+days+" Days"+"\n"+number+"Minutes = "+hours+" Hours"+"\n"+number+"Minutes = "+sec+" seconds";
            displaymessage(display);

        }
        else if(imc_met.equals("seconds"))
        {
            days=(int)(no/(60*60*24));
            minute=(int)(no/60);
            hours=(int)(no/(60*60));

            display=number+"Seconds = "+days+" Days"+"\n"+number+" Seconds = "+minute+" Minutes"+"\n"+number+" Seconds = "+hours+" Hours";
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
