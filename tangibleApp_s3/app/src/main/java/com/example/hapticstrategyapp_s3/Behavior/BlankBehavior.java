package com.example.hapticstrategyapp_s3.Behavior;

import android.graphics.Bitmap;

import com.example.hapticstrategyapp_s3.Activities.SlideActivity;
import com.example.hapticstrategyapp_s3.Controller.Event;
import com.example.hapticstrategyapp_s3.Controller.SlideController;
import com.example.hapticstrategyapp_s3.Polygons.BlankPolygons;
import com.example.hapticstrategyapp_s3.R;

public class BlankBehavior extends SlideBehaviorPolygon {

    public BlankBehavior(SlideController sc) {
        super(R.drawable.blank, sc);
    }

    @Override
    public void drawPolygons(SlideActivity sa) {
        BlankPolygons poly = new BlankPolygons();
        sa.drawPolygon(poly.MESSAGE);
    }

    @Override
    public void tapReaction(int x, int y, Bitmap bitmap, SlideActivity sa) {
        int width = bitmap.getWidth();
        String action = Event.ACTION_TAP;

        BlankPolygons poly = new BlankPolygons();

        if (poly.inPolygon(poly.MESSAGE, x, y, width)) {
            String s = "This page is blank on purpose.";
            sc.reactTapReadAgain(x, y, sa, s);
        }
    }

    @Override
    public void doubleTapReaction(int x, int y, Bitmap bitmap, SlideActivity sa) {
//        if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap) && x < 1024) {
//            String s = "Dot Endpoint 1";
//            sc.reactDotSpeak(x, y, sa, s);
//        }
//        else if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap) && x > 1024) {
//            String s = "Dot Endpoint 2";
//            sc.reactDotSpeak(x, y, sa, s);
//        }
    }

    @Override
    public void touchReaction(int x, int y, Bitmap bitmap, SlideActivity sa, String action) {
        int width = bitmap.getWidth();

        BlankPolygons poly = new BlankPolygons();

        if (poly.inPolygon(poly.MESSAGE, x, y, width)) {
            String s = "This page is blank on purpose.";
            sc.reactAreaThenBargraphNoRepeat(x, y, bitmap, sa, action, s);
        }
        else {
            sc.reactAreaThenLineBargraphNoSpeak(x, y, bitmap, sa, action);
        }
    }
}
