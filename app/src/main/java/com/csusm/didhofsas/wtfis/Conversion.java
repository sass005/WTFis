package com.csusm.didhofsas.wtfis;

import android.util.Log;
import android.widget.Toast;

import java.text.DecimalFormat;

//Umrechnung, Zahl, Einheit, Einheit -> works
//Return Double Result
public class Conversion
{
    static double fixedconversion(double inputValue, double rate1, double rate2)
    {
        if (rate1 == 0.0 || rate2 == 0.0)
        {
            return -1;
        }
        Log.i("Calc", inputValue + " x " + rate1 + " : " + rate2);
        return (inputValue / rate1) * rate2;
    }

    static double celsiusToFahrenheit(double inputValue)
    {
        return inputValue*1.8+32;
    }

    static double fahrenheitToCelsius(double inputValue)
    {
        return (inputValue-32)/1.8;
    }
    private static DecimalFormat customDecimalFormat(double sol)
    {
        if(sol > 0.0001) {
            return  new DecimalFormat("0.####");
        }else{
            return new DecimalFormat ("0.0000E0");
        }
    }
}
