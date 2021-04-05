package com.example.hapticstrategyapp_s3.Behavior;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;

import com.example.hapticstrategyapp_s3.Activities.SlideActivity;
import com.example.hapticstrategyapp_s3.Controller.Event;
import com.example.hapticstrategyapp_s3.Controller.SlideController;
import com.example.hapticstrategyapp_s3.Polygons.QuadAPolygons;
import com.example.hapticstrategyapp_s3.R;

public class QuadABehavior extends SlideBehaviorPolygon {

    boolean speak = true;

    public QuadABehavior(SlideController sc) {
        super(R.drawable.quad_a, sc);
    }

    @Override
    public void drawPolygons(SlideActivity sa) {
        QuadAPolygons poly = new QuadAPolygons();
        sa.drawPolygon(poly.QA_LINEA);
        sa.drawPolygon(poly.QA_LINEB);
        sa.drawPolygon(poly.QA_LINEC);
        sa.drawPolygon(poly.QA_LINED);
        sa.drawPolygon(poly.QA_ANGLEA);
        sa.drawPolygon(poly.QA_ANGLEB);
        sa.drawPolygon(poly.QA_ANGLEC);
        sa.drawPolygon(poly.QA_ANGLED);
    }

    @Override
    public void tapReaction(int x, int y, Bitmap bitmap, SlideActivity sa) {
        int width = bitmap.getWidth();
        String action = Event.ACTION_TAP;

        QuadAPolygons poly = new QuadAPolygons();

        if (poly.inPolygon(poly.QA_LINEA, x, y, width)) {
            String s = "Line Ei equals 5.5 inches";
            //sa.speak(s);
            //sc.reactTapReadAgain(x, y, sa, s);
            sc.reactQuad(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QA_LINEB, x, y, width)) {
            String s = "Line B equals 5.5 inches";
            sc.reactAreaThenLinegraphNoRepeat(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QA_LINEC, x, y, width)) {
            String s = "Line C equals 5.5 inches";
            sc.reactAreaThenLinegraphNoRepeat(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QA_LINED, x, y, width)) {
            String s = "Line D equals 5.5 inches";
            sc.reactAreaThenLinegraphNoRepeat(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QA_ANGLEA, x, y, width)) {
            String s = "Angle Ei equals 90 degrees";
            sc.reactAreaThenLinegraphNoRepeat(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QA_ANGLEB, x, y, width)) {
            String s = "Angle B equals 90 degrees";
            sc.reactAreaThenLinegraphNoRepeat(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QA_ANGLEC, x, y, width)) {
            String s = "Angle C equals 90 degrees";
            sc.reactAreaThenLinegraphNoRepeat(x,y,bitmap,sa,action,s);
        } else if (poly.inPolygon(poly.QA_ANGLED, x, y, width)) {
            String s = "Angle D equals 90 degrees";
            sc.reactAreaThenLinegraphNoRepeat(x,y,bitmap,sa,action,s);
        }

    }

    @Override
    public void doubleTapReaction(int x, int y, Bitmap bitmap, SlideActivity sa) {
        if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap) && x < 388) {
            String s = "Dot 19'70";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap) && x < 589) {
            String s = "Dot 19'75";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap) && x < 790) {
            String s = "Dot 19'80";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap) && x < 990) {
            String s = "Dot 19'85";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap) && x < 1191) {
            String s = "Dot 19'90";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap) && x < 1391) {
            String s = "Dot 19'95";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap) && x < 1591) {
            String s = "Dot 2000";
            sc.reactDotSpeak(x, y, sa, s);
        }
        else if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap) && x < 1791) {
            String s = "Dot 2005";
            sc.reactDotSpeak(x, y, sa, s);
        }
    }

    @Override
    public void touchReaction(int x, int y, Bitmap bitmap, SlideActivity sa, String action) {
        int width = bitmap.getWidth();


        QuadAPolygons poly = new QuadAPolygons();

        if (poly.inPolygon(poly.QA_LINEA, x, y, width)) {
            String s = "Line Ei equals 5.5 inches";

            //Log.d("color: ", String.valueOf(bitmap.getPixel(x,y)));
            sc.reactQuad(x, y, bitmap, sa, action, s);
        }

//        if (poly.inPolygon(poly.LINE, x, y, width)) {
//            String sAdd = "On Line";
//            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
//                if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap) && x < 388) {
//                    if (speak) {
//                        String sSpeak = "Dot 19'70";
//                        sc.reactDotSpeak(x, y, sa, sSpeak);
//                        speak = false;
//                    }
//                }
//                else if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap) && x < 589) {
//                    if (speak) {
//                        String sSpeak = "Dot 19'75";
//                        sc.reactDotSpeak(x, y, sa, sSpeak);
//                        speak = false;
//                    }
//                }
//                else if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap) && x < 790) {
//                    if (speak) {
//                        String sSpeak = "Dot 19'80";
//                        sc.reactDotSpeak(x, y, sa, sSpeak);
//                        speak = false;
//                    }
//                }
//                else if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap) && x < 990) {
//                    if (speak) {
//                        String sSpeak = "Dot 19'85";
//                        sc.reactDotSpeak(x, y, sa, sSpeak);
//                        speak = false;
//                    }
//                }
//                else if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap) && x < 1191) {
//                    if (speak) {
//                        String sSpeak = "Dot 19'90";
//                        sc.reactDotSpeak(x, y, sa, sSpeak);
//                        speak = false;
//                    }
//                }
//                else if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap) && x < 1391) {
//                    if (speak) {
//                        String sSpeak = "Dot 19'95";
//                        sc.reactDotSpeak(x, y, sa, sSpeak);
//                        speak = false;
//                    }
//                }
//                else if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap) && x < 1591) {
//                    if (speak) {
//                        String sSpeak = "Dot 2000";
//                        sc.reactDotSpeak(x, y, sa, sSpeak);
//                        speak = false;
//                    }
//                }
//                else if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap) && x < 1791) {
//                    if (speak) {
//                        String sSpeak = "Dot 2005";
//                        sc.reactDotSpeak(x, y, sa, sSpeak);
//                        speak = false;
//                    }
//                }
//                else {
//                    speak = true;
//                }
//
//                String s = "Line";
//                sc.reactAreaThenLinegraphNoRepeat(x, y, bitmap, sa, action, s);
//            }
//        }
//        else if (poly.inPolygon(poly.XAXIS, x, y, width)) {
//            String sAdd = "Year";
//            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
//                String s = "Year";
//                sc.reactAreaThenLinegraphNoRepeat(x, y, bitmap, sa, action, s);
//            }
//        }
//        else if (poly.inPolygon(poly.X_1970, x, y, width)) {
//            String sAdd = "1970";
//            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
//                String s = "1970";
//                sc.reactAreaThenLinegraphNoRepeat(x, y, bitmap, sa, action, s);
//            }
//        }
//        else if (poly.inPolygon(poly.X_1975, x, y, width)) {
//            String sAdd = "1975";
//            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
//                String s = "1975";
//                sc.reactAreaThenLinegraphNoRepeat(x, y, bitmap, sa, action, s);
//            }
//        }
//        else if (poly.inPolygon(poly.X_1980, x, y, width)) {
//            String sAdd = "1980";
//            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
//                String s = "1980";
//                sc.reactAreaThenLinegraphNoRepeat(x, y, bitmap, sa, action, s);
//            }
//        }
//        else if (poly.inPolygon(poly.X_1985, x, y, width)) {
//            String sAdd = "1985";
//            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
//                String s = "1985";
//                sc.reactAreaThenLinegraphNoRepeat(x, y, bitmap, sa, action, s);
//            }
//        }
//        else if (poly.inPolygon(poly.X_1990, x, y, width)) {
//            String sAdd = "1990";
//            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
//                String s = "1990";
//                sc.reactAreaThenLinegraphNoRepeat(x, y, bitmap, sa, action, s);
//            }
//        }
//        else if (poly.inPolygon(poly.X_1995, x, y, width)) {
//            String sAdd = "1995";
//            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
//                String s = "1995";
//                sc.reactAreaThenLinegraphNoRepeat(x, y, bitmap, sa, action, s);
//            }
//        }
//        else if (poly.inPolygon(poly.X_2000, x, y, width)) {
//            String sAdd = "2000";
//            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
//                String s = "2000";
//                sc.reactAreaThenLinegraphNoRepeat(x, y, bitmap, sa, action, s);
//            }
//        }
//        else if (poly.inPolygon(poly.X_2005, x, y, width)) {
//            String sAdd = "2005";
//            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
//                String s = "2005";
//                sc.reactAreaThenLinegraphNoRepeat(x, y, bitmap, sa, action, s);
//            }
//        }
//        else if (poly.inPolygon(poly.X_2010, x, y, width)) {
//            String sAdd = "2010";
//            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
//                String s = "2010";
//                sc.reactAreaThenLinegraphNoRepeat(x, y, bitmap, sa, action, s);
//            }
//        }
//        else if (poly.inPolygon(poly.YAXIS, x, y, width)) {
//            String sAdd = "Percentage of people with Adeolitis";
//            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
//                String s = "Percentage of people with Adeolitis";
//                sc.reactAreaThenLinegraphNoRepeat(x, y, bitmap, sa, action, s);
//            }
//        }
//        else if (poly.inPolygon(poly.ZERO_LINE, x, y, width)) {
//            String s = "0 Percent";
//            sc.reactGridLine(x, y, bitmap, sa, action, s);
//        }
//        else if (poly.inPolygon(poly.FIVE_LINE, x, y, width)) {
//            String s = "5 Percent";
//            sc.reactGridLine(x, y, bitmap, sa, action, s);
//        }
//        else if (poly.inPolygon(poly.TEN_LINE, x, y, width)) {
//            String s = "10 Percent";
//            sc.reactGridLine(x, y, bitmap, sa, action, s);
//        }
//        else if (poly.inPolygon(poly.FIFTEEN_LINE, x, y, width)) {
//            String s = "15 Percent";
//            sc.reactGridLine(x, y, bitmap, sa, action, s);
//        }
//        else if (poly.inPolygon(poly.TWENTY_LINE, x, y, width)) {
//            String s = "20 Percent";
//            sc.reactGridLine(x, y, bitmap, sa, action, s);
//        }
//        else if (poly.inPolygon(poly.TWENTYFIVE_LINE, x, y, width)) {
//            String s = "25 Percent";
//            sc.reactGridLine(x, y, bitmap, sa, action, s);
//        }
//        else {
//            sc.reactAreaThenLineBargraphNoSpeak(x, y, bitmap, sa, action);
//        }
    }

    private boolean handleGrids(String sAdd, int x, int y, Bitmap bitmap, int width, QuadAPolygons poly, SlideActivity sa, String action) {

        if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap) && x < 388) {
            if (speak) {
                String sSpeak = "Dot 19'70";
                sc.reactDotSpeak(x, y, sa, sSpeak);
                speak = false;
            }
        }
        else if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap) && x < 589) {
            if (speak) {
                String sSpeak = "Dot 19'75";
                sc.reactDotSpeak(x, y, sa, sSpeak);
                speak = false;
            }
        }
        else if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap) && x < 790) {
            if (speak) {
                String sSpeak = "Dot 19'80";
                sc.reactDotSpeak(x, y, sa, sSpeak);
                speak = false;
            }
        }
        else if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap) && x < 990) {
            if (speak) {
                String sSpeak = "Dot 19'85";
                sc.reactDotSpeak(x, y, sa, sSpeak);
                speak = false;
            }
        }
        else if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap) && x < 1191) {
            if (speak) {
                String sSpeak = "Dot 19'90";
                sc.reactDotSpeak(x, y, sa, sSpeak);
                speak = false;
            }
        }
        else if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap) && x < 1391) {
            if (speak) {
                String sSpeak = "Dot 19'95";
                sc.reactDotSpeak(x, y, sa, sSpeak);
                speak = false;
            }
        }
        else if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap) && x < 1591) {
            if (speak) {
                String sSpeak = "Dot 2000";
                sc.reactDotSpeak(x, y, sa, sSpeak);
                speak = false;
            }
        }
        else if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap) && x < 1791) {
            if (speak) {
                String sSpeak = "Dot 2005";
                sc.reactDotSpeak(x, y, sa, sSpeak);
                speak = false;
            }
        }
        else {
            speak = true;
        }

//        if (poly.inPolygon(poly.ZERO_LINE, x, y, width)) {
//            String s = "0 Percent";
//            sc.reactGridLine(x, y, bitmap, sa, action, s);
//            return true;
//        }
//        else if (poly.inPolygon(poly.FIVE_LINE, x, y, width)) {
//            String s = "5 Percent";
//            sc.reactGridLine(x, y, bitmap, sa, action, s);
//            return true;
//        }
//        else if (poly.inPolygon(poly.TEN_LINE, x, y, width)) {
//            String s = "10 Percent";
//            sc.reactGridLine(x, y, bitmap, sa, action, s);
//            return true;
//        }
//        else if (poly.inPolygon(poly.FIFTEEN_LINE, x, y, width)) {
//            String s = "15 Percent";
//            sc.reactGridLine(x, y, bitmap, sa, action, s);
//            return true;
//        }
//        else if (poly.inPolygon(poly.TWENTY_LINE, x, y, width)) {
//            String s = "20 Percent";
//            sc.reactGridLine(x, y, bitmap, sa, action, s);
//            return true;
//        }
//        else if (poly.inPolygon(poly.TWENTYFIVE_LINE, x, y, width)) {
//            String s = "25 Percent";
//            sc.reactGridLine(x, y, bitmap, sa, action, s);
//            return true;
//        }
        return false;
    }
}
