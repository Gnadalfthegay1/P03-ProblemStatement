package com.myapplicationdev.android.p03_problemstatement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int requestCodeForC347 = 1;
    int requestCodeForC302 = 2;
    TextView tvC302, tvC347;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvC302 = findViewById(R.id.tvC302);
        tvC347 = findViewById(R.id.tvC347);

        tvC347.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,
                        info_activity.class);
                i.putExtra("module", tvC347.getText().toString());
                // Start the activity
                startActivity(i);
            }
        });
        tvC302.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,
                        info_activity.class);
                i.putExtra("module", tvC302.getText().toString());
                // Start the activity
                startActivity(i);
            }
        });





    }

}
