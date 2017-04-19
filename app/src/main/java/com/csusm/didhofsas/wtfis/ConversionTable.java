package com.csusm.didhofsas.wtfis;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ConversionTable extends Activity {

    ListView klist, clist, flist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion_table);

        klist = (ListView)findViewById(R.id.kelvinList);
        clist = (ListView)findViewById(R.id.celsiusList);
        flist = (ListView)findViewById(R.id.fahrenheitList);

        String[] kelvinContent = new String[]{"Kelvin", "0 K", "263 K", "268 K", "273 K", "278 K", "283 K", "288 K", "293 K", "298 K", "303 K", "308 K", "313 K" , "373 K"};
        String [] celsiusContent = new String [] {"Celsius", "-273 °C", "-10 °C", "-5 °C", "0 °C", "5 °C", "10 °C", "15 °C", "20 °C", "25 °C", "30 °C", "35 °C", "40 °C", "100 °C"};
        String [] fahrenheitContent = new String [] {"Fahrenheit", "-459.4 °F", "14 °F", "23 °F", "32 °F", "41 °F", "50 °F", "59 °F", "68 °F", "77 °F", "86 °F", "95 °F" , "104 °F", "212 °F"  };

        ArrayAdapter<String> adapterk = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, kelvinContent);
        klist.setAdapter(adapterk);
        setListViewHeightBasedOnChildren(klist);

        ArrayAdapter<String> adapterc = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, celsiusContent);
        clist.setAdapter(adapterc);
        setListViewHeightBasedOnChildren(clist);

        ArrayAdapter<String> adapterf = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, fahrenheitContent);
        flist.setAdapter(adapterf);
        setListViewHeightBasedOnChildren(flist);
    }

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null)
            return;

        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.UNSPECIFIED);
        int totalHeight = 0;
        View view = null;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            view = listAdapter.getView(i, view, listView);
            if (i == 0)
                view.setLayoutParams(new ViewGroup.LayoutParams(desiredWidth, ViewGroup.LayoutParams.WRAP_CONTENT));

            view.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }
}
