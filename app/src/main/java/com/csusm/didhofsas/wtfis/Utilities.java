package com.csusm.didhofsas.wtfis;

import android.util.Log;
import android.view.View;
import android.widget.RadioButton;

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

    //TODO REWRITE
    public void calc()
    {
        double solution;
        double input;
        //catch Tempeture
        if(memory.getCheckedCategory() == 4){
            //Methodenaufruf for Tempeture
            calcTemp();
        }

        if(memory.isFocusOnHome()){
            input = Double.parseDouble(main.inputHome.getText().toString());
            solution = Conversion.fixedconversion(input, memory.getHomeExchangeRate(),memory.getTravelExchangeRate());
            main.inputTravel.setText("" + solution);
        }else{
            input = Double.parseDouble(main.inputTravel.getText().toString());
            solution = Conversion.fixedconversion(input, memory.getTravelExchangeRate(),memory.getHomeExchangeRate());
            main.inputHome.setText("" + solution);
        }
    }

    //Set Tempeture
    private void calcTemp(){
        double solution;
        double input;
        //For FocusOnHome
        if(memory.isFocusOnHome()){
            input = Double.parseDouble(main.inputHome.getText().toString());

            // Checks if Same Unit (C=C or F=F)
            if(memory.equalTemp()){
                solution = input;

                //HomeCounry ist in Celsius, TravelCounry hat Fahrenheit
            }else if(memory.hasHomeCountryC()){
                solution = Conversion.celsiusToFahrenheit(input);

                //HomeCounry ist in Fahrenheit, TravelCounry hat Celsius
            }else{
                solution = Conversion.fahrenheitToCelsius(input);
            }

            main.inputTravel.setText("" + solution);


            //For FocusOnTravel
        }else{
            input = Double.parseDouble(main.inputTravel.getText().toString());

            // Checks if Same Unit (C=C or F=F)
            if(memory.equalTemp()){
                solution = input;

                //HomeCounry ist in Celsius, TravelCounry hat Fahrenheit
            }else if(memory.hasHomeCountryC()){
                solution = Conversion.fahrenheitToCelsius(input);

                //HomeCounry ist in Fahrenheit, TravelCounry hat Celsius
            }else{
                solution = Conversion.celsiusToFahrenheit(input);
            }
            main.inputHome.setText("" + solution);
        }
    }

    //Access to FillSingleRadio() Method from Main Class
    //Changes Radiobutton Text
    public void fillAllRadio()
    {
        fillSingleRadio(memory.getRadioHome(), memory.getDataHome());
        fillSingleRadio(memory.getRadioTravel(), memory.getDataTravel());
    }

    //Reads checked Category of Spinner
    //saves into Memory
    //Renames and Hides RadioButtons according to chosen Category
    private void fillSingleRadio(RadioButton[] rb, Countrycode cc)
    {
        //check selected Category in spinner and save it
        int checkedCategory = main.inputUnit.getSelectedItemPosition();
        memory.setCheckedCategory(checkedCategory);

        switch (checkedCategory)
        {
            case 0: //Length
                String[] temp = cc.getLenghthName();

                //Set right name for all used Radiobuttons
                for(int i = 0; i < temp.length; i++)
                {
                    rb[i].setVisibility(View.VISIBLE);
                    rb[i].setText(temp[i]);
                }

                //hide all unused Radiobuttons
                for(int i = temp.length; i < 6; i++)
                {
                    rb[i].setVisibility(View.INVISIBLE);
                }
                break;
            case 1: //Weight
                String[] temp2 = cc.getWeightName();

                //Set right name for all used Radiobuttons
                for(int i = 0; i < temp2.length; i++)
                {
                    rb[i].setVisibility(View.VISIBLE);
                    rb[i].setText(temp2[i]);
                }

                //hide all unused Radiobuttons
                for(int i = temp2.length; i < 6; i++)
                {
                    rb[i].setVisibility(View.INVISIBLE);
                }
                break;
            case 2: //Liquids
                String[] temp3 = cc.getLiquidName();

                //Set right name for all used Radiobuttons
                for(int i = 0; i < temp3.length; i++)
                {
                    rb[i].setVisibility(View.VISIBLE);
                    rb[i].setText(temp3[i]);
                }

                //hide all unused Radiobuttons
                for(int i = temp3.length; i < 6; i++)
                {
                    rb[i].setVisibility(View.INVISIBLE);
                }
                break;
            case 3: //Currency
                String temp4 = cc.getCurrencyName();

                //set only first one visible
                rb[0].setVisibility(View.VISIBLE);
                rb[0].setText(temp4);

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
                if (cc.isTempC())
                    rb[0].setText("Celsius");
                else
                    rb[0].setText("Fahrenheit");

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
}
