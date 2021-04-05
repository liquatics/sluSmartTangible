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
    }

    @Override
    public void tapReaction(int x, int y, Bitmap bitmap, SlideActivity sa) {
        int width = bitmap.getWidth();
        String action = Event.ACTION_TAP;

        TrapezoidBPolygons poly = new TrapezoidBPolygons();

        if (poly.inPolygon(poly.TB_LINEA, x, y, width)) {
            String s = "Line Ei equals 5.5 inches";
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.TB_LINEB, x, y, width)) {
            String s = "Line B equals 5.75 inches";
            sc.reactAreaThenLinegraphNoRepeat(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.TB_LINEC, x, y, width)) {
            String s = "Line C equals 7.2 inches";
            sc.reactAreaThenLinegraphNoRepeat(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.TB_LINED, x, y, width)) {
            String s = "Line D equals 5.5 inches";
            sc.reactAreaThenLinegraphNoRepeat(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.TB_ANGLEA, x, y, width)) {
            String s = "Angle Ei equals 90 degrees";
            sc.reactAreaThenLinegraphNoRepeat(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.TB_ANGLEB, x, y, width)) {
            String s = "Angle B equals 110 degrees";
            sc.reactAreaThenLinegraphNoRepeat(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.TB_ANGLEC, x, y, width)) {
            String s = "Angle C equals 70 degrees";
            sc.reactAreaThenLinegraphNoRepeat(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.TB_ANGLED, x, y, width)) {
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

        TrapezoidBPolygons poly = new TrapezoidBPolygons();

        if (poly.inPolygon(poly.TB_LINEA, x, y, width)) {
            String s = "Line Ei equals 5.5 inches";

            //Log.d("color: ", String.valueOf(bitmap.getPixel(x,y)));
            sc.reactQuad(x, y, bitmap, sa, action, s);
        }


    }

}
