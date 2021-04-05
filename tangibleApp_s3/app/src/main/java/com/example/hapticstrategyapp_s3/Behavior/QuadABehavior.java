package com.example.hapticstrategyapp_s3.Behavior;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;

import com.example.hapticstrategyapp_s3.Activities.SlideActivity;
import com.example.hapticstrategyapp_s3.Controller.Event;
import com.example.hapticstrategyapp_s3.Controller.SlideController;
import com.example.hapticstrategyapp_s3.Polygons.QuadAPolygons;
import com.example.hapticstrategyapp_s3.R;

public class QuadABehavior extends SlideBehaviorPolygon {

    boolean speak = true;

    public QuadABehavior(SlideController sc) {
        super(R.drawable.quad_a, sc);
    }

    @Override
    public void drawPolygons(SlideActivity sa) {
        QuadAPolygons poly = new QuadAPolygons();
        sa.drawPolygon(poly.QA_LINEA);
        sa.drawPolygon(poly.QA_LINEB);
        sa.drawPolygon(poly.QA_LINEC);
        sa.drawPolygon(poly.QA_LINED);
        sa.drawPolygon(poly.QA_ANGLEA);
        sa.drawPolygon(poly.QA_ANGLEB);
        sa.drawPolygon(poly.QA_ANGLEC);
        sa.drawPolygon(poly.QA_ANGLED);
        sa.drawPolygon(poly.QA_WHITESPACE);
    }

    @Override
    public void tapReaction(int x, int y, Bitmap bitmap, SlideActivity sa) {
        int width = bitmap.getWidth();
        String action = Event.ACTION_TAP;

        QuadAPolygons poly = new QuadAPolygons();

        // NOTE: commas ',' add a pause in the TTS engine!

        if (poly.inPolygon(poly.QA_LINEA, x, y, width)) {
            String s = "Horizontal Line, Ei, B, equals 5.5 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QA_LINEB, x, y, width)) {
            String s = "Vertical Line, B, C, 5.5 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QA_LINEC, x, y, width)) {
            String s = "Horizontal Line, C, D, 5.5 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QA_LINED, x, y, width)) {
            String s = "Vertical Line, D, Ei,  5.5 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QA_ANGLEA, x, y, width)) {
            String s = "Angle Ei, 90 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QA_ANGLEB, x, y, width)) {
            String s = "Angle B, 90 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QA_ANGLEC, x, y, width)) {
            String s = "Angle C, 90 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QA_ANGLED, x, y, width)) {
            String s = "Angle D, 90 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QA_WHITESPACE, x, y, width)) {
            sc.reactWS(x, y, bitmap, sa);
        }

    }

    @Override
    public void doubleTapReaction(int x, int y, Bitmap bitmap, SlideActivity sa) {

    }

    @Override
    public void touchReaction(int x, int y, Bitmap bitmap, SlideActivity sa, String action) {
        int width = bitmap.getWidth();


        QuadAPolygons poly = new QuadAPolygons();

        // NOTE: commas ',' add a pause in the TTS engine!

        if (poly.inPolygon(poly.QA_LINEA, x, y, width)) {
            String s = "Horizontal Line, Ei, B, equals 5.5 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QA_LINEB, x, y, width)) {
            String s = "Vertical Line, B, C, 5.5 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QA_LINEC, x, y, width)) {
            String s = "Horizontal Line, C, D, 5.5 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QA_LINED, x, y, width)) {
            String s = "Vertical Line, D, Ei,  5.5 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QA_ANGLEA, x, y, width)) {
            String s = "Angle Ei, 90 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QA_ANGLEB, x, y, width)) {
            String s = "Angle B, 90 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QA_ANGLEC, x, y, width)) {
            String s = "Angle C, 90 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QA_ANGLED, x, y, width)) {
            String s = "Angle D, 90 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QA_WHITESPACE, x, y, width)) {
            sc.reactWS(x, y, bitmap, sa);
        }
    }

}
