package com.example.hapticstrategyapp_s3.Activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hapticstrategyapp_s3.Constants;
import com.example.hapticstrategyapp_s3.ExperimentManager;
import com.example.hapticstrategyapp_s3.R;

import java.io.File;

public class ParticipantID extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participant);

        Button beginButton = findViewById(R.id.beginButton);
        beginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Select editText with participant ID
                final EditText idBox = findViewById(R.id.participantID);
                if (!idBox.getText().toString().matches("")){

                    // Parse Participant ID Number (PIN) and convert to string
                    String pinString = idBox.getText().toString();

                    // Convert PIN string to integer
                    int pinInteger = Integer.parseInt(pinString);
                    ExperimentManager.setParticipantID(pinInteger);

                    startActivity((new Intent(getApplicationContext(), SetSelection.class)));
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sharemenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.share)
            shareFile();
        return true;
    }

    private void shareFile() {
        Intent intentShareFile = new Intent(Intent.ACTION_SEND);
        File folder = ExperimentManager.getPublicDataStorage("data");

        File file = new File(folder.getAbsolutePath() + File.separator + Constants.DATA_FILE);
        if(file.exists()) {
            intentShareFile.setType("text/csv");
            intentShareFile.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://"+file.getAbsolutePath()));

            intentShareFile.putExtra(Intent.EXTRA_SUBJECT, "Sharing File...");

            startActivity(Intent.createChooser(intentShareFile, "Share File"));
        }
    }

//    private void goToGroupScreen(int sessionNumber, View v) {
//        Intent intent = new Intent(v.getContext(), GroupChoiceActivity.class);
//
//        intent.putExtra(Constants.EXTRA_SESSION, sessionNumber);
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//        }
//    }
}
