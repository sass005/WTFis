package com.csusm.didhofsas.wtfis;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Spinner;

public class MainActivity extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener, TextWatcher, View.OnFocusChangeListener {
    EditText inputHome, inputTravel;                 //Input Number
    Spinner inputUnit;                                  //Spinner Unit
    ImageButton reloadButton, changeCountryButton;      //Buttons
    RadioButton[] radioHome, radioTravel;               //Radiobuttons (1-6 left, 7-12 right)
    Utilities util;                                     //Access to necessary Methods
    private static final String LOG_TAG = MainActivity.class.getSimpleName();


    //Creates connection to XML
    //Sets Listener to Items
    //Creates a Utilities object to access calculation Methods and save Values
    //Opens CountryActivity to get Home and Travelcountry
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Log.d(LOG_TAG, "Application started");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Finding IDS
        inputHome = (EditText)findViewById(R.id.number_input);
        inputTravel = (EditText)findViewById(R.id.number_output);
        inputUnit = (Spinner)findViewById(R.id.unitInput);
        reloadButton = (ImageButton)findViewById(R.id.reload_button);
        changeCountryButton = (ImageButton)findViewById(R.id.change_country_button);

        radioHome = new RadioButton[6];
        radioHome[0] = ((RadioButton)findViewById(R.id.radioButton1));
        radioHome[1] = ((RadioButton)findViewById(R.id.radioButton2));
        radioHome[2] = ((RadioButton)findViewById(R.id.radioButton3));
        radioHome[3] = ((RadioButton)findViewById(R.id.radioButton4));
        radioHome[4] = ((RadioButton)findViewById(R.id.radioButton5));
        radioHome[5] = ((RadioButton)findViewById(R.id.radioButton6));

        radioTravel = new RadioButton[6];
        radioTravel[0] = ((RadioButton)findViewById(R.id.radioButton7));
        radioTravel[1] = ((RadioButton)findViewById(R.id.radioButton8));
        radioTravel[2] = ((RadioButton)findViewById(R.id.radioButton9));
        radioTravel[3] = ((RadioButton)findViewById(R.id.radioButton10));
        radioTravel[4] = ((RadioButton)findViewById(R.id.radioButton11));
        radioTravel[5] = ((RadioButton)findViewById(R.id.radioButton12));

        //Setting Adapter for Spinner
        String[] spinnerArray = {"Lenght/ Distance", "Weight", "Liquids", "Currency", "Temperature"};
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerArray);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        inputUnit.setAdapter(spinnerArrayAdapter);

        //Setting Listener
        inputHome.setOnFocusChangeListener(this);
        inputTravel.setOnFocusChangeListener(this);
        inputUnit.setOnItemSelectedListener(this);
        reloadButton.setOnClickListener(this);
        changeCountryButton.setOnClickListener(this);

        radioHome[0].setOnClickListener(this);
        radioHome[1].setOnClickListener(this);
        radioHome[2].setOnClickListener(this);
        radioHome[3].setOnClickListener(this);
        radioHome[4].setOnClickListener(this);
        radioHome[5].setOnClickListener(this);

        radioTravel[0].setOnClickListener(this);
        radioTravel[1].setOnClickListener(this);
        radioTravel[2].setOnClickListener(this);
        radioTravel[3].setOnClickListener(this);
        radioTravel[4].setOnClickListener(this);
        radioTravel[5].setOnClickListener(this);

        //Access to necessary Data
        util = new Utilities(this);
        Intent i = new Intent(this, CountryActivity.class);
        i.putExtra("country_array", util.getAllCountryNames());
        startActivityForResult(i, 0);
    }

    //Saves chosenCountries
    //Reloads RadioButtons to fit new units
    //Requests new Currency Values out of API
    public void onActivityResult(int requestNumber, int resultNumber, Intent data)
    {
        Log.d(LOG_TAG, "onActivityResult wurde aufgerufen");
        util.setChosenCountries(data.getExtras().getInt("homeCode"), data.getExtras().getInt("travelCode"));
        util.fillAllRadio();
        util.setNewCurrencyValues();
    }

    //Country Button opens CountryActivity
    //selected Radiobutton gets saved
    //TODO REMOVE RELOAD BUTTON
    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.reload_button:
                util.calc();
                break;

            //Start CountryActivity to change the country
            case R.id.change_country_button:
                Intent intent = new Intent(this, CountryActivity.class);
                intent.putExtra("country_array", util.getAllCountryNames());
                startActivityForResult(intent, 0);
                break;

            //Home Side Radio Button selected
            case R.id.radioButton1:
            case R.id.radioButton2:
            case R.id.radioButton3:
            case R.id.radioButton4:
            case R.id.radioButton5:
            case R.id.radioButton6:
                for(int i = 0; i < radioHome.length; i++)
                    if(radioHome[i].getId() == v.getId())
                    {
                        util.setSelectedRadioHome(i);
                        Log.d(LOG_TAG, "RadioButton: " + i);
                    }
                // calc numbers
                util.calc();

                break;

            //Travel Side Radio Button selected
            case R.id.radioButton7:
            case R.id.radioButton8:
            case R.id.radioButton9:
            case R.id.radioButton10:
            case R.id.radioButton11:
            case R.id.radioButton12:
                for(int i = 0; i < radioTravel.length; i++)
                    if(radioTravel[i].getId() == v.getId())
                    {
                        util.setSelectedRadioTravel(i);
                        Log.d(LOG_TAG, "RadioButton: " + i);
                    }
                //calc numbers
                util.calc();
                break;
        }

    }

    //Reloads RadioButtons after Spinner got changed
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        util.fillAllRadio();
        util.calc();
    }

    //Oversees from which Side to Read and to which SIde to Write to
    @Override
    public void onFocusChange(View v, boolean hasFocus)
    {
        //Only do something if EditText got has Focus now
        if(hasFocus)
            switch (v.getId())
            {
                //Read from Home, write to Travel
                case R.id.number_input:
                    Log.d(LOG_TAG, "Focus on HOME!");
                    util.setFocusOnHome();
                    break;

                //Read from Travel, write to Home
                case R.id.number_output:
                    Log.d(LOG_TAG, "Focus on TRAVEL!");
                    util.setFocusOnTravel();
                    break;
            }
    }

    //Calcs if Text changes
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        util.calc();
    }











//DONT DO ANYTHING JUST NEED TO BE IMPLEMENTED FOR INTERFACES

    //Does Nothing, needs to be implemented for SpinnerListener
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        //fillRadio(radioHome, getChosenCountry(chosenHome));
        //fillRadio(radioTravel, getChosenCountry(chosenTravel));
    }

    //Does Nothing, needs to be implemented for SpinnerListener
    @Override
    public void onNothingSelected(AdapterView<?> parent) {}

    //Does Nothing, needs to be implemented for OnTextListener
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}



    //Does Nothing, needs to be implemented for OnTextListener
    @Override
    public void afterTextChanged(Editable s) {}

}
