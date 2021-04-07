package com.example.hapticstrategyapp_s3.Polygons;

public class TrapezoidBPolygons extends Polygons {

    //******************************************//
    //*** Line segments - clockwise from top ***//
    //******************************************//

    public static float[][] TB_LINEA = {
            {300, 50},
            {1490, 50},
            {1490, 140},
            {300, 140}
    };

    public static float[][] TB_LINEB = {
            {1545, 180},
            {1645, 180},
            {1950, 1200},
            {1850, 1200}
    };

    public static float[][] TB_LINEC = {
            {300, 1230},
            {1830, 1230},
            {1830, 1330},
            {300, 1330}
    };

    public static float[][] TB_LINED = {
            {150, 180},
            {250, 180},
            {250, 1200},
            {150, 1200}
    };

    //**************************************//
    //*** Angles clockwise from top left ***//
    //**************************************//

    public static float[][] TB_ANGLEA = {
            {150, 50},
            {260, 50},
            {260, 150},
            {150, 150}
    };

    public static float[][] TB_ANGLEB = {
            {1500, 50},
            {1620, 50},
            {1620, 150},
            {1500, 150}
    };

    public static float[][] TB_ANGLEC = {
            {1840, 1230},
            {1960, 1230},
            {1960, 1330},
            {1840, 1330}
    };

    public static float[][] TB_ANGLED = {
            {150, 1210},
            {260, 1210},
            {260, 1330},
            {150, 1330}
    };

    //***************************//
    //*** Whitespace Polygon ***//
    //**************************//

    public static float[][] TB_WHITESPACE = {
            {280, 150},
            {1510, 150},
            {1840, 1210},
            {280, 1210}
    };

}