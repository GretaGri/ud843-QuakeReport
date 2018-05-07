package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import android.graphics.drawable.GradientDrawable;

/**
 * Created by Greta Grigutė on 2018-04-25.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    List<Earthquake> earthquakes;
    private LayoutInflater inflater;

    public EarthquakeAdapter(Context context, List<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
        this.earthquakes = earthquakes;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = inflater.inflate(
                    R.layout.list_item, parent, false);
        }


        Earthquake thisEarthquake = getItem(position);

        double magnitude = thisEarthquake.getMag();
        DecimalFormat formatter = new DecimalFormat("0.0");
        String output = formatter.format(magnitude);

        TextView mag = listItemView.findViewById(R.id.mag);
        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) mag.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(thisEarthquake.getMag());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        mag.setText(output);


        String place = thisEarthquake.getPlace();
        String place1;
        String place2;
        if (place.contains("of")) {
            place1 = place.substring(0, place.indexOf("of") + 2);
            place2 = place.substring(place.indexOf("of") + 2, place.length());
        } else {
            place1 = getContext().getString(R.string.near);
            place2 = place;
        }

        TextView locationOffset = listItemView.findViewById(R.id.location_offset);
        locationOffset.setText(place1);

        TextView primaryLocation = listItemView.findViewById(R.id.primary_location);
        primaryLocation.setText(place2);

        TextView date = listItemView.findViewById(R.id.date);
        date.setText(thisEarthquake.getDate());

        TextView time = listItemView.findViewById(R.id.time);
        time.setText(thisEarthquake.getTime());

        // Return the whole list item layout so that it can be shown in the ListView.
        return listItemView;
    }

    private int getMagnitudeColor(double mag) {
        int magnitudeColor;
        DecimalFormat formatter = new DecimalFormat("0");
        formatter.setRoundingMode(RoundingMode.FLOOR);
        String output = formatter.format(mag);
        switch (output) {
            case "0":
            case "1":
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude1);
                break;
            case "2":
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude2);
                break;
            case "3":
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude3);
                break;
            case "4":
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude4);
                break;
            case "5":
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude5);
                break;
            case "6":
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude6);
                break;
            case "7":
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude7);
                break;
            case "8":
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude8);
                break;
            case "9":
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude9);
                break;
            default:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude10plus);
                break;
        }
        return magnitudeColor;
    }

    public void setEarthquake(List<Earthquake> data) {
        earthquakes.addAll(data);
        notifyDataSetChanged();
    }
}
