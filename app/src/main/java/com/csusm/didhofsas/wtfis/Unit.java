package com.csusm.didhofsas.wtfis;

import android.util.Log;

public class Unit
{
    public String name;
    public double calc_factor;

    Unit(String name, double calc_factor)
    {
        this.name = name;
        this.calc_factor = calc_factor;
        Log.i("CREATE_UNIT",name + ", " + calc_factor);
    }
}
