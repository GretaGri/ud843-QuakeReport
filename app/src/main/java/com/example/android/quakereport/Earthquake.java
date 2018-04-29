package com.example.android.quakereport;

/**
 * Created by Greta Grigutė on 2018-04-25.
 */

public class Earthquake {

   private double mag;
   private String place;
   private String date;
   private String time;
   private String url;

    public Earthquake(double magnitude, String EarquakePlace, String EarthquakeDate, String EarthquakeTime, String UrlWithDetails) {
        mag = magnitude;
        place = EarquakePlace;
        date = EarthquakeDate;
        time = EarthquakeTime;
        url = UrlWithDetails;
    }

    public double getMag () {
        return mag;
    }
    public String getPlace () {
        return place;
    }
    public String getDate () {
        return date;
    }
    public String getTime () {return time;}
    public String getUrl () {return url;}
}
