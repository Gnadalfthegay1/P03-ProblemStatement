package com.myapplicationdev.android.p03_problemstatement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class moduleAdapter extends ArrayAdapter<module> {

    private ArrayList<module> M;
    private Context context;
    private TextView tvCode, tvName;

    public moduleAdapter(Context context, int resource, ArrayList<module> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        M = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row2, parent, false);

        // Get the TextView object
        tvCode = (TextView) rowView.findViewById(R.id.tvCode);
        tvName = (TextView) rowView.findViewById(R.id.tvName);

        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        module currentModule= M.get(position);
        // Set the TextView to show the food
        tvCode.setText(currentModule.getCode());
        tvName.setText(currentModule.getName());
        // Return the nicely done up View to the ListView
        return rowView;
    }
}