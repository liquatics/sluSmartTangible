package com.example.hapticstrategyapp_s3;

import android.os.Environment;
import android.util.Log;

import com.example.hapticstrategyapp_s3.Controller.SlideController;

import java.io.File;

public class ExperimentManager {

    private static SlideController controller;

    private static int participantID = -1;
    private static int groupID = -1;
    private static int sessionID = -1;

    public static void reset() {
        participantID = -1;
        groupID = -1;
        sessionID = -1;
        controller = null;
    }

    public static File getPublicDataStorage(String datafolder) {

        // Get the directory for the user's public pictures directory
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), datafolder);

        if (!file.mkdirs()) {
            Log.e("FileWriting", "Directory not created");
        }
        return file;
    }

    public static int getParticipantID() {
        return participantID;
    }

    public static void setParticipantID(int pID) {
        ExperimentManager.participantID = pID;
    }

    public static SlideController getController() {
        return controller;
    }

    public static void setController(SlideController controller) {
        ExperimentManager.controller = controller;
    }

    public static int getGroupID() {
        return groupID;
    }

    public static void setGroupID(int group) {
        ExperimentManager.groupID = group;
    }

    public static int getSessionID() {
        return sessionID;
    }

    public static void setSessionID(int sessionID) {
        ExperimentManager.sessionID = sessionID;
    }
}
