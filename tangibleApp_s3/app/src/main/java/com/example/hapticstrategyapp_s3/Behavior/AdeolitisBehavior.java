package com.example.hapticstrategyapp_s3.Behavior;

import android.graphics.Bitmap;

import com.example.hapticstrategyapp_s3.Activities.SlideActivity;
import com.example.hapticstrategyapp_s3.Controller.Event;
import com.example.hapticstrategyapp_s3.Controller.SlideController;
import com.example.hapticstrategyapp_s3.Polygons.AdeolitisPolygons;
import com.example.hapticstrategyapp_s3.R;

public class AdeolitisBehavior extends SlideBehaviorPolygon {

    boolean speak = true;

    public AdeolitisBehavior(SlideController sc) {
        super(R.drawable.adeolitis, sc);
    }

    @Override
    public void drawPolygons(SlideActivity sa) {
        AdeolitisPolygons poly = new AdeolitisPolygons();
        sa.drawPolygon(poly.LINE);
        sa.drawPolygon(poly.YAXIS);
        sa.drawPolygon(poly.TWENTYFIVE_LINE);
        sa.drawPolygon(poly.TWENTY_LINE);
        sa.drawPolygon(poly.FIFTEEN_LINE);
        sa.drawPolygon(poly.TEN_LINE);
        sa.drawPolygon(poly.FIVE_LINE);
        sa.drawPolygon(poly.ZERO_LINE);
        sa.drawPolygon(poly.XAXIS);
        sa.drawPolygon(poly.X_1970);
        sa.drawPolygon(poly.X_1975);
        sa.drawPolygon(poly.X_1980);
        sa.drawPolygon(poly.X_1985);
        sa.drawPolygon(poly.X_1990);
        sa.drawPolygon(poly.X_1995);
        sa.drawPolygon(poly.X_2000);
        sa.drawPolygon(poly.X_2005);
        sa.drawPolygon(poly.X_2010);
    }

    @Override
    public void tapReaction(int x, int y, Bitmap bitmap, SlideActivity sa) {
        int width = bitmap.getWidth();
        String action = Event.ACTION_TAP;

        AdeolitisPolygons poly = new AdeolitisPolygons();

        if (poly.inPolygon(poly.LINE, x, y, width)) {
            String s = "Line";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.XAXIS, x, y, width)) {
            String s = "Year";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.X_1970, x, y, width)) {
            String s = "1970";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.X_1975, x, y, width)) {
            String s = "1975";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.X_1980, x, y, width)) {
            String s = "1980";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.X_1985, x, y, width)) {
            String s = "1985";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.X_1990, x, y, width)) {
            String s = "1990";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.X_1995, x, y, width)) {
            String s = "1995";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.X_2000, x, y, width)) {
            String s = "2000";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.X_2005, x, y, width)) {
            String s = "2005";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.X_2010, x, y, width)) {
            String s = "2010";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.YAXIS, x, y, width)) {
            String s = "Percentage of people with Adeolitis";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.ZERO_LINE, x, y, width)) {
            String s  = "0 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.FIVE_LINE, x, y, width)) {
            String s  = "5 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.TEN_LINE, x, y, width)) {
            String s  = "10 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.FIFTEEN_LINE, x, y, width)) {
            String s  = "15 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.TWENTY_LINE, x, y, width)) {
            String s  = "20 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.TWENTYFIVE_LINE, x, y, width)) {
            String s  = "25 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
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

        AdeolitisPolygons poly = new AdeolitisPolygons();

        if (poly.inPolygon(poly.LINE, x, y, width)) {
            String sAdd = "On Line";
            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
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

                String s = "Line";
                sc.reactAreaThenLinegraphNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else if (poly.inPolygon(poly.XAXIS, x, y, width)) {
            String sAdd = "Year";
            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
                String s = "Year";
                sc.reactAreaThenLinegraphNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else if (poly.inPolygon(poly.X_1970, x, y, width)) {
            String sAdd = "1970";
            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
                String s = "1970";
                sc.reactAreaThenLinegraphNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else if (poly.inPolygon(poly.X_1975, x, y, width)) {
            String sAdd = "1975";
            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
                String s = "1975";
                sc.reactAreaThenLinegraphNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else if (poly.inPolygon(poly.X_1980, x, y, width)) {
            String sAdd = "1980";
            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
                String s = "1980";
                sc.reactAreaThenLinegraphNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else if (poly.inPolygon(poly.X_1985, x, y, width)) {
            String sAdd = "1985";
            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
                String s = "1985";
                sc.reactAreaThenLinegraphNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else if (poly.inPolygon(poly.X_1990, x, y, width)) {
            String sAdd = "1990";
            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
                String s = "1990";
                sc.reactAreaThenLinegraphNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else if (poly.inPolygon(poly.X_1995, x, y, width)) {
            String sAdd = "1995";
            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
                String s = "1995";
                sc.reactAreaThenLinegraphNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else if (poly.inPolygon(poly.X_2000, x, y, width)) {
            String sAdd = "2000";
            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
                String s = "2000";
                sc.reactAreaThenLinegraphNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else if (poly.inPolygon(poly.X_2005, x, y, width)) {
            String sAdd = "2005";
            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
                String s = "2005";
                sc.reactAreaThenLinegraphNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else if (poly.inPolygon(poly.X_2010, x, y, width)) {
            String sAdd = "2010";
            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
                String s = "2010";
                sc.reactAreaThenLinegraphNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else if (poly.inPolygon(poly.YAXIS, x, y, width)) {
            String sAdd = "Percentage of people with Adeolitis";
            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
                String s = "Percentage of people with Adeolitis";
                sc.reactAreaThenLinegraphNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else if (poly.inPolygon(poly.ZERO_LINE, x, y, width)) {
            String s = "0 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.FIVE_LINE, x, y, width)) {
            String s = "5 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.TEN_LINE, x, y, width)) {
            String s = "10 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.FIFTEEN_LINE, x, y, width)) {
            String s = "15 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.TWENTY_LINE, x, y, width)) {
            String s = "20 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.TWENTYFIVE_LINE, x, y, width)) {
            String s = "25 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else {
            sc.reactAreaThenLineBargraphNoSpeak(x, y, bitmap, sa, action);
        }
    }

    private boolean handleGrids(String sAdd, int x, int y, Bitmap bitmap, int width, AdeolitisPolygons poly, SlideActivity sa, String action) {

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

        if (poly.inPolygon(poly.ZERO_LINE, x, y, width)) {
            String s = "0 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
            return true;
        }
        else if (poly.inPolygon(poly.FIVE_LINE, x, y, width)) {
            String s = "5 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
            return true;
        }
        else if (poly.inPolygon(poly.TEN_LINE, x, y, width)) {
            String s = "10 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
            return true;
        }
        else if (poly.inPolygon(poly.FIFTEEN_LINE, x, y, width)) {
            String s = "15 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
            return true;
        }
        else if (poly.inPolygon(poly.TWENTY_LINE, x, y, width)) {
            String s = "20 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
            return true;
        }
        else if (poly.inPolygon(poly.TWENTYFIVE_LINE, x, y, width)) {
            String s = "25 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
            return true;
        }
        return false;
    }
}

