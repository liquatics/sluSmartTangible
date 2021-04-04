package com.example.hapticstrategyapp_s3;

import android.graphics.Bitmap;
import android.util.Log;

public class TouchManager {

    public int touchRadius = 5;

    public void setTouchRadius(int touchRadius) {
        this.touchRadius = touchRadius;
    }

    public int getTouchRadius() {
        return touchRadius;
    }

    public boolean circleIsNotOnly(int color, int h, int k, Bitmap bitmap) {

        // Radius in pixel
        int radius = touchRadius;
        int radiusSquared = radius * radius;

        for (int x = h - radius; x < h + radius; x++) {
            for (int y = k - radius; y < k + radius; y++) {
                double dx = x - h;
                double dy = y - k;
                double distanceSquared = dx * dx + dy * dy;

                if (distanceSquared <= radiusSquared) {
                    int pixelColor = bitmap.getPixel(x, y);
                    if (pixelColor != color) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean circleContains(int color, int h, int k, Bitmap bitmap) {

        // Radius in pixels
        int radius = touchRadius;
        int radiusSquared = radius * radius;

        for (int x = h - radius; x < h + radius; x++) {
            for (int y = k - radius; y < k + radius; y++) {
                double dx = x - h;
                double dy = y - k;
                double distanceSquared = dx * dx + dy * dy;

                if (distanceSquared <= radiusSquared) {
                    if (y < 0 || x < 0) {
                        return false;
                    }

                    if (y >= bitmap.getHeight() || x >= bitmap.getWidth()) {
                        return false;
                    }

                    int pixelColor = bitmap.getPixel(x, y);
                    Log.i("PixelColor", "The integer value of this color is: " + pixelColor);
                    if (pixelColor == color) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
