package com.example.hapticstrategyapp_s3.Polygons;

public class Polygons {

    public boolean inPolygon(float[][] polygon, float x, float y, int width) {
        return inPolygon(polygon, new float[] {x,y}, width);
    }

    public boolean inPolygon(float[][] polygon, float[] point, int width) {

        int n = polygon.length;

        // At least 3 points are required
        if (n < 3)
            return false;

        float[] extreme = {width, point[1]};

        int count = 0;
        int i = 0;

        do {
            int next = (i + 1) % n;
            // Check if the line segment from 'p' to 'extreme' intersects with the line segment from 'polygon[1]' to 'polygon[next]'
            if (doIntersect(polygon[i], polygon[next], point, extreme)) {
                // If the point 'p' is colinear with line segment 'i-next', then check if it lies on the segment. If it does, return true. Otherwise, return false.
                if (orientation(polygon[i], point, polygon[next]) == 0) {
                    return onSegment(polygon[i], point, polygon[next]);
                }
                count++;
            }
            i = next;
        }
        while (i != 0);

        if (count % 2 == 1) {
            if (doesCrossPoint(polygon, point)) {
                return false;
            }
            else{
                return true;
            }
        }

        return false;
    }

    public boolean doesCrossPoint(float[][] polygon, float[] point) {
        for (int i = 0; i < polygon.length; i++) {
            if (polygon[i][1] == point[1]) {
                return true;
            }
        }
        return false;
    }

    public boolean doIntersect(float[] p1, float[] q1, float[] p2, float[] q2) {
        int o1 = orientation(p1, q1, p2);
        int o2 = orientation(p1, q1, q2);
        int o3 = orientation(p2, q2, p1);
        int o4 = orientation(p2, q2, q1);

        // General Case
        if (o1 != o2 && o3 != o4) {
            return true;
        }
        // Special Cases
        // SC-1: p1, q1, and p2 are colinear and p2 lies on segment p1q1
        if (o1 == 0 && onSegment(p1, p2, q1)) {
            return true;
        }

        // SC-2: p1, q1, and q2 are colinear and q2 lies on segment p1q1
        if (o2 == 0 && onSegment(p1, q2, q1)) {
            return true;
        }

        // SC-3: p2, q2, and p1 are colinear and p1 lies on segment p2q2
        if (o3 == 0 && onSegment(p2, p1, q2)) {
            return true;
        }

        // SC-4: p2, q2, and q1 are colinear and q1 lies on segment p2q2
        if (o4 == 0 && onSegment(p2, q1, q2)) {
            return true;
        }

        // Does not fall into any of the above cases
        return false;
    }

    // This function finds the orientation of the ordered triplet (p, q, r) and returns the
    // following values:
    // 0 --> p, q, and r are colinear
    // 1 --> clockwise
    // 2 --> counterclockwise
    // from https://www.geeksforgeeks.org/check-if-two-given-line-segments-intersect/
    private int orientation(float[] p, float[] q, float[] r) {
        float val = (int) ((q[1] - p[1]) * (r[0] - q[0]) - (q[0] - p[0]) * (r[1] - q[1]));

        if (val == 0) {
            return 0;
        }
        else if (val > 0) {
            return 1;
        }
        else {
            return 2;
        }
    }

    // Given three colinear points p, q, and r, the function checks if point q lies on line segment 'pr'
    boolean onSegment(float[] p, float[] q, float[] r) {
        if (q[0] <= Math.max(p[0], r[0]) && q[0] >= Math.min(p[0], r[0])
                && q[1] <= Math.max(p[1], r[1]) && q[1] >= Math.min(p[1], r[1])) {
            return true;
        }

        return false;
    }
}
