package com.example.hapticstrategyapp_s3.Behavior;

import android.graphics.Bitmap;

import com.example.hapticstrategyapp_s3.Activities.SlideActivity;
import com.example.hapticstrategyapp_s3.Controller.Event;
import com.example.hapticstrategyapp_s3.Controller.SlideController;
import com.example.hapticstrategyapp_s3.Polygons.QuadTrainingPolygons;
import com.example.hapticstrategyapp_s3.R;

public class QuadTrainingBehavior extends SlideBehaviorPolygon {

    boolean speak = true;

    public QuadTrainingBehavior(SlideController sc) {
        super(R.drawable.quad_training, sc);
    }

    @Override
    public void drawPolygons(SlideActivity sa) {
//        QuadTrainingPolygons poly = new QuadTrainingPolygons();
//        sa.drawPolygon(poly.QT_LINEA);
//        sa.drawPolygon(poly.QT_LINEB);
//        sa.drawPolygon(poly.QT_LINEC);
//        sa.drawPolygon(poly.QT_LINED);
//        sa.drawPolygon(poly.QT_ANGLEA);
//        sa.drawPolygon(poly.QT_ANGLEB);
//        sa.drawPolygon(poly.QT_ANGLEC);
//        sa.drawPolygon(poly.QT_ANGLED);
//        sa.drawPolygon(poly.QT_WHITESPACE);
    }

    @Override
    public void tapReaction(int x, int y, Bitmap bitmap, SlideActivity sa) {
        int width = bitmap.getWidth();
        String action = Event.ACTION_TAP;

        QuadTrainingPolygons poly = new QuadTrainingPolygons();

        // NOTE: commas ',' add a pause in the TTS engine!

        if (poly.inPolygon(poly.QT_LINEA, x, y, width)) {
            String s = "Horizontal Line, Ei, B, equals 3 inches";
            sc.reactQuad(x, y, bitmap, sa, action, s);
        } else if (poly.inPolygon(poly.QT_LINEB, x, y, width)) {
            String s = "Vertical Line, B, C, 3 inches";
            sc.reactQuad(x, y, bitmap, sa, action, s);
        } else if (poly.inPolygon(poly.QT_LINEC, x, y, width)) {
            String s = "Horizontal Line, C, D, 3 inches";
            sc.reactQuad(x, y, bitmap, sa, action, s);
        } else if (poly.inPolygon(poly.QT_LINED, x, y, width)) {
            String s = "Vertical Line, D, Ei, 3 inches";
            sc.reactQuad(x, y, bitmap, sa, action, s);
        } else if (poly.inPolygon(poly.QT_ANGLEA, x, y, width)) {
            String s = "Angle Ei, 90 degrees";
            sc.reactQuad(x, y, bitmap, sa, action, s);
        } else if (poly.inPolygon(poly.QT_ANGLEB, x, y, width)) {
            String s = "Angle B, 90 degrees";
            sc.reactQuad(x, y, bitmap, sa, action, s);
        } else if (poly.inPolygon(poly.QT_ANGLEC, x, y, width)) {
            String s = "Angle C, 90 degrees";
            sc.reactQuad(x, y, bitmap, sa, action, s);
        } else if (poly.inPolygon(poly.QT_ANGLED, x, y, width)) {
            String s = "Angle D, 90 degrees";
            sc.reactQuad(x, y, bitmap, sa, action, s);
        } else if (poly.inPolygon(poly.QT_WHITESPACE, x, y, width)) {
            sc.reactWS(x, y, bitmap, sa);
        } else {
            sc.reactNothing(x, y, bitmap, sa);
        }

    }

    @Override
    public void doubleTapReaction(int x, int y, Bitmap bitmap, SlideActivity sa) {

    }

    @Override
    public void touchReaction(int x, int y, Bitmap bitmap, SlideActivity sa, String action) {
        int width = bitmap.getWidth();


        QuadTrainingPolygons poly = new QuadTrainingPolygons();

        // NOTE: commas ',' add a pause in the TTS engine!
        
        if (poly.inPolygon(poly.QT_LINEA, x, y, width)) {
            String s = "Horizontal Line, Ei, B, equals 3 inches";
            sc.reactQuad(x, y, bitmap, sa, action, s);
        } else if (poly.inPolygon(poly.QT_LINEB, x, y, width)) {
            String s = "Vertical Line, B, C, 3 inches";
            sc.reactQuad(x, y, bitmap, sa, action, s);
        } else if (poly.inPolygon(poly.QT_LINEC, x, y, width)) {
            String s = "Horizontal Line, C, D, 3 inches";
            sc.reactQuad(x, y, bitmap, sa, action, s);
        } else if (poly.inPolygon(poly.QT_LINED, x, y, width)) {
            String s = "Vertical Line, D, Ei, 3 inches";
            sc.reactQuad(x, y, bitmap, sa, action, s);
        } else if (poly.inPolygon(poly.QT_ANGLEA, x, y, width)) {
            String s = "Angle Ei, 90 degrees";
            sc.reactQuad(x, y, bitmap, sa, action, s);
        } else if (poly.inPolygon(poly.QT_ANGLEB, x, y, width)) {
            String s = "Angle B, 90 degrees";
            sc.reactQuad(x, y, bitmap, sa, action, s);
        } else if (poly.inPolygon(poly.QT_ANGLEC, x, y, width)) {
            String s = "Angle C, 90 degrees";
            sc.reactQuad(x, y, bitmap, sa, action, s);
        } else if (poly.inPolygon(poly.QT_ANGLED, x, y, width)) {
            String s = "Angle D, 90 degrees";
            sc.reactQuad(x, y, bitmap, sa, action, s);
        } else if (poly.inPolygon(poly.QT_WHITESPACE, x, y, width)) {
            sc.reactWS(x, y, bitmap, sa);
        } else {
            sc.reactNothing(x, y, bitmap, sa);
        }

    }
}
