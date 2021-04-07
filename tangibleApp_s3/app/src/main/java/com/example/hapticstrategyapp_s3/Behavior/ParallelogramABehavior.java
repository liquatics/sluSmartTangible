package com.example.hapticstrategyapp_s3.Behavior;

import android.graphics.Bitmap;

import com.example.hapticstrategyapp_s3.Activities.SlideActivity;
import com.example.hapticstrategyapp_s3.Controller.Event;
import com.example.hapticstrategyapp_s3.Controller.SlideController;
import com.example.hapticstrategyapp_s3.Polygons.ParallelogramAPolygons;
import com.example.hapticstrategyapp_s3.R;

public class ParallelogramABehavior extends SlideBehaviorPolygon {

    boolean speak = true;

    public ParallelogramABehavior(SlideController sc) {
        super(R.drawable.par_a, sc);
    }

    @Override
    public void drawPolygons(SlideActivity sa) {
//        ParallelogramAPolygons poly = new ParallelogramAPolygons();
//        sa.drawPolygon(poly.PA_LINEA);
//        sa.drawPolygon(poly.PA_LINEB);
//        sa.drawPolygon(poly.PA_LINEC);
//        sa.drawPolygon(poly.PA_LINED);
//        sa.drawPolygon(poly.PA_ANGLEA);
//        sa.drawPolygon(poly.PA_ANGLEB);
//        sa.drawPolygon(poly.PA_ANGLEC);
//        sa.drawPolygon(poly.PA_ANGLED);
//        sa.drawPolygon(poly.PA_WHITESPACE);
    }

    @Override
    public void tapReaction(int x, int y, Bitmap bitmap, SlideActivity sa) {
        int width = bitmap.getWidth();
        String action = Event.ACTION_TAP;

        ParallelogramAPolygons poly = new ParallelogramAPolygons();

        if (poly.inPolygon(poly.PA_LINEA, x, y, width)) {
            String s = "Horizontal Line, Ei, B, 5.5 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PA_LINEB, x, y, width)) {
            String s = "Diagonal Line, B, C, 7 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PA_LINEC, x, y, width)) {
            String s = "Horizontal Line, C, D 5.5 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PA_LINED, x, y, width)) {
            String s = "Diagonal Line, D, Ei, 7 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PA_ANGLEA, x, y, width)) {
            String s = "Angle Ei, 75 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PA_ANGLEB, x, y, width)) {
            String s = "Angle B, 105 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PA_ANGLEC, x, y, width)) {
            String s = "Angle C, 75 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PA_ANGLED, x, y, width)) {
            String s = "Angle D, 105 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PA_WHITESPACE, x, y, width)) {
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

        ParallelogramAPolygons poly = new ParallelogramAPolygons();

        if (poly.inPolygon(poly.PA_LINEA, x, y, width)) {
            String s = "Horizontal Line, Ei, B, 5.5 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PA_LINEB, x, y, width)) {
            String s = "Diagonal Line, B, C, 7 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PA_LINEC, x, y, width)) {
            String s = "Horizontal Line, C, D 5.5 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PA_LINED, x, y, width)) {
            String s = "Diagonal Line, D, Ei, 7 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PA_ANGLEA, x, y, width)) {
            String s = "Angle Ei, 75 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PA_ANGLEB, x, y, width)) {
            String s = "Angle B, 105 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PA_ANGLEC, x, y, width)) {
            String s = "Angle C, 75 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PA_ANGLED, x, y, width)) {
            String s = "Angle D, 105 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PA_WHITESPACE, x, y, width)) {
            sc.reactWS(x, y, bitmap, sa);
        } else {
            sc.reactNothing(x, y, bitmap, sa);
        }
    }


}
