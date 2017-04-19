package com.csusm.didhofsas.wtfis;

import android.util.Log;

public class Unit
{
    public int id;
    public String name;
    public double calc_factor;

    Unit(int id, String name, double calc_factor)
    {
        this.id = id;
        this.name = name;
        this.calc_factor = calc_factor;
        Log.i("CREATE_UNIT",+id+","+name + ", " + calc_factor);
    }
}
