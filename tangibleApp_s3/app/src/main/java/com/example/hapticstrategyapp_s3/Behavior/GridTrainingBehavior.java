package com.example.hapticstrategyapp_s3.Behavior;

import android.graphics.Bitmap;

import com.example.hapticstrategyapp_s3.Activities.SlideActivity;
import com.example.hapticstrategyapp_s3.Controller.Event;
import com.example.hapticstrategyapp_s3.Controller.SlideController;
import com.example.hapticstrategyapp_s3.Polygons.GridTrainingPolygons;
import com.example.hapticstrategyapp_s3.R;

public class GridTrainingBehavior extends SlideBehaviorPolygon {

    public GridTrainingBehavior(SlideController sc) {
        super(R.drawable.grid_training, sc);
    }

    @Override
    public void drawPolygons(SlideActivity sa) {
//        GridTrainingPolygons poly = new GridTrainingPolygons();
//        sa.drawPolygon(poly.GRID);
//        sa.drawPolygon(poly.SQ_A1);
//        sa.drawPolygon(poly.SQ_A2);
//        sa.drawPolygon(poly.SQ_A3);
//        sa.drawPolygon(poly.SQ_A4);
//        sa.drawPolygon(poly.SQ_A5);
//        sa.drawPolygon(poly.SQ_A6);
//        sa.drawPolygon(poly.SQ_A7);
//        sa.drawPolygon(poly.SQ_A8);
//        sa.drawPolygon(poly.SQ_B1);
//        sa.drawPolygon(poly.SQ_B2);
//        sa.drawPolygon(poly.SQ_B3);
//        sa.drawPolygon(poly.SQ_B4);
//        sa.drawPolygon(poly.SQ_B5);
//        sa.drawPolygon(poly.SQ_B6);
//        sa.drawPolygon(poly.SQ_B7);
//        sa.drawPolygon(poly.SQ_B8);
//        sa.drawPolygon(poly.SQ_C1);
//        sa.drawPolygon(poly.SQ_C2);
//        sa.drawPolygon(poly.SQ_C3);
//        sa.drawPolygon(poly.SQ_C4);
//        sa.drawPolygon(poly.SQ_C5);
//        sa.drawPolygon(poly.SQ_C6);
//        sa.drawPolygon(poly.SQ_C7);
//        sa.drawPolygon(poly.SQ_C8);
//        sa.drawPolygon(poly.SQ_D1);
//        sa.drawPolygon(poly.SQ_D2);
//        sa.drawPolygon(poly.SQ_D3);
//        sa.drawPolygon(poly.SQ_D4);
//        sa.drawPolygon(poly.SQ_D5);
//        sa.drawPolygon(poly.SQ_D6);
//        sa.drawPolygon(poly.SQ_D7);
//        sa.drawPolygon(poly.SQ_D8);
//        sa.drawPolygon(poly.SQ_E1);
//        sa.drawPolygon(poly.SQ_E2);
//        sa.drawPolygon(poly.SQ_E3);
//        sa.drawPolygon(poly.SQ_E4);
//        sa.drawPolygon(poly.SQ_E5);
//        sa.drawPolygon(poly.SQ_E6);
//        sa.drawPolygon(poly.SQ_E7);
//        sa.drawPolygon(poly.SQ_E8);
//        sa.drawPolygon(poly.SQ_F1);
//        sa.drawPolygon(poly.SQ_F2);
//        sa.drawPolygon(poly.SQ_F3);
//        sa.drawPolygon(poly.SQ_F4);
//        sa.drawPolygon(poly.SQ_F5);
//        sa.drawPolygon(poly.SQ_F6);
//        sa.drawPolygon(poly.SQ_F7);
//        sa.drawPolygon(poly.SQ_F8);
    }

    @Override
    public void tapReaction(int x, int y, Bitmap bitmap, SlideActivity sa) {
        int width = bitmap.getWidth();
        String action = Event.ACTION_TAP;

        GridTrainingPolygons poly = new GridTrainingPolygons();

        if (poly.inPolygon(poly.GRID, x, y, width)) {
            String s = "Grid";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SQ_A1, x, y, width)) {
            String s = "A-1";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_A2, x, y, width)) {
            String s = "A-2";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_A3, x, y, width)) {
            String s = "A-3";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_A4, x, y, width)) {
            String s = "A-4";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_A5, x, y, width)) {
            String s = "A-5";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_A6, x, y, width)) {
            String s  = "A-6";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_A7, x, y, width)) {
            String s  = "A-7";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_A8, x, y, width)) {
            String s  = "A-8";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_B1, x, y, width)) {
            String s  = "B-1";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_B2, x, y, width)) {
            String s  = "B-2";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_B3, x, y, width)) {
            String s  = "B-3";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_B4, x, y, width)) {
            String s  = "B-4";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_B5, x, y, width)) {
            String s  = "B-5";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_B6, x, y, width)) {
            String s  = "B-6";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_B7, x, y, width)) {
            String s  = "B-7";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_B8, x, y, width)) {
            String s  = "B-8";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_C1, x, y, width)) {
            String s  = "C-1";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_C2, x, y, width)) {
            String s  = "C-2";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_C3, x, y, width)) {
            String s  = "C-3";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_C4, x, y, width)) {
            String s  = "C-4";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_C5, x, y, width)) {
            String s  = "C-5";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_C6, x, y, width)) {
            String s  = "C-6";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_C7, x, y, width)) {
            String s  = "C-7";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_C8, x, y, width)) {
            String s  = "C-8";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_D1, x, y, width)) {
            String s  = "D-1";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_D2, x, y, width)) {
            String s  = "D-2";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_D3, x, y, width)) {
            String s  = "D-3";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_D4, x, y, width)) {
            String s  = "D-4";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_D5, x, y, width)) {
            String s  = "D-5";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_D6, x, y, width)) {
            String s  = "D-6";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_D7, x, y, width)) {
            String s  = "D-7";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_D8, x, y, width)) {
            String s  = "D-8";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_E1, x, y, width)) {
            String s  = "E-1";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_E2, x, y, width)) {
            String s  = "E-2";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_E3, x, y, width)) {
            String s  = "E-3";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_E4, x, y, width)) {
            String s  = "E-4";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_E5, x, y, width)) {
            String s  = "E-5";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_E6, x, y, width)) {
            String s  = "E-6";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_E7, x, y, width)) {
            String s  = "E-7";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_E8, x, y, width)) {
            String s  = "E-8";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_F1, x, y, width)) {
            String s  = "F-1";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_F2, x, y, width)) {
            String s  = "F-2";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_F3, x, y, width)) {
            String s  = "F-3";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_F4, x, y, width)) {
            String s  = "F-4";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_F5, x, y, width)) {
            String s  = "F-5";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_F6, x, y, width)) {
            String s  = "F-6";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_F7, x, y, width)) {
            String s  = "F-7";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_F8, x, y, width)) {
            String s  = "F-8";
            sc.reactTapReadAgain(x, y, sa, s);
        }
    }

    @Override
    public void doubleTapReaction(int x, int y, Bitmap bitmap, SlideActivity sa) {
        int width = bitmap.getWidth();
        GridTrainingPolygons poly = new GridTrainingPolygons();

        if (poly.inPolygon(poly.SQ_A1, x, y, width)) {
            String s = "Dot A-1";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_A2, x, y, width)) {
            String s = "Dot A-2";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_A3, x, y, width)) {
            String s = "Dot A-3";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_A4, x, y, width)) {
            String s = "Dot A-4";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_A5, x, y, width)) {
            String s = "Dot A-5";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_A6, x, y, width)) {
            String s = "Dot A-6";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_A7, x, y, width)) {
            String s = "Dot A-7";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_A8, x, y, width)) {
            String s = "Dot A-8";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_B1, x, y, width)) {
            String s = "Dot B-1";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_B2, x, y, width)) {
            String s = "Dot B-2";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_B3, x, y, width)) {
            String s = "Dot B-3";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_B4, x, y, width)) {
            String s = "Dot B-4";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_B5, x, y, width)) {
            String s = "Dot B-5";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_B6, x, y, width)) {
            String s = "Dot B-6";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_B7, x, y, width)) {
            String s = "Dot B-7";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_B8, x, y, width)) {
            String s = "Dot B-8";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_C1, x, y, width)) {
            String s = "Dot C-1";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_C2, x, y, width)) {
            String s = "Dot C-2";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_C3, x, y, width)) {
            String s = "Dot C-3";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_C4, x, y, width)) {
            String s = "Dot C-4";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_C5, x, y, width)) {
            String s = "Dot C-5";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_C6, x, y, width)) {
            String s = "Dot C-6";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_C7, x, y, width)) {
            String s = "Dot C-7";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_C8, x, y, width)) {
            String s = "Dot C-8";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_D1, x, y, width)) {
            String s = "Dot D-1";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_D2, x, y, width)) {
            String s = "Dot D-2";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_D3, x, y, width)) {
            String s = "Dot D-3";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_D4, x, y, width)) {
            String s = "Dot D-4";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_D5, x, y, width)) {
            String s = "Dot D-5";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_D6, x, y, width)) {
            String s = "Dot D-6";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_D7, x, y, width)) {
            String s = "Dot D-7";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_D8, x, y, width)) {
            String s = "Dot D-8";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_E1, x, y, width)) {
            String s = "Dot E-1";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_E2, x, y, width)) {
            String s = "Dot E-2";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_E3, x, y, width)) {
            String s = "Dot E-3";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_E4, x, y, width)) {
            String s = "Dot E-4";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_E5, x, y, width)) {
            String s = "Dot E-5";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_E6, x, y, width)) {
            String s = "Dot E-6";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_E7, x, y, width)) {
            String s = "Dot E-7";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_E8, x, y, width)) {
            String s = "Dot E-8";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_F1, x, y, width)) {
            String s = "Dot F-1";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_F2, x, y, width)) {
            String s = "Dot F-2";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_F3, x, y, width)) {
            String s = "Dot F-3";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_F4, x, y, width)) {
            String s = "Dot F-4";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_F5, x, y, width)) {
            String s = "Dot F-5";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_F6, x, y, width)) {
            String s = "Dot F-6";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_F7, x, y, width)) {
            String s = "Dot F-7";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.SQ_F8, x, y, width)) {
            String s = "Dot F-8";
            sc.reactDotSpeak(x, y, sa, s);
        }
    }

    @Override
    public void touchReaction(int x, int y, Bitmap bitmap, SlideActivity sa, String action) {
        int width = bitmap.getWidth();

        GridTrainingPolygons poly = new GridTrainingPolygons();

        if (poly.inPolygon(poly.SQ_A1, x, y, width)) {
            String s = "A-1";
            sc.reactAreaThenGridTestNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SQ_A2, x, y, width)) {
            String s = "A-2";
            sc.reactAreaThenGridTestNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SQ_A3, x, y, width)) {
            String s = "A-3";
            sc.reactAreaThenGridTestNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SQ_A4, x, y, width)) {
            String s = "A-4";
            sc.reactAreaThenGridTestNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SQ_A5, x, y, width)) {
            String s = "A-5";
            sc.reactAreaThenGridTestNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SQ_A6, x, y, width)) {
            String s = "A-6";
            sc.reactAreaThenGridTestNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SQ_A7, x, y, width)) {
            String s = "A-7";
            sc.reactAreaThenGridTestNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SQ_A8, x, y, width)) {
            String s = "A-8";
            sc.reactAreaThenGridTestNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SQ_B1, x, y, width)) {
            String s = "B-1";
            sc.reactAreaThenGridTestNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SQ_B2, x, y, width)) {
            String s = "B-2";
            sc.reactAreaThenGridTestNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SQ_B3, x, y, width)) {
            String s = "B-3";
            sc.reactAreaThenGridTestNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SQ_B4, x, y, width)) {
            String s = "B-4";
            sc.reactAreaThenGridTestNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SQ_B5, x, y, width)) {
            String s = "B-5";
            sc.reactAreaThenGridTestNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SQ_B6, x, y, width)) {
            String s = "B-6";
            sc.reactAreaThenGridTestNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SQ_B7, x, y, width)) {
            String s = "B-7";
            sc.reactAreaThenGridTestNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SQ_B8, x, y, width)) {
            String s = "B-8";
            sc.reactAreaThenGridTestNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SQ_C1, x, y, width)) {
            String s = "C-1";
            sc.reactAreaThenGridTestNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SQ_C2, x, y, width)) {
            String s = "C-2";
            sc.reactAreaThenGridTestNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SQ_C3, x, y, width)) {
            String s = "C-3";
            sc.reactAreaThenGridTestNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SQ_C4, x, y, width)) {
            String s = "C-4";
            sc.reactAreaThenGridTestNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SQ_C5, x, y, width)) {
            String s = "C-5";
            sc.reactAreaThenGridTestNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SQ_C6, x, y, width)) {
            String s = "C-6";
            sc.reactAreaThenGridTestNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SQ_C7, x, y, width)) {
            String s = "C-7";
            sc.reactAreaThenGridTestNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SQ_C8, x, y, width)) {
            String s = "C-8";
            sc.reactAreaThenGridTestNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SQ_D1, x, y, width)) {
            String s = "D-1";
            sc.reactAreaThenGridTestNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SQ_D2, x, y, width)) {
            String s = "D-2";
            sc.reactAreaThenGridTestNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SQ_D3, x, y, width)) {
            String s = "D-3";
            sc.reactAreaThenGridTestNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SQ_D4, x, y, width)) {
            String s = "D-4";
            sc.reactAreaThenGridTestNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SQ_D5, x, y, width)) {
            String s = "D-5";
            sc.reactAreaThenGridTestNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SQ_D6, x, y, width)) {
            String s = "D-6";
            sc.reactAreaThenGridTestNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SQ_D7, x, y, width)) {
            String s = "D-7";
            sc.reactAreaThenGridTestNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SQ_D8, x, y, width)) {
            String s = "D-8";
            sc.reactAreaThenGridTestNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SQ_E1, x, y, width)) {
            String s = "E-1";
            sc.reactAreaThenGridTestNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SQ_E2, x, y, width)) {
            String s = "E-2";
            sc.reactAreaThenGridTestNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SQ_E3, x, y, width)) {
            String s = "E-3";
            sc.reactAreaThenGridTestNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SQ_E4, x, y, width)) {
            String s = "E-4";
            sc.reactAreaThenGridTestNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SQ_E5, x, y, width)) {
            String s = "E-5";
            sc.reactAreaThenGridTestNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SQ_E6, x, y, width)) {
            String s = "E-6";
            sc.reactAreaThenGridTestNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SQ_E7, x, y, width)) {
            String s = "E-7";
            sc.reactAreaThenGridTestNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SQ_E8, x, y, width)) {
            String s = "E-8";
            sc.reactAreaThenGridTestNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SQ_F1, x, y, width)) {
            String s = "F-1";
            sc.reactAreaThenGridTestNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SQ_F2, x, y, width)) {
            String s = "F-2";
            sc.reactAreaThenGridTestNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SQ_F3, x, y, width)) {
            String s = "F-3";
            sc.reactAreaThenGridTestNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SQ_F4, x, y, width)) {
            String s = "F-4";
            sc.reactAreaThenGridTestNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SQ_F5, x, y, width)) {
            String s = "F-5";
            sc.reactAreaThenGridTestNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SQ_F6, x, y, width)) {
            String s = "F-6";
            sc.reactAreaThenGridTestNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SQ_F7, x, y, width)) {
            String s = "F-7";
            sc.reactAreaThenGridTestNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SQ_F8, x, y, width)) {
            String s = "F-8";
            sc.reactAreaThenGridTestNoRepeat(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.GRID, x, y, width)) {
            String s = "Gridlines";
            sc.reactGridSystem(x, y, bitmap, sa, action, s);
        }
        else {
            sc.reactAreaThenLineBargraphNoSpeak(x, y, bitmap, sa, action);
        }
    }
}
