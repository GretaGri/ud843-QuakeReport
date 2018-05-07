package com.example.android.quakereport;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import java.util.List;

/**
 * Created by Greta Grigutė on 2018-05-07.
 */
public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {
    private String mUrl;
    private static final String LOG_TAG = EarthquakeActivity.class.getName();

    public EarthquakeLoader(Context context,  String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading(){
        forceLoad();
        Log.d (LOG_TAG, "start Loading");
    }

    @Override
    public List<Earthquake> loadInBackground() {
        Log.d (LOG_TAG, "load in background");
        if (mUrl == null){
            return null;
        }

        List <Earthquake> earthquake = QueryUtils.fetchEarthquakeData(mUrl);


    return earthquake;
    }
}
