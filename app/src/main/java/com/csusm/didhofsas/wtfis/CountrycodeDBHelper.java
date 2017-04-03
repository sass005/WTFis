package com.csusm.didhofsas.wtfis;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Florian on 17-Feb-17.
 */

public class CountrycodeDBHelper extends SQLiteOpenHelper
{

    private static final String LOG_TAG = CountrycodeDBHelper.class.getSimpleName();
    private static final String dbName = "WTFis_db";
    private static final int DB_VERSION = 1;

    public static final String TABLE_NAME = "the_one_table";
    public static final String ID_NAME = "id";
    public static final String CURRENCY_NAME = "currency";
    public static final String HOME_COUNTRY_SET_NAME = "home_country_set";
    public static final String TRAVEL_COUNTRY_SET_NAME = "travel_country_set";


    public static final String SQL_CREATE = "CREATE TABLE "+ TABLE_NAME
            + "( " + ID_NAME + " INTEGER PRIMARY KEY, "
            + CURRENCY_NAME + " DOUBLE NOT NULL, "
            + HOME_COUNTRY_SET_NAME + " INTEGER NOT NULL, "
            + TRAVEL_COUNTRY_SET_NAME + " INTEGER NOT NULL);";

    public CountrycodeDBHelper(Context context)
    {
        super(context, dbName, null, DB_VERSION);
        Log.d(LOG_TAG, "hat die DB: " + getDatabaseName() + " erzeugt.");
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        try {
            Log.d(LOG_TAG, "Tabelle wird mit dem SQL Befehl " + SQL_CREATE + " angelegt.");
            db.execSQL(SQL_CREATE);
        }
        catch (Exception e)
        {
            Log.e(LOG_TAG, "Fehler beim Anlegen der Tabelle: " + e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
