package com.example.hapticstrategyapp_s3.Controller;

import android.util.Log;

import com.example.hapticstrategyapp_s3.Behavior.BlankBehavior;
import com.example.hapticstrategyapp_s3.Behavior.ErrorBehavior;
import com.example.hapticstrategyapp_s3.Behavior.ParallelogramCBehavior;
import com.example.hapticstrategyapp_s3.Behavior.QuadCBehavior;
import com.example.hapticstrategyapp_s3.Behavior.SlideBehavior;
import com.example.hapticstrategyapp_s3.Behavior.TrapezoidCBehavior;
import com.example.hapticstrategyapp_s3.ExperimentManager;

import java.util.ArrayList;
import java.util.List;

public class SetCController extends SlideController{

    List<SlideBehavior> sessionC = new ArrayList<SlideBehavior>();

    int groupID = -1;

    public SetCController(int session, int group) {
        super(session);
        this.groupID = group;
        createBehaviors();
    }

    private void createBehaviors() {
        setUpSessionC();
    }

    /*
    While this could have possibly been solved more automatically instead of having
    A ton of strings in an array, this was the fastest, most reliable way to do this.
     */
    public void setUpSessionC() {
        // String currentOrdering = slideOrder[0];

        int participantID = ExperimentManager.getParticipantID();
        String currentOrdering;

        if (participantID > 50) {
            currentOrdering = slideOrder[0];
        }
        else{
            currentOrdering = slideOrder[participantID % 10]; //0-9, then start over
        }

        String[] orderingSplit = currentOrdering.split(",");
        Log.i("SlideOrder", "This slide order is: " + orderingSplit);
        System.out.println("ORDERING : groupID: " + groupID + ", split: " + orderingSplit.length);

        for (String s :
                orderingSplit) {
            if (s.equals("QuadC")) {
                sessionC.add(new QuadCBehavior(this));
            }
            else if (s.equals("TrapezoidC")) {
                sessionC.add(new TrapezoidCBehavior(this));
            }
            else if (s.equals("ParallelogramC")) {
                sessionC.add(new ParallelogramCBehavior(this));
            }
            else if (s.equals("Blank")){
                sessionC.add(new BlankBehavior(this));
            }
            else {
                // This shouldn't happen, just adding something obviously wrong
                // to more easily spot issues
                System.out.println("AAAAAAAH");
                sessionC.add(new ErrorBehavior(this));
            }
        }
    }

    @Override
    public List<SlideBehavior> getSlideArray(int session) {
        return sessionC;
    }


    String[] slideOrder = {
            "QuadC,TrapezoidC,ParallelogramC,Blank", //0 - test participant
            "QuadC,ParallelogramC,TrapezoidC,Blank",
            "ParallelogramC,TrapezoidC,QuadC,Blank",
            "QuadC,TrapezoidC,ParallelogramC,Blank",
            "ParallelogramC,QuadC,TrapezoidC,Blank",
            "TrapezoidC,ParallelogramC,QuadC,Blank",
            "TrapezoidC,QuadC,ParallelogramC,Blank",
            "ParallelogramC,TrapezoidC,QuadC,Blank",
            "ParallelogramC,QuadC,TrapezoidC,Blank",
            "TrapezoidC,QuadC,ParallelogramC,Blank" //9
    };
}