package com.example.hapticstrategyapp_s3.Behavior;

import android.graphics.Bitmap;

import com.example.hapticstrategyapp_s3.Activities.SlideActivity;
import com.example.hapticstrategyapp_s3.Controller.Event;
import com.example.hapticstrategyapp_s3.Controller.SlideController;
import com.example.hapticstrategyapp_s3.Polygons.DotChartPolygons;
import com.example.hapticstrategyapp_s3.R;

public class DotChartBehavior extends SlideBehaviorPolygon{

    public DotChartBehavior(SlideController sc) {
        super(R.drawable.dot_chart, sc);
    }

    @Override
    public void drawPolygons(SlideActivity sa) {
        DotChartPolygons poly = new DotChartPolygons();
        sa.drawPolygon(poly.CHART);
        sa.drawPolygon(poly.MEN);
        sa.drawPolygon(poly.WOMEN);
        sa.drawPolygon(poly.V1);
        sa.drawPolygon(poly.V2);
        sa.drawPolygon(poly.V3);
        sa.drawPolygon(poly.V4);
        sa.drawPolygon(poly.V5);
        sa.drawPolygon(poly.V6);
        sa.drawPolygon(poly.V7);
        sa.drawPolygon(poly.V8);
        sa.drawPolygon(poly.V9);
        sa.drawPolygon(poly.V10);
        sa.drawPolygon(poly.V11);
    }

    @Override
    public void tapReaction(int x, int y, Bitmap bitmap, SlideActivity sa) {
        int width = bitmap.getWidth();
        String action = Event.ACTION_TAP;

        DotChartPolygons poly = new DotChartPolygons();

        if (poly.inPolygon(poly.CHART, x, y, width)) {
            String s = "Dot Chart";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.MEN, x, y, width)) {
            String s = "Men";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.WOMEN, x, y, width)) {
            String s = "Women";
            sc.reactTapReadAgain(x, y, sa, s);
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

        DotChartPolygons poly = new DotChartPolygons();

        if (poly.inPolygon(poly.CHART, x, y, width)) {
            String sAdd = "In Dot Chart";
            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
                String s = "Dot Chart";
                sc.reactAreaThenDotTestNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else if (poly.inPolygon(poly.MEN, x, y, width)) {
            String sAdd = "In Men Legend";
            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
                String s = "Men";
                sc.reactAreaThenDotTestNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else if (poly.inPolygon(poly.WOMEN, x, y, width)) {
            String sAdd = "In Women Legend";
            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
                String s = "Women";
                sc.reactAreaThenDotTestNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else {
            String s = "";
            sc.reactAreaThenDotTestNoRepeat(x, y, bitmap, sa, action, s);
        }
    }

    private boolean handleGrids(String sAdd, int x, int y, Bitmap bitmap, int width, DotChartPolygons poly, SlideActivity sa, String action) {
        if (poly.inPolygon(poly.V1, x, y, width)) {
            String s = "Vertical Line 1";
            sc.reactDotGridLine(x, y, bitmap, sa, action, s);
            return true;
        }
        else if (poly.inPolygon(poly.V2, x, y, width)) {
            String s = "Vertical Line 2";
            sc.reactDotGridLine(x, y, bitmap, sa, action, s);
            return true;
        }
        else if (poly.inPolygon(poly.V3, x, y, width)) {
            String s = "Vertical Line 3";
            sc.reactDotGridLine(x, y, bitmap, sa, action, s);
            return true;
        }
        else if (poly.inPolygon(poly.V4, x, y, width)) {
            String s = "Vertical Line 4";
            sc.reactDotGridLine(x, y, bitmap, sa, action, s);
            return true;
        }
        else if (poly.inPolygon(poly.V5, x, y, width)) {
            String s = "Vertical Line 5";
            sc.reactDotGridLine(x, y, bitmap, sa, action, s);
            return true;
        }
        else if (poly.inPolygon(poly.V6, x, y, width)) {
            String s = "Vertical Line 6";
            sc.reactDotGridLine(x, y, bitmap, sa, action, s);
            return true;
        }
        else if (poly.inPolygon(poly.V7, x, y, width)) {
            String s = "Vertical Line 7";
            sc.reactDotGridLine(x, y, bitmap, sa, action, s);
            return true;
        }
        else if (poly.inPolygon(poly.V8, x, y, width)) {
            String s = "Vertical Line 8";
            sc.reactDotGridLine(x, y, bitmap, sa, action, s);
            return true;
        }
        else if (poly.inPolygon(poly.V9, x, y, width)) {
            String s = "Vertical Line 9";
            sc.reactDotGridLine(x, y, bitmap, sa, action, s);
            return true;
        }
        else if (poly.inPolygon(poly.V10, x, y, width)) {
            String s = "Vertical Line 10";
            sc.reactDotGridLine(x, y, bitmap, sa, action, s);
            return true;
        }
        else if (poly.inPolygon(poly.V11, x, y, width)) {
            String s = "Vertical Line 11";
            sc.reactDotGridLine(x, y, bitmap, sa, action, s);
            return true;
        }
        return false;
    }
}
