package com.example.hapticstrategyapp_s3.Polygons;

public class QuadBPolygons extends Polygons {

    //******************************************//
    //*** Line segments - clockwise from top ***//
    //******************************************//

    public static float[][] QB_LINEA = {
            {150, 10},
            {1900, 10},
            {1900, 110},
            {150, 110}
    };

    public static float[][] QB_LINEB = {
            {1910, 120},
            {2010, 120},
            {2010, 1220},
            {1910, 1220}
    };

    public static float[][] QB_LINEC = {
            {160, 1260},
            {1900, 1260},
            {1900, 1350},
            {160, 1350}
    };

    public static float[][] QB_LINED = {
            {15, 150},
            {125, 150},
            {125, 1220},
            {15, 1220}
    };

    //**************************************//
    //*** Angles clockwise from top left ***//
    //**************************************//

    public static float[][] QB_ANGLEA = {
            {15, 10},
            {125, 10},
            {125, 140},
            {15, 140}
    };

    public static float[][] QB_ANGLEB = {
            {1910, 10},
            {2010, 10},
            {2010, 140},
            {1910, 140}
    };

    public static float[][] QB_ANGLEC = {
            {1910, 1230},
            {2010, 1230},
            {2010, 1350},
            {1910, 1350}
    };

    public static float[][] QB_ANGLED = {
            {15, 1230},
            {125, 1230},
            {125, 1350},
            {15, 1350}
    };

    //***************************//
    //*** Whitespace Polygon ***//
    //**************************//

    public static float[][] QB_WHITESPACE = {
            {135, 120},
            {1910, 120},
            {1910, 1250},
            {135, 1250}
    };
}