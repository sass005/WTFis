package com.csusm.didhofsas.wtfis;

import android.util.Log;
import android.view.View;
import android.widget.RadioButton;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Utilities
{
    private static final String LOG_TAG = Utilities.class.getSimpleName();
    private Memory memory;
    private MainActivity main;

    //Constructor
    Utilities(MainActivity main)
    {
        memory = new Memory(main);
        this.main = main;
    }


    public void calc()
    {
        double solution;
        double input;
        //catch Tempeture
        if(memory.getCheckedCategory() == 4){
            //Methodenaufruf for Tempeture
            calcTemp();
            return;
        }

        if(memory.isFocusOnHome()){
            input = Double.parseDouble(main.inputHome.getText().toString());
            solution = Conversion.fixedconversion(input, memory.getHomeExchangeRate(),memory.getTravelExchangeRate());
            DecimalFormat df = custumDecimalFormat(solution);
            main.inputTravel.setText("" + df.format(solution));
        }else{
            input = Double.parseDouble(main.inputTravel.getText().toString());
            solution = Conversion.fixedconversion(input, memory.getTravelExchangeRate(),memory.getHomeExchangeRate());
            DecimalFormat df = custumDecimalFormat(solution);
            main.inputHome.setText("" + df.format(solution));
        }
    }

    //Set Tempeture
    private void calcTemp(){
        double solution;
        double input;
        boolean isHomeCelsius = memory.getHomeUnits().get(0).calc_factor > 0;
        Log.i("CALC","Home has Celsius: " +isHomeCelsius);
        boolean isTravelCelsius = memory.getTravelUnits().get(0).calc_factor > 0;
        Log.i("CALC", "Travel has Celsius: " + isTravelCelsius);
        //For FocusOnHome
        if(memory.isFocusOnHome()){
            input = Double.parseDouble(main.inputHome.getText().toString());

            // Checks if Same Unit (C=C or F=F)
            if(isHomeCelsius == isTravelCelsius){
                Log.i("CALC", "No Conversion needed");
                solution = input;

                //HomeCounry ist in Celsius, TravelCounry hat Fahrenheit
            }else if(isHomeCelsius)
            {
                Log.i("CALC", "Convert Celsius to Fahrenheit");
                solution = Conversion.celsiusToFahrenheit(input);

                //HomeCounry ist in Fahrenheit, TravelCounry hat Celsius
            }else
            {
                Log.i("CALC", "Convert Fahrenheit to Celsius");
                solution = Conversion.fahrenheitToCelsius(input);
            }

            main.inputTravel.setText("" + solution);


            //For FocusOnTravel
        }else{
            input = Double.parseDouble(main.inputTravel.getText().toString());

            // Checks if Same Unit (C=C or F=F)
            if(isHomeCelsius == isTravelCelsius){
                Log.i("CALC", "No Conversion needed");
                solution = input;

                //HomeCounry ist in Celsius, TravelCounry hat Fahrenheit
            }else if(isHomeCelsius){
                Log.i("CALC", "Convert Celsius to Fahrenheit");
                solution = Conversion.fahrenheitToCelsius(input);

                //HomeCounry ist in Fahrenheit, TravelCounry hat Celsius
            }else{
                Log.i("CALC", "Convert Fahrenheit to Celsius");
                solution = Conversion.celsiusToFahrenheit(input);
            }
            main.inputHome.setText("" + solution);
        }
    }

    //Access to FillSingleRadio() Method from Main Class
    //Changes Radiobutton Text
    public void fillAllRadio()
    {
        int checkedCategory = main.inputUnit.getSelectedItemPosition();
        memory.setCheckedCategory(checkedCategory);
        Log.i("Category", "checked Category: " + checkedCategory);
        Log.i(LOG_TAG, "Home Radio Buttons");
        fillSingleRadio(memory.getRadioHome(), memory.getHomeUnits(), checkedCategory);
        Log.i(LOG_TAG, "Travel Radio Buttons");
        fillSingleRadio(memory.getRadioTravel(), memory.getTravelUnits(), checkedCategory);
    }

    //Reads checked Category of Spinner
    //saves into Memory
    //Renames and Hides RadioButtons according to chosen Category
    private void fillSingleRadio(RadioButton[] rb, ArrayList<Unit> units, int checkedCategory)
    {
        //check selected Category in spinner and save it


        switch (checkedCategory)
        {
            case 0: //Length
                //Set right name for all used Radiobuttons
                for(int i = 0; i < units.size(); i++)
                {
                    rb[i].setVisibility(View.VISIBLE);
                    rb[i].setText(units.get(i).name);
                }

                //hide all unused Radiobuttons
                for(int i = units.size(); i < 6; i++)
                {
                    rb[i].setVisibility(View.INVISIBLE);
                }
                break;
            case 1: //Weight
                //Set right name for all used Radiobuttons
                for(int i = 0; i < units.size(); i++)
                {
                    rb[i].setVisibility(View.VISIBLE);
                    rb[i].setText(units.get(i).name);
                }

                //hide all unused Radiobuttons
                for(int i = units.size(); i < 6; i++)
                {
                    rb[i].setVisibility(View.INVISIBLE);
                }
                break;
            case 2: //Liquids
                //Set right name for all used Radiobuttons
                for(int i = 0; i < units.size(); i++)
                {
                    rb[i].setVisibility(View.VISIBLE);
                    rb[i].setText(units.get(i).name);
                }

                //hide all unused Radiobuttons
                for(int i = units.size(); i < 6; i++)
                {
                    rb[i].setVisibility(View.INVISIBLE);
                }
                break;
            case 3: //Currency
                //set only first one visible
                rb[0].setVisibility(View.VISIBLE);
                rb[0].setText(units.get(0).name);

                //hide all unused Radiobuttons
                for(int i = 1; i < 6; i++)
                {
                    rb[i].setVisibility(View.INVISIBLE);
                }
                break;
            case 4: //Temperature

                //set only first one visible
                rb[0].setVisibility(View.VISIBLE);

                //Can only be Celsius or Fahrenheit
                rb[0].setText(units.get(0).name);

                //hide all unused Radiobuttons
                for(int i = 1; i < 6; i++)
                {
                    rb[i].setVisibility(View.INVISIBLE);
                }
                break;
        }
    }


    //GETTER

    public String[] getAllCountryNames()
    {
        return memory.getAllCountryNames();
    }


    //API TEST
    public void setNewCurrencyValues()
    {
        APICurrencyConnector api = new APICurrencyConnector();
        api.execute();
        String apiReturn = null;
        try {
            apiReturn = api.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        if (apiReturn.charAt(0) == 'c')
            return;
        Log.d("Currency", "Return of API: " + apiReturn);
        int progress = 0;
        String sGBP = "", sUSD = "";
        for (int i = 0; i < apiReturn.length();i++)
        {
            if (progress == 4)
                if(apiReturn.charAt(i) == ',')
                    progress++;
                else
                    sGBP = sGBP + apiReturn.charAt(i);
            if (progress == 6)
                if(apiReturn.charAt(i) == '}')
                    progress++;
                else
                    sUSD = sUSD + apiReturn.charAt(i);
            if(apiReturn.charAt(i) == ':')
                progress++;
        }
        Log.d("Currency","USD-String:" + sUSD);
        Log.d("Currency","GBP-String:" + sGBP);
        memory.setAllCurrencies(Double.parseDouble(sUSD), Double.parseDouble(sGBP));
    }

    //SETTER FOR THE MAIN TO ACCESS MEMORY

    //Access to Memory for Main
    public void setChosenCountries(int chosenHome, int chosenTravel)
    {
        memory.setHomeCountry(chosenHome);
        memory.setTravelCountry(chosenTravel);
    }

    //Access to Memory for Main
    public void setFocusOnHome()
    {
        memory.setFocusOnHome(true);
    }

    //Access to Memory for Main
    public void setFocusOnTravel()
    {
        memory.setFocusOnHome(false);
    }

    //Access to Memory for Main
    public void setSelectedRadioHome(int selectedRadioHome)
    {
        memory.setSelectedRadioHome(selectedRadioHome);
    }

    //Access to Memory for Main
    public void setSelectedRadioTravel(int selectedRadioTravel)
    {
        memory.setSelectedRadioTravel(selectedRadioTravel);
    }

    //TextView changes after new Radiobutton/Spinner gets selected
    public void changeUnitView()
    {
        Log.i("CHANGE UNIT VIEW",memory.getSelectedRadioHome() +"");
        Log.i("CHANGE UNIT VIEW", main.radioHome[0].getText().toString());
        main.homeunitview.setText(main.radioHome[memory.getSelectedRadioHome()].getText().toString());
        main.travelunitview.setText(main.radioTravel[memory.getSelectedRadioTravel()].getText().toString());
        return;
    }

    private DecimalFormat custumDecimalFormat(double sol)
    {
        if(sol > 0.0001) {
            return  new DecimalFormat("0.####");
        }else{
            return new DecimalFormat ("0.0000E0");
        }
    }
}
