package com.example.hapticstrategyapp_s3.Behavior;

import android.graphics.Bitmap;

import com.example.hapticstrategyapp_s3.Activities.SlideActivity;
import com.example.hapticstrategyapp_s3.Controller.Event;
import com.example.hapticstrategyapp_s3.Controller.SlideController;
import com.example.hapticstrategyapp_s3.Polygons.PieChartPolygons;
import com.example.hapticstrategyapp_s3.R;

public class PieChartBehavior extends SlideBehaviorPolygon{

    public PieChartBehavior(SlideController sc) {
        super(R.drawable.pie_chart, sc);
    }

    @Override
    public void drawPolygons(SlideActivity sa) {
        PieChartPolygons poly = new PieChartPolygons();
        sa.drawPolygon(poly.TITLE);
        sa.drawPolygon(poly.PIE_CHART);
//        sa.drawPolygon(poly.BAR_CROSICOL);
//        sa.drawPolygon(poly.X_PLACEBO1);
//        sa.drawPolygon(poly.X_CROSICOL);
//        sa.drawPolygon(poly.TITLE_2);
//        sa.drawPolygon(poly.BAR_PLACEBO2);
//        sa.drawPolygon(poly.BAR_HERTINOL);
//        sa.drawPolygon(poly.X_PLACEBO2);
//        sa.drawPolygon(poly.X_HERTINOL);
//        sa.drawPolygon(poly.SIXTY_LINE);
//        sa.drawPolygon(poly.FIFTY_LINE);
//        sa.drawPolygon(poly.FORTY_LINE);
//        sa.drawPolygon(poly.THIRTY_LINE);
//        sa.drawPolygon(poly.TWENTY_LINE);
    }

    @Override
    public void tapReaction(int x, int y, Bitmap bitmap, SlideActivity sa) {
        int width = bitmap.getWidth();
        String action = Event.ACTION_TAP;

        PieChartPolygons poly = new PieChartPolygons();

        if (poly.inPolygon(poly.TITLE, x, y, width)) {
            String s = "Percentage of people that die from different forms of cancer";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.PIE_CHART, x, y, width)) {
            String s = "Pie Chart";
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

        PieChartPolygons poly = new PieChartPolygons();

        if (poly.inPolygon(poly.TITLE, x, y, width)) {
            String s = "Title";
            sc.reactAreaThenPiechartNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.PIE_CHART, x, y, width)) {
            String s = "Pie Chart";
            sc.reactAreaThenPiechartNoRepeat(x, y, bitmap, sa, action, s);
        }
        else {
            sc.reactAreaThenLineBargraphNoSpeak(x, y, bitmap, sa, action);
        }
    }

}
