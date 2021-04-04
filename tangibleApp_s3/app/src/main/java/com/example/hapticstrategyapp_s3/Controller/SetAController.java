package com.example.hapticstrategyapp_s3.Controller;

import android.util.Log;

import com.example.hapticstrategyapp_s3.Behavior.BlankBehavior;
import com.example.hapticstrategyapp_s3.Behavior.ErrorBehavior;
import com.example.hapticstrategyapp_s3.Behavior.QuadABehavior;
import com.example.hapticstrategyapp_s3.Behavior.TrapezoidABehavior;
import com.example.hapticstrategyapp_s3.Behavior.ParallelogramABehavior;
import com.example.hapticstrategyapp_s3.Behavior.TriangleABehavior;
import com.example.hapticstrategyapp_s3.Behavior.SlideBehavior;

import java.util.ArrayList;
import java.util.List;

public class SetAController extends SlideController{

    List<SlideBehavior> sessionA = new ArrayList<SlideBehavior>();

    int groupID = -1;

    public SetAController(int session, int group) {
        super(session);
        this.groupID = group;
        createBehaviors();
    }

    private void createBehaviors() {
        setUpSession0();
    }

    /*
    While this could have possibly been solved more automatically instead of having
    A ton of strings in an array, this was the fastest, most reliable way to do this.
     */
    public void setUpSession0() {

        String currentOrdering = slideOrder[0];

        String[] orderingSplit = currentOrdering.split(",");
        Log.i("SlideOrder", "This slide order is: " + orderingSplit);
        System.out.println("ORDERING : groupID: " + groupID + ", split: " + orderingSplit.length);

        for (String s :
                orderingSplit) {
            if (s.equals("QuadA")) {
                sessionA.add(new QuadABehavior(this));
            }
            else if (s.equals("TrapezoidA")) {
                sessionA.add(new TrapezoidABehavior(this));
            }
            else if (s.equals("ParallelogramA")) {
                sessionA.add(new ParallelogramABehavior(this));
            }
            else if (s.equals("TriangleA")) {
                sessionA.add(new TriangleABehavior(this));
            }
            else if (s.equals("Blank")){
                sessionA.add(new BlankBehavior(this));
            }
            else {
                // This shouldn't happen, just adding something obviously wrong
                // to more easily spot issues
                System.out.println("AAAAAAAH");
                sessionA.add(new ErrorBehavior(this));
            }
        }
    }

    @Override
    public List<SlideBehavior> getSlideArray(int session) {
        return sessionA;
    }


    String[] slideOrder = {
            "QuadA,TrapezoidA,ParallelogramA,TrianglA,Blank"
    };
}
