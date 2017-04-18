package com.csusm.didhofsas.wtfis;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;


public class CountrycodeDBHelper extends SQLiteOpenHelper
{

    private static final String LOG_TAG = CountrycodeDBHelper.class.getSimpleName();
    private static final String dbName = "WTFis_db";
    private static final int DB_VERSION = 1;

    public static final String COUNTRY_TABLE = "country";
    public static final String APPUSER_TABLE = "appuser";
    public static final String COUNTRY_UNIT_TABLE = "country_unit";
    public static final String UNIT_TABLE = "unit";
    public static final String MEASURE_TABLE = "measure";
    public static final String CURRENCY_TABLE = "currency";

    public static final String COUNTRY_ID = "country_id";
    public static final String COUNTRY_NAME = "name";
    public static final String COUNTRY_TEMP_IN_CELSIUS = "temp_in_celsius";

    public static final String APPUSER_ID = "user_id";
    public static final String APPUSER_LAST_HOME = "last_home";
    public static final String APPUSER_LAST_TRAVEL = "last_travel";

    public static final String COUNTRY_UNIT_ID = "country_unit_id";
    public static final String COUNTRY_UNIT_COUNTRY_ID = "country_id";
    public static final String COUNTRY_UNIT_UNIT_ID = "unit_id";

    public static final String UNIT_ID = "unit_id";
    public static final String UNIT_NAME = "name";
    public static final String UNIT_CALC_FACTOR = "calc_factor";
    public static final String UNIT_MEASURE_ID = "measure_id";

    public static final String CURRENCY_ID = "c_unit_id";
    public static final String CURRENCY_SHORTNAME ="shortname";
    public static final String CURRENCY_TIMESTAMP = "timestamp";

    public static final String MEASURE_ID = "measure_id";
    public static final String MEASURE_NAME = "name";
    public static final String MEASURE_STANDARD_UNIT = "standard_unit";


    public static final String SQL_CREATE_COUNTRY =
            "CREATE TABLE "+ COUNTRY_TABLE
            + "("+ COUNTRY_ID +" INTEGER PRIMARY KEY, "
            + COUNTRY_NAME+" VARCHAR(64), "
            + COUNTRY_TEMP_IN_CELSIUS+" BOOLEAN);";

    public static final String SQL_CREATE_USER =
            "CREATE TABLE " + APPUSER_TABLE +" ("
            +APPUSER_ID+" INTEGER PRIMARY KEY,"
            +APPUSER_LAST_HOME+" INTEGER,"
            +APPUSER_LAST_TRAVEL+" INTEGER,"
            +"FOREIGN KEY("+APPUSER_LAST_HOME+") REFERENCES "+COUNTRY_TABLE+"("+ COUNTRY_ID +"),"
            +"FOREIGN KEY("+APPUSER_LAST_TRAVEL+") REFERENCES "+COUNTRY_TABLE+"("+ COUNTRY_ID +"));";

    public static final String SQL_CREATE_COUNTRY_UNIT =
            "CREATE TABLE " + COUNTRY_UNIT_TABLE +" ("
            +COUNTRY_UNIT_ID+" INTEGER PRIMARY KEY,"
            +COUNTRY_UNIT_COUNTRY_ID+" INTEGER NOT NULL,"
            +COUNTRY_UNIT_UNIT_ID+" INTEGER NOT NULL,"
            +"FOREIGN KEY("+COUNTRY_UNIT_COUNTRY_ID+") REFERENCES "+COUNTRY_TABLE+"("+ COUNTRY_ID +"),"
            +"FOREIGN KEY("+COUNTRY_UNIT_UNIT_ID+") REFERENCES "+UNIT_TABLE+"("+UNIT_ID+"));";

    public static final String SQL_CREATE_MEASURE =
            "CREATE TABLE " + MEASURE_TABLE +" ("
                    +MEASURE_ID+" INTEGER PRIMARY KEY,"
                    +MEASURE_NAME+" VARCHAR(64),"
                    +MEASURE_STANDARD_UNIT+" INTEGER,"
                    +"FOREIGN KEY("+MEASURE_STANDARD_UNIT+") REFERENCES "+UNIT_TABLE+"("+UNIT_ID+"));";

    public static final String SQL_CREATE_UNIT =
            "CREATE TABLE " + UNIT_TABLE +" ("
            +UNIT_ID+" INTEGER PRIMARY KEY,"
            +UNIT_NAME+" VARCHAR(64),"
            +UNIT_CALC_FACTOR+" FLOAT,"
            +UNIT_MEASURE_ID+" INTEGER,"
            +"FOREIGN KEY("+UNIT_MEASURE_ID+") REFERENCES "+MEASURE_TABLE+"("+MEASURE_ID+"));";

    public static final String SQL_CREATE_CURRENCY =
            "CREATE TABLE " + CURRENCY_TABLE +" ("
            +CURRENCY_ID+" INTEGER PRIMARY KEY,"
            +CURRENCY_SHORTNAME+" VARCHAR(3) NOT NULL,"
            +CURRENCY_TIMESTAMP+" INTEGER NOT NULL DEFAULT(0),"
            +"FOREIGN KEY("+CURRENCY_ID+") REFERENCES "+UNIT_TABLE+"("+UNIT_ID+"));";

    public CountrycodeDBHelper(Context context)
    {
        super(context, dbName, null, DB_VERSION);
        Log.d(LOG_TAG, "hat die DB: " + getDatabaseName() + " erzeugt.");
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        createAll(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        dropAll(db);
        createAll(db);
    }

    //BUILD PURPOSE ONLY
    public void dropAll(SQLiteDatabase db)
    {
        db.execSQL("DROP TABLE IF EXISTS " + CURRENCY_TABLE + ";");
        db.execSQL("DROP TABLE IF EXISTS " + MEASURE_TABLE + ";");
        db.execSQL("DROP TABLE IF EXISTS " + COUNTRY_UNIT_TABLE + ";");
        db.execSQL("DROP TABLE IF EXISTS " + COUNTRY_TABLE + ";");
        db.execSQL("DROP TABLE IF EXISTS " + UNIT_TABLE + ";");
        db.execSQL("DROP TABLE IF EXISTS " + APPUSER_TABLE + ";");
    }

    public void createAll(SQLiteDatabase db)
    {
        try {
            Log.d(LOG_TAG, "Country wird mit dem SQL Befehl " + SQL_CREATE_COUNTRY + " angelegt.");
            db.execSQL(SQL_CREATE_COUNTRY);
        }
        catch (Exception e) {Log.e(LOG_TAG, "Fehler beim Anlegen der Tabelle: " + e.getMessage());}

        try {
            Log.d(LOG_TAG, "User wird mit dem SQL Befehl " + SQL_CREATE_USER + " angelegt.");
            db.execSQL(SQL_CREATE_USER);
        }
        catch (Exception e) {Log.e(LOG_TAG, "Fehler beim Anlegen der Tabelle: " + e.getMessage());}

        try {
            Log.d(LOG_TAG, "Unit wird mit dem SQL Befehl " + SQL_CREATE_UNIT + " angelegt.");
            db.execSQL(SQL_CREATE_UNIT);
        }
        catch (Exception e) {Log.e(LOG_TAG, "Fehler beim Anlegen der Tabelle: " + e.getMessage());}

        try {
            Log.d(LOG_TAG, "Measure wird mit dem SQL Befehl " + SQL_CREATE_MEASURE + " angelegt.");
            db.execSQL(SQL_CREATE_MEASURE);
        }
        catch (Exception e) {Log.e(LOG_TAG, "Fehler beim Anlegen der Tabelle: " + e.getMessage());}

        try {
            Log.d(LOG_TAG, "Country_User wird mit dem SQL Befehl " + SQL_CREATE_COUNTRY_UNIT + " angelegt.");
            db.execSQL(SQL_CREATE_COUNTRY_UNIT);
        }
        catch (Exception e) {Log.e(LOG_TAG, "Fehler beim Anlegen der Tabelle: " + e.getMessage());}

        try {
            Log.d(LOG_TAG, "Currency wird mit dem SQL Befehl " + SQL_CREATE_CURRENCY + " angelegt.");
            db.execSQL(SQL_CREATE_CURRENCY);
        }
        catch (Exception e) {Log.e(LOG_TAG, "Fehler beim Anlegen der Tabelle: " + e.getMessage());}
    }

    public void describeAll(SQLiteDatabase db)
    {
        Log.i("DESCRIBE","Describe All Tables called");
        Cursor c = db.query(COUNTRY_TABLE, null, null, null, null, null, null);
        String[] country_columns = c.getColumnNames();
        for(int i = 0; i < country_columns.length; i++)
            Log.i("DESCRIBE",COUNTRY_TABLE + ": " + country_columns[i]);

        c = db.query(APPUSER_TABLE, null, null, null, null, null, null);
        String[] user_column = c.getColumnNames();
        for(int i = 0; i < user_column.length; i++)
            Log.i("DESCRIBE",APPUSER_TABLE + ": " + user_column[i]);

        c = db.query(COUNTRY_UNIT_TABLE, null, null, null, null, null, null);
        String[] country_unit_columns = c.getColumnNames();
        for(int i = 0; i < country_unit_columns.length; i++)
            Log.i("DESCRIBE",COUNTRY_UNIT_TABLE + ": " + country_unit_columns[i]);

        c = db.query(UNIT_TABLE, null, null, null, null, null, null);
        String[] unit_columns = c.getColumnNames();
        for(int i = 0; i < unit_columns.length; i++)
            Log.i("DESCRIBE",UNIT_TABLE + ": " + unit_columns[i]);

        c = db.query(MEASURE_TABLE, null, null, null, null, null, null);
        String[] measure_columns = c.getColumnNames();
        for(int i = 0; i < measure_columns.length; i++)
            Log.i("DESCRIBE",MEASURE_TABLE + ": " + measure_columns[i]);
        c.close();

        c = db.query(CURRENCY_TABLE, null, null, null, null, null, null);
        String[] currency_columns = c.getColumnNames();
        for(int i = 0; i < currency_columns.length; i++)
            Log.i("DESCRIBE",CURRENCY_TABLE + ": " + currency_columns[i]);
        c.close();
    }

    public void selectAllFromTable(String tableName, String[] columns, SQLiteDatabase db)
    {
        Cursor c = db.query(tableName, null, null, null, null, null, null);
        String temp = "";
        for (int i = 0; i < columns.length; i++)
            temp = temp + c.getColumnName(i) + "\t\t| ";
        Log.i("SELECT", temp);
        if(c.moveToFirst())
        do {
            temp = "";
            for(int i = 0; i < columns.length; i++)
                temp = temp + c.getString(c.getColumnIndex(columns[i])) + "\t\t| ";
            Log.i("SELECT", temp);
        }while (c.moveToNext());
        c.close();
    }

    public String[] selectNamesInTable(String tableName, String[] columns, SQLiteDatabase db)
    {
        Cursor c = db.query(tableName, null, null, null, null, null, null);
        String[] temp = new String[c.getCount()];
        int i = 0;
        if(c.moveToFirst())
            do {
                temp[i] = c.getString(c.getColumnIndex("name"));
                i++;
            }while (c.moveToNext());
        c.close();
        return temp;
    }

    public boolean isTempInCelsius(int country_id, SQLiteDatabase db)
    {
        Cursor c = db.query(COUNTRY_TABLE, null, null, null, null, null, null);
        if (c.moveToFirst())
        {
            c.moveToPosition(country_id);
            return c.getInt(c.getColumnIndex("temp_in_celsius")) > 0;
        }
        return true;
    }


    public int selectLastHome(SQLiteDatabase db)
    {
        Cursor c = db.query(APPUSER_TABLE, null, null, null, null, null, null);
        if (c.moveToFirst())
        {
            if(c.getString(c.getColumnIndex("last_home"))!=null)
                return c.getInt(c.getColumnIndex("last_home"));
        }
        return 0;
    }

    public int selectLastTravel(SQLiteDatabase db)
    {
        Cursor c = db.query(APPUSER_TABLE, null, null, null, null, null, null);
        if (c.moveToFirst())
        {
            if(c.getString(c.getColumnIndex("last_travel"))!=null)
                return c.getInt(c.getColumnIndex("last_travel"));
        }
        return 1;
    }

    public int selectUnitIDByName(String unit_name, SQLiteDatabase db)
    {
        Cursor c = db.query(UNIT_TABLE, null, null, null, null, null, null);
        int i = 0;
        if (c.moveToFirst())
            do{
                if (c.getString(c.getColumnIndex("name")).equals(unit_name))
                    return c.getInt(c.getColumnIndex("unit_id"));
                i++;
            }while(c.moveToNext());
        return -1;
    }

    public ArrayList<Unit> getSelectedUnits(int country_id, int measure_id, SQLiteDatabase db)
    {
        Cursor c = db.query(COUNTRY_UNIT_TABLE, null, null, null, null, null, null);
        ArrayList<Unit> units = new ArrayList<Unit>();
        if (c.moveToFirst())
            do{
                if (c.getInt(c.getColumnIndex(COUNTRY_UNIT_COUNTRY_ID)) == country_id)
                {
                    Log.i("UNIT", "Country: " + c.getString(c.getColumnIndex(COUNTRY_UNIT_COUNTRY_ID)));
                    int id_temp = c.getInt(c.getColumnIndex(COUNTRY_UNIT_UNIT_ID));
                    Cursor c2 = db.query(UNIT_TABLE, null, null, null, null, null, null);
                    if (c2.moveToFirst())
                    {
                        c2.moveToPosition(id_temp-1);
                        if (c2.getInt(c2.getColumnIndex(UNIT_MEASURE_ID))==measure_id)
                        {
                            double calc_factor_temp = c2.getDouble(c2.getColumnIndex(UNIT_CALC_FACTOR));
                            String name_temp = c2.getString(c2.getColumnIndex(UNIT_NAME));
                            units.add(new Unit(name_temp, calc_factor_temp));
                        }
                    }
                }
            }while(c.moveToNext());
        return units;
    }

    public ArrayList<String> selectAllCurrencyShorts(SQLiteDatabase db)
    {
        Cursor c = db.query(CURRENCY_TABLE, null, null, null, null, null, null);
        ArrayList<String> currencyShorts = new ArrayList<String>();
        if (c.moveToFirst())
            do
            {
                currencyShorts.add(c.getString(c.getColumnIndex(CURRENCY_SHORTNAME)));
            }while(c.moveToNext());
        return currencyShorts;
    }

    public int selectCurrencyID(String shortname, SQLiteDatabase db)
    {
        Cursor c = db.query(CURRENCY_TABLE, null, null, null, null, null, null);
        if (c.moveToFirst())
            do
            {
                if (c.getString(c.getColumnIndex(CURRENCY_SHORTNAME)).equals(shortname))
                    return c.getInt(c.getColumnIndex(CURRENCY_ID));
            }while(c.moveToNext());
        return -1;
    }

    public long selectLastAPICurrencyCall(SQLiteDatabase db)
    {
        Cursor c = db.query(CURRENCY_TABLE, null, null, null, null, null, null);
        long lastCall = -1;
        if (c.moveToFirst())
            do
            {
                if (c.getLong(c.getColumnIndex(CURRENCY_TIMESTAMP))>lastCall)
                    lastCall = c.getLong(c.getColumnIndex(CURRENCY_TIMESTAMP));
            }while(c.moveToNext());
        return lastCall;
    }
}
