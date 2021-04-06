package com.example.hapticstrategyapp_s3.Polygons;

public class ParallelogramBPolygons extends Polygons{

    //******************************************//
    //*** Line segments - clockwise from top ***//
    //******************************************//

    public static float[][] PB_LINEA = {
            {650,50},
            {1690,50},
            {1690,150},
            {650,150}
    };

    public static float[][] PB_LINEB = {
            {1700,170},
            {1800,170},
            {1515,1200},
            {1415,1200}
    };

    public static float[][] PB_LINEC = {
            {340,1220},
            {1370,1220},
            {1370,1320},
            {340,1320}
    };

    public static float[][] PB_LINED = {
            {500,170},
            {600,170},
            {330,1180},
            {230,1180}
    };

    //**************************************//
    //*** Angles clockwise from top left ***//
    //**************************************//

    public static float[][] PB_ANGLEA = {
            {500,50},
            {630,50},
            {630,150},
            {500,150}
    };

    public static float[][] PB_ANGLEB = {
            {1700,50},
            {1830,50},
            {1830,150},
            {1700,150}
    };

    public static float[][] PB_ANGLEC = {
            {1405,1220},
            {1515,1220},
            {1515,1320},
            {1405,1320}
    };

    public static float[][] PB_ANGLED = {
            {200,1210},
            {320,1210},
            {320,1320},
            {200,1320}
    };

    //***************************//
    //*** Whitespace Polygon ***//
    //**************************//

    public static float[][] PB_WHITESPACE = {
            {620,170},
            {1690,170},
            {1415,1200},
            {340,1200}
    };
}
