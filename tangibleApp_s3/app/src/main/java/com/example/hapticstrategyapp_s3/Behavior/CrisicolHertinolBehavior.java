package com.example.hapticstrategyapp_s3.Behavior;

import android.graphics.Bitmap;

import com.example.hapticstrategyapp_s3.Activities.SlideActivity;
import com.example.hapticstrategyapp_s3.Controller.Event;
import com.example.hapticstrategyapp_s3.Controller.SlideController;
import com.example.hapticstrategyapp_s3.Polygons.CrisicolHertinolPolygons;
import com.example.hapticstrategyapp_s3.R;

public class CrisicolHertinolBehavior extends SlideBehaviorPolygon{

    public CrisicolHertinolBehavior(SlideController sc) {
        super(R.drawable.crisicol_hertinol, sc);
    }

    @Override
    public void drawPolygons(SlideActivity sa) {
        CrisicolHertinolPolygons poly = new CrisicolHertinolPolygons();
        sa.drawPolygon(poly.TITLE_1);
        sa.drawPolygon(poly.BAR_PLACEBO1);
        sa.drawPolygon(poly.BAR_CROSICOL);
        sa.drawPolygon(poly.X_PLACEBO1);
        sa.drawPolygon(poly.X_CROSICOL);
        sa.drawPolygon(poly.Y_AXIS_1);
        sa.drawPolygon(poly.DIVIDER);
        sa.drawPolygon(poly.TITLE_2);
        sa.drawPolygon(poly.BAR_PLACEBO2);
        sa.drawPolygon(poly.BAR_HERTINOL);
        sa.drawPolygon(poly.X_PLACEBO2);
        sa.drawPolygon(poly.X_HERTINOL);
        sa.drawPolygon(poly.Y_AXIS_2);
        sa.drawPolygon(poly.SIXTY_LINE1);
        sa.drawPolygon(poly.FIFTY_LINE1);
        sa.drawPolygon(poly.FORTY_LINE1);
        sa.drawPolygon(poly.THIRTY_LINE1);
        sa.drawPolygon(poly.TWENTY_LINE1);
        sa.drawPolygon(poly.SIXTY_LINE2);
        sa.drawPolygon(poly.FIFTY_LINE2);
        sa.drawPolygon(poly.FORTY_LINE2);
        sa.drawPolygon(poly.THIRTY_LINE2);
        sa.drawPolygon(poly.TWENTY_LINE2);
        sa.drawPolygon(poly.TEN_LINE2);
        sa.drawPolygon(poly.ZERO_LINE2);
    }

    @Override
    public void tapReaction(int x, int y, Bitmap bitmap, SlideActivity sa) {
        int width = bitmap.getWidth();
        String action = Event.ACTION_TAP;

        CrisicolHertinolPolygons poly = new CrisicolHertinolPolygons();

        if (poly.inPolygon(poly.TITLE_1, x, y, width)) {
            String s = "Crisicol Helps!";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.BAR_PLACEBO1, x, y, width)) {
            String s = "Bar 1";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.BAR_CROSICOL, x, y, width)) {
            String s = "Bar 2";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.X_PLACEBO1, x, y, width)) {
            String s = "Placebo";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.X_CROSICOL, x, y, width)) {
            String s = "Crosicol";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.Y_AXIS_1, x, y, width)) {
            String s = "Percent of patients who die";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.DIVIDER, x, y, width)) {
            String s = "New Graph";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.TITLE_2, x, y, width)) {
            String s = "Hertinol Helps!";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.BAR_PLACEBO2, x, y, width)) {
            String s = "Bar 3";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.BAR_HERTINOL, x, y, width)) {
            String s = "Bar 4";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.X_PLACEBO2, x, y, width)) {
            String s = "Placebo";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.X_HERTINOL, x, y, width)) {
            String s = "Hertinol";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.Y_AXIS_2, x, y, width)) {
            String s = "Percent of patients who die";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.TWENTY_LINE1, x, y, width)) {
            String s  = "20 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.THIRTY_LINE1, x, y, width)) {
            String s  = "30 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.FORTY_LINE1, x, y, width)) {
            String s  = "40 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.FIFTY_LINE1, x, y, width)) {
            String s  = "50 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SIXTY_LINE1, x, y, width)) {
            String s  = "60 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.ZERO_LINE2, x, y, width)) {
            String s  = "0 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.TEN_LINE2, x, y, width)) {
            String s  = "10 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.TWENTY_LINE2, x, y, width)) {
            String s  = "20 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.THIRTY_LINE2, x, y, width)) {
            String s  = "30 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.FORTY_LINE2, x, y, width)) {
            String s  = "40 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.FIFTY_LINE2, x, y, width)) {
            String s  = "50 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SIXTY_LINE2, x, y, width)) {
            String s  = "60 Percent";
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

        CrisicolHertinolPolygons poly = new CrisicolHertinolPolygons();

        if (poly.inPolygon(poly.TITLE_1, x, y, width)) {
            String sAdd = "In Chart 1 Title";
            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
                String s = "Crisicol Helps!";
                sc.reactAreaThenBargraphNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else if (poly.inPolygon(poly.BAR_PLACEBO1, x, y, width)) {
            String sAdd = "In Placebo Bar 1";
            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
                String s = "Bar 1";
                sc.reactAreaThenBargraphNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else if (poly.inPolygon(poly.BAR_CROSICOL, x, y, width)) {
            String sAdd = "In Crosicol Bar";
            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
                String s = "Bar 2";
                sc.reactAreaThenBargraphNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else if (poly.inPolygon(poly.X_PLACEBO1, x, y, width)) {
            String sAdd = "In Chart 1 x-axis";
            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
                String s = "Placebo 1";
                sc.reactAreaThenBargraphNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else if (poly.inPolygon(poly.X_CROSICOL, x, y, width)) {
            String sAdd = "In Chart 1 x-axis";
            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
                String s = "Crosicol";
                sc.reactAreaThenBargraphNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else if (poly.inPolygon(poly.Y_AXIS_1, x, y, width)) {
            String sAdd = "In Chart 1 y-axis";
            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
                String s = "Percent of patients who die";
                sc.reactAreaThenBargraphNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else if (poly.inPolygon(poly.DIVIDER, x, y, width)) {
            String s = "New graph";
            sc.reactAreaThenBargraphNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.TITLE_2, x, y, width)) {
            String sAdd = "In Chart 2 Title";
            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
                String s = "Hertinol Helps!";
                sc.reactAreaThenBargraphNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else if (poly.inPolygon(poly.BAR_PLACEBO2, x, y, width)) {
            String sAdd = "In Placebo Bar 2";
            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
                String s = "Bar 3";
                sc.reactAreaThenBargraphNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else if (poly.inPolygon(poly.BAR_HERTINOL, x, y, width)) {
            String sAdd = "In Hertinol Bar";
            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
                String s = "Bar 4";
                sc.reactAreaThenBargraphNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else if (poly.inPolygon(poly.X_PLACEBO2, x, y, width)) {
            String sAdd = "In Chart 2 x-axis";
            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
                String s = "Placebo 2";
                sc.reactAreaThenBargraphNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else if (poly.inPolygon(poly.X_HERTINOL, x, y, width)) {
            String sAdd = "In Chart 2 x-axis";
            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
                String s = "Hertinol";
                sc.reactAreaThenBargraphNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else if (poly.inPolygon(poly.Y_AXIS_2, x, y, width)) {
            String sAdd = "In Chart 2 y-axis";
            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
                String s = "Percent of patients who die";
                sc.reactAreaThenBargraphNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else if (poly.inPolygon(poly.TWENTY_LINE1, x, y, width)) {
            String s = "20 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.THIRTY_LINE1, x, y, width)) {
            String s = "30 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.FORTY_LINE1, x, y, width)) {
            String s = "40 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.FIFTY_LINE1, x, y, width)) {
            String s = "50 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SIXTY_LINE1, x, y, width)) {
            String s = "60 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.ZERO_LINE2, x, y, width)) {
            String s = "0 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.TEN_LINE2, x, y, width)) {
            String s = "10 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.TWENTY_LINE2, x, y, width)) {
            String s = "20 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.THIRTY_LINE2, x, y, width)) {
            String s = "30 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.FORTY_LINE2, x, y, width)) {
            String s = "40 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.FIFTY_LINE2, x, y, width)) {
            String s = "50 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SIXTY_LINE2, x, y, width)) {
            String s = "60 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else {
            sc.reactAreaThenLineBargraphNoSpeak(x, y, bitmap, sa, action);
        }
    }

    private boolean handleGrids(String sAdd, int x, int y, Bitmap bitmap, int width, CrisicolHertinolPolygons poly, SlideActivity sa, String action) {
        if (poly.inPolygon(poly.TWENTY_LINE1, x, y, width)) {
            String s = "20 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
            return true;
        }
        else if (poly.inPolygon(poly.THIRTY_LINE1, x, y, width)) {
            String s = "30 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
            return true;
        }
        else if (poly.inPolygon(poly.FORTY_LINE1, x, y, width)) {
            String s = "40 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
            return true;
        }
        else if (poly.inPolygon(poly.FIFTY_LINE1, x, y, width)) {
            String s = "50 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
            return true;
        }
        else if (poly.inPolygon(poly.SIXTY_LINE1, x, y, width)) {
            String s = "60 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
            return true;
        }
        else if (poly.inPolygon(poly.ZERO_LINE2, x, y, width)) {
            String s = "0 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
            return true;
        }
        else if (poly.inPolygon(poly.TEN_LINE2, x, y, width)) {
            String s = "10 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
            return true;
        }
        else if (poly.inPolygon(poly.TWENTY_LINE2, x, y, width)) {
            String s = "20 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
            return true;
        }
        else if (poly.inPolygon(poly.THIRTY_LINE2, x, y, width)) {
            String s = "30 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
            return true;
        }
        else if (poly.inPolygon(poly.FORTY_LINE2, x, y, width)) {
            String s = "40 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
            return true;
        }
        else if (poly.inPolygon(poly.FIFTY_LINE2, x, y, width)) {
            String s = "50 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
            return true;
        }
        else if (poly.inPolygon(poly.SIXTY_LINE2, x, y, width)) {
            String s = "60 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
            return true;
        }
        return false;
    }
}
