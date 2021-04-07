package com.example.hapticstrategyapp_s3.Behavior;

import android.graphics.Bitmap;
import android.util.Log;

import com.example.hapticstrategyapp_s3.Activities.SlideActivity;
import com.example.hapticstrategyapp_s3.Controller.Event;
import com.example.hapticstrategyapp_s3.Controller.SlideController;
import com.example.hapticstrategyapp_s3.Polygons.TrapezoidCPolygons;
import com.example.hapticstrategyapp_s3.R;

public class TrapezoidCBehavior extends SlideBehaviorPolygon {

    boolean speak = true;

    public TrapezoidCBehavior(SlideController sc) {
        super(R.drawable.trap_c, sc);
    }

    @Override
    public void drawPolygons(SlideActivity sa) {
//        TrapezoidCPolygons poly = new TrapezoidCPolygons();
//        sa.drawPolygon(poly.TC_LINEA);
//        sa.drawPolygon(poly.TC_LINEB);
//        sa.drawPolygon(poly.TC_LINEC);
//        sa.drawPolygon(poly.TC_LINED);
//        sa.drawPolygon(poly.TC_ANGLEA);
//        sa.drawPolygon(poly.TC_ANGLEB);
//        sa.drawPolygon(poly.TC_ANGLEC);
//        sa.drawPolygon(poly.TC_ANGLED);
//        sa.drawPolygon(poly.TC_WHITESPACE);
    }

    @Override
    public void tapReaction(int x, int y, Bitmap bitmap, SlideActivity sa) {
        int width = bitmap.getWidth();
        String action = Event.ACTION_TAP;
        int color = bitmap.getPixel(x,y);
        Log.d("trap_color:", String.valueOf(color));

        TrapezoidCPolygons poly = new TrapezoidCPolygons();

        if (poly.inPolygon(poly.TC_LINEA, x, y, width)) {
            String s = "Horizontal Line, Ei, B, 5.5 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.TC_LINEB, x, y, width)) {
            String s = "Diagonal Line, B, C, 5.5 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.TC_LINEC, x, y, width)) {
            String s = "Horizontal Line, C, A, 7.5 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.TC_LINED, x, y, width)) {
            String s = "Diagonal Line, D, Ei, 5.5 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.TC_ANGLEA, x, y, width)) {
            String s = "Angle Ei, 100 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.TC_ANGLEB, x, y, width)) {
            String s = "Angle B, 100 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.TC_ANGLEC, x, y, width)) {
            String s = "Angle C, 80 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.TC_ANGLED, x, y, width)) {
            String s = "Angle D, 80 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.TC_WHITESPACE, x, y, width)) {
            sc.reactWS(x,y,bitmap,sa);
        }
    }

    @Override
    public void doubleTapReaction(int x, int y, Bitmap bitmap, SlideActivity sa) {

    }

    @Override
    public void touchReaction(int x, int y, Bitmap bitmap, SlideActivity sa, String action) {
        int width = bitmap.getWidth();

        TrapezoidCPolygons poly = new TrapezoidCPolygons();

        if (poly.inPolygon(poly.TC_LINEA, x, y, width)) {
            String s = "Horizontal Line, Ei, B, 5.5 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.TC_LINEB, x, y, width)) {
            String s = "Diagonal Line, B, C, 5.5 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.TC_LINEC, x, y, width)) {
            String s = "Horizontal Line, C, A, 7.5 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.TC_LINED, x, y, width)) {
            String s = "Diagonal Line, D, Ei, 5.5 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.TC_ANGLEA, x, y, width)) {
            String s = "Angle Ei, 100 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.TC_ANGLEB, x, y, width)) {
            String s = "Angle B, 100 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.TC_ANGLEC, x, y, width)) {
            String s = "Angle C, 80 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.TC_ANGLED, x, y, width)) {
            String s = "Angle D, 80 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.TC_WHITESPACE, x, y, width)) {
            sc.reactWS(x,y,bitmap,sa);
        }


    }

}
