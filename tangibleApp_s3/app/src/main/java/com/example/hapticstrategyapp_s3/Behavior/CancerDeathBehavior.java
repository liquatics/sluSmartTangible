package com.example.hapticstrategyapp_s3.Behavior;

import android.graphics.Bitmap;

import com.example.hapticstrategyapp_s3.Activities.SlideActivity;
import com.example.hapticstrategyapp_s3.Controller.Event;
import com.example.hapticstrategyapp_s3.Controller.SlideController;
import com.example.hapticstrategyapp_s3.Polygons.CancerDeathPolygons;
import com.example.hapticstrategyapp_s3.R;

public class CancerDeathBehavior extends SlideBehaviorPolygon {

    public CancerDeathBehavior(SlideController sc) {
        super(R.drawable.cancer_death, sc);
    }

    @Override
    public void drawPolygons(SlideActivity sa) {
        CancerDeathPolygons poly = new CancerDeathPolygons();
        sa.drawPolygon(poly.BAR_1);
        sa.drawPolygon(poly.BAR_2);
        sa.drawPolygon(poly.BAR_3);
        sa.drawPolygon(poly.X_AXIS);
        sa.drawPolygon(poly.RADIATION);
        sa.drawPolygon(poly.CHEMO);
        sa.drawPolygon(poly.SURGERY);
        sa.drawPolygon(poly.Y_AXIS);
        sa.drawPolygon(poly.TEN_LINE);
        sa.drawPolygon(poly.NINE_LINE);
        sa.drawPolygon(poly.EIGHT_LINE);
        sa.drawPolygon(poly.SEVEN_LINE);
        sa.drawPolygon(poly.SIX_LINE);
        sa.drawPolygon(poly.FIVE_LINE);
        sa.drawPolygon(poly.FOUR_LINE);
        sa.drawPolygon(poly.THREE_LINE);
        sa.drawPolygon(poly.TWO_LINE);
        sa.drawPolygon(poly.ONE_LINE);
        sa.drawPolygon(poly.ZERO_LINE);
    }

    @Override
    public void tapReaction(int x, int y, Bitmap bitmap, SlideActivity sa) {
        int width = bitmap.getWidth();
        String action = Event.ACTION_TAP;

        CancerDeathPolygons poly = new CancerDeathPolygons();

        if (poly.inPolygon(poly.BAR_1, x, y, width)) {
            String s = "Bar 1";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.BAR_2, x, y, width)) {
            String s = "Bar 2";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.BAR_3, x, y, width)) {
            String s = "Bar 3";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.X_AXIS, x, y, width)) {
            String s = "Treatment";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.RADIATION, x, y, width)) {
            String s = "Radiation";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.CHEMO, x, y, width)) {
            String s = "Chemotherapy";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SURGERY, x, y, width)) {
            String s = "Surgery";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.Y_AXIS, x, y, width)) {
            String s = "Percent of cancer patients who die";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.ZERO_LINE, x, y, width)) {
            String s  = "0 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.ONE_LINE, x, y, width)) {
            String s = "1 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.TWO_LINE, x, y, width)) {
            String s = "2 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.THREE_LINE, x, y, width)) {
            String s = "3 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.FOUR_LINE, x, y, width)) {
            String s = "4 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.FIVE_LINE, x, y, width)) {
            String s  = "5 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SIX_LINE, x, y, width)) {
            String s  = "6 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SEVEN_LINE, x, y, width)) {
            String s  = "7 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.EIGHT_LINE, x, y, width)) {
            String s  = "8 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.NINE_LINE, x, y, width)) {
            String s  = "9 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.TEN_LINE, x, y, width)) {
            String s  = "10 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
    }

    @Override
    public void doubleTapReaction(int x, int y, Bitmap bitmap, SlideActivity sa) {
//        if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap) && x < 1024) {
//            String s = "Dot Endpoint 1";
//            sc.reactDotSpeak(x, y, sa, s);
//        }
//        else if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap) && x > 1024) {
//            String s = "Dot Endpoint 2";
//            sc.reactDotSpeak(x, y, sa, s);
//        }
    }

    @Override
    public void touchReaction(int x, int y, Bitmap bitmap, SlideActivity sa, String action) {
        int width = bitmap.getWidth();

        CancerDeathPolygons poly = new CancerDeathPolygons();

        if (poly.inPolygon(poly.BAR_1, x, y, width)) {
            String sAdd = "In Bar 1";
            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
                String s = "Bar 1";
                sc.reactAreaThenBargraphNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else if (poly.inPolygon(poly.BAR_2, x, y, width)) {
            String sAdd = "In Bar 2";
            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
                String s = "Bar 2";
                sc.reactAreaThenBargraphNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else if (poly.inPolygon(poly.BAR_3, x, y, width)) {
            String sAdd = "In Bar 3";
            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
                String s = "Bar 3";
                sc.reactAreaThenBargraphNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else if (poly.inPolygon(poly.X_AXIS, x, y, width)) {
            String sAdd = "In x-axis";
            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
                String s = "Treatment";
                sc.reactAreaThenBargraphNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else if (poly.inPolygon(poly.RADIATION, x, y, width)) {
            String sAdd = "In x-axis";
            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
                String s = "Radiation";
                sc.reactAreaThenBargraphNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else if (poly.inPolygon(poly.CHEMO, x, y, width)) {
            String sAdd = "In x-axis";
            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
                String s = "Chemotherapy";
                sc.reactAreaThenBargraphNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else if (poly.inPolygon(poly.SURGERY, x, y, width)) {
            String sAdd = "In x-axis";
            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
                String s = "Surgery";
                sc.reactAreaThenBargraphNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else if (poly.inPolygon(poly.Y_AXIS, x, y, width)) {
            String sAdd = "In y-axis";
            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
                String s = "Percent of cancer patients who die";
                sc.reactAreaThenBargraphNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else if (poly.inPolygon(poly.ZERO_LINE, x, y, width)) {
            String s = "0 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.ONE_LINE, x, y, width)) {
            String s = "1 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.TWO_LINE, x, y, width)) {
            String s = "2 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.THREE_LINE, x, y, width)) {
            String s = "3 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.FOUR_LINE, x, y, width)) {
            String s = "4 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.FIVE_LINE, x, y, width)) {
            String s = "5 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SIX_LINE, x, y, width)) {
            String s = "6 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SEVEN_LINE, x, y, width)) {
            String s = "7 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.EIGHT_LINE, x, y, width)) {
            String s = "8 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.NINE_LINE, x, y, width)) {
            String s = "9 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.TEN_LINE, x, y, width)) {
            String s = "10 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else {
            sc.reactAreaThenLineBargraphNoSpeak(x, y, bitmap, sa, action);
        }
    }

    private boolean handleGrids(String sAdd, int x, int y, Bitmap bitmap, int width, CancerDeathPolygons poly, SlideActivity sa, String action) {
        if (poly.inPolygon(poly.ZERO_LINE, x, y, width)) {
            String s = "0 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
            return true;
        }
        else if (poly.inPolygon(poly.ONE_LINE, x, y, width)) {
            String s = "1 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
            return true;
        }
        else if (poly.inPolygon(poly.TWO_LINE, x, y, width)) {
            String s = "2 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
            return true;
        }
        else if (poly.inPolygon(poly.THREE_LINE, x, y, width)) {
            String s = "3 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
            return true;
        }
        else if (poly.inPolygon(poly.FOUR_LINE, x, y, width)) {
            String s = "4 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
            return true;
        }
        else if (poly.inPolygon(poly.FIVE_LINE, x, y, width)) {
            String s = "5 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
            return true;
        }
        else if (poly.inPolygon(poly.SIX_LINE, x, y, width)) {
            String s = "6 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
            return true;
        }
        else if (poly.inPolygon(poly.SEVEN_LINE, x, y, width)) {
            String s = "7 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
            return true;
        }
        else if (poly.inPolygon(poly.EIGHT_LINE, x, y, width)) {
            String s = "8 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
            return true;
        }
        else if (poly.inPolygon(poly.NINE_LINE, x, y, width)) {
            String s = "9 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
            return true;
        }
        else if (poly.inPolygon(poly.TEN_LINE, x, y, width)) {
            String s = "10 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
            return true;
        }
        return false;
    }
}

