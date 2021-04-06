package com.example.hapticstrategyapp_s3.Controller;

import java.util.UUID;

public class Event {

    private String uuid;
    private String status;
    private String voiceArea;
    private String action;

    private long timeStamp;

    private float xPos;
    private float yPos;

    private final int slide;
    private int id;
    private int group;
    private int session;

    static final String START_EVENT = "Slide Start";
    static final String PAUSE_EVENT = "Slide Paused";
    static final String CONTINUE_EVENT = "Slide Continued";
    static final String END_EVENT = "Slide End";
    static final String ON_LINE = "On Line";
    static final String OFF_LINE = "Off Line";
    static final String TAP = "Tap";
    static final String DOUBLE_TAP = "Double Tap";
    static final String EVENT_UP = "Stop Touch";

    static final String ACTION_UP = "Action Up";
    static final String ACTION_NONE = "No Action";

    public static final String ACTION_TAP = "Action Tap";
    static final String ACTION_DOUBLE_TAP = "Action Double Tap";
    public static final String ACTION_MOVE = "Action Move";
    public static final String ACTION_DOWN = "Action Down";

    public static final String AREA_NONE = "No Area";

    //Quad study vars
    public static final String WHITESPACE = "Inside Shape";
    public static final String ANGLE = "Exploring Angle";
    public static final String LINE = "Exploring Line";
    public static final String OUTSIDE = "Outside Shape";

    public Event(float x, float y, String status, String voiceArea, String action, int slide,
                 int id, int group, int session) {
        this.uuid = UUID.randomUUID().toString();
        this.timeStamp = System.currentTimeMillis();
        this.xPos = x;
        this.yPos = y;
        this.status = status;
        this.voiceArea = voiceArea;
        this.slide = slide;
        this.id = id;
        this.group = group;
        this.session = session;
        this.action = action;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public float getxPos() {
        return xPos;
    }

    public void setxPos(float xPos) {
        this.xPos = xPos;
    }

    public float getyPos() {
        return yPos;
    }

    public void setyPos(float yPos) {
        this.yPos = yPos;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVoiceArea() {
        return voiceArea;
    }

    public void setVoiceArea(String voiceArea) {
        this.voiceArea = voiceArea;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public int getSession() {
        return session;
    }

    public void setSession(int session) {
        this.session = session;
    }

    public int getSlide() {
        return slide;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public static String makeCSVHeader() {
        StringBuilder sb = new StringBuilder();

        sb.append("UUID");
        sb.append(",");
        sb.append("Timestamp");
        sb.append(",");
        sb.append("ParticipantID");
        sb.append(",");
        sb.append("GroupID");
        sb.append(",");
        sb.append("SessionID");
        sb.append(",");
        sb.append("SlideNumber");
        sb.append(",");
        sb.append("Event");
        sb.append(",");
        sb.append("VoiceArea");
        sb.append(",");
        sb.append("Action");
        sb.append(",");
        sb.append("x");
        sb.append(",");
        sb.append("y");
        sb.append(System.getProperty("line.separator"));

        return sb.toString();
    }

    public String toCSVRow() {
        StringBuilder sb = new StringBuilder();

        sb.append(getUuid());
        sb.append(",");
        sb.append(getTimeStamp());
        sb.append(",");
        sb.append(getID());
        sb.append(",");
        sb.append(getGroup());
        sb.append(",");
        sb.append(getSession());
        sb.append(",");
        sb.append(getSlide());
        sb.append(",");
        sb.append(getStatus());
        sb.append(",");
        sb.append(getVoiceArea());
        sb.append(",");
        sb.append(getAction());
        sb.append(",");
        sb.append(getxPos());
        sb.append(",");
        sb.append(getyPos());
        sb.append(System.getProperty("line.separator"));

        return sb.toString();
    }
}
