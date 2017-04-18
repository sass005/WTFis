

package com.csusm.didhofsas.wtfis;

import android.util.Log;
import android.widget.ArrayAdapter;


public class DatabaseTools {
    CountrycodeDataSource db;
    MainActivity main;

    public DatabaseTools(MainActivity main){
        this.main = main;

    }

    public void fillDatabase(){


        //new countrys
        main.db.createCountry(0, "Argentina", true);
        main.db.createCountry(1, "Austrailia", true);
        main.db.createCountry(2, "Austria", true);
        main.db.createCountry(3, "Belgium", true);
        main.db.createCountry(4, "Brazil", true);
        main.db.createCountry(5, "Canada", true);
        main.db.createCountry(6, "Chile", true);
        main.db.createCountry(7, "China", true);
        main.db.createCountry(8, "Croatia", true);
        main.db.createCountry(9, "Denmark", true);
        main.db.createCountry(10, "Finland", true);
        main.db.createCountry(11, "France", true);
        main.db.createCountry(12, "Germany", true);
        main.db.createCountry(13, "Greece", true);
        main.db.createCountry(14, "India", true);
        main.db.createCountry(15, "Italy", true);
        main.db.createCountry(16, "Japan", true);
        main.db.createCountry(17, "Netherlands", true);
        main.db.createCountry(18, "Norway", true);
        main.db.createCountry(19, "Poland", true);
        main.db.createCountry(20, "Portugal", true);
        main.db.createCountry(21, "Russia", true);
        main.db.createCountry(22, "South Africa", true);
        main.db.createCountry(23, "Spain", true);
        main.db.createCountry(24, "Sweden", true);
        main.db.createCountry(25, "Switzerland", true);
        main.db.createCountry(26, "Turkey", true);
        main.db.createCountry(27, "United Kingdom", true);
        main.db.createCountry(28, "United States of America", false);













        main.db.createUser(0);
        main.db.createMeasure(0, "Lenghth/ Distance");
        main.db.createMeasure(1, "Weight");
        main.db.createMeasure(2, "Liquids");
        main.db.createMeasure(3, "Currency");
        main.db.createMeasure(4, "Temperature");
        main.db.createUnit("kilometer", 0.001, 0);
        main.db.createUnit("meter", 1.0, 0);
        main.db.createUnit("centimeter", 100.0, 0);
        main.db.createUnit("millimeter", 1000.0, 0);
        main.db.createUnit("miles", 0.00062137, 0);
        main.db.createUnit("yards", 1.09361, 0);
        main.db.createUnit("feet", 3.28084, 0);
        main.db.createUnit("inches", 39.3701, 0);
        main.db.createUnit("ton", 0.001, 1);
        main.db.createUnit("kilogram", 1.0, 1);
        main.db.createUnit("gram", 1000.0, 1);
        main.db.createUnit("pound", 2.20462,1);
        main.db.createUnit("ounce", 35.274,1);
        main.db.createUnit("liter", 1.0, 2);
        main.db.createUnit("milliliter", 1000.0, 2);
        //TODO THINK ABOUT REMOVING (country) before showing in APP
        main.db.createUnit("gallon (us)", 0.264172, 2);
        main.db.createUnit("quart (us)", 1.05669, 2);
        main.db.createUnit("pint (us)", 2.11338,2);
        main.db.createUnit("cup (us)", 4.1667, 2);
        main.db.createUnit("fl. ounce (us)", 33.814, 2);
        main.db.createUnit("gallon (uk)", 0.219969, 2);
        main.db.createUnit("quart (uk)", 0.879877, 2);
        main.db.createUnit("pint (uk)", 1.75975, 2);
        main.db.createUnit("cup (uk)", 3.51951, 2);
        main.db.createUnit("fl. ounce (uk)", 35.1951, 2);
        main.db.createCurrency("euro", "EUR", 1.0);
        main.db.createCurrency("argentinian peso","ARS", 0);//not working
        main.db.createCurrency("australian dollar","AUD",1.4027);
        main.db.createCurrency("brazilian real","BRL",3.3277);
        main.db.createCurrency("canadian dollar","CAD",1.4069);
        main.db.createCurrency("chilenian peso","CLP", 0);//not working
        main.db.createCurrency("swiss frank","CHF",1.0686);
        main.db.createCurrency("yuan renminbi","CNY",7.3227);
        main.db.createCurrency("danish crown","DKK",7.4376);
        main.db.createCurrency("pound sterling", "GBP", 0.854);
        main.db.createCurrency("rupie","INR",68.492);
        main.db.createCurrency("yen","JPY",116.01);
        main.db.createCurrency("new peso","MXN",19.766);
        main.db.createCurrency("norwegian crown","NOK",9.1033);
        main.db.createCurrency("zloty","PLZ", 0);//not working
        main.db.createCurrency("rubel","RUR", 0);//not working
        main.db.createCurrency("swedish crown","SEK",9.582);
        main.db.createCurrency("lira","TRL", 0);//not working
        main.db.createCurrency("us dollar", "USD", 1.057);
        main.db.createCurrency("rant","ZAR",14.38);
        main.db.createUnit("celsius", 1.0, 4);
        main.db.createUnit("fahrenheit", 0.0, 4);


        //new country
        //Argentina
        main.db.linkCountryUnit(0, "kilometer");
        main.db.linkCountryUnit(0, "meter");
        main.db.linkCountryUnit(0, "centimeter");
        main.db.linkCountryUnit(0, "millimeter");
        main.db.linkCountryUnit(0, "ton");
        main.db.linkCountryUnit(0, "kilogram");
        main.db.linkCountryUnit(0, "gram");
        main.db.linkCountryUnit(0, "liter");
        main.db.linkCountryUnit(0, "milliliter");
        main.db.linkCountryUnit(0, "argentina peso");
        main.db.linkCountryUnit(0, "celsius");
        //Austrailia
        main.db.linkCountryUnit(1, "kilometer");
        main.db.linkCountryUnit(1, "meter");
        main.db.linkCountryUnit(1, "centimeter");
        main.db.linkCountryUnit(1, "millimeter");
        main.db.linkCountryUnit(1, "ton");
        main.db.linkCountryUnit(1, "kilogram");
        main.db.linkCountryUnit(1, "gram");
        main.db.linkCountryUnit(1, "liter");
        main.db.linkCountryUnit(1, "milliliter");
        main.db.linkCountryUnit(1, "austailian dollar");
        main.db.linkCountryUnit(1, "celsius");
        //Austria
        main.db.linkCountryUnit(2, "kilometer");
        main.db.linkCountryUnit(2, "meter");
        main.db.linkCountryUnit(2, "centimeter");
        main.db.linkCountryUnit(2, "millimeter");
        main.db.linkCountryUnit(2, "ton");
        main.db.linkCountryUnit(2, "kilogram");
        main.db.linkCountryUnit(2, "gram");
        main.db.linkCountryUnit(2, "liter");
        main.db.linkCountryUnit(2, "milliliter");
        main.db.linkCountryUnit(2, "euro");
        main.db.linkCountryUnit(2, "celsius");
        //Belgium
        main.db.linkCountryUnit(3, "kilometer");
        main.db.linkCountryUnit(3, "meter");
        main.db.linkCountryUnit(3, "centimeter");
        main.db.linkCountryUnit(3, "millimeter");
        main.db.linkCountryUnit(3, "ton");
        main.db.linkCountryUnit(3, "kilogram");
        main.db.linkCountryUnit(3, "gram");
        main.db.linkCountryUnit(3, "liter");
        main.db.linkCountryUnit(3, "milliliter");
        main.db.linkCountryUnit(3, "euro");
        main.db.linkCountryUnit(3, "celsius");
        //Brazil
        main.db.linkCountryUnit(4, "kilometer");
        main.db.linkCountryUnit(4, "meter");
        main.db.linkCountryUnit(4, "centimeter");
        main.db.linkCountryUnit(4, "millimeter");
        main.db.linkCountryUnit(4, "ton");
        main.db.linkCountryUnit(4, "kilogram");
        main.db.linkCountryUnit(4, "gram");
        main.db.linkCountryUnit(4, "liter");
        main.db.linkCountryUnit(4, "milliliter");
        main.db.linkCountryUnit(4, "brazil real");
        main.db.linkCountryUnit(4, "celsius");
        //Canada
        main.db.linkCountryUnit(5, "kilometer");
        main.db.linkCountryUnit(5, "meter");
        main.db.linkCountryUnit(5, "centimeter");
        main.db.linkCountryUnit(5, "millimeter");
        main.db.linkCountryUnit(5, "ton");
        main.db.linkCountryUnit(5, "kilogram");
        main.db.linkCountryUnit(5, "gram");
        main.db.linkCountryUnit(5, "liter");
        main.db.linkCountryUnit(5, "milliliter");
        main.db.linkCountryUnit(5, "canadian dollar");
        main.db.linkCountryUnit(5, "celsius");
        //Chile
        main.db.linkCountryUnit(6, "kilometer");
        main.db.linkCountryUnit(6, "meter");
        main.db.linkCountryUnit(6, "centimeter");
        main.db.linkCountryUnit(6, "millimeter");
        main.db.linkCountryUnit(6, "ton");
        main.db.linkCountryUnit(6, "kilogram");
        main.db.linkCountryUnit(6, "gram");
        main.db.linkCountryUnit(6, "liter");
        main.db.linkCountryUnit(6, "milliliter");
        main.db.linkCountryUnit(6, "chile peso");
        main.db.linkCountryUnit(6, "celsius");
        //China
        main.db.linkCountryUnit(7, "kilometer");
        main.db.linkCountryUnit(7, "meter");
        main.db.linkCountryUnit(7, "centimeter");
        main.db.linkCountryUnit(7, "millimeter");
        main.db.linkCountryUnit(7, "ton");
        main.db.linkCountryUnit(7, "kilogram");
        main.db.linkCountryUnit(7, "gram");
        main.db.linkCountryUnit(7, "liter");
        main.db.linkCountryUnit(7, "milliliter");
        main.db.linkCountryUnit(7, "euro");
        main.db.linkCountryUnit(7, "celsius");
        //Croatia
        main.db.linkCountryUnit(8, "kilometer");
        main.db.linkCountryUnit(8, "meter");
        main.db.linkCountryUnit(8, "centimeter");
        main.db.linkCountryUnit(8, "millimeter");
        main.db.linkCountryUnit(8, "ton");
        main.db.linkCountryUnit(8, "kilogram");
        main.db.linkCountryUnit(8, "gram");
        main.db.linkCountryUnit(8, "liter");
        main.db.linkCountryUnit(8, "milliliter");
        main.db.linkCountryUnit(8, "euro");
        main.db.linkCountryUnit(8, "celsius");
        //Denmark
        main.db.linkCountryUnit(9, "kilometer");
        main.db.linkCountryUnit(9, "meter");
        main.db.linkCountryUnit(9, "centimeter");
        main.db.linkCountryUnit(9, "millimeter");
        main.db.linkCountryUnit(9, "ton");
        main.db.linkCountryUnit(9, "kilogram");
        main.db.linkCountryUnit(9, "gram");
        main.db.linkCountryUnit(9, "liter");
        main.db.linkCountryUnit(9, "milliliter");
        main.db.linkCountryUnit(9, "Danishe Crones");
        main.db.linkCountryUnit(9, "celsius");
        //Finland
        main.db.linkCountryUnit(10, "kilometer");
        main.db.linkCountryUnit(10, "meter");
        main.db.linkCountryUnit(10, "centimeter");
        main.db.linkCountryUnit(10, "millimeter");
        main.db.linkCountryUnit(10, "ton");
        main.db.linkCountryUnit(10, "kilogram");
        main.db.linkCountryUnit(10, "gram");
        main.db.linkCountryUnit(10, "liter");
        main.db.linkCountryUnit(10, "milliliter");
        main.db.linkCountryUnit(10, "euro");
        main.db.linkCountryUnit(10, "celsius");
        //France
        main.db.linkCountryUnit(11, "kilometer");
        main.db.linkCountryUnit(11, "meter");
        main.db.linkCountryUnit(11, "centimeter");
        main.db.linkCountryUnit(11, "millimeter");
        main.db.linkCountryUnit(11, "ton");
        main.db.linkCountryUnit(11, "kilogram");
        main.db.linkCountryUnit(11, "gram");
        main.db.linkCountryUnit(11, "liter");
        main.db.linkCountryUnit(11, "milliliter");
        main.db.linkCountryUnit(11, "euro");
        main.db.linkCountryUnit(11, "celsius");
        //Germany
        main.db.linkCountryUnit(12, "kilometer");
        main.db.linkCountryUnit(12, "meter");
        main.db.linkCountryUnit(12, "centimeter");
        main.db.linkCountryUnit(12, "millimeter");
        main.db.linkCountryUnit(12, "ton");
        main.db.linkCountryUnit(12, "kilogram");
        main.db.linkCountryUnit(12, "gram");
        main.db.linkCountryUnit(12, "liter");
        main.db.linkCountryUnit(12, "milliliter");
        main.db.linkCountryUnit(12, "euro");
        main.db.linkCountryUnit(12, "celsius");
        //Greece
        main.db.linkCountryUnit(13, "kilometer");
        main.db.linkCountryUnit(13, "meter");
        main.db.linkCountryUnit(13, "centimeter");
        main.db.linkCountryUnit(13, "millimeter");
        main.db.linkCountryUnit(13, "ton");
        main.db.linkCountryUnit(13, "kilogram");
        main.db.linkCountryUnit(13, "gram");
        main.db.linkCountryUnit(13, "liter");
        main.db.linkCountryUnit(13, "milliliter");
        main.db.linkCountryUnit(13, "euro");
        main.db.linkCountryUnit(13, "celsius");
        //India
        main.db.linkCountryUnit(14, "kilometer");
        main.db.linkCountryUnit(14, "meter");
        main.db.linkCountryUnit(14, "centimeter");
        main.db.linkCountryUnit(14, "millimeter");
        main.db.linkCountryUnit(14, "ton");
        main.db.linkCountryUnit(14, "kilogram");
        main.db.linkCountryUnit(14, "gram");
        main.db.linkCountryUnit(14, "liter");
        main.db.linkCountryUnit(14, "milliliter");
        main.db.linkCountryUnit(14, "indian rupee");
        main.db.linkCountryUnit(14, "celsius");
        //Italy
        main.db.linkCountryUnit(15, "kilometer");
        main.db.linkCountryUnit(15, "meter");
        main.db.linkCountryUnit(15, "centimeter");
        main.db.linkCountryUnit(15, "millimeter");
        main.db.linkCountryUnit(15, "ton");
        main.db.linkCountryUnit(15, "kilogram");
        main.db.linkCountryUnit(15, "gram");
        main.db.linkCountryUnit(15, "liter");
        main.db.linkCountryUnit(15, "milliliter");
        main.db.linkCountryUnit(15, "euro");
        main.db.linkCountryUnit(15, "celsius");
        //Japan
        main.db.linkCountryUnit(16, "kilometer");
        main.db.linkCountryUnit(16, "meter");
        main.db.linkCountryUnit(16, "centimeter");
        main.db.linkCountryUnit(16, "millimeter");
        main.db.linkCountryUnit(16, "ton");
        main.db.linkCountryUnit(16, "kilogram");
        main.db.linkCountryUnit(16, "gram");
        main.db.linkCountryUnit(16, "liter");
        main.db.linkCountryUnit(16, "milliliter");
        main.db.linkCountryUnit(16, "yen");
        main.db.linkCountryUnit(16, "celsius");
        //Netherlands
        main.db.linkCountryUnit(17, "kilometer");
        main.db.linkCountryUnit(17, "meter");
        main.db.linkCountryUnit(17, "centimeter");
        main.db.linkCountryUnit(17, "millimeter");
        main.db.linkCountryUnit(17, "ton");
        main.db.linkCountryUnit(17, "kilogram");
        main.db.linkCountryUnit(17, "gram");
        main.db.linkCountryUnit(17, "liter");
        main.db.linkCountryUnit(17, "milliliter");
        main.db.linkCountryUnit(17, "euro");
        main.db.linkCountryUnit(17, "celsius");
        //Norway
        main.db.linkCountryUnit(18, "kilometer");
        main.db.linkCountryUnit(18, "meter");
        main.db.linkCountryUnit(18, "centimeter");
        main.db.linkCountryUnit(18, "millimeter");
        main.db.linkCountryUnit(18, "ton");
        main.db.linkCountryUnit(18, "kilogram");
        main.db.linkCountryUnit(18, "gram");
        main.db.linkCountryUnit(18, "liter");
        main.db.linkCountryUnit(18, "milliliter");
        main.db.linkCountryUnit(18, "norwegian krone");
        main.db.linkCountryUnit(18, "celsius");
        //Poland
        main.db.linkCountryUnit(19, "kilometer");
        main.db.linkCountryUnit(19, "meter");
        main.db.linkCountryUnit(19, "centimeter");
        main.db.linkCountryUnit(19, "millimeter");
        main.db.linkCountryUnit(19, "ton");
        main.db.linkCountryUnit(19, "kilogram");
        main.db.linkCountryUnit(19, "gram");
        main.db.linkCountryUnit(19, "liter");
        main.db.linkCountryUnit(19, "milliliter");
        main.db.linkCountryUnit(19, "slotti");
        main.db.linkCountryUnit(19, "celsius");
        //Portugal
        main.db.linkCountryUnit(20, "kilometer");
        main.db.linkCountryUnit(20, "meter");
        main.db.linkCountryUnit(20, "centimeter");
        main.db.linkCountryUnit(20, "millimeter");
        main.db.linkCountryUnit(20, "ton");
        main.db.linkCountryUnit(20, "kilogram");
        main.db.linkCountryUnit(20, "gram");
        main.db.linkCountryUnit(20, "liter");
        main.db.linkCountryUnit(20, "milliliter");
        main.db.linkCountryUnit(20, "euro");
        main.db.linkCountryUnit(20, "celsius");
        //Russia
        main.db.linkCountryUnit(21, "kilometer");
        main.db.linkCountryUnit(21, "meter");
        main.db.linkCountryUnit(21, "centimeter");
        main.db.linkCountryUnit(21, "millimeter");
        main.db.linkCountryUnit(21, "ton");
        main.db.linkCountryUnit(21, "kilogram");
        main.db.linkCountryUnit(21, "gram");
        main.db.linkCountryUnit(21, "liter");
        main.db.linkCountryUnit(21, "milliliter");
        main.db.linkCountryUnit(21, "russion ruble");
        main.db.linkCountryUnit(21, "celsius");
        //South Africa
        main.db.linkCountryUnit(22, "kilometer");
        main.db.linkCountryUnit(22, "meter");
        main.db.linkCountryUnit(22, "centimeter");
        main.db.linkCountryUnit(22, "millimeter");
        main.db.linkCountryUnit(22, "ton");
        main.db.linkCountryUnit(22, "kilogram");
        main.db.linkCountryUnit(22, "gram");
        main.db.linkCountryUnit(22, "liter");
        main.db.linkCountryUnit(22, "milliliter");
        main.db.linkCountryUnit(22, "south africa rand");
        main.db.linkCountryUnit(22, "celsius");
        //Spain
        main.db.linkCountryUnit(23, "kilometer");
        main.db.linkCountryUnit(23, "meter");
        main.db.linkCountryUnit(23, "centimeter");
        main.db.linkCountryUnit(23, "millimeter");
        main.db.linkCountryUnit(23, "ton");
        main.db.linkCountryUnit(23, "kilogram");
        main.db.linkCountryUnit(23, "gram");
        main.db.linkCountryUnit(23, "liter");
        main.db.linkCountryUnit(23, "milliliter");
        main.db.linkCountryUnit(23, "euro");
        main.db.linkCountryUnit(23, "celsius");
        //Sweden
        main.db.linkCountryUnit(24, "kilometer");
        main.db.linkCountryUnit(24, "meter");
        main.db.linkCountryUnit(24, "centimeter");
        main.db.linkCountryUnit(24, "millimeter");
        main.db.linkCountryUnit(24, "ton");
        main.db.linkCountryUnit(24, "kilogram");
        main.db.linkCountryUnit(24, "gram");
        main.db.linkCountryUnit(24, "liter");
        main.db.linkCountryUnit(24, "milliliter");
        main.db.linkCountryUnit(24, "Sweeden Krones");
        main.db.linkCountryUnit(24, "celsius");
        //Switzerland
        main.db.linkCountryUnit(25, "kilometer");
        main.db.linkCountryUnit(25, "meter");
        main.db.linkCountryUnit(25, "centimeter");
        main.db.linkCountryUnit(25, "millimeter");
        main.db.linkCountryUnit(25, "ton");
        main.db.linkCountryUnit(25, "kilogram");
        main.db.linkCountryUnit(25, "gram");
        main.db.linkCountryUnit(25, "liter");
        main.db.linkCountryUnit(25, "milliliter");
        main.db.linkCountryUnit(25, "Swiss Franc");
        main.db.linkCountryUnit(25, "celsius");
        //Turkey
        main.db.linkCountryUnit(26, "kilometer");
        main.db.linkCountryUnit(26, "meter");
        main.db.linkCountryUnit(26, "centimeter");
        main.db.linkCountryUnit(26, "millimeter");
        main.db.linkCountryUnit(26, "ton");
        main.db.linkCountryUnit(26, "kilogram");
        main.db.linkCountryUnit(26, "gram");
        main.db.linkCountryUnit(26, "liter");
        main.db.linkCountryUnit(26, "milliliter");
        main.db.linkCountryUnit(26, "turkish lira");
        main.db.linkCountryUnit(26, "celsius");
        //UK
        main.db.linkCountryUnit(27, "miles");
        main.db.linkCountryUnit(27, "yards");
        main.db.linkCountryUnit(27, "feet");
        main.db.linkCountryUnit(27, "inches");
        main.db.linkCountryUnit(27, "ton");
        main.db.linkCountryUnit(27, "pound");
        main.db.linkCountryUnit(27, "ounce");
        main.db.linkCountryUnit(27, "gallon (uk)");
        main.db.linkCountryUnit(27, "quart (uk)");
        main.db.linkCountryUnit(27, "pint (uk)");
        main.db.linkCountryUnit(27, "cup (uk)");
        main.db.linkCountryUnit(27, "fl. ounce (uk)");
        main.db.linkCountryUnit(27, "pound sterling");
        main.db.linkCountryUnit(27, "celsius");
        //US
        main.db.linkCountryUnit(28, "miles");
        main.db.linkCountryUnit(28, "yards");
        main.db.linkCountryUnit(28, "feet");
        main.db.linkCountryUnit(28, "inches");
        main.db.linkCountryUnit(28, "pound");
        main.db.linkCountryUnit(28, "ounce");
        main.db.linkCountryUnit(28, "gallon (us)");
        main.db.linkCountryUnit(28, "quart (us)");
        main.db.linkCountryUnit(28, "pint (us)");
        main.db.linkCountryUnit(28, "cup (us)");
        main.db.linkCountryUnit(28, "fl. ounce (us)");
        main.db.linkCountryUnit(28, "us dollar");
        main.db.linkCountryUnit(28, "fahrenheit");




        main.db.selectAllFromTable(CountrycodeDBHelper.COUNTRY_TABLE, CountrycodeDataSource.COUNTRY_COLUMNS);
        main.db.selectAllFromTable(CountrycodeDBHelper.UNIT_TABLE, CountrycodeDataSource.UNIT_COLUMNS);
        main.db.selectAllFromTable(CountrycodeDBHelper.APPUSER_TABLE, CountrycodeDataSource.USER_COLUMNS);
        main.db.selectAllFromTable(CountrycodeDBHelper.MEASURE_TABLE, CountrycodeDataSource.MEASURE_COLUMNS);
        main.db.selectAllFromTable(CountrycodeDBHelper.CURRENCY_TABLE, CountrycodeDataSource.CURRENCY_COLUMNS);
        main.db.selectAllFromTable(CountrycodeDBHelper.COUNTRY_UNIT_TABLE, CountrycodeDataSource.COUNTRY_USER_COLUMNS);


    }
}

