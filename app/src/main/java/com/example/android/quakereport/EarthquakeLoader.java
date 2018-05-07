package com.example.android.quakereport;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.util.List;

/**
 * Created by Greta Grigutė on 2018-05-07.
 */
public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {
    private String mUrl;

    public EarthquakeLoader(Context context,  String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading(){
        forceLoad();
    }

    @Override
    public List<Earthquake> loadInBackground() {

        if (mUrl == null){
            return null;
        }

        List <Earthquake> earthquake = QueryUtils.fetchEarthquakeData(mUrl);

    return earthquake;
    }
}
