package com.example.hapticstrategyapp_s3.Behavior;

import android.graphics.Bitmap;

import com.example.hapticstrategyapp_s3.Activities.SlideActivity;
import com.example.hapticstrategyapp_s3.Controller.Event;
import com.example.hapticstrategyapp_s3.Controller.SlideController;
import com.example.hapticstrategyapp_s3.Polygons.QuadCPolygons;
import com.example.hapticstrategyapp_s3.R;

public class QuadCBehavior extends SlideBehaviorPolygon {

    boolean speak = true;

    public QuadCBehavior(SlideController sc) {
        super(R.drawable.quad_c, sc);
    }

    @Override
    public void drawPolygons(SlideActivity sa) {
        QuadCPolygons poly = new QuadCPolygons();
        sa.drawPolygon(poly.QC_LINEA);
        sa.drawPolygon(poly.QC_LINEB);
        sa.drawPolygon(poly.QC_LINEC);
        sa.drawPolygon(poly.QC_LINED);
        sa.drawPolygon(poly.QC_ANGLEA);
        sa.drawPolygon(poly.QC_ANGLEB);
        sa.drawPolygon(poly.QC_ANGLEC);
        sa.drawPolygon(poly.QC_ANGLED);
        sa.drawPolygon(poly.QC_WHITESPACE);
    }

    @Override
    public void tapReaction(int x, int y, Bitmap bitmap, SlideActivity sa) {
        int width = bitmap.getWidth();
        String action = Event.ACTION_TAP;

        QuadCPolygons poly = new QuadCPolygons();

        if (poly.inPolygon(poly.QC_LINEA, x, y, width)) {
            String s = "Horizontal Line, Ei, B, 6.5 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QC_LINEB, x, y, width)) {
            String s = "Vertical Line, B, C, 5.5 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QC_LINEC, x, y, width)) {
            String s = "Horizontal Line, C, D, 6.5 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QC_LINED, x, y, width)) {
            String s = "Vertical Line, D, Ei, 5.5 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QC_ANGLEA, x, y, width)) {
            String s = "Angle Ei, 90 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QC_ANGLEB, x, y, width)) {
            String s = "Angle B, 90 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QC_ANGLEC, x, y, width)) {
            String s = "Angle C, 90 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QC_ANGLED, x, y, width)) {
            String s = "Angle D, 90 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QC_WHITESPACE, x, y, width)) {
            sc.reactWS(x,y,bitmap,sa);
        }

    }

    @Override
    public void doubleTapReaction(int x, int y, Bitmap bitmap, SlideActivity sa) {
    }

    @Override
    public void touchReaction(int x, int y, Bitmap bitmap, SlideActivity sa, String action) {
        int width = bitmap.getWidth();

        QuadCPolygons poly = new QuadCPolygons();

        if (poly.inPolygon(poly.QC_LINEA, x, y, width)) {
            String s = "Horizontal Line, Ei, B, 6.5 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QC_LINEB, x, y, width)) {
            String s = "Vertical Line, B, C, 5.5 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QC_LINEC, x, y, width)) {
            String s = "Horizontal Line, C, D, 6.5 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QC_LINED, x, y, width)) {
            String s = "Vertical Line, D, Ei, 5.5 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QC_ANGLEA, x, y, width)) {
            String s = "Angle Ei, 90 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QC_ANGLEB, x, y, width)) {
            String s = "Angle B, 90 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QC_ANGLEC, x, y, width)) {
            String s = "Angle C, 90 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QC_ANGLED, x, y, width)) {
            String s = "Angle D, 90 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QC_WHITESPACE, x, y, width)) {
            sc.reactWS(x,y,bitmap,sa);
        }

    }


}