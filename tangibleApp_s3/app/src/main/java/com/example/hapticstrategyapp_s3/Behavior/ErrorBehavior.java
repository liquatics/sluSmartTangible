package com.example.hapticstrategyapp_s3.Behavior;

import android.graphics.Bitmap;

import com.example.hapticstrategyapp_s3.Activities.SlideActivity;
import com.example.hapticstrategyapp_s3.Controller.SlideController;
import com.example.hapticstrategyapp_s3.R;

public class ErrorBehavior extends SlideBehavior {

    public ErrorBehavior(SlideController sc) {
        super(R.drawable.barembossederror, sc);
    }

    @Override
    public void touchReaction(int x, int y, Bitmap bitmap, SlideActivity sa, String action) {
        sa.speak("Error: This is not functioning correctly.");
    }
}
