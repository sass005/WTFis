package com.csusm.didhofsas.wtfis;

import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.ArrayList;

public class Memory
{
    private Countrycode euData, ukData, usData;
    private Countrycode dataHome, dataTravel;
    private MainActivity main;
    private boolean focusOnHome;
    private int checkedCategory;
    private int selectedRadioHome, selectedRadioTravel;

    Memory(MainActivity main)
    {
        this.main = main;

        createCountries();
    }


    public boolean hasHomeCountryC(){
        return (dataHome.isTempC());
    }


    private void createCountries()
    {
        euData = new Countrycode(
                0                       //code
                , "European Union"
                , new double[]{0.001, 1.0, 100.0, 1000.0}     //kilometer, meter, centimeter, millimeter
                , new String[]{"kilometer","meter","centimeter","millimeter"}
                , new double[]{0.001, 1.0, 1000.0}     //ton, kilogramm, gramm
                , new String[]{"ton","kilogramm","gramm"}
                , new double[]{1.0, 1000.0}     //liter, milliliter
                , new String[]{"liter","milliliter"}
                , 1.0                   //euro
                , "Euro"
                , true                 //Celsius
        );

        usData = new Countrycode(
                1                       //code
                , "United States of America"
                , new double[]{0.00062137, 1.09361, 3.28084, 39.3701}     //miles, yards, feet, inches
                , new String[]{"miles","yards","feet","inches"}
                , new double[] {2.20462, 35.274}    //pound, ounce
                , new String[]{"pound","ounce"}
                , new double[]{0.264172, 1.05669, 2.11338, 4.1667, 33.814}     //gallon, quart, pint, cup, fl. ounces
                , new String[]{"gallon","quart","pint","cup","fl. ounce"}
                , 1.057                  //dollar for one euro
                , "US Dollar"
                , false                 //not Celsius
        );
        ukData = new Countrycode(
                2                       //code
                , "United Kingdom"
                , new double[]{0.00062137, 1.09361, 3.28084, 39.3701}     //miles, yards, feet, inches
                , new String[]{"miles","yards","feet","inches"}
                , new double[] {0.001, 2.20462, 35.274}    //ton, pound, ounce
                , new String[]{"ton","pound","ounce"}
                , new double[]{0.219969, 0.879877, 1.75975, 3.51951, 35.1951}     //gallon, quart, pint, cup, fl. ounce
                , new String[]{"gallon","quart","pint","cup", "fl. ounce"}
                , 0.854                  //pound for one euro
                , "Pound Sterling"
                , true                 //Celsius
        );
    }


    //SETTER

    //TODO REWRITE
    public void setHomeAndTravelCountry(int chosenHome, int chosenTravel)
    {
        main.db.updateLastHomeAndTravel(chosenHome, chosenTravel);
    }

    public void setCheckedCategory(int checkedCategory)
    {
        this.checkedCategory = checkedCategory;
        resetSelectedRadio();
    }

    private void resetSelectedRadio()
    {
        selectedRadioHome = 0;
        selectedRadioTravel = 0;
        main.radioHome[0].setChecked(true);
        main.radioTravel[0].setChecked(true);
    }

    public void setSelectedRadioHome(int selectedRadioHome) {
        this.selectedRadioHome = selectedRadioHome;
    }

    public void setSelectedRadioTravel(int selectedRadioTravel) {
        this.selectedRadioTravel = selectedRadioTravel;
    }

    public void setFocusOnHome(boolean focusOnHome) {
        this.focusOnHome = focusOnHome;
    }


    //GETTER

    public Spinner getUnitInput()
    {
        return main.inputUnit;
    }

    public RadioButton[] getRadioHome() {
        return main.radioHome;
    }

    public RadioButton[] getRadioTravel() {
        return main.radioTravel;
    }

    public double getHomeExchangeRate()
    {
        return main.db.getSelectedUnits(main.db.selectLastHome(),checkedCategory).get(selectedRadioHome).calc_factor;
    }

    public double getTravelExchangeRate()
    {
        return main.db.getSelectedUnits(main.db.selectLastTravel(),checkedCategory).get(selectedRadioTravel).calc_factor;
    }

    public Countrycode getDataHome() {
        return dataHome;
    }

    public Countrycode getDataTravel() {
        return dataTravel;
    }

    public int getCheckedCategory() {
        return checkedCategory;
    }

    public boolean isFocusOnHome() {
        return focusOnHome;
    }

    public String[] getAllCountryNames()
    {
        String[] allCountryNames = new String[3];
        allCountryNames[0] = usData.getName();
        allCountryNames[1] = ukData.getName();
        allCountryNames[2] = euData.getName();
        return allCountryNames;
    }

    public void setAllCurrencies(double usd, double gbp)
    {
        usData.setCurrency(usd);
        ukData.setCurrency(gbp);
    }

    //TODO remove reliability on that method getRegioncode()
    public ArrayList<Unit> getHomeUnits() {
        return main.db.getSelectedUnits(main.db.selectLastHome(), checkedCategory);
    }

    public ArrayList<Unit> getTravelUnits() {
        return main.db.getSelectedUnits(main.db.selectLastTravel(), checkedCategory);
    }

    public int getSelectedRadioHome() {
        return selectedRadioHome;
    }

    public int getSelectedRadioTravel() {
        return selectedRadioTravel;
    }
}

