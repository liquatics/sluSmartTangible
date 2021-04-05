package com.example.hapticstrategyapp_s3.Activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import com.example.hapticstrategyapp_s3.Constants;
import com.example.hapticstrategyapp_s3.Controller.SetAController;
import com.example.hapticstrategyapp_s3.Controller.SetBController;
import com.example.hapticstrategyapp_s3.Controller.SetCController;
import com.example.hapticstrategyapp_s3.Controller.TrainingController;
import com.example.hapticstrategyapp_s3.Controller.GLTController;
import com.example.hapticstrategyapp_s3.ExperimentManager;
import com.example.hapticstrategyapp_s3.R;

import java.io.File;

public class SectionActivity extends Activity implements View.OnTouchListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section);
        View v = findViewById(R.id.mainLayout);

        // Set Participant Identification Number (PIN)
        //int pinInteger = 89898989;
        //ExperimentManager.setParticipantID(pinInteger);
        //Log.i("PARTICIPANT", "ID: " + pinInteger);

        // Start Slide Deck
        //ExperimentManager.setSessionID(1);

        int ID = ExperimentManager.getSessionID();
        Log.d("sessionID: ", String.valueOf(ID));
        goToSlide(ExperimentManager.getParticipantID(), ExperimentManager.getSessionID(), v);
    }

    // Set up slide deck
    private void goToSlide(int participantID, int sessionNumber, View v) {
        Intent intent = new Intent(v.getContext(), SlideActivity.class);
        int groupNumber = participantID % 32;
        ExperimentManager.setGroupID(groupNumber);

        if (sessionNumber == 1) {
            ExperimentManager.setController(new SetAController(sessionNumber, groupNumber));
        } else if(sessionNumber == 2){
            ExperimentManager.setController(new SetBController(sessionNumber, groupNumber));
        } else {
            ExperimentManager.setController(new SetCController(sessionNumber, groupNumber));
        }


        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

//        final Button training = findViewById(R.id.training);
//        training.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                ExperimentManager.setSessionID(0);
//                goToSlide(ExperimentManager.getParticipantID(), 0, v);
//            }
//        });
//
//        final Button gltSession = findViewById(R.id.gltSession);
//        gltSession.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                ExperimentManager.setSessionID(1);
//                goToSlide(ExperimentManager.getParticipantID(), 1, v);
//            }
//        });
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
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
}
