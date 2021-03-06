

package com.csusm.didhofsas.wtfis;


public class DatabaseTools
{
    CountrycodeDataSource db;
    public static boolean newDBCreated = false;

    public DatabaseTools(MainActivity main)
    {
        db = main.db;
    }

    public void fillDatabaseIfNotExists()
    {
        if (newDBCreated)
            fillDatabase();
        selectAll();
    }

    private void fillDatabase(){

        //new countrys
        db.createCountry(0, "Argentina", true);
        db.createCountry(1, "Australia", true);
        db.createCountry(2, "Austria", true);
        db.createCountry(3, "Belgium", true);
        db.createCountry(4, "Brazil", true);
        db.createCountry(5, "Canada", true);
        db.createCountry(6, "Chile", true);
        db.createCountry(7, "China", true);
        db.createCountry(8, "Croatia", true);
        db.createCountry(9, "Denmark", true);
        db.createCountry(10, "Finland", true);
        db.createCountry(11, "France", true);
        db.createCountry(12, "Germany", true);
        db.createCountry(13, "Greece", true);
        db.createCountry(14, "India", true);
        db.createCountry(15, "Italy", true);
        db.createCountry(16, "Japan", true);
        db.createCountry(17, "Netherlands", true);
        db.createCountry(18, "Norway", true);
        db.createCountry(19, "Poland", true);
        db.createCountry(20, "Portugal", true);
        db.createCountry(21, "Russia", true);
        db.createCountry(22, "South Africa", true);
        db.createCountry(23, "Spain", true);
        db.createCountry(24, "Sweden", true);
        db.createCountry(25, "Switzerland", true);
        db.createCountry(26, "Turkey", true);
        db.createCountry(27, "United Kingdom", true);
        db.createCountry(28, "United States of America", false);

        db.createUser(0);

        db.createMeasure(0, "Lenghth/ Distance");
        db.createMeasure(1, "Weight");
        db.createMeasure(2, "Liquids");
        db.createMeasure(3, "Currency");
        db.createMeasure(4, "Temperature");

        db.createUnit("kilometer", 0.001, 0);
        db.createUnit("meter", 1.0, 0);
        db.createUnit("centimeter", 100.0, 0);
        db.createUnit("millimeter", 1000.0, 0);
        db.createUnit("miles", 0.00062137, 0);
        db.createUnit("yards", 1.09361, 0);
        db.createUnit("feet", 3.28084, 0);
        db.createUnit("inches", 39.3701, 0);
        db.createUnit("ton", 0.001, 1);
        db.createUnit("kilogram", 1.0, 1);
        db.createUnit("gram", 1000.0, 1);
        db.createUnit("pound", 2.20462,1);
        db.createUnit("ounce", 35.274,1);
        db.createUnit("liter", 1.0, 2);
        db.createUnit("milliliter", 1000.0, 2);
        //TODO THINK ABOUT REMOVING (country) before showing in APP
        db.createUnit("gallon (us)", 0.264172, 2);
        db.createUnit("quart (us)", 1.05669, 2);
        db.createUnit("pint (us)", 2.11338,2);
        db.createUnit("cup (us)", 4.1667, 2);
        db.createUnit("fl. ounce (us)", 33.814, 2);
        db.createUnit("gallon (uk)", 0.219969, 2);
        db.createUnit("quart (uk)", 0.879877, 2);
        db.createUnit("pint (uk)", 1.75975, 2);
        db.createUnit("cup (uk)", 3.51951, 2);
        db.createUnit("fl. ounce (uk)", 35.1951, 2);
        db.createCurrency("euro", "EUR", 1.0);
        db.createCurrency("argentinian peso","ARS");//not working
        db.createCurrency("australian dollar","AUD");
        db.createCurrency("brazilian real","BRL");
        db.createCurrency("canadian dollar","CAD");
        db.createCurrency("chilenian peso","CLP");//not working
        db.createCurrency("swiss frank","CHF");
        db.createCurrency("yuan renminbi","CNY");
        db.createCurrency("danish crones","DKK");
        db.createCurrency("pound sterling", "GBP");
        db.createCurrency("indian rupee","INR");
        db.createCurrency("yen","JPY");
        db.createCurrency("new peso","MXN");
        db.createCurrency("norwegian crones","NOK");
        db.createCurrency("zloty","PLN");
        db.createCurrency("russian rubel","RUB");
        db.createCurrency("swedish crones","SEK");
        db.createCurrency("turkish lira","TRY");
        db.createCurrency("us dollar", "USD");
        db.createCurrency("south african rand","ZAR");
        db.createUnit("celsius", 1.0, 4);
        db.createUnit("fahrenheit", 0.0, 4);


        //new country
        //Argentina
        db.linkCountryUnit(0, "kilometer");
        db.linkCountryUnit(0, "meter");
        db.linkCountryUnit(0, "centimeter");
        db.linkCountryUnit(0, "millimeter");
        db.linkCountryUnit(0, "ton");
        db.linkCountryUnit(0, "kilogram");
        db.linkCountryUnit(0, "gram");
        db.linkCountryUnit(0, "liter");
        db.linkCountryUnit(0, "milliliter");
        db.linkCountryUnit(0, "argentinian peso");
        db.linkCountryUnit(0, "celsius");
        //Austrailia
        db.linkCountryUnit(1, "kilometer");
        db.linkCountryUnit(1, "meter");
        db.linkCountryUnit(1, "centimeter");
        db.linkCountryUnit(1, "millimeter");
        db.linkCountryUnit(1, "ton");
        db.linkCountryUnit(1, "kilogram");
        db.linkCountryUnit(1, "gram");
        db.linkCountryUnit(1, "liter");
        db.linkCountryUnit(1, "milliliter");
        db.linkCountryUnit(1, "australian dollar");
        db.linkCountryUnit(1, "celsius");
        //Austria
        db.linkCountryUnit(2, "kilometer");
        db.linkCountryUnit(2, "meter");
        db.linkCountryUnit(2, "centimeter");
        db.linkCountryUnit(2, "millimeter");
        db.linkCountryUnit(2, "ton");
        db.linkCountryUnit(2, "kilogram");
        db.linkCountryUnit(2, "gram");
        db.linkCountryUnit(2, "liter");
        db.linkCountryUnit(2, "milliliter");
        db.linkCountryUnit(2, "euro");
        db.linkCountryUnit(2, "celsius");
        //Belgium
        db.linkCountryUnit(3, "kilometer");
        db.linkCountryUnit(3, "meter");
        db.linkCountryUnit(3, "centimeter");
        db.linkCountryUnit(3, "millimeter");
        db.linkCountryUnit(3, "ton");
        db.linkCountryUnit(3, "kilogram");
        db.linkCountryUnit(3, "gram");
        db.linkCountryUnit(3, "liter");
        db.linkCountryUnit(3, "milliliter");
        db.linkCountryUnit(3, "euro");
        db.linkCountryUnit(3, "celsius");
        //Brazil
        db.linkCountryUnit(4, "kilometer");
        db.linkCountryUnit(4, "meter");
        db.linkCountryUnit(4, "centimeter");
        db.linkCountryUnit(4, "millimeter");
        db.linkCountryUnit(4, "ton");
        db.linkCountryUnit(4, "kilogram");
        db.linkCountryUnit(4, "gram");
        db.linkCountryUnit(4, "liter");
        db.linkCountryUnit(4, "milliliter");
        db.linkCountryUnit(4, "brazilian real");
        db.linkCountryUnit(4, "celsius");
        //Canada
        db.linkCountryUnit(5, "kilometer");
        db.linkCountryUnit(5, "meter");
        db.linkCountryUnit(5, "centimeter");
        db.linkCountryUnit(5, "millimeter");
        db.linkCountryUnit(5, "ton");
        db.linkCountryUnit(5, "kilogram");
        db.linkCountryUnit(5, "gram");
        db.linkCountryUnit(5, "liter");
        db.linkCountryUnit(5, "milliliter");
        db.linkCountryUnit(5, "canadian dollar");
        db.linkCountryUnit(5, "celsius");
        //Chile
        db.linkCountryUnit(6, "kilometer");
        db.linkCountryUnit(6, "meter");
        db.linkCountryUnit(6, "centimeter");
        db.linkCountryUnit(6, "millimeter");
        db.linkCountryUnit(6, "ton");
        db.linkCountryUnit(6, "kilogram");
        db.linkCountryUnit(6, "gram");
        db.linkCountryUnit(6, "liter");
        db.linkCountryUnit(6, "milliliter");
        db.linkCountryUnit(6, "chilenian peso");
        db.linkCountryUnit(6, "celsius");
        //China
        db.linkCountryUnit(7, "kilometer");
        db.linkCountryUnit(7, "meter");
        db.linkCountryUnit(7, "centimeter");
        db.linkCountryUnit(7, "millimeter");
        db.linkCountryUnit(7, "ton");
        db.linkCountryUnit(7, "kilogram");
        db.linkCountryUnit(7, "gram");
        db.linkCountryUnit(7, "liter");
        db.linkCountryUnit(7, "milliliter");
        db.linkCountryUnit(7, "yuan renminbi");
        db.linkCountryUnit(7, "celsius");
        //Croatia
        db.linkCountryUnit(8, "kilometer");
        db.linkCountryUnit(8, "meter");
        db.linkCountryUnit(8, "centimeter");
        db.linkCountryUnit(8, "millimeter");
        db.linkCountryUnit(8, "ton");
        db.linkCountryUnit(8, "kilogram");
        db.linkCountryUnit(8, "gram");
        db.linkCountryUnit(8, "liter");
        db.linkCountryUnit(8, "milliliter");
        db.linkCountryUnit(8, "euro");
        db.linkCountryUnit(8, "celsius");
        //Denmark
        db.linkCountryUnit(9, "kilometer");
        db.linkCountryUnit(9, "meter");
        db.linkCountryUnit(9, "centimeter");
        db.linkCountryUnit(9, "millimeter");
        db.linkCountryUnit(9, "ton");
        db.linkCountryUnit(9, "kilogram");
        db.linkCountryUnit(9, "gram");
        db.linkCountryUnit(9, "liter");
        db.linkCountryUnit(9, "milliliter");
        db.linkCountryUnit(9, "danish crones");
        db.linkCountryUnit(9, "celsius");
        //Finland
        db.linkCountryUnit(10, "kilometer");
        db.linkCountryUnit(10, "meter");
        db.linkCountryUnit(10, "centimeter");
        db.linkCountryUnit(10, "millimeter");
        db.linkCountryUnit(10, "ton");
        db.linkCountryUnit(10, "kilogram");
        db.linkCountryUnit(10, "gram");
        db.linkCountryUnit(10, "liter");
        db.linkCountryUnit(10, "milliliter");
        db.linkCountryUnit(10, "euro");
        db.linkCountryUnit(10, "celsius");
        //France
        db.linkCountryUnit(11, "kilometer");
        db.linkCountryUnit(11, "meter");
        db.linkCountryUnit(11, "centimeter");
        db.linkCountryUnit(11, "millimeter");
        db.linkCountryUnit(11, "ton");
        db.linkCountryUnit(11, "kilogram");
        db.linkCountryUnit(11, "gram");
        db.linkCountryUnit(11, "liter");
        db.linkCountryUnit(11, "milliliter");
        db.linkCountryUnit(11, "euro");
        db.linkCountryUnit(11, "celsius");
        //Germany
        db.linkCountryUnit(12, "kilometer");
        db.linkCountryUnit(12, "meter");
        db.linkCountryUnit(12, "centimeter");
        db.linkCountryUnit(12, "millimeter");
        db.linkCountryUnit(12, "ton");
        db.linkCountryUnit(12, "kilogram");
        db.linkCountryUnit(12, "gram");
        db.linkCountryUnit(12, "liter");
        db.linkCountryUnit(12, "milliliter");
        db.linkCountryUnit(12, "euro");
        db.linkCountryUnit(12, "celsius");
        //Greece
        db.linkCountryUnit(13, "kilometer");
        db.linkCountryUnit(13, "meter");
        db.linkCountryUnit(13, "centimeter");
        db.linkCountryUnit(13, "millimeter");
        db.linkCountryUnit(13, "ton");
        db.linkCountryUnit(13, "kilogram");
        db.linkCountryUnit(13, "gram");
        db.linkCountryUnit(13, "liter");
        db.linkCountryUnit(13, "milliliter");
        db.linkCountryUnit(13, "euro");
        db.linkCountryUnit(13, "celsius");
        //India
        db.linkCountryUnit(14, "kilometer");
        db.linkCountryUnit(14, "meter");
        db.linkCountryUnit(14, "centimeter");
        db.linkCountryUnit(14, "millimeter");
        db.linkCountryUnit(14, "ton");
        db.linkCountryUnit(14, "kilogram");
        db.linkCountryUnit(14, "gram");
        db.linkCountryUnit(14, "liter");
        db.linkCountryUnit(14, "milliliter");
        db.linkCountryUnit(14, "indian rupee");
        db.linkCountryUnit(14, "celsius");
        //Italy
        db.linkCountryUnit(15, "kilometer");
        db.linkCountryUnit(15, "meter");
        db.linkCountryUnit(15, "centimeter");
        db.linkCountryUnit(15, "millimeter");
        db.linkCountryUnit(15, "ton");
        db.linkCountryUnit(15, "kilogram");
        db.linkCountryUnit(15, "gram");
        db.linkCountryUnit(15, "liter");
        db.linkCountryUnit(15, "milliliter");
        db.linkCountryUnit(15, "euro");
        db.linkCountryUnit(15, "celsius");
        //Japan
        db.linkCountryUnit(16, "kilometer");
        db.linkCountryUnit(16, "meter");
        db.linkCountryUnit(16, "centimeter");
        db.linkCountryUnit(16, "millimeter");
        db.linkCountryUnit(16, "ton");
        db.linkCountryUnit(16, "kilogram");
        db.linkCountryUnit(16, "gram");
        db.linkCountryUnit(16, "liter");
        db.linkCountryUnit(16, "milliliter");
        db.linkCountryUnit(16, "yen");
        db.linkCountryUnit(16, "celsius");
        //Netherlands
        db.linkCountryUnit(17, "kilometer");
        db.linkCountryUnit(17, "meter");
        db.linkCountryUnit(17, "centimeter");
        db.linkCountryUnit(17, "millimeter");
        db.linkCountryUnit(17, "ton");
        db.linkCountryUnit(17, "kilogram");
        db.linkCountryUnit(17, "gram");
        db.linkCountryUnit(17, "liter");
        db.linkCountryUnit(17, "milliliter");
        db.linkCountryUnit(17, "euro");
        db.linkCountryUnit(17, "celsius");
        //Norway
        db.linkCountryUnit(18, "kilometer");
        db.linkCountryUnit(18, "meter");
        db.linkCountryUnit(18, "centimeter");
        db.linkCountryUnit(18, "millimeter");
        db.linkCountryUnit(18, "ton");
        db.linkCountryUnit(18, "kilogram");
        db.linkCountryUnit(18, "gram");
        db.linkCountryUnit(18, "liter");
        db.linkCountryUnit(18, "milliliter");
        db.linkCountryUnit(18, "norwegian crones");
        db.linkCountryUnit(18, "celsius");
        //Poland
        db.linkCountryUnit(19, "kilometer");
        db.linkCountryUnit(19, "meter");
        db.linkCountryUnit(19, "centimeter");
        db.linkCountryUnit(19, "millimeter");
        db.linkCountryUnit(19, "ton");
        db.linkCountryUnit(19, "kilogram");
        db.linkCountryUnit(19, "gram");
        db.linkCountryUnit(19, "liter");
        db.linkCountryUnit(19, "milliliter");
        db.linkCountryUnit(19, "zloty");
        db.linkCountryUnit(19, "celsius");
        //Portugal
        db.linkCountryUnit(20, "kilometer");
        db.linkCountryUnit(20, "meter");
        db.linkCountryUnit(20, "centimeter");
        db.linkCountryUnit(20, "millimeter");
        db.linkCountryUnit(20, "ton");
        db.linkCountryUnit(20, "kilogram");
        db.linkCountryUnit(20, "gram");
        db.linkCountryUnit(20, "liter");
        db.linkCountryUnit(20, "milliliter");
        db.linkCountryUnit(20, "euro");
        db.linkCountryUnit(20, "celsius");
        //Russia
        db.linkCountryUnit(21, "kilometer");
        db.linkCountryUnit(21, "meter");
        db.linkCountryUnit(21, "centimeter");
        db.linkCountryUnit(21, "millimeter");
        db.linkCountryUnit(21, "ton");
        db.linkCountryUnit(21, "kilogram");
        db.linkCountryUnit(21, "gram");
        db.linkCountryUnit(21, "liter");
        db.linkCountryUnit(21, "milliliter");
        db.linkCountryUnit(21, "russian rubel");
        db.linkCountryUnit(21, "celsius");
        //South Africa
        db.linkCountryUnit(22, "kilometer");
        db.linkCountryUnit(22, "meter");
        db.linkCountryUnit(22, "centimeter");
        db.linkCountryUnit(22, "millimeter");
        db.linkCountryUnit(22, "ton");
        db.linkCountryUnit(22, "kilogram");
        db.linkCountryUnit(22, "gram");
        db.linkCountryUnit(22, "liter");
        db.linkCountryUnit(22, "milliliter");
        db.linkCountryUnit(22, "south african rand");
        db.linkCountryUnit(22, "celsius");
        //Spain
        db.linkCountryUnit(23, "kilometer");
        db.linkCountryUnit(23, "meter");
        db.linkCountryUnit(23, "centimeter");
        db.linkCountryUnit(23, "millimeter");
        db.linkCountryUnit(23, "ton");
        db.linkCountryUnit(23, "kilogram");
        db.linkCountryUnit(23, "gram");
        db.linkCountryUnit(23, "liter");
        db.linkCountryUnit(23, "milliliter");
        db.linkCountryUnit(23, "euro");
        db.linkCountryUnit(23, "celsius");
        //Sweden
        db.linkCountryUnit(24, "kilometer");
        db.linkCountryUnit(24, "meter");
        db.linkCountryUnit(24, "centimeter");
        db.linkCountryUnit(24, "millimeter");
        db.linkCountryUnit(24, "ton");
        db.linkCountryUnit(24, "kilogram");
        db.linkCountryUnit(24, "gram");
        db.linkCountryUnit(24, "liter");
        db.linkCountryUnit(24, "milliliter");
        db.linkCountryUnit(24, "swedish crones");
        db.linkCountryUnit(24, "celsius");
        //Switzerland
        db.linkCountryUnit(25, "kilometer");
        db.linkCountryUnit(25, "meter");
        db.linkCountryUnit(25, "centimeter");
        db.linkCountryUnit(25, "millimeter");
        db.linkCountryUnit(25, "ton");
        db.linkCountryUnit(25, "kilogram");
        db.linkCountryUnit(25, "gram");
        db.linkCountryUnit(25, "liter");
        db.linkCountryUnit(25, "milliliter");
        db.linkCountryUnit(25, "swiss frank");
        db.linkCountryUnit(25, "celsius");
        //Turkey
        db.linkCountryUnit(26, "kilometer");
        db.linkCountryUnit(26, "meter");
        db.linkCountryUnit(26, "centimeter");
        db.linkCountryUnit(26, "millimeter");
        db.linkCountryUnit(26, "ton");
        db.linkCountryUnit(26, "kilogram");
        db.linkCountryUnit(26, "gram");
        db.linkCountryUnit(26, "liter");
        db.linkCountryUnit(26, "milliliter");
        db.linkCountryUnit(26, "turkish lira");
        db.linkCountryUnit(26, "celsius");
        //UK
        db.linkCountryUnit(27, "miles");
        db.linkCountryUnit(27, "yards");
        db.linkCountryUnit(27, "feet");
        db.linkCountryUnit(27, "inches");
        db.linkCountryUnit(27, "ton");
        db.linkCountryUnit(27, "pound");
        db.linkCountryUnit(27, "ounce");
        db.linkCountryUnit(27, "gallon (uk)");
        db.linkCountryUnit(27, "quart (uk)");
        db.linkCountryUnit(27, "pint (uk)");
        db.linkCountryUnit(27, "cup (uk)");
        db.linkCountryUnit(27, "fl. ounce (uk)");
        db.linkCountryUnit(27, "pound sterling");
        db.linkCountryUnit(27, "celsius");
        //US
        db.linkCountryUnit(28, "miles");
        db.linkCountryUnit(28, "yards");
        db.linkCountryUnit(28, "feet");
        db.linkCountryUnit(28, "inches");
        db.linkCountryUnit(28, "pound");
        db.linkCountryUnit(28, "ounce");
        db.linkCountryUnit(28, "gallon (us)");
        db.linkCountryUnit(28, "quart (us)");
        db.linkCountryUnit(28, "pint (us)");
        db.linkCountryUnit(28, "cup (us)");
        db.linkCountryUnit(28, "fl. ounce (us)");
        db.linkCountryUnit(28, "us dollar");
        db.linkCountryUnit(28, "fahrenheit");
        }

    public void selectAll()
    {
        db.selectAllFromTable(CountrycodeDBHelper.COUNTRY_TABLE, CountrycodeDataSource.COUNTRY_COLUMNS);
        db.selectAllFromTable(CountrycodeDBHelper.UNIT_TABLE, CountrycodeDataSource.UNIT_COLUMNS);
        db.selectAllFromTable(CountrycodeDBHelper.APPUSER_TABLE, CountrycodeDataSource.USER_COLUMNS);
        db.selectAllFromTable(CountrycodeDBHelper.MEASURE_TABLE, CountrycodeDataSource.MEASURE_COLUMNS);
        db.selectAllFromTable(CountrycodeDBHelper.CURRENCY_TABLE, CountrycodeDataSource.CURRENCY_COLUMNS);
        db.selectAllFromTable(CountrycodeDBHelper.COUNTRY_UNIT_TABLE, CountrycodeDataSource.COUNTRY_USER_COLUMNS);
    }
}

