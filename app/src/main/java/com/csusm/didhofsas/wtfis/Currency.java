package com.csusm.didhofsas.wtfis;

public class Currency
{
    public String shortname;
    public double conversion_rate;
    public Currency(String shortname, double conversion_rate)
    {
        this.shortname = shortname;
        this.conversion_rate = conversion_rate;
    }
}
