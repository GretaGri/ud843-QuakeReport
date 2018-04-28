package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by Greta Grigutė on 2018-04-25.
 */

public class EarthquakeAdapter extends ArrayAdapter <Earthquake> {

        public EarthquakeAdapter(Context context, ArrayList<Earthquake> earthquakes) {
            super(context, 0, earthquakes);
        }

        @NonNull
        @Override
        public View getView (int position, View convertView,@NonNull ViewGroup parent){
            // Check if an existing view is being reused, otherwise inflate the view
            View listItemView = convertView;
            if (listItemView == null) {
                listItemView = LayoutInflater.from(getContext()).inflate(
                        R.layout.list_item, parent, false);
            }

            Earthquake thisEarthquake = getItem(position);

            double magnitude = thisEarthquake.getMag();
            DecimalFormat formatter = new DecimalFormat("0.0");
            String output = formatter.format(magnitude);

            TextView mag = listItemView.findViewById(R.id.mag);
            mag.setText(output);


            String place = thisEarthquake.getPlace();
            String place1;
            String place2;
            if (place.contains("of")){
            place1 = place.substring(0, place.indexOf("of")+2);
            place2 = place.substring(place.indexOf("of")+2,place.length());
            }
            else {place1 = getContext().getString(R.string.near);
            place2 = place;}

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
    }
