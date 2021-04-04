package com.example.hapticstrategyapp_s3.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Switch;

import com.example.hapticstrategyapp_s3.Behavior.SlideBehavior;
import com.example.hapticstrategyapp_s3.Behavior.SlideBehaviorPolygon;
import com.example.hapticstrategyapp_s3.Constants;
import com.example.hapticstrategyapp_s3.Controller.Event;
import com.example.hapticstrategyapp_s3.Controller.SlideController;
import com.example.hapticstrategyapp_s3.ExperimentManager;
import com.example.hapticstrategyapp_s3.R;
import com.example.hapticstrategyapp_s3.TouchManager;

import java.util.Locale;

import edu.unlv.cs.vibration.VibrationManager;

public class SlideActivity extends AppCompatActivity implements View.OnTouchListener {

    ImageView img;

    TouchManager touchManager;
    VibrationManager vibrationManager;
    boolean vibrating = false;
    int vibrationNumber = -1;
    Menu navigationMenu;

    float paintX1 = 0;
    float paintY1 = 0;
    float paintX2 = 0;
    float paintY2 = 0;

    Bitmap bitmap;
    Canvas canvas;

    TextToSpeech t1;

    SlideController controller;
    SlideBehavior behavior;

    long timestamp_start;
    long timestamp_end;

    long tapTime = System.currentTimeMillis();

    boolean hasWritePermission = false;
    boolean newslide = false;
    boolean should_click = true;
    boolean high_speed = true;
    boolean temp_blocking = false;

    MediaPlayer click_mp;
    MediaPlayer ting;
    MediaPlayer clink;
    MediaPlayer pop;
    MediaPlayer woosh;
    MediaPlayer freq262;
    MediaPlayer freq196;

    private ToneGenerator beep = new ToneGenerator(AudioManager.STREAM_MUSIC, 500);

    private Switch speedSwitch;

    public SlideActivity() {
        super();
        this.controller = ExperimentManager.getController();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        vibrationManager = new VibrationManager();
        vibrationManager.setActivity(this);
        vibrationManager.initialize();

        touchManager = new TouchManager();

        setContentView(R.layout.activity_slide);

        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.US);
                }
            }
        });

        t1.setSpeechRate(2.0f);

        img = findViewById(R.id.graphImg);

        initPopup();
        ensurePermissions();
        startNewSlide();
    }

    private void ensurePermissions() {
        if (this.checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) !=
                PackageManager.PERMISSION_GRANTED) {
            this.requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 23);
        }
        else {
            hasWritePermission = true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == Constants.REQUEST_WRITE_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                hasWritePermission = true;
            }
            else {
                hasWritePermission = false;
            }
        }
    }

    private void startNewSlide() {
        loadSlide();
        controller.addStartEvent();
        newslide = true;
        invalidateOptionsMenu();
    }

    private void loadSlide() {

        behavior = controller.getSlideBehavior();

        Resources res = getResources();
        Bitmap bm = BitmapFactory.decodeResource(res, controller.getDrawableID());
        Bitmap bitmapRightSize = Bitmap.createScaledBitmap(bm, 2048, 1360, false);
//        Bitmap bitmapRightSize = Bitmap.createScaledBitmap(bm, 2560, 1417, false);

        bitmap = bitmapRightSize.copy(Bitmap.Config.ARGB_8888, true);
        canvas = new Canvas(bitmap);

        canvas.drawBitmap(bitmap, 0, 0, null);

        if (behavior instanceof SlideBehaviorPolygon) {
            System.out.println("Is slide behavior polygon");
            SlideBehaviorPolygon b = (SlideBehaviorPolygon) behavior;

            b.drawPolygons(this);
        }
        img.setImageBitmap(bitmap);
        img.setOnTouchListener(this);

        click_mp = MediaPlayer.create(this, R.raw.click);
        ting = MediaPlayer.create(this, R.raw.ting);
        clink = MediaPlayer.create(this, R.raw.clink);
        pop = MediaPlayer.create(this, R.raw.pop);
        woosh = MediaPlayer.create(this, R.raw.woosh);
        freq262 = MediaPlayer.create(this, R.raw.freq262_micro);
        freq196 = MediaPlayer.create(this, R.raw.freq196_short);
    }

    int clickCount = 0;
    float mainFingerStartPositionX = -1;
    float mainFingerStartPositionY = -1;
    float mainFingerLastPositionX = -1;
    float mainFingerLastPositionY = -1;
    int mainFingerID = 0;

    @Override
    protected void onResume() {
        super.onResume();

        click_mp = MediaPlayer.create(this, R.raw.click);
        ting = MediaPlayer.create(this, R.raw.ting);
        clink = MediaPlayer.create(this, R.raw.clink);
        pop = MediaPlayer.create(this, R.raw.pop);
        woosh = MediaPlayer.create(this, R.raw.woosh);
        freq262 = MediaPlayer.create(this, R.raw.freq262_micro);
        freq196 = MediaPlayer.create(this, R.raw.freq196_short);
    }

    @Override
    protected void onPause() {
        super.onPause();

        click_mp.release();
        ting.release();
        clink.release();
        pop.release();
        woosh.release();
        freq262.release();
        freq196.release();
    }

    long doubleFingerTapTimer = 0l;

    @Override
    public boolean onTouch(View view, final MotionEvent ev) {
        int action = ev.getActionMasked();

        Log.d("Touch", "Touchevent");
        switch (action) {
            case MotionEvent.ACTION_OUTSIDE:
                break;

            case MotionEvent.ACTION_MOVE:
                if (ev.getPointerCount() == 1) {
                    react(ev, Event.ACTION_MOVE);
                }
                else {
                    int mainIndex = ev.findPointerIndex(mainFingerID);

                    if (mainIndex > -1) {
                        mainFingerLastPositionX = ev.getX(mainIndex);
                        mainFingerLastPositionY = ev.getY(mainIndex);
                    }
                    else {
                    }
                }
                break;

            case MotionEvent.ACTION_DOWN:
                System.out.println("ACTION DOWN");
                if (ev.getPointerCount() == 1) {
                    react(ev, Event.ACTION_DOWN);
                    paintX1 = ev.getX();
                    paintY1 = ev.getY() * (1360f / 1525f);
                    tapTime = System.currentTimeMillis();
                }

                mainFingerStartPositionX = ev.getX();
                mainFingerStartPositionY = ev.getY();
                mainFingerLastPositionX = 0;
                mainFingerLastPositionY = 0;
                mainFingerID = ev.getPointerId(0);
                break;

            case MotionEvent.ACTION_POINTER_DOWN:
                if (ev.getPointerCount() == 3) {
                    final Handler triFingerHandler = new Handler();
                    triFingerHandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            float xDelta = mainFingerLastPositionX - mainFingerStartPositionX;
                            float yDelta = mainFingerLastPositionY - mainFingerStartPositionY;

                            float absDeltaX = Math.abs(xDelta);
                            float absDeltaY = Math.abs(yDelta);

                            // Horizontal Swipe
                            if (absDeltaX > absDeltaY) {
                                // Log.i("SLIDE", "the xDelta is: " + xDelta);
                                if (xDelta > 250f) {
                                    backSlide();
                                }
                                else {
                                    nextSlide();
                                }
                            }

                            // Vertical Swipe
                            if (absDeltaY > 250f) {
                                startMenu();
                            }
                        }
                    }, ViewConfiguration.getDoubleTapTimeout());
                }
                else if (ev.getPointerCount() == 2) {
                    System.out.println("Double Finger Down");
                    doubleFingerTapTimer = System.currentTimeMillis();
                }
                break;

            case MotionEvent.ACTION_UP:
                System.out.println("ACTION UP");
                reactUp(ev);
                paintX2 = ev.getX();
                paintY2 = ev.getY() * (1360f / 1525f);
                Log.d("Draw", "drawevent: {" + paintX1 + "f, " + paintY1 + "f}, {"
                        + paintX2 + "f, " + paintY2 + "f},");

                System.out.println("Double finger tap pre timer: " + (System.currentTimeMillis()
                        - doubleFingerTapTimer) + " pointers: " + ev.getPointerCount());
                if (((System.currentTimeMillis() - doubleFingerTapTimer) < 400)) {
                    System.out.println("Double finger tap");
                    reactDoubleFingerTap();
                    return true;
                }

                if (ev.getPointerCount() == 1 && (System.currentTimeMillis() - tapTime)
                        < ViewConfiguration.getTapTimeout()) {
                    clickCount++;

                    // This needs to manage single and double tap, which is why it triggers a timed
                    // method which checks if two clicks occurred within the time of a double click
                    if (clickCount == 1) {
                        final float x_event = ev.getX();
                        final float y_event = ev.getY();
                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                if (clickCount == 1) {
                                    System.out.println("TAP REACT");
                                    tapReact(x_event, y_event);
                                }
                                else if (clickCount >= 2) {
                                    System.out.println("DOUBLE TAP");
                                    doubleTapReact(x_event, y_event);
                                }

                                clickCount = 0;
                            }
                        }, 500); //custom double
                    }
                    break;
                }
                break;
        }
        return true;
    }

    void reactDoubleFingerTap() {
        stopVibration();
        t1.stop();
        click_mp.stop();
        ting.stop();
        clink.stop();
        pop.stop();
        woosh.stop();
        freq262.stop();
        freq196.stop();
    }

    void reactUp(MotionEvent ev) {
        controller.addTouchEventUp(ev.getX(), ev.getY());
        stopVibration();
    }

    void tapReact(float eventX, float eventY) {
        int x = Integer.valueOf((int) eventX);
        int y = Integer.valueOf((int) (eventY * (1360f / 1525f)));

        if (0 < x && x <= bitmap.getWidth() && 0 < y && y < bitmap.getHeight()) {
            eventBehaviorTap(x, y);
        }
    }

    void doubleTapReact(float eventX, float eventY) {
        int x = Integer.valueOf((int) eventX);
        int y = Integer.valueOf((int) (eventY * (1360f/1525f)));

        if (0 < x && x <= bitmap.getWidth() && 0 < y && y < bitmap.getHeight()) {
            eventBehaviorDoubleTap(x,y);
        }
    }

    void react(MotionEvent ev, String action) {
        float eventX;
        float eventY;

        eventX = ev.getX();
        eventY = ev.getY() * (1360f / 1525f);

        int x = Integer.valueOf((int) eventX);
        int y = Integer.valueOf((int) eventY);

        if (x >= 0 && x <= bitmap.getWidth() && y >= 0 && y < bitmap.getHeight()) {
            eventBehavior(x, y, action);
        }
    }

    public void drawPolygon(float[][] polygon) {
        Paint paint = new Paint();
        paint.setColor(Color.CYAN);
        paint.setStyle(Paint.Style.STROKE);
        Path path = new Path();
        path.moveTo(polygon[0][0], polygon[0][1]);
        for (int b = 0; b < polygon.length; b++) {
            float[] step = polygon[b];
            path.lineTo(step[0], step[1]);
        }
        path.lineTo(polygon[0][0], polygon[0][1]);

        canvas.drawPath(path, paint);
    }

    private void eventBehavior(int x, int y, String action) {
        behavior.touchReaction(x, y, bitmap, this, action);
    }

    private void eventBehaviorTap(int x, int y) {
        if (behavior instanceof SlideBehaviorPolygon) {
            ((SlideBehaviorPolygon) behavior).tapReaction(x, y, bitmap, this);
        }
    }

    private void eventBehaviorDoubleTap(int x, int y) {
        if (behavior instanceof SlideBehaviorPolygon) {
            ((SlideBehaviorPolygon) behavior).doubleTapReaction(x, y, bitmap, this);
        }
    }

    public void speak(String text) {
        t1.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

    public void speakBlocking(String text) {
        t1.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

    public void playTone() {
        beep.startTone(ToneGenerator.TONE_CDMA_NETWORK_BUSY, 200);
    }

    public void playClick() {
        if (should_click && !click_mp.isPlaying()) {
            click_mp.setVolume(0.75f, 0.75f);
            click_mp.start();
        }
    }

    public void playFreq() {
        if (!freq262.isPlaying()) {
            freq262.setVolume(0.75f, 0.75f);
            freq262.start();
        }
    }

    public void playFreq2() {
        if (!freq196.isPlaying()) {
            freq196.setVolume(0.75f, 0.75f);
            freq196.start();
        }
    }

    public void playTing() {
        if (!ting.isPlaying()) {
            ting.setVolume(075f, 0.75f);
            ting.start();
        }
    }

    public void playClink() {
        if (!clink.isPlaying()) {
            clink.setVolume(075f, 0.75f);
            clink.start();
        }
    }

    public void playPop() {
        if (!pop.isPlaying()) {
            pop.setVolume(075f, 0.75f);
            pop.start();
        }
    }

    public void playWoosh() {
        if (!woosh.isPlaying()) {
            woosh.setVolume(075f, 0.75f);
            woosh.start();
        }
    }

    public void startVibration() {
        if (vibrationNumber != 0) {
            vibrationNumber = 0;
            vibrationManager.slowPulseForever();
        }
    }

    public void startVibration(int vibPatternNumber) {
        if (vibrationNumber != vibPatternNumber) {
            vibrationNumber = vibPatternNumber;
            vibrationManager.stop();

            if (vibPatternNumber == 0) {
                vibrationManager.slowPulseForever();
            } else if (vibPatternNumber == 1) {
                vibrationManager.quickPulseForever();
            } else if (vibPatternNumber == 2) {
                vibrationManager.rumbleForever();
            } else if (vibPatternNumber == 3) {
                vibrationManager.knockForever();
            } else if (vibPatternNumber == 4) {
                vibrationManager.vibrateForever();
            } else if (vibPatternNumber == 5) {
                vibrationManager.quickPulseForever();
            }
        }
    }

    public void vibrateClick() {
        if (vibrationNumber != 0) {
            vibrationNumber = -1;
            vibrationManager.vibrate(0.1);
        }
    }

    public void stopVibration() {
        vibrationNumber = -1;
        vibrationManager.stop();
    }

    public void stopSounds() {
        click_mp.release();
        ting.release();
        clink.release();
        pop.release();
        woosh.release();
        freq262.release();
        freq196.release();
    }

    public TouchManager getTouchManagement() {
        return touchManager;
    }

    private void startMenu() {
        displayPopupWindow(img);
    }

    private void nextSlide() {
        if (controller.nextSlide()) {
            t1.stop();
            stopVibration();
            stopSounds();
            finalizeData();
            resetCoordinates();
            startNewSlide();
        }
        else {
            t1.stop();
            stopVibration();
            finalizeData();
            resetCoordinates();
            ExperimentManager.reset();
            startActivity(new Intent(getApplicationContext(), ParticipantID.class));
        }
    }

    private void backSlide() {
        if (controller.backSlide()) {
            t1.stop();
            stopVibration();
            finalizeData();
            resetCoordinates();
            startNewSlide();
        }
    }

    private void resetCoordinates() {
        clickCount = 0;
        mainFingerStartPositionX = -1;
        mainFingerStartPositionY = -1;
        mainFingerLastPositionX = -1;
        mainFingerLastPositionY = -1;
        mainFingerID = 0;
    }

    public SlideController getController() {
        return controller;
    }

    private void finalizeData() {
        controller.addEndEvent();
        controller.commitData();
    }

    PopupWindow popup;
    Switch clickSwitch;
    private void initPopup() {
        popup = new PopupWindow(SlideActivity.this);

        // Set content width and height
        popup.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        popup.setWidth(WindowManager.LayoutParams.WRAP_CONTENT);

        // Closes the popup window when touch outside of it - when looses focus
        popup.setOutsideTouchable(true);
        popup.setFocusable(true);
        popup.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                controller.addContinueEvent();
            }
        });

        clickSwitch = findViewById(R.id.click_switch);
        clickSwitch = new Switch(this);
        clickSwitch.setChecked(should_click);
        clickSwitch.setText(R.string.enable_clicking2);

        speedSwitch = findViewById(R.id.speed_switch);
        speedSwitch = new Switch(this);
        speedSwitch.setChecked(high_speed);
        speedSwitch.setText(R.string.fast_speed);

        LinearLayout layoutOfPopup = new LinearLayout(this);
        layoutOfPopup.setOrientation(LinearLayout.VERTICAL);
        layoutOfPopup.setBackgroundColor(getResources().getColor(R.color.white));
        layoutOfPopup.addView(clickSwitch);
        layoutOfPopup.addView(speedSwitch);

        speedSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                high_speed = speedSwitch.isChecked();

                if (high_speed) {
                    t1.setSpeechRate(2.0f);
                } else {
                    t1.setSpeechRate(1.0f);
                }
                System.out.println("SWITCH: " + should_click);
            }
        });

        clickSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                should_click = clickSwitch.isChecked();
                System.out.println("SWITCH: " + should_click);
            }
        });

        popup.setContentView(layoutOfPopup);
    }

    private void displayPopupWindow(View anchorView) {
        controller.addPauseEvent();
        popup.showAtLocation(anchorView, 1, 0, 0);
    }
}
