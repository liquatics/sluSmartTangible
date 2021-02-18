package com.example.smartpoly;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Canvas canvas = new Canvas();
    PolyView polyView;

    static DataController dataController;
    float[] temp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.polyview_layout);

        temp = new float[4];

        //init float array
        for (int i = 0; i < temp.length; i++) {
            temp[i] = 0;
        }

        //set values
        temp[0] = 6;
        temp[1] = (float)5.8;
        temp[2] = (float)6.4;
        temp[3] = 7;

        dataController = new DataController(temp);

        //setNewView();
    }

    public void setNewView() {
        String temp;

        //Creates a graphicsView to use
        polyView = new PolyView(this);
        setContentView(polyView);

        //Attach the touch listener to the new graphics view!
        //polyView.setOnTouchListener(this);
    }

    public static DataController getDataController() {
        return dataController;
    }

}