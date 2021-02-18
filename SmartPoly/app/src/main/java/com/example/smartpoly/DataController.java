package com.example.smartpoly;

import android.graphics.Point;
import android.util.Log;

public class DataController {

    public static final int sides = 4;
    float[] lengths;

    public DataController() {

    }

    public DataController(float[] lengthData) {

        Log.d("lengthData", String.valueOf(lengthData));

        lengths = new float[sides];

        //init float array
        for (int i = 0; i < sides; i++) {
            lengths[i] = 0;
        }

        //init float array
        for (int i = 0; i < sides; i++) {
            lengths[i] = lengthData[i];
        }
    }

    public float[] getLengths() {
        return lengths;
    }

}
