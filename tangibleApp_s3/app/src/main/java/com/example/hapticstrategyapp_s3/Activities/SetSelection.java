package com.example.hapticstrategyapp_s3.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hapticstrategyapp_s3.ExperimentManager;
import com.example.hapticstrategyapp_s3.R;

public class SetSelection extends Activity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_selection);

        //ExperimentManager not setting sessionID?

        Button setAButton = findViewById(R.id.setA_btn);
        setAButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    ExperimentManager.setSessionID(1);
//                    int ID = ExperimentManager.getSessionID();
//                Log.d("sessionID: ", String.valueOf(ID));
                    startActivity((new Intent(getApplicationContext(), SectionActivity.class)));
                }
        });

        Button setBButton = findViewById(R.id.setB_btn);
        setBButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ExperimentManager.setSessionID(2);
                startActivity((new Intent(getApplicationContext(), SectionActivity.class)));
            }
        });

        Button setCButton = findViewById(R.id.setC_btn);
        setCButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ExperimentManager.setSessionID(3);
                startActivity((new Intent(getApplicationContext(), SectionActivity.class)));
            }
        });
    }
}