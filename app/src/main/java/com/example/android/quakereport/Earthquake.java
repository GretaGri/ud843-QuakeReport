package com.example.android.quakereport;

/**
 * Created by Greta Grigutė on 2018-04-25.
 */

public class Earthquake {

   private Double mag;
   private String place;
   private String date;

    public Earthquake(Double magnitude, String EarquakePlace, String EarthquakeDate) {
        mag = magnitude;
        place = EarquakePlace;
        date = EarthquakeDate;
    }

    public Double getMag () {
        return mag;
    }
    public String getPlace () {
        return place;
    }
    public String getDate () {
        return date;
    }
}
