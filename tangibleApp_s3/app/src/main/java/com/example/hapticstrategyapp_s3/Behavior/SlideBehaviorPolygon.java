package com.example.hapticstrategyapp_s3.Behavior;

import android.graphics.Bitmap;

import com.example.hapticstrategyapp_s3.Activities.SlideActivity;
import com.example.hapticstrategyapp_s3.Controller.SlideController;

public abstract class SlideBehaviorPolygon extends SlideBehavior{

    public SlideBehaviorPolygon(int graphID, SlideController sc) {
        super(graphID, sc);
    }

    abstract public void drawPolygons(SlideActivity sa);

    abstract public void tapReaction(int x, int y, Bitmap bitmap, SlideActivity sa);

    abstract public void doubleTapReaction(int x, int y, Bitmap bitmap, SlideActivity sa);
}
