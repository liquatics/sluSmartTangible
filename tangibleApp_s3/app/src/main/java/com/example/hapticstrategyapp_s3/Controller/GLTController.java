package com.example.hapticstrategyapp_s3.Controller;

import android.util.Log;

import com.example.hapticstrategyapp_s3.Behavior.AdeolitisBehavior;
import com.example.hapticstrategyapp_s3.Behavior.ApsoriatinNopsorianBehavior;
import com.example.hapticstrategyapp_s3.Behavior.BlankBehavior;
import com.example.hapticstrategyapp_s3.Behavior.ErrorBehavior;
import com.example.hapticstrategyapp_s3.Behavior.CancerDeathBehavior;
import com.example.hapticstrategyapp_s3.Behavior.CancerRecoverBehavior;
import com.example.hapticstrategyapp_s3.Behavior.ColiosisTiosisBehavior;
import com.example.hapticstrategyapp_s3.Behavior.CrisicolHertinolBehavior;
import com.example.hapticstrategyapp_s3.Behavior.DotChartBehavior;
import com.example.hapticstrategyapp_s3.Behavior.GridTrainingBehavior;
import com.example.hapticstrategyapp_s3.Behavior.LineTrainingBehavior;
import com.example.hapticstrategyapp_s3.Behavior.PatternSearchBehavior;
import com.example.hapticstrategyapp_s3.Behavior.PieChartBehavior;
import com.example.hapticstrategyapp_s3.Behavior.SlideBehavior;

import java.util.ArrayList;
import java.util.List;

public class GLTController extends SlideController{

    List<SlideBehavior> session0 = new ArrayList<SlideBehavior>();

    int groupID = -1;

    public GLTController(int session, int group) {
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
            if (s.equals("Pattern")) {
                session0.add(new PatternSearchBehavior(this));
            }
            else if (s.equals("Line Training")) {
                session0.add(new LineTrainingBehavior(this));
            }
            else if (s.equals("Grid Training")) {
                session0.add(new GridTrainingBehavior(this));
            }
            else if (s.equals("Adeolitis")) {
                session0.add(new AdeolitisBehavior(this));
            }
            else if (s.equals("ApsoriatinNopsorian")) {
                session0.add(new ApsoriatinNopsorianBehavior(this));
            }
            else if (s.equals("Recover")) {
                session0.add(new CancerRecoverBehavior(this));
            }
            else if (s.equals("ColiosisTiosis")) {
                session0.add(new ColiosisTiosisBehavior(this));
            }
            else if (s.equals("CrisicolHertinol")) {
                session0.add(new CrisicolHertinolBehavior(this));
            }
            else if (s.equals("Death")) {
                session0.add(new CancerDeathBehavior(this));
            }
            else if (s.equals("Pie")) {
                session0.add(new PieChartBehavior(this));
            }
            else if (s.equals("Dot")) {
                session0.add(new DotChartBehavior(this));
            }
            else if (s.equals("Blank")){
                session0.add(new BlankBehavior(this));
            }
            else {
                // This shouldn't happen, just adding something obviously wrong
                // to more easily spot issues
                System.out.println("AAAAAAAH");
                session0.add(new ErrorBehavior(this));
            }
        }
    }

    @Override
    public List<SlideBehavior> getSlideArray(int session) {
        return session0;
    }


    String[] slideOrder = {
            "Blank,Pattern,Blank,Line Training,Grid Training,Blank,Recover,Pie,Adeolitis,Dot,CrisicolHertinol,ApsoriatinNopsorian,ColiosisTiosis,Death,Blank"
    };
}
