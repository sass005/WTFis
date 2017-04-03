package com.csusm.didhofsas.wtfis;


public class DBCountryFragment
{
    private int id;
    private double currency;
    private boolean homeCountrySet;
    private boolean travelCountrySet;

    DBCountryFragment(int id, double currency, int homeCountrySet, int travelCountrySet)
    {
        this.id = id;
        this.currency = currency;
        if(homeCountrySet == 1)
            this.homeCountrySet = true;
        else
            this.travelCountrySet = false;
        if(travelCountrySet == 1)
            this.travelCountrySet = true;
        else
            this.travelCountrySet = false;
    }

    public int getId() {
        return id;
    }

    public double getCurrency() {
        return currency;
    }

    public boolean isHomeCountrySet() {
        return homeCountrySet;
    }

    public boolean isTravelCountrySet() {
        return travelCountrySet;
    }
}
