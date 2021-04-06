package com.example.hapticstrategyapp_s3.Controller;

import android.util.Log;

import com.example.hapticstrategyapp_s3.Behavior.ErrorBehavior;
import com.example.hapticstrategyapp_s3.Behavior.QuadTrainingBehavior;
import com.example.hapticstrategyapp_s3.Behavior.SlideBehavior;


import java.util.ArrayList;
import java.util.List;

public class QuadTrainingController extends SlideController{

    List<SlideBehavior> sessionT = new ArrayList<SlideBehavior>();

    int groupID = -1;

    public QuadTrainingController(int session, int group) {
        super(session);
        this.groupID = group;
        createBehaviors();
    }

    private void createBehaviors() {
        setUpSessionA();
    }

    /*
    While this could have possibly been solved more automatically instead of having
    A ton of strings in an array, this was the fastest, most reliable way to do this.
     */
    public void setUpSessionA() {
         String currentOrdering = slideOrder[0];

        String[] orderingSplit = currentOrdering.split(",");
        Log.i("SlideOrder", "This slide order is: " + orderingSplit);
        System.out.println("ORDERING : groupID: " + groupID + ", split: " + orderingSplit.length);

        for (String s :
                orderingSplit) {
            if (s.equals("Training")) {
                sessionT.add(new QuadTrainingBehavior(this));
            } else {
                // This shouldn't happen, just adding something obviously wrong
                // to more easily spot issues
                System.out.println("AAAAAAAH");
                sessionT.add(new ErrorBehavior(this));
            }
        }
    }

    @Override
    public List<SlideBehavior> getSlideArray(int session) {
        return sessionT;
    }


    String[] slideOrder = {
            "Training"
    };
}