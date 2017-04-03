package com.csusm.didhofsas.wtfis;

import android.util.Log;
//Umrechnung, Zahl, Einheit, Einheit -> works
//Return Double Result
public class Conversion
{
    static double fixedconversion(double inputValue, double rate1, double rate2)
    {
        Log.i("Calc", inputValue + " x " + rate1 + " : " + rate2);
        return ((inputValue / rate1) * rate2);
    }

    static double celsiusToFahrenheit(double inputValue)
    {
        return inputValue*1.8+32;
    }

    static double fahrenheitToCelsius(double inputValue)
    {
        return (inputValue-32)/1.8;
    }
}
