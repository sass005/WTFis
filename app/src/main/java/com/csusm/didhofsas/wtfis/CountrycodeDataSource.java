package com.csusm.didhofsas.wtfis;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.Date;

public class CountrycodeDataSource
{
    private static final String LOG_TAG = CountrycodeDataSource.class.getSimpleName();
    private SQLiteDatabase database;
    private CountrycodeDBHelper dbHelper;
    public static final String[] COUNTRY_COLUMNS = {
            CountrycodeDBHelper.COUNTRY_ID,
            CountrycodeDBHelper.COUNTRY_NAME,
            CountrycodeDBHelper.COUNTRY_TEMP_IN_CELSIUS
    };
    public static final String[] USER_COLUMNS = {
            CountrycodeDBHelper.APPUSER_ID,
            CountrycodeDBHelper.APPUSER_LAST_HOME,
            CountrycodeDBHelper.APPUSER_LAST_TRAVEL
    };
    public static final String[] COUNTRY_USER_COLUMNS = {
            CountrycodeDBHelper.COUNTRY_UNIT_ID,
            CountrycodeDBHelper.COUNTRY_UNIT_COUNTRY_ID,
            CountrycodeDBHelper.COUNTRY_UNIT_UNIT_ID
    };

    public static final String[] UNIT_COLUMNS = {
            CountrycodeDBHelper.UNIT_ID,
            CountrycodeDBHelper.UNIT_NAME,
            CountrycodeDBHelper.UNIT_CALC_FACTOR,
            CountrycodeDBHelper.UNIT_MEASURE_ID
    };

    public static final String[] MEASURE_COLUMNS = {
            CountrycodeDBHelper.MEASURE_ID,
            CountrycodeDBHelper.MEASURE_NAME,
            CountrycodeDBHelper.MEASURE_STANDARD_UNIT
    };

    public static final String[] CURRENCY_COLUMNS = {
            CountrycodeDBHelper.CURRENCY_ID,
            CountrycodeDBHelper.CURRENCY_SHORTNAME,
            CountrycodeDBHelper.CURRENCY_TIMESTAMP
    };

    public CountrycodeDataSource(Context context)
    {
        Log.d(LOG_TAG, "db Helper wird erzeugt");
        dbHelper = new CountrycodeDBHelper(context);
    }

    public CountrycodeDataSource(Context context, boolean updateForced)
    {
        Log.d(LOG_TAG, "db Helper wird erzeugt");
        dbHelper = new CountrycodeDBHelper(context);
        if(updateForced)
        {
            Log.d(LOG_TAG, "Update Forced");
            open();
            Log.d(LOG_TAG, "REBUILD IN PROGRESS");
            dbHelper.dropAll(database);
            dbHelper.createAll(database);
            dbHelper.describeAll(database);
            close();
        }
    }

    public void open()
    {
        Log.d(LOG_TAG, "Eine Referenz auf die Datenbank wird jetzt angefragt.");
        database = dbHelper.getWritableDatabase();
        Log.d(LOG_TAG, "Datenbankreferenz erhalten. Pfad zur Datenbank: " + database.getPath());
    }

    public void close()
    {
        dbHelper.close();
        Log.d(LOG_TAG, "Datenbank geschlossen.");
    }

    //Insert new Country
    public void createCountry(int id, String name, boolean temp_in_c)
    {
        ContentValues cv = new ContentValues();
        cv.put(COUNTRY_COLUMNS[0], id);
        cv.put(COUNTRY_COLUMNS[1], name);
        cv.put(COUNTRY_COLUMNS[2], temp_in_c);
        database.insert(CountrycodeDBHelper.COUNTRY_TABLE, null, cv);
        Log.i("DATA_INSERT","Country Created: " + name);
        //Cursor cursor = database.query(CountrycodeDBHelper.COUNTRY_TABLE, COUNTRY_COLUMNS, CountrycodeDBHelper.COUNTRY_ID + "=" + insertID, null, null, null, null);
        //cursor.moveToFirst();
        //DBCountryFragment countrycode = cursorToCountrycode(cursor);
        //cursor.close();

        //return countrycode;
    }

    //create a new User, at the moment there should be just one User
    public void createUser(int id)
    {
        ContentValues cv = new ContentValues();
        cv.put(USER_COLUMNS[0], id);
        database.insert(CountrycodeDBHelper.APPUSER_TABLE, null, cv);
        Log.i("DATA_INSERT","User Created, User_ID: " + id);
    }

    //create a new measuretype (e.g. liquid, weight)
    public void createMeasure (int id, String name)
    {
        ContentValues cv = new ContentValues();
        cv.put(MEASURE_COLUMNS[0], id);
        cv.put(MEASURE_COLUMNS[1], name);
        database.insert(CountrycodeDBHelper.MEASURE_TABLE, null, cv);
        Log.i("DATA_INSERT","Measure Created, Measure ID: "+ id + ", Name: " + name);
    }

    public void createCurrency(String name, String shortname)
    {
        createCurrency(name, shortname, 0);
    }

    //create a Unit assigned to measuretype 3 (Currency) and also an entry in the Currency Table
    public void createCurrency(String name, String shortname, double currencyRate)
    {
        long id = createUnit(name, currencyRate, 3);
        ContentValues cv = new ContentValues();
        cv.put(CURRENCY_COLUMNS[0], id);
        cv.put(CURRENCY_COLUMNS[1], shortname);
        database.insert(CountrycodeDBHelper.CURRENCY_TABLE, null, cv);
        Log.i("DATA_INSERT","Currency Created, Name: " + name);
    }

    //create a new Unit with a name, the factor for calculation and assignement to a measuretype
    public long createUnit(String name, double calc_factor, int measure_id)
    {
        ContentValues cv = new ContentValues();
        cv.put(UNIT_COLUMNS[1], name);
        cv.put(UNIT_COLUMNS[2], calc_factor);
        cv.put(UNIT_COLUMNS[3], measure_id);
        long id = database.insert(CountrycodeDBHelper.UNIT_TABLE, null, cv);
        Log.i("DATA_INSERT","Unit Created, Unit_ID: " + id + ", Name: " + name);
        return id;
    }

    //Set a Relationship between a Unit and a COuntry
    public void linkCountryUnit(int country_id, String unit_name)
    {
        ContentValues cv = new ContentValues();
        cv.put(COUNTRY_USER_COLUMNS[1], country_id);
        cv.put(COUNTRY_USER_COLUMNS[2], dbHelper.selectUnitIDByName(unit_name, database));
        database.insert(CountrycodeDBHelper.COUNTRY_UNIT_TABLE, null, cv);
        Log.i("DATA_INSERT","DATA LINKED, COUNTRY_ID: " + country_id + ", Unit_Name: " + unit_name);
    }

    //TODO Update Last_Home, Last_Travel
    public void updateLastHomeAndTravel(int chosenHome, int chosenTravel)
    {
        ContentValues cv = new ContentValues();
        cv.put(USER_COLUMNS[1],chosenHome);
        cv.put(USER_COLUMNS[2],chosenTravel);
        database.update(CountrycodeDBHelper.APPUSER_TABLE, cv, null, null);
    }

    public void updateCurrency(String shortname, double rate, long timestamp)
    {
        ContentValues cv = new ContentValues();
        cv.put(UNIT_COLUMNS[2],rate);
        Log.i("UPDATE","TABLE: " + CountrycodeDBHelper.UNIT_TABLE + ", WHERE " + CountrycodeDBHelper.UNIT_ID + " = " + dbHelper.selectCurrencyID(shortname,database));
        database.update(CountrycodeDBHelper.UNIT_TABLE, cv,CountrycodeDBHelper.UNIT_ID + " = " + dbHelper.selectCurrencyID(shortname,database),null);
        Log.i("UPDATE","Currency " + shortname + " updated to " +rate);

        cv = new ContentValues();
        cv.put(CURRENCY_COLUMNS[2], timestamp);
        database.update(CountrycodeDBHelper.CURRENCY_TABLE,cv,CountrycodeDBHelper.CURRENCY_ID + " = "+dbHelper.selectCurrencyID(shortname,database),null);
        selectAllFromTable(CountrycodeDBHelper.UNIT_TABLE, UNIT_COLUMNS);
    }


    //TODO REMOVE just for test purpose
    public void selectAllFromTable(String tableName, String[] columns)
    {
        dbHelper.selectAllFromTable(tableName, columns, database);
    }

    //get the entire name column of the selected table
    public String[] selectNamesInTable(String tableName, String[] columns)
    {
        return dbHelper.selectNamesInTable(tableName, columns, database);
    }

    // Alle Units pro Land pro Measure
    public ArrayList<Unit> getSelectedUnits(int country_id, int measure_id)
    {
        Log.i("UNITS", "GOT DATA, COUNTRY ID: " + country_id + ", MEASURE ID: " + measure_id);
        return dbHelper.getSelectedUnits(country_id, measure_id, database);
    }
    //get if the Temperature in the selected Country is in Celsius
    public boolean isTempInCelsius(int country_id)
    {
        return dbHelper.isTempInCelsius(country_id, database);
    }
    //TODO Update Currency
    //public void updateCurrency();

    //Select Last_Home
    public int selectLastHome()
    {
        return dbHelper.selectLastHome(database);
    }

    //Select Last_Travel
    public int selectLastTravel()
    {
        return dbHelper.selectLastTravel(database);
    }

    public ArrayList<String> selectAllCurrencyShorts()
    {
        return dbHelper.selectAllCurrencyShorts(database);
    }


    public long selectLastAPICurrencyCall()
    {
        return dbHelper.selectLastAPICurrencyCall(database);
    }

    public long selectLastAPICurrencyCall(int currencyId)
    {
        return dbHelper.selectLastAPICurrencyCall(database, currencyId);
    }
}
