package com.example.hapticstrategyapp_s3.Controller;

import android.util.Log;

import com.example.hapticstrategyapp_s3.Behavior.BlankBehavior;
import com.example.hapticstrategyapp_s3.Behavior.ErrorBehavior;
import com.example.hapticstrategyapp_s3.Behavior.ParallelogramBBehavior;
import com.example.hapticstrategyapp_s3.Behavior.QuadBBehavior;
import com.example.hapticstrategyapp_s3.Behavior.SlideBehavior;
import com.example.hapticstrategyapp_s3.Behavior.TrapezoidBBehavior;
import com.example.hapticstrategyapp_s3.ExperimentManager;

import java.util.ArrayList;
import java.util.List;

public class SetBController extends SlideController{

    List<SlideBehavior> sessionB = new ArrayList<SlideBehavior>();

    int groupID = -1;

    public SetBController(int session, int group) {
        super(session);
        this.groupID = group;
        createBehaviors();
    }

    private void createBehaviors() {
        setUpSessionB();
    }

    /*
    While this could have possibly been solved more automatically instead of having
    A ton of strings in an array, this was the fastest, most reliable way to do this.
     */
    public void setUpSessionB() {

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
            if (s.equals("QuadB")) {
                sessionB.add(new QuadBBehavior(this));
            }
            else if (s.equals("TrapezoidB")) {
                sessionB.add(new TrapezoidBBehavior(this));
            }
            else if (s.equals("ParallelogramB")) {
                sessionB.add(new ParallelogramBBehavior(this));
            }
            else if (s.equals("Blank")){
                sessionB.add(new BlankBehavior(this));
            }
            else {
                // This shouldn't happen, just adding something obviously wrong
                // to more easily spot issues
                System.out.println("AAAAAAAH");
                sessionB.add(new ErrorBehavior(this));
            }
        }
    }

    @Override
    public List<SlideBehavior> getSlideArray(int session) {
        return sessionB;
    }


    String[] slideOrder = {
            "ParallelogramB,QuadB,TrapezoidB,Blank", //0 - test participant
            "TrapezoidB,QuadB,ParallelogramB,Blank",
            "QuadB,TrapezoidB,ParallelogramB,Blank",
            "ParallelogramB,QuadB,TrapezoidB,Blank",
            "QuadB,TrapezoidB,ParallelogramB,Blank",
            "ParallelogramB,QuadB,TrapezoidB,Blank",
            "ParallelogramB,TrapezoidB,QuadB,Blank",
            "TrapezoidB,QuadB,ParallelogramB,Blank",
            "TrapezoidB,ParallelogramB,QuadB,Blank",
            "ParallelogramB,TrapezoidB,QuadB,Blank" //9
    };
}
