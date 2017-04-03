package com.csusm.didhofsas.wtfis;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

//Read the countrys, Return: both countrys as Integer
//0 = US
//1 = UK
//2 = EU



public class CountryActivity extends Activity implements View.OnClickListener {

    Spinner homeSpinner, travelSpinner;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);

        homeSpinner = (Spinner)findViewById(R.id.spinner_Homecountry);
        travelSpinner = (Spinner)findViewById(R.id.spinner_Travelcountry);
        submitButton = (Button)findViewById(R.id.cButton);
        submitButton.setOnClickListener(this);

        ArrayAdapter homeSpinnerArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item,
                this.getIntent().getExtras().getStringArray("country_array"));
        homeSpinner.setAdapter(homeSpinnerArrayAdapter);

        ArrayAdapter travelSpinnerArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item,
                this.getIntent().getExtras().getStringArray("country_array"));
        travelSpinner.setAdapter(travelSpinnerArrayAdapter);
    }

    @Override
    public void onClick(View v)
    {
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("homeCode", homeSpinner.getSelectedItemPosition());
        i.putExtra("travelCode", travelSpinner.getSelectedItemPosition());
        setResult(0, i);
        finish();
    }
}
