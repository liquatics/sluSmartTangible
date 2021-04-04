package com.example.hapticstrategyapp_s3.Behavior;

import android.graphics.Bitmap;

import com.example.hapticstrategyapp_s3.Activities.SlideActivity;
import com.example.hapticstrategyapp_s3.Controller.Event;
import com.example.hapticstrategyapp_s3.Controller.SlideController;
import com.example.hapticstrategyapp_s3.Polygons.LineTrainingPolygons;
import com.example.hapticstrategyapp_s3.R;

public class LineTrainingBehavior extends SlideBehaviorPolygon {

    boolean speak = true;

    public LineTrainingBehavior(SlideController sc) {
        super(R.drawable.line_training, sc);
    }

    @Override
    public void drawPolygons(SlideActivity sa) {
//        LineTrainingPolygons poly = new LineTrainingPolygons();
//        sa.drawPolygon(poly.LINE_1);
    }

    @Override
    public void tapReaction(int x, int y, Bitmap bitmap, SlideActivity sa) {
        int width = bitmap.getWidth();
        String action = Event.ACTION_TAP;

        LineTrainingPolygons poly = new LineTrainingPolygons();


        if (poly.inPolygon(poly.LINE_1, x, y, width)) {
            String s = "Line 1";
            sc.reactTapReadAgain(x, y, sa, s);
        }
    }

    @Override
    public void doubleTapReaction(int x, int y, Bitmap bitmap, SlideActivity sa) {
        if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap) && x < 1024) {
            String s = "Dot Endpoint 1";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap) && x > 1024) {
            String s = "Dot Endpoint 2";
            sc.reactDotSpeak(x, y, sa, s);
        }
    }

    @Override
    public void touchReaction(int x, int y, Bitmap bitmap, SlideActivity sa, String action) {
        int width = bitmap.getWidth();

        LineTrainingPolygons poly = new LineTrainingPolygons();

        if (poly.inPolygon(poly.LINE_1, x, y, width)) {
            if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap)) {
                if (speak) {
                    String sSpeak = "Dot Endpoint";
                    sc.reactDotSpeak(x, y, sa, sSpeak);
                    speak = false;
                }
            }
            else {
                speak = true;
            }

            String s = "Line 1";
            sc.reactAreaThenLinegraphNoRepeat(x, y, bitmap, sa, action, s);
        }
        else {
            sc.reactAreaThenLineBargraphNoSpeak(x, y, bitmap, sa, action);
        }
    }
}
