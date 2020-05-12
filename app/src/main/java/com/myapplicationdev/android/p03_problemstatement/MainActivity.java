package com.myapplicationdev.android.p03_problemstatement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvModules;
    ArrayAdapter aa;
    ArrayList<module> M;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvModules = findViewById(R.id.lvModules);
        M = new ArrayList<module>();
        M.add(new module("C302", "Web Services"));
        M.add(new module("C347", "Android Programming II"));
        aa = new moduleAdapter(this, R.layout.row2, M);
        lvModules.setAdapter(aa);
        lvModules.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                module m = M.get(position);
                Intent i = new Intent(getApplicationContext(), info_activity.class);
                i.putExtra("module", m.getCode());
                startActivity(i);
            }
        });
    }

}
