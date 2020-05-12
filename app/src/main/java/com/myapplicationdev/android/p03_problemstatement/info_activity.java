package com.myapplicationdev.android.p03_problemstatement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class info_activity extends AppCompatActivity {
    int requestCodeForC347 = 1;
    int requestCodeForC302 = 2;
    ListView lvgrades;
    Button btAdd, btInfo, btEmail;
    ArrayAdapter a;
    ArrayList<DailyCA> CA = new ArrayList<DailyCA>();
    ArrayList<DailyCA> CA2 = new ArrayList<DailyCA>();
    String module;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_activity);
        lvgrades = findViewById(R.id.lvGrades);
        btAdd = findViewById(R.id.btAdd);
        btInfo = findViewById(R.id.btInfo);
        btEmail = findViewById(R.id.btMail);
        Intent oi = getIntent();
        module = oi.getStringExtra("module");
        if(module.equals("C347")){
            a = new customAdapter(this, R.layout.row, CA);
            lvgrades.setAdapter(a);
        }
        else{
            a = new customAdapter(this, R.layout.row, CA2);
            lvgrades.setAdapter(a);
        }




        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(module.equals("C347")){
                    int num = CA.size();
                    Intent i = new Intent(getApplicationContext(), add.class);
                    i.putExtra("module", module);
                    i.putExtra("wk", num);
                    startActivityForResult(i, requestCodeForC347);
                }
                else if(module.equals("C302")){
                    int num = CA2.size();
                    Intent i = new Intent(getApplicationContext(), add.class);
                    i.putExtra("module", module);
                    i.putExtra("wk", num);
                    startActivityForResult(i, requestCodeForC302);
                }
            }
        });
        btInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(module.equals("C347")){
                    Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                    // Set the URL to be used.
                    rpIntent.setData(Uri.parse("https://www.rp.edu.sg/soi/home"));
                    startActivity(rpIntent);
                }
                else if(module.equals("C302")){
                    Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                    // Set the URL to be used.
                    rpIntent.setData(Uri.parse("https://www.rp.edu.sg/soi/home"));
                    startActivity(rpIntent);

                }
            }
        });
        btEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(module.equals("C347")){
                    Intent email = new Intent(Intent.ACTION_SEND);
                    // Put essentials like email address, subject & body text
                    email.putExtra(Intent.EXTRA_EMAIL,
                            new String[]{"jason_lim@rp.edu.sg"});
                    email.putExtra(Intent.EXTRA_SUBJECT,
                            "Test Email from "+module);
                    String msg = "";
                    for(int i = 0; i<CA.size(); i++){
                        DailyCA grades = CA.get(i);
                        msg += "Week "+grades.getWeek()+": DG: "+grades.getDgGrade()+"\n";
                    }
                    email.putExtra(Intent.EXTRA_TEXT, "Hi faci, \n\n"+"I am Adam \n"+"Please see my remarks so far, thank you!\n\n"+msg);
                    // This MIME type indicates email
                    email.setType("message/rfc822");
                    // createChooser shows user a list of app that can handle
                    // this MIME type, which is, email
                    startActivity(Intent.createChooser(email,
                            "Choose an Email client :"));
                }
                else if(module.equals("C302")){
                    Intent email = new Intent(Intent.ACTION_SEND);
                    // Put essentials like email address, subject & body text
                    email.putExtra(Intent.EXTRA_EMAIL,
                            new String[]{"jason_lim@rp.edu.sg"});
                    email.putExtra(Intent.EXTRA_SUBJECT,
                            "Test Email from "+module);
                    String msg = "";
                    for(int i = 0; i<CA2.size(); i++){
                        DailyCA grades = CA2.get(i);
                        msg += "Week "+grades.getWeek()+": DG: "+grades.getDgGrade()+"\n";
                    }
                    email.putExtra(Intent.EXTRA_TEXT, "Hi faci, \n\n"+"I am Adam \n"+"Please see my remarks so far, thank you!\n\n"+msg);
                    // This MIME type indicates email
                    email.setType("message/rfc822");
                    // createChooser shows user a list of app that can handle
                    // this MIME type, which is, email
                    startActivity(Intent.createChooser(email,
                            "Choose an Email client :"));

                }
            }
        });



    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Only handle when 2nd activity closed normally
        //  and data contains something
        if(resultCode == RESULT_OK){
            if (data != null) {
                // Get data passed back from 2nd activity
                int Week = data.getIntExtra("wk", 0);
                String module = data.getStringExtra("module");
                String grade = data.getStringExtra("grade");
                if(requestCode == requestCodeForC347){
                    CA.add(new DailyCA(grade, module, Week));
                    a.notifyDataSetChanged();
                }
                if(requestCode == requestCodeForC302){
                    CA2.add(new DailyCA(grade, module, Week));
                    a.notifyDataSetChanged();
                }


            }
        }
    }
}
