package com.example.hapticstrategyapp_s3.Controller;

import com.example.hapticstrategyapp_s3.Behavior.PatternSearchBehavior;
import com.example.hapticstrategyapp_s3.Behavior.GridTrainingBehavior;
import com.example.hapticstrategyapp_s3.Behavior.LineTrainingBehavior;
import com.example.hapticstrategyapp_s3.Behavior.SlideBehavior;
import com.example.hapticstrategyapp_s3.Behavior.SlideBehaviorPolygon;

import java.util.ArrayList;
import java.util.List;

public class TrainingController extends SlideController{

    List<SlideBehavior> session1 = new ArrayList<>();

    public TrainingController(int session) {
        super(session);
        createBehaviors();
    }

    private void createBehaviors() {

        setUpSession1();
    }

    public void setUpSession1() {

        SlideBehaviorPolygon slide1 = new LineTrainingBehavior(this);
        SlideBehaviorPolygon slide2 = new PatternSearchBehavior(this);
        SlideBehaviorPolygon slide3 = new GridTrainingBehavior(this);

        session1.add(slide1);
        session1.add(slide2);
        session1.add(slide3);
    }

    @Override
    public List<SlideBehavior> getSlideArray(int session) {
        return session1;
    }
}
