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

            TextView mag = listItemView.findViewById(R.id.mag);
            mag.setText(thisEarthquake.getMag().toString());

            TextView place = listItemView.findViewById(R.id.place);
            place.setText(thisEarthquake.getPlace());

            TextView date = listItemView.findViewById(R.id.date);
            date.setText(thisEarthquake.getDate());

            TextView time = listItemView.findViewById(R.id.time);
            time.setText(thisEarthquake.getTime());

            // Return the whole list item layout so that it can be shown in the ListView.
            return listItemView;
        }
    }
