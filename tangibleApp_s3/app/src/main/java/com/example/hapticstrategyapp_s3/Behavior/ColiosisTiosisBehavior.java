package com.example.hapticstrategyapp_s3.Behavior;

import android.graphics.Bitmap;

import com.example.hapticstrategyapp_s3.Activities.SlideActivity;
import com.example.hapticstrategyapp_s3.Controller.Event;
import com.example.hapticstrategyapp_s3.Controller.SlideController;
import com.example.hapticstrategyapp_s3.Polygons.ColiosisTiosisPolygons;
import com.example.hapticstrategyapp_s3.R;

public class ColiosisTiosisBehavior extends SlideBehaviorPolygon {

    boolean speak = true;

    public ColiosisTiosisBehavior(SlideController sc) {
        super(R.drawable.coliosis_tiosis, sc);
    }

    @Override
    public void drawPolygons(SlideActivity sa) {
        ColiosisTiosisPolygons poly = new ColiosisTiosisPolygons();
        sa.drawPolygon(poly.LINE_1);
        sa.drawPolygon(poly.LINE_2);
        sa.drawPolygon(poly.X_AXIS);
        sa.drawPolygon(poly.X_1970);
        sa.drawPolygon(poly.X_1975);
        sa.drawPolygon(poly.X_1980);
        sa.drawPolygon(poly.X_1985);
        sa.drawPolygon(poly.X_1990);
        sa.drawPolygon(poly.X_1995);
        sa.drawPolygon(poly.X_2000);
        sa.drawPolygon(poly.X_2005);
        sa.drawPolygon(poly.Y_AXIS);
        sa.drawPolygon(poly.FIFTY_LINE);
        sa.drawPolygon(poly.FORTY_LINE);
        sa.drawPolygon(poly.THIRTY_LINE);
        sa.drawPolygon(poly.TWENTY_LINE);
        sa.drawPolygon(poly.TEN_LINE);
        sa.drawPolygon(poly.ZERO_LINE);
    }

    @Override
    public void tapReaction(int x, int y, Bitmap bitmap, SlideActivity sa) {
        int width = bitmap.getWidth();
        String action = Event.ACTION_TAP;

        ColiosisTiosisPolygons poly = new ColiosisTiosisPolygons();

        if (poly.inPolygon(poly.LINE_1, x, y, width)) {
            String s = "Coliosis";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.LINE_2, x, y, width)) {
            String s = "Tiosis";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.X_AXIS, x, y, width)) {
            String s = "Year";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.X_1970, x, y, width)) {
            String s = "1970";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.X_1975, x, y, width)) {
            String s = "1975";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.X_1980, x, y, width)) {
            String s = "1980";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.Y_AXIS, x, y, width)) {
            String s = "Percent of sick people";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.ZERO_LINE, x, y, width)) {
            String s  = "0 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.TEN_LINE, x, y, width)) {
            String s  = "10 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.TWENTY_LINE, x, y, width)) {
            String s  = "20 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.THIRTY_LINE, x, y, width)) {
            String s  = "30 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.FORTY_LINE, x, y, width)) {
            String s  = "40 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.FIFTY_LINE, x, y, width)) {
            String s  = "50 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
    }

    @Override
    public void doubleTapReaction(int x, int y, Bitmap bitmap, SlideActivity sa) {
        if (sa.getTouchManagement().circleContains(-16777216, x, y, bitmap)) {
            String s = "Coliosis";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (sa.getTouchManagement().circleContains(-8421505, x, y, bitmap)) {
            String s = "Tiosis";
            sc.reactDotSpeak(x, y, sa, s);
        }
        if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap) && x < 1024) {
            String s = "1970";
            sc.reactDotSpeak(x, y, sa, s);
        }
        if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap) && x > 1024) {
            String s = "2005";
            sc.reactDotSpeak(x, y, sa, s);
        }
    }

    @Override
    public void touchReaction(int x, int y, Bitmap bitmap, SlideActivity sa, String action) {
        int width = bitmap.getWidth();

        ColiosisTiosisPolygons poly = new ColiosisTiosisPolygons();

        if (poly.inPolygon(poly.LINE_1, x, y, width)) {
            String sAdd = "In Line 1";
            if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap) && x < 575) {
                if (speak) {
                    String sSpeak = "Endpoint 19'70";
                    sc.reactDotSpeak(x, y, sa, sSpeak);
                    speak = false;
                }
            }
            else if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap) && x > 1575) {
                if (speak) {
                    String sSpeak = "Endpoint 2005";
                    sc.reactDotSpeak(x, y, sa, sSpeak);
                    speak = false;
                }
            }
            else {
                speak = true;
            }

            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
                String s = "Line 1";
                sc.reactAreaThenLinegraphNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else if (poly.inPolygon(poly.LINE_2, x, y, width)) {
            String sAdd = "In Line 2";
            if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap) && x < 575) {
                if (speak) {
                    String sSpeak = "Endpoint 19'70";
                    sc.reactDotSpeak(x, y, sa, sSpeak);
                    speak = false;
                }
            }
            else if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap) && x > 1575) {
                if (speak) {
                    String sSpeak = "Endpoint 2005";
                    sc.reactDotSpeak(x, y, sa, sSpeak);
                    speak = false;
                }
            }
            else {
                speak = true;
            }

            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
                String s = "Line 2";
                sc.reactAreaThenLinegraphNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else if (poly.inPolygon(poly.X_AXIS, x, y, width)) {
            String sAdd = "In x-axis";
            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
                String s = "Year";
                sc.reactAreaThenLinegraphNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else if (poly.inPolygon(poly.X_1970, x, y, width)) {
            String sAdd = "In x-axis";
            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
                String s = "1970";
                sc.reactAreaThenLinegraphNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else if (poly.inPolygon(poly.X_1975, x, y, width)) {
            String sAdd = "In x-axis";
            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
                String s = "1975";
                sc.reactAreaThenLinegraphNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else if (poly.inPolygon(poly.X_1980, x, y, width)) {
            String sAdd = "In x-axis";
            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
                String s = "1980";
                sc.reactAreaThenLinegraphNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else if (poly.inPolygon(poly.X_1985, x, y, width)) {
            String sAdd = "In x-axis";
            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
                String s = "1985";
                sc.reactAreaThenLinegraphNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else if (poly.inPolygon(poly.X_1990, x, y, width)) {
            String sAdd = "In x-axis";
            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
                String s = "1990";
                sc.reactAreaThenLinegraphNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else if (poly.inPolygon(poly.X_1995, x, y, width)) {
            String sAdd = "In x-axis";
            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
                String s = "1995";
                sc.reactAreaThenLinegraphNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else if (poly.inPolygon(poly.X_2000, x, y, width)) {
            String sAdd = "In x-axis";
            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
                String s = "2000";
                sc.reactAreaThenLinegraphNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else if (poly.inPolygon(poly.X_2005, x, y, width)) {
            String sAdd = "In x-axis";
            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
                String s = "2005";
                sc.reactAreaThenLinegraphNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else if (poly.inPolygon(poly.Y_AXIS, x, y, width)) {
            String sAdd = "In y-axis";
            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
                String s = "Percent of sick people";
                sc.reactAreaThenLinegraphNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else if (poly.inPolygon(poly.ZERO_LINE, x, y, width)) {
            String s = "0 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.TEN_LINE, x, y, width)) {
            String s = "10 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.TWENTY_LINE, x, y, width)) {
            String s = "20 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.THIRTY_LINE, x, y, width)) {
            String s = "30 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.FORTY_LINE, x, y, width)) {
            String s = "40 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.FIFTY_LINE, x, y, width)) {
            String s = "50 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else {
            sc.reactAreaThenLineBargraphNoSpeak(x, y, bitmap, sa, action);
        }
    }

    private boolean handleGrids(String sAdd, int x, int y, Bitmap bitmap, int width, ColiosisTiosisPolygons poly, SlideActivity sa, String action) {

        if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap) && x < 575) {
            if (speak) {
                String sSpeak = "Endpoint 19'70";
                sc.reactDotSpeak(x, y, sa, sSpeak);
                speak = false;
            }
        }
        else if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap) && x > 1575) {
            if (speak) {
                String sSpeak = "Endpoint 2005";
                sc.reactDotSpeak(x, y, sa, sSpeak);
                speak = false;
            }
        }
        else {
            speak = true;
        }

        if (poly.inPolygon(poly.ZERO_LINE, x, y, width)) {
            String s = "0 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
            return true;
        }
        else if (poly.inPolygon(poly.TEN_LINE, x, y, width)) {
            String s = "10 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
            return true;
        }
        else if (poly.inPolygon(poly.TWENTY_LINE, x, y, width)) {
            String s = "20 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
            return true;
        }
        else if (poly.inPolygon(poly.THIRTY_LINE, x, y, width)) {
            String s = "30 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
            return true;
        }
        else if (poly.inPolygon(poly.FORTY_LINE, x, y, width)) {
            String s = "40 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
            return true;
        }
        else if (poly.inPolygon(poly.FIFTY_LINE, x, y, width)) {
            String s = "50 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
            return true;
        }

        return false;
    }
}

