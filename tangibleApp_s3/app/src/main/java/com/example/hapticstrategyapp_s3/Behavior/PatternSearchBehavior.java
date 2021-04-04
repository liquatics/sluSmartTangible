package com.example.hapticstrategyapp_s3.Behavior;

import android.graphics.Bitmap;

import com.example.hapticstrategyapp_s3.Activities.SlideActivity;
import com.example.hapticstrategyapp_s3.Controller.Event;
import com.example.hapticstrategyapp_s3.Controller.SlideController;
import com.example.hapticstrategyapp_s3.Polygons.PatternSearchPolygons;
import com.example.hapticstrategyapp_s3.R;

public class PatternSearchBehavior extends SlideBehaviorPolygon {

    public PatternSearchBehavior(SlideController sc) {
        super(R.drawable.pattern_of_search_s3, sc);
    }

    @Override
    public void drawPolygons(SlideActivity sa) {
        PatternSearchPolygons poly = new PatternSearchPolygons();
        sa.drawPolygon(poly.DOT_1);
    }

    @Override
    public void tapReaction(int x, int y, Bitmap bitmap, SlideActivity sa) {
        int width = bitmap.getWidth();
        String action = Event.ACTION_TAP;

        PatternSearchPolygons poly = new PatternSearchPolygons();

        if (poly.inPolygon(poly.DOT_1, x, y, width)) {
            String s = "Dot";
            sc.reactTapReadAgain(x, y, sa, s);
        }
    }

    @Override
    public void doubleTapReaction(int x, int y, Bitmap bitmap, SlideActivity sa) {
        if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap)) {
            String s = "Dot";
            sc.reactDotSpeak(x, y, sa, s);
        }
    }

    @Override
    public void touchReaction(int x, int y, Bitmap bitmap, SlideActivity sa, String action) {
        int width = bitmap.getWidth();

        PatternSearchPolygons poly = new PatternSearchPolygons();

        if (poly.inPolygon(poly.DOT_1, x, y, width)) {
            String s = "Dot";
            sc.reactAreaThenDotsNoRepeat(x, y, bitmap, sa, action, s);
        }
        else {
            sc.reactAreaThenLineBargraphNoSpeak(x, y, bitmap, sa, action);
        }
    }
}
