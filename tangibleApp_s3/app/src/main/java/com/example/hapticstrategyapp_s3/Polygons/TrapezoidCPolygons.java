package com.example.hapticstrategyapp_s3.Polygons;

public class TrapezoidCPolygons extends Polygons {

    //******************************************//
    //*** Line segments - clockwise from top ***//
    //******************************************//

    public static float[][] TC_LINEA = {
            {500, 10},
            {1550, 10},
            {1550, 110},
            {500, 110}
    };

    public static float[][] TC_LINEB = {
            {1610, 140},
            {1720, 140},
            {1980, 1170},
            {1880, 1170}
    };

    public static float[][] TC_LINEC = {
            {200, 1250},
            {1855, 1250},
            {1855, 1350},
            {200, 1350}
    };

    public static float[][] TC_LINED = {
            {320, 140},
            {430, 140},
            {170, 1170},
            {65, 1170}
    };

    //**************************************//
    //*** Angles clockwise from top left ***//
    //**************************************//

    public static float[][] TC_ANGLEA = {
            {340, 10},
            {470, 10},
            {470, 110},
            {340, 110}
    };

    public static float[][] TC_ANGLEB = {
            {1560, 10},
            {1700, 10},
            {1700, 110},
            {1560, 110}
    };

    public static float[][] TC_ANGLEC = {
            {1875, 1200},
            {2010, 1200},
            {2010, 1330},
            {1875, 1330}
    };

    public static float[][] TC_ANGLED = {
            {35, 1200},
            {170, 1200},
            {170, 1350},
            {35, 1350}
    };

    //***************************//
    //*** Whitespace Polygon ***//
    //**************************//

    public static float[][] TC_WHITESPACE = {
            {450, 120},
            {1600, 120},
            {1865, 1230},
            {190, 1230}
    };

}