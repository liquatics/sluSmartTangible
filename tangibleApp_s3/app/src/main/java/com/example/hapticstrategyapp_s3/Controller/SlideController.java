package com.example.hapticstrategyapp_s3.Controller;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;

import com.example.hapticstrategyapp_s3.Activities.SlideActivity;
import com.example.hapticstrategyapp_s3.Behavior.SlideBehavior;
import com.example.hapticstrategyapp_s3.Constants;
import com.example.hapticstrategyapp_s3.ExperimentManager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class SlideController {

    private int session = 1;
    private int slideNumber = 0;
    private boolean playTone = true;
    private boolean speak = true;
    private String currentArea = "";
    private String lastArea = "";

    private List<Event> eventLog = new ArrayList<>();

    public void addStartEvent() {
        Event e = new Event(-1, -1, Event.START_EVENT, Event.AREA_NONE, Event.ACTION_NONE,
                slideNumber, ExperimentManager.getParticipantID(), ExperimentManager.getGroupID(),
                ExperimentManager.getSessionID());
        eventLog.add(e);
        Log.d("Data", e.toCSVRow());
    }

    public void addPauseEvent() {
        Event e = new Event(-1, -1, Event.PAUSE_EVENT, Event.AREA_NONE, Event.ACTION_NONE,
                slideNumber, ExperimentManager.getParticipantID(), ExperimentManager.getGroupID(),
                ExperimentManager.getSessionID());
        eventLog.add(e);
        Log.d("Data", e.toCSVRow());
    }

    public void addContinueEvent() {
        Event e = new Event(-1, -1, Event.CONTINUE_EVENT, Event.AREA_NONE, Event.ACTION_NONE,
                slideNumber, ExperimentManager.getParticipantID(), ExperimentManager.getGroupID(),
                ExperimentManager.getSessionID());
        eventLog.add(e);
        Log.d("Data", e.toCSVRow());
    }

    public void addEndEvent() {
        Event e = new Event(-1, -1, Event.END_EVENT, Event.AREA_NONE, Event.ACTION_NONE,
                slideNumber, ExperimentManager.getParticipantID(), ExperimentManager.getGroupID(),
                ExperimentManager.getSessionID());
        eventLog.add(e);
        Log.d("Data", e.toCSVRow());
    }

    public void addTouchEvent(float x, float y, String event, String area, String action) {
        Event e = new Event(x, y, event, stripStringOfComma(area), stripStringOfComma(action),
                slideNumber, ExperimentManager.getParticipantID(), ExperimentManager.getGroupID(),
                ExperimentManager.getSessionID());
        eventLog.add(e);
        Log.d("Data", e.toCSVRow());
    }

    private String stripStringOfComma(String s) {
        String r = s.replaceAll("\\,", "\\_");
        System.out.println(r);
        return r;
    }

    public void addTouchEventUp(float x, float y) {
        Event e = new Event(x, y, Event.EVENT_UP, Event.AREA_NONE, Event.ACTION_UP, slideNumber,
                ExperimentManager.getParticipantID(), ExperimentManager.getGroupID(),
                ExperimentManager.getSessionID());
        eventLog.add(e);
        Log.d("Data", e.toCSVRow());
        currentArea="";
    }

    public SlideController() {
        this.session = 1;
        this.slideNumber = 0;
    }

    public SlideController(int session) {
        this.session = session;
        this.slideNumber = 0;
    }

    public boolean nextSlide() {
        if (slideNumber < getSlideArray(session).size() -1) {
            slideNumber = slideNumber + 1;
            return true;
        }
        return false;
    }

    public boolean backSlide() {
        if (slideNumber > 0) {
            slideNumber = slideNumber - 1;
            return true;
        }
        return false;
    }

    private void clearEventLog() {
        eventLog.clear();
    }

    private void saveCSVFile(String data) {
        String fileName = "p" + ExperimentManager.getParticipantID() +
                "_set" + ExperimentManager.getSessionID() +
                "_" + Constants.DATA_FILE;

        File folder = ExperimentManager.getPublicDataStorage("data");
        File file = new File(folder.getAbsolutePath() + File.separator + fileName);

        boolean needsHeader = false;

        Log.d("Data", data);

        FileWriter fw = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
                needsHeader = true;
            }
            fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);

            if (needsHeader) {
                bw.write(Event.makeCSVHeader());
            }
            bw.write(data);
            bw.close();
            clearEventLog();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reactTapReadAgain(int x, int y, SlideActivity sa, String area) {
        sa.getController().addTouchEvent(x, y, Event.TAP, stripStringOfComma(area), Event.ACTION_TAP);
    }

    public void reactAreaThenBargraphNoRepeat(int x, int y, Bitmap bitmap, SlideActivity sa,
                                                   String action, String s) {
        Log.i("REACTION", "reactAreaThenBargraphNoRepeat called");
        if (s != "Bar 1" && s != "Bar 2" && s != "Bar 3" && s != "Bar 4"){
            checkAreaSpeak(s, sa, y);
        }
        else {
            if (sa.getTouchManagement().circleContains(-16777216, x, y, bitmap)) {
                sa.getController().addTouchEvent(x, y, Event.ON_LINE, s, action); // bar set 1
                sa.startVibration(4);
            }
            else if (sa.getTouchManagement().circleContains(-14277082, x, y, bitmap)) {
                sa.getController().addTouchEvent(x, y, Event.ON_LINE, s, action); // bar set 2
                sa.startVibration(4);
            }
            else if (sa.getTouchManagement().circleContains(-9014927, x, y, bitmap)) {
                sa.getController().addTouchEvent(x, y, Event.ON_LINE, s, action); // bar set 3
                sa.startVibration(3);
            }
            else {
                sa.getController().addTouchEvent(x, y, Event.OFF_LINE, s, action);
                sa.stopVibration();
            }
        }
    }

    public void reactAreaThenLinegraphNoRepeat(int x, int y, Bitmap bitmap, SlideActivity sa,
                                                  String action, String s) {
        Log.i("REACTION", "reactAreaThenLinegraphNoRepeat called");

        if (s != "Line" && s != "Line 1" && s != "Line 2" && s != "Dot"){
            checkAreaSpeak(s, sa, y);
        }
        else{
            //Color = Red
            if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap)) {
                sa.getController().addTouchEvent(x, y, Event.ON_LINE, s, action); //dots
                if (playTone){
                    sa.playFreq();
                    playTone = false;
                }
            }
            //Color = black
            else if (sa.getTouchManagement().circleContains(-16777216, x, y, bitmap)) {
                sa.getController().addTouchEvent(x, y, Event.ON_LINE, s, action); //1ine set 1
                sa.startVibration(4);
                playTone = true;
            }
            else if (sa.getTouchManagement().circleContains(-8421505, x, y, bitmap)) {
                sa.getController().addTouchEvent(x, y, Event.ON_LINE, s, action); //1ine set 2
                sa.startVibration(3);
                playTone = true;
            }
            else if (sa.getTouchManagement().circleContains(-2500135, x, y, bitmap)) {
                sa.getController().addTouchEvent(x, y, Event.ON_LINE, s, action); // grid line set
                sa.startVibration(4);
                checkAreaSpeak(s, sa, y);
                playTone = true;
            }
            else {
                sa.getController().addTouchEvent(x, y, Event.OFF_LINE, s, action);
                sa.stopVibration();
                playTone = true;
            }
        }
    }

    public void reactAreaThenGridTestNoRepeat(int x, int y, Bitmap bitmap, SlideActivity sa,
                                               String action, String s) {
//        checkAreaSpeak(s, sa, y);
        if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap)) {
            sa.getController().addTouchEvent(x, y, Event.ON_LINE, s, action); //dots
            if (playTone){
                sa.playFreq();
                playTone = false;
            }
        }
        else {
            sa.getController().addTouchEvent(x, y, Event.OFF_LINE, s, action);
            sa.stopVibration();
            playTone = true;
        }
    }

    public void reactAreaThenDotTestNoRepeat(int x, int y, Bitmap bitmap, SlideActivity sa,
                                              String action, String s) {
        if (s != "Dot Chart") {
            if (s.equals("Men")) {
                sa.getController().addTouchEvent(x, y, Event.ON_LINE, s, action); // men box legend
                sa.stopVibration();
                if (playTone){
                    sa.playFreq();
                    playTone = false;
                }
            }
            else if (s.equals("Women")) {
                sa.getController().addTouchEvent(x, y, Event.ON_LINE, s, action); // women box legend
                sa.stopVibration();
                if (playTone){
                    sa.playFreq2();
                    playTone = false;
                }
            }

            checkAreaSpeak(s, sa, y);
        }

        if (sa.getTouchManagement().circleContains(-1, x, y, bitmap) && s.equals("Dot Chart")) {
            sa.getController().addTouchEvent(x, y, Event.ON_LINE, s, action); // outline
            sa.startVibration(4);
            playTone = true;
        }
        else if (sa.getTouchManagement().circleContains(-12291388, x, y, bitmap)) {
            sa.getController().addTouchEvent(x, y, Event.ON_LINE, s, action); // men box
            sa.stopVibration();
            if (playTone){
                sa.playFreq();
                playTone = false;
            }
        }
        else if (sa.getTouchManagement().circleContains(-1213135, x, y, bitmap)) {
            sa.getController().addTouchEvent(x, y, Event.ON_LINE, s, action); // women box
            sa.stopVibration();
            if (playTone){
                sa.playFreq2();
                playTone = false;
            }
        }
        else {
            sa.getController().addTouchEvent(x, y, Event.OFF_LINE, s, action);
            sa.stopVibration();
            playTone = true;
        }
    }

    public void reactAreaThenPiechartNoRepeat(int x, int y, Bitmap bitmap, SlideActivity sa,
                                              String action, String s) {
        Log.i("REACTION", "reactAreaThenPiechartNoRepeat called");
        String segment;
        String title = "Percentage of people that die form different forms of cancer";

        if (s.equals("Title")) {
            sa.getController().addTouchEvent(x, y, Event.ON_LINE, s, action); // title
            checkAreaSpeak(title, sa, y);
        }
        else {
            if (sa.getTouchManagement().circleContains(-16777216, x, y, bitmap)) {
                sa.getController().addTouchEvent(x, y, Event.ON_LINE, s, action); // pie chart line
                sa.startVibration(4);
            }
            else if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap)) {
                sa.getController().addTouchEvent(x, y, Event.ON_LINE, s, action); // pie chart red
                sa.stopVibration();
                segment = "Lung cancer";
                checkAreaSpeak(segment, sa, y);
                sa.playPop();

            }
            else if (sa.getTouchManagement().circleContains(-16384, x, y, bitmap)) {
                sa.getController().addTouchEvent(x, y, Event.ON_LINE, s, action); // pie chart yellow
                sa.stopVibration();
                segment = "Colon cancer";
                checkAreaSpeak(segment, sa, y);
                sa.playTing();
            }
            else if (sa.getTouchManagement().circleContains(-16740800, x, y, bitmap)) {
                sa.getController().addTouchEvent(x, y, Event.ON_LINE, s, action); // pie chart green
                sa.stopVibration();
                segment = "Breast cancer";
                checkAreaSpeak(segment, sa, y);
                sa.playClink();
            }
            else if (sa.getTouchManagement().circleContains(-9014927, x, y, bitmap)) {
                sa.getController().addTouchEvent(x, y, Event.ON_LINE, s, action); // pie chart grey
                sa.stopVibration();
                segment = "Other forms of cancer";
                checkAreaSpeak(segment, sa, y);
                sa.playClick();
            }
            else if (sa.getTouchManagement().circleContains(-16768928, x, y, bitmap)) {
                sa.getController().addTouchEvent(x, y, Event.ON_LINE, s, action); // pie chart blue
                segment = "Prostate cancer";
                checkAreaSpeak(segment, sa, y);
                sa.playWoosh();
            }
            else {
                sa.getController().addTouchEvent(x, y, Event.OFF_LINE, s, action);
                sa.stopVibration();
            }
        }
    }

    public void reactAreaThenDotsNoRepeat(int x, int y, Bitmap bitmap, SlideActivity sa,
                                               String action, String s) {
        Log.i("REACTION", "reactAreaThenDotsNoRepeat called");

        if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap)) {
            sa.getController().addTouchEvent(x, y, Event.ON_LINE, s, action); // dots
            if (playTone){
                sa.playFreq();
                playTone = false;
            }
        }
        else if (sa.getTouchManagement().circleContains(-1237980, x, y, bitmap)) {
            sa.getController().addTouchEvent(x, y, Event.ON_LINE, s, action); // dots
            if (playTone){
                sa.playFreq();
                playTone = false;
            }
        }
        else{
            playTone = true;
        }
    }

    public void reactAreaThenLineBargraphGrid(int x, int y, SlideActivity sa, String action, String s) {
        // System.out.println("TEST: in speak");
        sa.getController().addTouchEvent(x, y, Event.ON_LINE, s, action);
        //sa.playClick();
        //sa.vibrateClick();
    }

    public void reactGridLine (int x, int y, Bitmap bitmap, SlideActivity sa, String action, String s) {
        Log.i("REACTION", "reactGridline called");
        sa.playClick();
        checkAreaSpeak(s, sa, y);

        if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap)) {
            sa.getController().addTouchEvent(x, y, Event.ON_LINE, s, action); // dots
            sa.startVibration(4);
            if (playTone) {
                sa.playFreq();
                playTone = false;
            }
        }
        else if (sa.getTouchManagement().circleContains(-16777216, x, y, bitmap)) {
            sa.getController().addTouchEvent(x, y, Event.ON_LINE, s, action); // line set 1 & bar set 1
            sa.startVibration(4);
            playTone = true;
        }
        else if (sa.getTouchManagement().circleContains(-8421505, x, y, bitmap)) {
            sa.getController().addTouchEvent(x, y, Event.ON_LINE, s, action); //1ine set 2
            sa.startVibration(3);
            playTone = true;
        }
        else if (sa.getTouchManagement().circleContains(-14277082, x, y, bitmap)) {
            sa.getController().addTouchEvent(x, y, Event.ON_LINE, s, action); // bar set 2
            sa.startVibration(4);
            playTone = true;
        }
        else if (sa.getTouchManagement().circleContains(-9014927, x, y, bitmap)) {
            sa.getController().addTouchEvent(x, y, Event.ON_LINE, s, action); // bar set 3
            sa.startVibration(3);
            playTone = true;
        }
        else if (sa.getTouchManagement().circleContains(-2500135, x, y, bitmap)) {
            sa.getController().addTouchEvent(x, y, Event.ON_LINE, s, action); // grid line set
            sa.startVibration(4);
            checkAreaSpeak(s, sa, y);
            playTone = true;
        }
        else {
            sa.getController().addTouchEvent(x, y, Event.OFF_LINE, s, action);
            sa.stopVibration();
            playTone = true;
        }
    }

    public void reactGridSystem (int x, int y, Bitmap bitmap, SlideActivity sa, String action, String s) {
        Log.i("REACTION", "reactGridline called");

        checkAreaSpeak("", sa, y);

        if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap)) {
            sa.getController().addTouchEvent(x, y, Event.ON_LINE, s, action); // dots
            sa.stopVibration();
            if (playTone) {
                sa.playFreq();
                playTone = false;
            }
        }
        else if (sa.getTouchManagement().circleContains(-16777216, x, y, bitmap)) {
            sa.getController().addTouchEvent(x, y, Event.ON_LINE, s, action); // horz. lines
            sa.startVibration(4);
            playTone = true;
        }
        else if (sa.getTouchManagement().circleContains(-2500135, x, y, bitmap)) {
            sa.getController().addTouchEvent(x, y, Event.ON_LINE, s, action); // vert. lines
            sa.stopVibration();
            sa.playClick();
            playTone = true;
        }
        else {
            sa.getController().addTouchEvent(x, y, Event.OFF_LINE, s, action);
            sa.stopVibration();
            playTone = true;
        }
    }

    public void reactDotGridLine (int x, int y, Bitmap bitmap, SlideActivity sa, String action, String s) {
        Log.i("REACTION", "reactGridline called");

        checkAreaSpeak("", sa, y);

        if (sa.getTouchManagement().circleContains(-1, x, y, bitmap)) {
            sa.getController().addTouchEvent(x, y, Event.ON_LINE, s, action); // dots
            sa.stopVibration();
            sa.playClick();
            playTone = true;
        }
        else {
            sa.getController().addTouchEvent(x, y, Event.OFF_LINE, s, action);
            sa.stopVibration();
            playTone = true;
        }
    }

    void checkAreaSpeak(String area, SlideActivity sa, int y) {
        if (!currentArea.equals(area)) {
            currentArea = area;
            sa.speak(area);
        }
    }

    public void reactDotSpeak(int x, int y, SlideActivity sa, String s) {
        Log.i("AREA:", " " + s);
        if (!s.equals("Grid")) {
            sa.speak(s);
        }
    }

    public void reactAreaThenLineBargraphNoSpeak(int x, int y, Bitmap bitmap, SlideActivity sa, String action) {
        if (!currentArea.equals("")) {
            lastArea = currentArea;
        }
        currentArea = "";
        if (sa.getTouchManagement().circleContains(-49091, x, y, bitmap)) {
            sa.getController().addTouchEvent(x, y, Event.ON_LINE, "Bar", action);
            sa.startVibration(4);
        }
        else {
            sa.getController().addTouchEvent(x, y, Event.OFF_LINE, Event.AREA_NONE, action);
            sa.stopVibration();
        }
    }

    //Can't get tones to play or vibrations to stop when off line
    public void reactQuad(int x, int y, Bitmap bitmap, SlideActivity sa, String action, String s){
        if(action == Event.ACTION_TAP){
            checkAreaSpeak(s, sa, y);
        } else {
            checkAreaSpeak(s, sa, y);
            if (sa.getTouchManagement().circleContains(-65536, x, y, bitmap)) {
                //Color = Red
                sa.getController().addTouchEvent(x, y, Event.ANGLE, s, action); //angles
                if (playTone) {
                    sa.playTing();
                }
                sa.startVibration(2);
                playTone = true;
            } else if (sa.getTouchManagement().circleContains(-16777216, x, y, bitmap) ||
                    (sa.getTouchManagement().circleContains(-16448251, x, y, bitmap))) {
                //Color = black
                sa.getController().addTouchEvent(x, y, Event.LINE, s, action); //1ines
                sa.startVibration(4);
                playTone = true;
            } else if (sa.getTouchManagement().circleContains(-1, x, y, bitmap)){
                sa.stopVibration();
            } else {
                sa.getController().addTouchEvent(x, y, Event.OUTSIDE, s, action);
                sa.stopVibration();
                playTone = true;
            }
        }
    }

    public void reactWS(int x, int y, Bitmap bitmap, SlideActivity sa){
        String action = "";
        String s = "";
        if (sa.getTouchManagement().circleContains(Color.WHITE, x, y, bitmap)) {
            sa.getController().addTouchEvent(x, y, Event.WHITESPACE, s, action);
            sa.playClick();
        }
    }

    abstract public List<SlideBehavior> getSlideArray(int session);

    public SlideBehavior getSlideBehavior() {
        return getSlideArray(session).get(slideNumber);
    }

    public int getDrawableID() {
        return getSlideArray(session).get(slideNumber).getGraphID();
    }

    public void commitData() {
        StringBuilder sb = new StringBuilder();
        for (Event event: eventLog) {
            sb.append(event.toCSVRow());
        }
        saveCSVFile(sb.toString());
    }
}
