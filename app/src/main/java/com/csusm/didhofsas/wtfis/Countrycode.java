package com.csusm.didhofsas.wtfis;

import java.lang.reflect.Array;

public class Countrycode
{
    private int regioncode;
    private String name;
    private double[] length, weight, liquid;
    private String[] sLenghth, sWeight, sLiquid;
    private double currency;
    private String sCurrency;
    private boolean tempC;

    Countrycode(int regioncode, String name, double[] length, String[] sLenghth, double[] weight, String[] sWeight,
                double[] liquid, String[] sLiquid, double currency, String sCurrency, boolean tempC)
    {
        this.regioncode = regioncode;
        this.name = name;
        this.length = length;
        this.sLenghth = sLenghth;
        this.weight = weight;
        this.sWeight = sWeight;
        this.liquid = liquid;
        this.sLiquid = sLiquid;
        this.currency = currency;
        this.sCurrency = sCurrency;
        this.tempC = tempC;
    }

    public void setCurrency(double currency)
    {
        this.currency = currency;
    }

    public int getRegioncode() {
        return regioncode;
    }

    public double getCurrency() {
        return currency;
    }

    public String getCurrencyName() {
        return sCurrency;
    }

    public double[] getLength()
    {
        return length;
    }

    public String[] getLenghthName() {
        return sLenghth;
    }

    public double[] getWeight()
    {
        return weight;
    }

    public String[] getWeightName() {
        return sWeight;
    }

    public double[] getLiquid() {
        return liquid;
    }

    public String[] getLiquidName() {
        return sLiquid;
    }

    public boolean isTempC() {
        return tempC;
    }

    public String getName() {
        return name;
    }
}
