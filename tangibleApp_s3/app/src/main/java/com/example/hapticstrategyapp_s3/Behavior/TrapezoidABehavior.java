package com.example.hapticstrategyapp_s3.Behavior;

import android.graphics.Bitmap;

import com.example.hapticstrategyapp_s3.Activities.SlideActivity;
import com.example.hapticstrategyapp_s3.Controller.Event;
import com.example.hapticstrategyapp_s3.Controller.SlideController;
import com.example.hapticstrategyapp_s3.Polygons.TrapezoidAPolygons;
import com.example.hapticstrategyapp_s3.R;

public class TrapezoidABehavior extends SlideBehaviorPolygon {

    boolean speak = true;

    public TrapezoidABehavior(SlideController sc) {
        super(R.drawable.trap_a, sc);
    }

    @Override
    public void drawPolygons(SlideActivity sa) {
        TrapezoidAPolygons poly = new TrapezoidAPolygons();
        sa.drawPolygon(poly.TA_LINEA);
        sa.drawPolygon(poly.TA_LINEB);
        sa.drawPolygon(poly.TA_LINEC);
        sa.drawPolygon(poly.TA_LINED);
        sa.drawPolygon(poly.TA_ANGLEA);
        sa.drawPolygon(poly.TA_ANGLEB);
        sa.drawPolygon(poly.TA_ANGLEC);
        sa.drawPolygon(poly.TA_ANGLED);
        sa.drawPolygon(poly.TA_WHITESPACE);
    }

    @Override
    public void tapReaction(int x, int y, Bitmap bitmap, SlideActivity sa) {
        int width = bitmap.getWidth();
        String action = Event.ACTION_TAP;

        TrapezoidAPolygons poly = new TrapezoidAPolygons();

        // NOTE: commas ',' add a pause in the TTS engine!

        if (poly.inPolygon(poly.TA_LINEA, x, y, width)) {
            String s = "Horizontal Line, Ei, B, 7.5 inches";
            sc.reactQuad(x, y, bitmap, sa, action, s);
        } else if (poly.inPolygon(poly.TA_LINEB, x, y, width)) {
            String s = "Diagonal Line, B, C, 5.5 inches";
            sc.reactQuad(x, y, bitmap, sa, action, s);
        } else if (poly.inPolygon(poly.TA_LINEC, x, y, width)) {
            String s = "Horizontal Line, C, D, 5.5 inches";
            sc.reactQuad(x, y, bitmap, sa, action, s);
        } else if (poly.inPolygon(poly.TA_LINED, x, y, width)) {
            String s = "Diagonal Line, D, Ei, 5.5 inches";
            sc.reactQuad(x, y, bitmap, sa, action, s);
        } else if (poly.inPolygon(poly.TA_ANGLEA, x, y, width)) {
            String s = "Angle Ei, 80 degrees";
            sc.reactQuad(x, y, bitmap, sa, action, s);
        } else if (poly.inPolygon(poly.TA_ANGLEB, x, y, width)) {
            String s = "Angle B, 80 degrees";
            sc.reactQuad(x, y, bitmap, sa, action, s);
        } else if (poly.inPolygon(poly.TA_ANGLEC, x, y, width)) {
            String s = "Angle C, 100 degrees";
            sc.reactQuad(x, y, bitmap, sa, action, s);
        } else if (poly.inPolygon(poly.TA_ANGLED, x, y, width)) {
            String s = "Angle D, 100 degrees";
            sc.reactQuad(x, y, bitmap, sa, action, s);
        } else if (poly.inPolygon(poly.TA_WHITESPACE, x, y, width)) {
            sc.reactWS(x, y, bitmap, sa);
        }
    }

    @Override
    public void doubleTapReaction(int x, int y, Bitmap bitmap, SlideActivity sa) {

    }

    @Override
    public void touchReaction(int x, int y, Bitmap bitmap, SlideActivity sa, String action) {
        int width = bitmap.getWidth();

        TrapezoidAPolygons poly = new TrapezoidAPolygons();

        if (poly.inPolygon(poly.TA_LINEA, x, y, width)) {
            String s = "Horizontal Line, Ei, B, 7.5 inches";
            sc.reactQuad(x, y, bitmap, sa, action, s);
        } else if (poly.inPolygon(poly.TA_LINEB, x, y, width)) {
            String s = "Diagonal Line, B, C, 5.5 inches";
            sc.reactQuad(x, y, bitmap, sa, action, s);
        } else if (poly.inPolygon(poly.TA_LINEC, x, y, width)) {
            String s = "Horizontal Line, C, D, 5.5 inches";
            sc.reactQuad(x, y, bitmap, sa, action, s);
        } else if (poly.inPolygon(poly.TA_LINED, x, y, width)) {
            String s = "Diagonal Line, D, Ei, 5.5 inches";
            sc.reactQuad(x, y, bitmap, sa, action, s);
        } else if (poly.inPolygon(poly.TA_ANGLEA, x, y, width)) {
            String s = "Angle Ei, 80 degrees";
            sc.reactQuad(x, y, bitmap, sa, action, s);
        } else if (poly.inPolygon(poly.TA_ANGLEB, x, y, width)) {
            String s = "Angle B, 80 degrees";
            sc.reactQuad(x, y, bitmap, sa, action, s);
        } else if (poly.inPolygon(poly.TA_ANGLEC, x, y, width)) {
            String s = "Angle C, 100 degrees";
            sc.reactQuad(x, y, bitmap, sa, action, s);
        } else if (poly.inPolygon(poly.TA_ANGLED, x, y, width)) {
            String s = "Angle D, 100 degrees";
            sc.reactQuad(x, y, bitmap, sa, action, s);
        } else if (poly.inPolygon(poly.TA_WHITESPACE, x, y, width)) {
            sc.reactWS(x, y, bitmap, sa);
        }


    }

}
