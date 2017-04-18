package com.csusm.didhofsas.wtfis;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APICurrencyConnector extends AsyncTask<Void, Void, String>
{

    @Override
    protected String doInBackground(Void... urls)
    {
        try
        {
            URL url = new URL("http://api.fixer.io/latest");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null)
                {
                    stringBuilder.append(line).append("\n");
                }
                bufferedReader.close();
                return stringBuilder.toString();
            }
            finally
            {
                urlConnection.disconnect();
            }
        }
        catch (java.io.IOException e)
        {
            Log.e("API Error", e.getMessage(), e);
            return null;
        }
    }

        protected void onPostExecute(String response)
        {
        if(response == null)
        {
            response = "THERE WAS AN ERROR";
        }
        Log.i("INFO", response);
    }
}
