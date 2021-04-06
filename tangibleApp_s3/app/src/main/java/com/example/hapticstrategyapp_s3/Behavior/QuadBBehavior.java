package com.example.hapticstrategyapp_s3.Behavior;

import android.graphics.Bitmap;

import com.example.hapticstrategyapp_s3.Activities.SlideActivity;
import com.example.hapticstrategyapp_s3.Controller.Event;
import com.example.hapticstrategyapp_s3.Controller.SlideController;
import com.example.hapticstrategyapp_s3.Polygons.QuadBPolygons;
import com.example.hapticstrategyapp_s3.R;

public class QuadBBehavior extends SlideBehaviorPolygon {

    boolean speak = true;

    public QuadBBehavior(SlideController sc) {
        super(R.drawable.quad_b, sc);
    }

    @Override
    public void drawPolygons(SlideActivity sa) {
        QuadBPolygons poly = new QuadBPolygons();
        sa.drawPolygon(poly.QB_LINEA);
        sa.drawPolygon(poly.QB_LINEB);
        sa.drawPolygon(poly.QB_LINEC);
        sa.drawPolygon(poly.QB_LINED);
        sa.drawPolygon(poly.QB_ANGLEA);
        sa.drawPolygon(poly.QB_ANGLEB);
        sa.drawPolygon(poly.QB_ANGLEC);
        sa.drawPolygon(poly.QB_ANGLED);
        sa.drawPolygon(poly.QB_WHITESPACE);
    }

    @Override
    public void tapReaction(int x, int y, Bitmap bitmap, SlideActivity sa) {
        int width = bitmap.getWidth();
        String action = Event.ACTION_TAP;

        QuadBPolygons poly = new QuadBPolygons();

        if (poly.inPolygon(poly.QB_LINEA, x, y, width)) {
            String s = "Horizontal Line, Ei, B, 7.5 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QB_LINEB, x, y, width)) {
            String s = "Vertical Line, B, C, 5.5 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QB_LINEC, x, y, width)) {
            String s = "Horizontal Line, C, D, 7.5 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QB_LINED, x, y, width)) {
            String s = "Vertical Line, D, Ei, 5.5 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QB_ANGLEA, x, y, width)) {
            String s = "Angle Ei, 90 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QB_ANGLEB, x, y, width)) {
            String s = "Angle B, 90 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QB_ANGLEC, x, y, width)) {
            String s = "Angle C, 90 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QB_WHITESPACE, x, y, width)) {
            sc.reactWS(x,y,bitmap,sa);
        }

    }

    @Override
    public void doubleTapReaction(int x, int y, Bitmap bitmap, SlideActivity sa) {
    }

    @Override
    public void touchReaction(int x, int y, Bitmap bitmap, SlideActivity sa, String action) {
        int width = bitmap.getWidth();

        QuadBPolygons poly = new QuadBPolygons();

        if (poly.inPolygon(poly.QB_LINEA, x, y, width)) {
            String s = "Horizontal Line, Ei, B, 7.5 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QB_LINEB, x, y, width)) {
            String s = "Vertical Line, B, C, 5.5 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QB_LINEC, x, y, width)) {
            String s = "Horizontal Line, C, D, 7.5 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QB_LINED, x, y, width)) {
            String s = "Vertical Line, D, Ei, 5.5 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QB_ANGLEA, x, y, width)) {
            String s = "Angle Ei, 90 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QB_ANGLEB, x, y, width)) {
            String s = "Angle B, 90 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QB_ANGLEC, x, y, width)) {
            String s = "Angle C, 90 degrees";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QB_WHITESPACE, x, y, width)) {
            sc.reactWS(x,y,bitmap,sa);
        }

    }


}
