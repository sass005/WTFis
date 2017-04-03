package com.csusm.didhofsas.wtfis;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import static android.R.attr.value;

public class CountrycodeDataSource
{
    private static final String LOG_TAG = CountrycodeDataSource.class.getSimpleName();
    private SQLiteDatabase database;
    private CountrycodeDBHelper dbHelper;
    private String[] colums = {
            CountrycodeDBHelper.ID_NAME,
            CountrycodeDBHelper.CURRENCY_NAME,
            CountrycodeDBHelper.HOME_COUNTRY_SET_NAME,
            CountrycodeDBHelper.TRAVEL_COUNTRY_SET_NAME
    };

    public CountrycodeDataSource(Context context)
    {
        Log.d(LOG_TAG, "db Helper wird erzeugt");
        dbHelper = new CountrycodeDBHelper(context);
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

    //Insert new Entry
    public DBCountryFragment createCountrycode(int id, double currency, int homeCountrySet, int travelCountrySet)
    {
        ContentValues cv = new ContentValues();
        cv.put(CountrycodeDBHelper.ID_NAME, id);
        cv.put(CountrycodeDBHelper.CURRENCY_NAME, currency);
        cv.put(CountrycodeDBHelper.HOME_COUNTRY_SET_NAME, homeCountrySet);
        cv.put(CountrycodeDBHelper.TRAVEL_COUNTRY_SET_NAME, travelCountrySet);

        long insertID = database.insert(CountrycodeDBHelper.TABLE_NAME, null, cv);
        Log.i("insertID",insertID+"");
        Cursor cursor = database.query(CountrycodeDBHelper.TABLE_NAME, colums, CountrycodeDBHelper.ID_NAME + "=" + insertID, null, null, null, null);
        cursor.moveToFirst();
        DBCountryFragment countrycode = cursorToCountrycode(cursor);
        cursor.close();

        return countrycode;
    }

    public DBCountryFragment getCountryById(int id)
    {
        Cursor cursor = database.query(CountrycodeDBHelper.TABLE_NAME, colums, CountrycodeDBHelper.ID_NAME + "=" + id, null, null, null, null);
        cursor.moveToFirst();
        DBCountryFragment countrycode = cursorToCountrycode(cursor);
        cursor.close();

        return countrycode;
    }

    //Get Entry by Cursor
    private DBCountryFragment cursorToCountrycode(Cursor cursor)
    {
        int idIndex = cursor.getColumnIndex(CountrycodeDBHelper.ID_NAME);
        int idCurrency = cursor.getColumnIndex(CountrycodeDBHelper.CURRENCY_NAME);
        int idHomeCountrySet = cursor.getColumnIndex(CountrycodeDBHelper.HOME_COUNTRY_SET_NAME);
        int idTravelCountrySet = cursor.getColumnIndex(CountrycodeDBHelper.TRAVEL_COUNTRY_SET_NAME);



        int id = cursor.getInt(idIndex);
        double currency = cursor.getDouble(idCurrency);
        int homeCountrySet = cursor.getInt(idHomeCountrySet);
        int travelCountrySet = cursor.getInt(idTravelCountrySet);

        return new DBCountryFragment(id, currency, homeCountrySet, travelCountrySet);
    }

    public DBCountryFragment getItemByCountrycode(int countrycode)
    {
       //TODO REPLACE BY ACTUAL READ DATA
        return new DBCountryFragment(1, 1.0, 0, 0);
    }

    public String[] getAllCountryNames()
    {
        return new String[]{"United States", "United Kingdom", "Germany"};
    }
}
