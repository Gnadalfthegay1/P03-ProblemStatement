package com.myapplicationdev.android.p03_problemstatement;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class add extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Button btn = (Button) findViewById(R.id.btSubmit);
        Intent i = getIntent();
        final int wk = i.getIntExtra("wk", 0);
        TextView textView = (TextView)findViewById(R.id.textViewWeek);
        textView.setText("Week "+ (wk+1));
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                // Get the RadioGroup object
                RadioGroup rg = (RadioGroup) findViewById(R.id.RadioGroup);
                // Get the Id of the selected radio button in the RadioGroup
                int selectedButtonId = rg.getCheckedRadioButtonId();
                // Get the radio button object from the Id we had gotten above
                RadioButton rb = (RadioButton) findViewById(selectedButtonId);
                Intent i = getIntent();
                String module = i.getStringExtra("module");
                Intent ia = new Intent();
                i.putExtra("grade", rb.getText());
                i.putExtra("module", module);
                i.putExtra("wk", wk+1);

                setResult(RESULT_OK, i);
                finish();

            }});

    }
}
