package com.example.hapticstrategyapp_s3.Behavior;

import android.graphics.Bitmap;

import com.example.hapticstrategyapp_s3.Activities.SlideActivity;
import com.example.hapticstrategyapp_s3.Controller.Event;
import com.example.hapticstrategyapp_s3.Controller.SlideController;
import com.example.hapticstrategyapp_s3.Polygons.ParallelogramBPolygons;
import com.example.hapticstrategyapp_s3.R;

public class ParallelogramBBehavior extends SlideBehaviorPolygon {

    boolean speak = true;

    public ParallelogramBBehavior(SlideController sc) {
        super(R.drawable.par_b, sc);
    }

    @Override
    public void drawPolygons(SlideActivity sa) {
        ParallelogramBPolygons poly = new ParallelogramBPolygons();
        sa.drawPolygon(poly.PB_LINEA);
        sa.drawPolygon(poly.PB_LINEB);
        sa.drawPolygon(poly.PB_LINEC);
        sa.drawPolygon(poly.PB_LINED);
        sa.drawPolygon(poly.PB_ANGLEA);
        sa.drawPolygon(poly.PB_ANGLEB);
        sa.drawPolygon(poly.PB_ANGLEC);
        sa.drawPolygon(poly.PB_ANGLED);
        sa.drawPolygon(poly.PB_WHITESPACE);
    }

    @Override
    public void tapReaction(int x, int y, Bitmap bitmap, SlideActivity sa) {
        int width = bitmap.getWidth();
        String action = Event.ACTION_TAP;

        ParallelogramBPolygons poly = new ParallelogramBPolygons();

        if (poly.inPolygon(poly.PB_LINEA, x, y, width)) {
            String s = "Horizontal Line, Ei, B 6 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PB_LINEB, x, y, width)) {
            String s = "Diagonal Line, B, C, 5.5 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PB_LINEC, x, y, width)) {
            String s = "Horizontal Line, C, D, 6 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PB_LINED, x, y, width)) {
            String s = "Diagonal Line, D, Ei, 5.5 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PB_ANGLEA, x, y, width)) {
            String s = "Angle Ei, 100 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PB_ANGLEB, x, y, width)) {
            String s = "Angle B, 80 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PB_ANGLEC, x, y, width)) {
            String s = "Angle C, 100 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PB_ANGLED, x, y, width)) {
            String s = "Angle D, 80 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PB_WHITESPACE, x, y, width)) {
            sc.reactWS(x, y, bitmap, sa);
        }
    }

    @Override
    public void doubleTapReaction(int x, int y, Bitmap bitmap, SlideActivity sa) {

    }

    @Override
    public void touchReaction(int x, int y, Bitmap bitmap, SlideActivity sa, String action) {
        int width = bitmap.getWidth();

        ParallelogramBPolygons poly = new ParallelogramBPolygons();

        if (poly.inPolygon(poly.PB_LINEA, x, y, width)) {
            String s = "Horizontal Line, Ei, B 6 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PB_LINEB, x, y, width)) {
            String s = "Diagonal Line, B, C, 5.5 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PB_LINEC, x, y, width)) {
            String s = "Horizontal Line, C, D, 6 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PB_LINED, x, y, width)) {
            String s = "Diagonal Line, D, Ei, 5.5 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PB_ANGLEA, x, y, width)) {
            String s = "Angle Ei, 100 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PB_ANGLEB, x, y, width)) {
            String s = "Angle B, 80 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PB_ANGLEC, x, y, width)) {
            String s = "Angle C, 100 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PB_ANGLED, x, y, width)) {
            String s = "Angle D, 80 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PB_WHITESPACE, x, y, width)) {
            sc.reactWS(x, y, bitmap, sa);
        }
    }


}
