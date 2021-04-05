package com.example.hapticstrategyapp_s3.Behavior;

import android.graphics.Bitmap;

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
        ParallelogramCPolygons poly = new ParallelogramCPolygons();
        sa.drawPolygon(poly.PC_LINEA);
        sa.drawPolygon(poly.PC_LINEB);
        sa.drawPolygon(poly.PC_LINEC);
        sa.drawPolygon(poly.PC_LINED);
        sa.drawPolygon(poly.PC_ANGLEA);
        sa.drawPolygon(poly.PC_ANGLEB);
        sa.drawPolygon(poly.PC_ANGLEC);
        sa.drawPolygon(poly.PC_ANGLED);
    }

    @Override
    public void tapReaction(int x, int y, Bitmap bitmap, SlideActivity sa) {
        int width = bitmap.getWidth();
        String action = Event.ACTION_TAP;

        ParallelogramCPolygons poly = new ParallelogramCPolygons();

        if (poly.inPolygon(poly.PC_LINEA, x, y, width)) {
            String s = "Line Ei equals 7 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PC_LINEB, x, y, width)) {
            String s = "Line B equals 5.5 inches";
            sc.reactAreaThenLinegraphNoRepeat(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PC_LINEC, x, y, width)) {
            String s = "Line C equals 7 inches";
            sc.reactAreaThenLinegraphNoRepeat(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PC_LINED, x, y, width)) {
            String s = "Line D equals 5.5 inches";
            sc.reactAreaThenLinegraphNoRepeat(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PC_ANGLEA, x, y, width)) {
            String s = "Angle Ei equals 80 degrees";
            sc.reactAreaThenLinegraphNoRepeat(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PC_ANGLEB, x, y, width)) {
            String s = "Angle B equals 100 degrees";
            sc.reactAreaThenLinegraphNoRepeat(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PC_ANGLEC, x, y, width)) {
            String s = "Angle C equals 80 degrees";
            sc.reactAreaThenLinegraphNoRepeat(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.PC_ANGLED, x, y, width)) {
            String s = "Angle D equals 100 degrees";
            sc.reactAreaThenLinegraphNoRepeat(x,y,bitmap,sa,action,s);
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
            String s = "Line Ei equals 6 inches";

            //Log.d("color: ", String.valueOf(bitmap.getPixel(x,y)));
            sc.reactQuad(x, y, bitmap, sa, action, s);
        }
    }


}
