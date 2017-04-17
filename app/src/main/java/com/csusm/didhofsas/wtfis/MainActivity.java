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
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener, TextWatcher, View.OnFocusChangeListener {
    EditText inputHome, inputTravel;                 //Input Number
    Spinner inputUnit;                                  //Spinner Unit
    ImageButton reloadButton, changeCountryButton;      //Buttons
    RadioButton[] radioHome, radioTravel;               //Radiobuttons (1-6 left, 7-12 right)
    Utilities util;                                     //Access to necessary Methods
    TextView homeunitview, travelunitview;              //TextViews above input fields
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    CountrycodeDataSource db;


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

        db = new CountrycodeDataSource(this, true);
        db.open();

        //Finding IDS
        inputHome = (EditText)findViewById(R.id.number_input);
        inputTravel = (EditText)findViewById(R.id.number_output);
        inputUnit = (Spinner)findViewById(R.id.unitInput);
        reloadButton = (ImageButton)findViewById(R.id.reload_button);
        changeCountryButton = (ImageButton)findViewById(R.id.change_country_button);
        homeunitview = (TextView) findViewById(R.id.homeunitview);
        travelunitview = (TextView)findViewById(R.id.travelunitview);

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

        db.selectAllFromTable(CountrycodeDBHelper.APPUSER_TABLE, CountrycodeDataSource.USER_COLUMNS);

        //Access to necessary Data
        util = new Utilities(this);
        Intent i = new Intent(this, CountryActivity.class);
        i.putExtra("country_array", util.getAllCountryNames());
        db.close();
        startActivityForResult(i, 0);

        db.open();

        //DATABASE TEST IN PROGESS

        db.createCountry(0, "European Union", true);
        db.createCountry(1, "United States of America", false);
        db.createCountry(2, "United Kingdom", true);
        db.createUser(0);
        db.createMeasure(0, "Lenghth/ Distance");
        db.createMeasure(1, "Weight");
        db.createMeasure(2, "Liquids");
        db.createMeasure(3, "Currency");
        db.createMeasure(4, "Temperature");
        db.createUnit("kilometer", 0.001, 0);
        db.createUnit("meter", 1.0, 0);
        db.createUnit("centimeter", 100.0, 0);
        db.createUnit("millimeter", 1000.0, 0);
        db.createUnit("miles", 0.00062137, 0);
        db.createUnit("yards", 1.09361, 0);
        db.createUnit("feet", 3.28084, 0);
        db.createUnit("inches", 39.3701, 0);
        db.createUnit("ton", 0.001, 1);
        db.createUnit("kilogram", 1.0, 1);
        db.createUnit("gram", 1000.0, 1);
        db.createUnit("pound", 2.20462,1);
        db.createUnit("ounce", 35.274,1);
        db.createUnit("liter", 1.0, 2);
        db.createUnit("milliliter", 1000.0, 2);
        //TODO THINK ABOUT REMOVING (country) before showing in APP
        db.createUnit("gallon (us)", 0.264172, 2);
        db.createUnit("quart (us)", 1.05669, 2);
        db.createUnit("pint (us)", 2.11338,2);
        db.createUnit("cup (us)", 4.1667, 2);
        db.createUnit("fl. ounce (us)", 33.814, 2);
        db.createUnit("gallon (uk)", 0.219969, 2);
        db.createUnit("quart (uk)", 0.879877, 2);
        db.createUnit("pint (uk)", 1.75975, 2);
        db.createUnit("cup (uk)", 3.51951, 2);
        db.createUnit("fl. ounce (uk)", 35.1951, 2);
        db.createCurrency("euro", 1.0);
        db.createCurrency("us dollar", 1.057);
        db.createCurrency("pound sterling", 0.854);
        db.createUnit("celsius", 1.0, 4);
        db.createUnit("fahrenheit", 0.0, 4);



        db.linkCountryUnit(0, "kilometer");
        db.linkCountryUnit(0, "meter");
        db.linkCountryUnit(0, "centimeter");
        db.linkCountryUnit(0, "millimeter");
        db.linkCountryUnit(0, "ton");
        db.linkCountryUnit(0, "kilogram");
        db.linkCountryUnit(0, "gram");
        db.linkCountryUnit(0, "liter");
        db.linkCountryUnit(0, "milliliter");
        db.linkCountryUnit(0, "euro");
        db.linkCountryUnit(0, "celsius");
        db.linkCountryUnit(1, "miles");
        db.linkCountryUnit(1, "yards");
        db.linkCountryUnit(1, "feet");
        db.linkCountryUnit(1, "inches");
        db.linkCountryUnit(1, "pound");
        db.linkCountryUnit(1, "ounce");
        db.linkCountryUnit(1, "gallon (us)");
        db.linkCountryUnit(1, "quart (us)");
        db.linkCountryUnit(1, "pint (us)");
        db.linkCountryUnit(1, "cup (us)");
        db.linkCountryUnit(1, "fl. ounce (us)");
        db.linkCountryUnit(1, "us dollar");
        db.linkCountryUnit(1, "fahrenheit");
        db.linkCountryUnit(2, "miles");
        db.linkCountryUnit(2, "yards");
        db.linkCountryUnit(2, "feet");
        db.linkCountryUnit(2, "inches");
        db.linkCountryUnit(2, "ton");
        db.linkCountryUnit(2, "pound");
        db.linkCountryUnit(2, "ounce");
        db.linkCountryUnit(2, "gallon (uk)");
        db.linkCountryUnit(2, "quart (uk)");
        db.linkCountryUnit(2, "pint (uk)");
        db.linkCountryUnit(2, "cup (uk)");
        db.linkCountryUnit(2, "fl. ounce (uk)");
        db.linkCountryUnit(2, "pound sterling");
        db.linkCountryUnit(2, "celsius");


        /*db.selectAllFromTable(CountrycodeDBHelper.COUNTRY_TABLE, CountrycodeDataSource.COUNTRY_COLUMNS);*/
        db.selectAllFromTable(CountrycodeDBHelper.UNIT_TABLE, CountrycodeDataSource.UNIT_COLUMNS);
        /*db.selectAllFromTable(CountrycodeDBHelper.APPUSER_TABLE, CountrycodeDataSource.USER_COLUMNS);
        db.selectAllFromTable(CountrycodeDBHelper.MEASURE_TABLE, CountrycodeDataSource.MEASURE_COLUMNS);
        db.selectAllFromTable(CountrycodeDBHelper.CURRENCY_TABLE, CountrycodeDataSource.CURRENCY_COLUMNS);*/
        db.selectAllFromTable(CountrycodeDBHelper.COUNTRY_UNIT_TABLE, CountrycodeDataSource.COUNTRY_USER_COLUMNS);

        String[] spinnerArray = db.selectNamesInTable(CountrycodeDBHelper.MEASURE_TABLE, CountrycodeDataSource.MEASURE_COLUMNS);
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerArray);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        inputUnit.setAdapter(spinnerArrayAdapter);
        inputUnit.setSelection(0);

        db.close();
    }

    //Saves chosenCountries
    //Reloads RadioButtons to fit new units
    //Requests new Currency Values out of API
    public void onActivityResult(int requestNumber, int resultNumber, Intent data)
    {
        db.open();
        Log.d(LOG_TAG, "onActivityResult wurde aufgerufen");
        util.setChosenCountries(data.getExtras().getInt("homeCode"), data.getExtras().getInt("travelCode"));
        util.fillAllRadio();
        //util.setNewCurrencyValues();
        db.close();
    }

    //Country Button opens CountryActivity
    //selected Radiobutton gets saved
    //TODO REMOVE RELOAD BUTTON
    @Override
    public void onClick(View v)
    {
        db.open();
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
                // calc numbers + change TextView of InputFields
                util.calc();
                util.changeUnitView();

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
                //calc numbers + change TextView of InputFields
                util.calc();
                util.changeUnitView();
                break;
        }
        db.close();

    }

    //Reloads RadioButtons after Spinner got changed
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        db.open();
        util.fillAllRadio();
        util.calc();
        util.changeUnitView();
        db.close();
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
