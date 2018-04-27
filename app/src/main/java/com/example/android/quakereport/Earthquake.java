package com.example.android.quakereport;

/**
 * Created by Greta Grigutė on 2018-04-25.
 */

public class Earthquake {

   private Double mag;
   private String place;
   private String date;
   private String time;

    public Earthquake(Double magnitude, String EarquakePlace, String EarthquakeDate, String EarthquakeTime) {
        mag = magnitude;
        place = EarquakePlace;
        date = EarthquakeDate;
        time = EarthquakeTime;
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
    public String getTime () {return time;}
}
