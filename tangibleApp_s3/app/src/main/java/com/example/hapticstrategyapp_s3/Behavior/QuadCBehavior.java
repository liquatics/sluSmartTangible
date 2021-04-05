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
    }

    @Override
    public void tapReaction(int x, int y, Bitmap bitmap, SlideActivity sa) {
        int width = bitmap.getWidth();
        String action = Event.ACTION_TAP;

        QuadCPolygons poly = new QuadCPolygons();

        if (poly.inPolygon(poly.QC_LINEA, x, y, width)) {
            String s = "Line Ei equals 6.5 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QC_LINEB, x, y, width)) {
            String s = "Line B equals 5.5 inches";
            sc.reactAreaThenLinegraphNoRepeat(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QC_LINEC, x, y, width)) {
            String s = "Line C equals 6.5 inches";
            sc.reactAreaThenLinegraphNoRepeat(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QC_LINED, x, y, width)) {
            String s = "Line D equals 5.5 inches";
            sc.reactAreaThenLinegraphNoRepeat(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QC_ANGLEA, x, y, width)) {
            String s = "Angle Ei equals 90 degrees";
            sc.reactAreaThenLinegraphNoRepeat(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QC_ANGLEB, x, y, width)) {
            String s = "Angle B equals 90 degrees";
            sc.reactAreaThenLinegraphNoRepeat(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QC_ANGLEC, x, y, width)) {
            String s = "Angle C equals 90 degrees";
            sc.reactAreaThenLinegraphNoRepeat(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QC_ANGLED, x, y, width)) {
            String s = "Angle D equals 90 degrees";
            sc.reactAreaThenLinegraphNoRepeat(x,y,bitmap,sa,action,s);
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
            String s = "Line Ei equals 6.5 inches";

            //Log.d("color: ", String.valueOf(bitmap.getPixel(x,y)));
            sc.reactQuad(x, y, bitmap, sa, action, s);
        }

    }


}