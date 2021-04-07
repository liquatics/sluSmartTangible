package com.example.hapticstrategyapp_s3.Behavior;

import android.graphics.Bitmap;
import android.util.Log;

import com.example.hapticstrategyapp_s3.Activities.SlideActivity;
import com.example.hapticstrategyapp_s3.Controller.Event;
import com.example.hapticstrategyapp_s3.Controller.SlideController;
import com.example.hapticstrategyapp_s3.Polygons.ParallelogramCPolygons;
import com.example.hapticstrategyapp_s3.R;

public class ParallelogramCBehavior extends SlideBehaviorPolygon {

    boolean speak = true;

    public ParallelogramCBehavior(SlideController sc) {
        super(R.drawable.par_c, sc);
    }

    @Override
    public void drawPolygons(SlideActivity sa) {
//        ParallelogramCPolygons poly = new ParallelogramCPolygons();
//        sa.drawPolygon(poly.PC_LINEA);
//        sa.drawPolygon(poly.PC_LINEB);
//        sa.drawPolygon(poly.PC_LINEC);
//        sa.drawPolygon(poly.PC_LINED);
//        sa.drawPolygon(poly.PC_ANGLEA);
//        sa.drawPolygon(poly.PC_ANGLEB);
//        sa.drawPolygon(poly.PC_ANGLEC);
//        sa.drawPolygon(poly.PC_ANGLED);
//        sa.drawPolygon(poly.PC_WHITESPACE);
    }

    @Override
    public void tapReaction(int x, int y, Bitmap bitmap, SlideActivity sa) {
        int width = bitmap.getWidth();
        String action = Event.ACTION_TAP;

        ParallelogramCPolygons poly = new ParallelogramCPolygons();

        if (poly.inPolygon(poly.PC_LINEA, x, y, width)) {
            String s = "Horizontal Line, Ei, B, 7 inches";
            int color = bitmap.getPixel(x,y);
            //Log.d("color: ", String.valueOf(color));
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PC_LINEB, x, y, width)) {
            String s = "Diagonal Line, B, C, 5.5 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PC_LINEC, x, y, width)) {
            String s = "Horizontal Line, C, D, 7 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PC_LINED, x, y, width)) {
            String s = "Diagonal Line D, Ei, 5.5 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PC_ANGLEA, x, y, width)) {
            String s = "Angle Ei, 80 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PC_ANGLEB, x, y, width)) {
            String s = "Angle B, 100 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PC_ANGLEC, x, y, width)) {
            String s = "Angle C, 80 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PC_ANGLED, x, y, width)) {
            String s = "Angle D, 100 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PC_WHITESPACE, x, y, width)) {
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

        ParallelogramCPolygons poly = new ParallelogramCPolygons();

        if (poly.inPolygon(poly.PC_LINEA, x, y, width)) {
            String s = "Horizontal Line, Ei, B, 7 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PC_LINEB, x, y, width)) {
            String s = "Diagonal Line, B, C, 5.5 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PC_LINEC, x, y, width)) {
            String s = "Horizontal Line, C, D, 7 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PC_LINED, x, y, width)) {
            String s = "Diagonal Line D, Ei, 5.5 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PC_ANGLEA, x, y, width)) {
            String s = "Angle Ei, 80 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PC_ANGLEB, x, y, width)) {
            String s = "Angle B, 100 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PC_ANGLEC, x, y, width)) {
            String s = "Angle C, 80 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PC_ANGLED, x, y, width)) {
            String s = "Angle D, 100 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PC_WHITESPACE, x, y, width)) {
            sc.reactWS(x, y, bitmap, sa);
        } else {
            sc.reactNothing(x, y, bitmap, sa);
        }
    }


}
