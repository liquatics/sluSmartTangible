package com.example.hapticstrategyapp_s3.Behavior;

import android.graphics.Bitmap;

import com.example.hapticstrategyapp_s3.Activities.SlideActivity;
import com.example.hapticstrategyapp_s3.Controller.Event;
import com.example.hapticstrategyapp_s3.Controller.SlideController;
import com.example.hapticstrategyapp_s3.Polygons.TrapezoidBPolygons;
import com.example.hapticstrategyapp_s3.R;

public class TrapezoidBBehavior extends SlideBehaviorPolygon {

    boolean speak = true;

    public TrapezoidBBehavior(SlideController sc) {
        super(R.drawable.trap_b, sc);
    }

    @Override
    public void drawPolygons(SlideActivity sa) {
        TrapezoidBPolygons poly = new TrapezoidBPolygons();
        sa.drawPolygon(poly.TB_LINEA);
        sa.drawPolygon(poly.TB_LINEB);
        sa.drawPolygon(poly.TB_LINEC);
        sa.drawPolygon(poly.TB_LINED);
        sa.drawPolygon(poly.TB_ANGLEA);
        sa.drawPolygon(poly.TB_ANGLEB);
        sa.drawPolygon(poly.TB_ANGLEC);
        sa.drawPolygon(poly.TB_ANGLED);
        sa.drawPolygon(poly.TB_WHITESPACE);
    }

    @Override
    public void tapReaction(int x, int y, Bitmap bitmap, SlideActivity sa) {
        int width = bitmap.getWidth();
        String action = Event.ACTION_TAP;

        TrapezoidBPolygons poly = new TrapezoidBPolygons();

        if (poly.inPolygon(poly.TB_LINEA, x, y, width)) {
            String s = "Horizontal Line, Ei, B, 5.5 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.TB_LINEB, x, y, width)) {
            String s = "Diagonal Line, B, C, 5.75 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.TB_LINEC, x, y, width)) {
            String s = "Horizontal Line, C, D, 7.2 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.TB_LINED, x, y, width)) {
            String s = "Vertical Line, D, Ei, 5.5 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.TB_ANGLEA, x, y, width)) {
            String s = "Angle Ei, 90 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.TB_ANGLEB, x, y, width)) {
            String s = "Angle B, 110 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.TB_ANGLEC, x, y, width)) {
            String s = "Angle C, 70 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.TB_ANGLED, x, y, width)) {
            String s = "Angle D, 90 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.TB_WHITESPACE, x, y, width)) {
            sc.reactWS(x,y,bitmap,sa);
        }
    }

    @Override
    public void doubleTapReaction(int x, int y, Bitmap bitmap, SlideActivity sa) {

    }

    @Override
    public void touchReaction(int x, int y, Bitmap bitmap, SlideActivity sa, String action) {
        int width = bitmap.getWidth();

        TrapezoidBPolygons poly = new TrapezoidBPolygons();

        if (poly.inPolygon(poly.TB_LINEA, x, y, width)) {
            String s = "Horizontal Line, Ei, B, 5.5 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.TB_LINEB, x, y, width)) {
            String s = "Diagonal Line, B, C, 5.75 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.TB_LINEC, x, y, width)) {
            String s = "Horizontal Line, C, D, 7.2 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.TB_LINED, x, y, width)) {
            String s = "Vertical Line, D, Ei, 5.5 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.TB_ANGLEA, x, y, width)) {
            String s = "Angle Ei, 90 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.TB_ANGLEB, x, y, width)) {
            String s = "Angle B, 110 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.TB_ANGLEC, x, y, width)) {
            String s = "Angle C, 70 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.TB_ANGLED, x, y, width)) {
            String s = "Angle D, 90 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.TB_WHITESPACE, x, y, width)) {
            sc.reactWS(x,y,bitmap,sa);
        }


    }

}
