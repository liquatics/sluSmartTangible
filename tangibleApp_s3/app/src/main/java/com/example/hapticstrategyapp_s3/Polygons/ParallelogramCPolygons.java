package com.example.hapticstrategyapp_s3.Polygons;

public class ParallelogramCPolygons extends Polygons{

    //******************************************//
    //*** Line segments - clockwise from top ***//
    //******************************************//

    public static float[][] PC_LINEA = {
            {165,15},
            {1550,15},
            {1550,115},
            {165,115}
    };

    public static float[][] PC_LINEB = {
            {1600,135},
            {1700,135},
            {2000,1200},
            {1900,1200}
    };

    public static float[][] PC_LINEC = {
            {500,1250},
            {1850,1250},
            {1850,1350},
            {500,1350}
    };

    public static float[][] PC_LINED = {
            {40,135},
            {140,135},
            {430,1230},
            {330,1230}
    };

    //**************************************//
    //*** Angles clockwise from top left ***//
    //**************************************//

    public static float[][] PC_ANGLEA = {
            {10,15},
            {155,15},
            {155,115},
            {10,115}
    };

    public static float[][] PC_ANGLEB = {
            {1560,15},
            {1680,15},
            {1680,115},
            {1560,115}
    };

    public static float[][] PC_ANGLEC = {
            {1890,1230},
            {2010,1230},
            {2010,1350},
            {1890,1350}
    };

    public static float[][] PC_ANGLED = {
            {330,1230},
            {460,1230},
            {460,1340},
            {330,1340}
    };

    //***************************//
    //*** Whitespace Polygon ***//
    //**************************//

    public static float[][] PC_WHITESPACE = {
            {150,120},
            {1580,120},
            {1870,1220},
            {470,1220}
    };
}