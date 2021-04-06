package com.example.hapticstrategyapp_s3.Polygons;

public class QuadCPolygons extends Polygons {

    //******************************************//
    //*** Line segments - clockwise from top ***//
    //******************************************//

    public static float[][] QC_LINEA = {
            {310, 20},
            {1740, 20},
            {1740, 110},
            {310, 110}
    };

    public static float[][] QC_LINEB = {
            {1760, 150},
            {1860, 150},
            {1860, 1220},
            {1760, 1220}
    };

    public static float[][] QC_LINEC = {
            {330, 1250},
            {1750, 1250},
            {1750, 1330},
            {330, 1330}
    };

    public static float[][] QC_LINED = {
            {180, 150},
            {280, 150},
            {280, 1220},
            {180, 1220}
    };

    //**************************************//
    //*** Angles clockwise from top left ***//
    //**************************************//

    public static float[][] QC_ANGLEA = {
            {180, 20},
            {280, 20},
            {280, 110},
            {180, 110}
    };

    public static float[][] QC_ANGLEB = {
            {1760, 20},
            {1860, 20},
            {1860, 110},
            {1760, 110}
    };

    public static float[][] QC_ANGLEC = {
            {1760, 1250},
            {1860, 1250},
            {1860, 1330},
            {1760, 1330}
    };

    public static float[][] QC_ANGLED = {
            {180, 1250},
            {280, 1250},
            {280, 1330},
            {180, 1330}
    };

    //***************************//
    //*** Whitespace Polygon ***//
    //**************************//

    public static float[][] QC_WHITESPACE = {
            {300, 120},
            {1760, 120},
            {1760, 1230},
            {300, 1230}
    };
}