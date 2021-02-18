package com.example.smartpoly;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class PolyView extends View {

    DataController dataController;

    public PolyView(Context context, AttributeSet attr) {
        super(context);
    }

    public PolyView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        dataController = MainActivity.getDataController();

        Point[] points = new Point[4];

        for (int i = 0; i < points.length; i++) {
            points[i] = new Point();
        }

        float canvasLength = canvas.getWidth();
        float canvasHeight = canvas.getHeight();
        Log.d("canvasLength:", String.valueOf(canvasLength));
        Log.d("canvasHeight:", String.valueOf(canvasHeight));

        //Quad min and max
        float quadMax = 8;
        float quadMin = 5;
        float canvasMin = 100;
        int min = 100;

        float top = map(dataController.getLengths()[0], quadMin, quadMax, canvasMin, canvasLength);
        float right = map(dataController.getLengths()[1], quadMin, quadMax, canvasMin, canvasHeight);
        float bottom = map(dataController.getLengths()[2], quadMin, quadMax, canvasMin, canvasLength);
        float left = map(dataController.getLengths()[3], quadMin, quadMax, canvasMin, canvasHeight);

//        //Longest sides
//        float length1 = map(400, quadMin, quadMax, canvasMin , canvasLength);
//        float length2 = map(400, quadMin, quadMax, canvasMin, canvasLength);
//
//        //Shortest sides
//        float length3 = map(300, quadMin, quadMax, 0, canvasHeight);
//        float length4 = map(500, quadMin, quadMax, 0, canvasHeight);

        Log.d("length1:", String.valueOf(top));

        // Not working
//        points[0] = new Point(min, min);
//        points[1] = new Point(Math.round(top), min);
//        points[2] = new Point(Math.round(top), Math.round(right));
//        points[3] = new Point(Math.round(bottom), Math.round(right));

        //Something's up with this, not drawing a correct polygon
        points[0] = new Point(min, min);
        points[1] = new Point(Math.round(top), min);
        points[2] = new Point(Math.round(top), Math.round(right));
        points[3] = new Point(Math.round(bottom), Math.round(right));
        //points[3] = new Point(Math.round(bottom), Math.round(left));

//        points[0] = new Point(100, 100);
//        points[1] = new Point(250, 100);
//        points[2] = new Point(250, 300);
//        points[3] = new Point(100, 350);

        // line at minimum...
        if (points.length < 2) {
            return;
        }

        // paint
        Paint polyPaint = new Paint();
        polyPaint.setColor(Color.TRANSPARENT);
        polyPaint.setStyle(Paint.Style.FILL);

        // path
        Path polyPath = new Path();
        //canvas.drawPaint(polyPaint);
        polyPath.moveTo(points[0].x, points[0].y);

        int len = points.length;
        for (int i = 0; i < len; i++) {
            polyPath.lineTo(points[i].x, points[i].y);
        }
        //polyPath.lineTo(points[0].x, points[0].y);
        //polyPath.close();

        polyPaint.setStrokeWidth(50);
        polyPaint.setPathEffect(null);
        polyPaint.setColor(Color.BLACK);
        polyPaint.setStyle(Paint.Style.STROKE);

        // draw
        canvas.drawPath(polyPath, polyPaint);
    }

    static public final float map(float value, float min1, float max1, float min2, float max2) {

        //remaps a value with a range of start1-stop1 to a target value of start2-stop2
        float result = min2 + (max2 - min2) * ((value - min1) / (max1 - min1));
        Log.d("result:", String.valueOf(result));

        return result;
    }
}
