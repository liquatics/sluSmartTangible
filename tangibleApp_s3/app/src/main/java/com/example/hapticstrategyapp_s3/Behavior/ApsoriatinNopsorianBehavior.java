package com.example.hapticstrategyapp_s3.Behavior;

import android.graphics.Bitmap;

import com.example.hapticstrategyapp_s3.Activities.SlideActivity;
import com.example.hapticstrategyapp_s3.Controller.Event;
import com.example.hapticstrategyapp_s3.Controller.SlideController;
import com.example.hapticstrategyapp_s3.Polygons.ApsoriatinNopsorianPolygons;
import com.example.hapticstrategyapp_s3.R;

public class ApsoriatinNopsorianBehavior extends SlideBehaviorPolygon {

    boolean speak = true;

    public ApsoriatinNopsorianBehavior(SlideController sc) {
        super(R.drawable.apsoriatin_nopsorian, sc);
    }

    @Override
    public void drawPolygons(SlideActivity sa) {
        ApsoriatinNopsorianPolygons poly = new ApsoriatinNopsorianPolygons();
        sa.drawPolygon(poly.TITLE_1);
        sa.drawPolygon(poly.LINE_1);
        sa.drawPolygon(poly.MONTHS2_1);
        sa.drawPolygon(poly.MONTHS6_1);
        sa.drawPolygon(poly.YAXIS_1);
        sa.drawPolygon(poly.DIVIDER);
        sa.drawPolygon(poly.TITLE_2);
        sa.drawPolygon(poly.LINE_2);
        sa.drawPolygon(poly.MONTHS2_2);
        sa.drawPolygon(poly.MONTHS6_2);
        sa.drawPolygon(poly.YAXIS_2);
    }

    @Override
    public void tapReaction(int x, int y, Bitmap bitmap, SlideActivity sa) {
        int width = bitmap.getWidth();
        String action = Event.ACTION_TAP;

        ApsoriatinNopsorianPolygons poly = new ApsoriatinNopsorianPolygons();

        if (poly.inPolygon(poly.TITLE_1, x, y, width)) {
            String s = "Apsoriatin";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.LINE_1, x, y, width)) {
            String s = "Line 1";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.MONTHS2_1, x, y, width)) {
            String s = "After 2 months";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.MONTHS6_1, x, y, width)) {
            String s = "After 6 months";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.YAXIS_1, x, y, width)) {
            String s = "Percent sick patients";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.DIVIDER, x, y, width)) {
            String s = "Moving into new graph";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.TITLE_2, x, y, width)) {
            String s  = "Nopsorian";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.LINE_2, x, y, width)) {
            String s  = "Line 2";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.MONTHS2_2, x, y, width)) {
            String s  = "After 2 months";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.MONTHS6_2, x, y, width)) {
            String s  = "After 6 months";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.YAXIS_2, x, y, width)) {
            String s  = "Percent sick patients";
            sc.reactTapReadAgain(x, y, sa, s);
        }
    }

    @Override
    public void doubleTapReaction(int x, int y, Bitmap bitmap, SlideActivity sa) {
//        if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap) && (x < 575 || (x > 1006 && x < 1575))) {
//            String s = "After 2 Months";
//            sc.reactDotSpeak(x, y, sa, s);
//        }
//        else if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap) && ((x > 575 && x < 986) || x > 1575)) {
//            String s = "After 6 Months";
//            sc.reactDotSpeak(x, y, sa, s);
//        }
    }

    @Override
    public void touchReaction(int x, int y, Bitmap bitmap, SlideActivity sa, String action) {
        int width = bitmap.getWidth();

        ApsoriatinNopsorianPolygons poly = new ApsoriatinNopsorianPolygons();

        if (poly.inPolygon(poly.TITLE_1, x, y, width)) {
            String s = "Apsoriatin";
            sc.reactAreaThenLinegraphNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.LINE_1, x, y, width)) {
            if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap) && x < 575) {
                if (speak) {
                    String sSpeak = "After 2 Months";
                    sc.reactDotSpeak(x, y, sa, sSpeak);
                    speak = false;
                }
            }
            else if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap) && (x > 575 && x < 986)) {
                if (speak) {
                    String sSpeak = "After 6 Months";
                    sc.reactDotSpeak(x, y, sa, sSpeak);
                    speak = false;
                }
            }
            else {
                speak = true;
            }

            String s = "Line 1";
            sc.reactAreaThenLinegraphNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.MONTHS2_1, x, y, width)) {
            String s = "After 2 months";
            sc.reactAreaThenLinegraphNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.MONTHS6_1, x, y, width)) {
            String s = "After 6 months";
            sc.reactAreaThenLinegraphNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.YAXIS_1, x, y, width)) {
            String s = "Percent sick patients";
            sc.reactAreaThenLinegraphNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.DIVIDER, x, y, width)) {
            String s = "New graph";
            sc.reactAreaThenLinegraphNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.TITLE_2, x, y, width)) {
            String s = "Nopsorian";
            sc.reactAreaThenLinegraphNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.LINE_2, x, y, width)) {
            if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap) && (x > 1006 && x < 1575)) {
                if (speak) {
                    String sSpeak = "After 2 Months";
                    sc.reactDotSpeak(x, y, sa, sSpeak);
                    speak = false;
                }
            }
            else if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap) && x > 1575) {
                if (speak) {
                    String sSpeak = "After 6 Months";
                    sc.reactDotSpeak(x, y, sa, sSpeak);
                    speak = false;
                }
            }
            else {
                speak = true;
            }

            String s = "Line 2";
            sc.reactAreaThenLinegraphNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.MONTHS2_2, x, y, width)) {
            String s = "After 2 months";
            sc.reactAreaThenLinegraphNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.MONTHS6_2, x, y, width)) {
            String s = "After 6 months";
            sc.reactAreaThenLinegraphNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.YAXIS_2, x, y, width)) {
            String s = "Percent sick patients";
            sc.reactAreaThenLinegraphNoRepeat(x, y, bitmap, sa, action, s);
        }
        else {
            sc.reactAreaThenLineBargraphNoSpeak(x, y, bitmap, sa, action);
        }
    }
}
