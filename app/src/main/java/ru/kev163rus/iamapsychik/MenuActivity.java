package ru.kev163rus.iamapsychik;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuActivity extends FragmentActivity implements View.OnClickListener {

    private Timer mTimer;
    private MyTimerTask mMyTimerTask;
    private TextView textViewLogoLine1, textViewLogoLine2, textViewStartFastTest, textViewStartFullTest, textViewStartAddTest, textViewExit;
    private Animation handFadeInAnimation, handFadeOutAnimation, logoFadeInAnimation, logoFadeOutAnimation;
    private ImageView imageViewHandNewSeason;
    static Intent activityQuestion, activityMenu;
    Intent activityBeforeTest;
    Dialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_menu);

        textViewLogoLine1 = (TextView) findViewById(R.id.textViewLogoLine1);
        textViewLogoLine1.setShadowLayer(10f, 60f, 30f, 0xFFFFFFFF);

        textViewLogoLine2 = (TextView) findViewById(R.id.textViewLogoLine2);
        textViewLogoLine2.setShadowLayer(10f, 60f, 30f, 0xFFFFFFFF);
        textViewLogoLine2.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/romul.ttf"));

        textViewStartFastTest = (TextView) findViewById(R.id.textViewStartFastTest);
        textViewStartFastTest.setShadowLayer(7f, 25f, 15f, ContextCompat.getColor(this, R.color.colorMenuItemShadow2));
        textViewStartFastTest.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/crashctt.ttf"));

        textViewStartFullTest = (TextView) findViewById(R.id.textViewStartFullTest);
        textViewStartFullTest.setShadowLayer(7f, 25f, 15f, ContextCompat.getColor(this, R.color.colorMenuItemShadow2));
        textViewStartFullTest.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/crashctt.ttf"));

        textViewStartAddTest = (TextView) findViewById(R.id.textViewStartAddTest);
        textViewStartAddTest.setShadowLayer(7f, 25f, 15f, ContextCompat.getColor(this, R.color.colorMenuItemShadow2));
        textViewStartAddTest.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/crashctt.ttf"));

        textViewExit = (TextView) findViewById(R.id.textViewExit);
        textViewExit.setShadowLayer(7f, 25f, 15f, ContextCompat.getColor(this, R.color.colorMenuItemShadow2));
        textViewExit.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/crashctt.ttf"));


        if (mTimer != null) {
            mTimer.cancel();
        }
        mTimer = new Timer();
        mMyTimerTask = new MyTimerTask();
        mTimer.schedule(mMyTimerTask, 300, 2000);

        imageViewHandNewSeason = (ImageView) findViewById(R.id.imageViewHandNewSeason);

        handFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.handfadein);
        handFadeOutAnimation = AnimationUtils.loadAnimation(this, R.anim.handfadeout);
        logoFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.logofadein);
        logoFadeOutAnimation = AnimationUtils.loadAnimation(this, R.anim.logofadeout);

        handFadeInAnimation.setAnimationListener(animationFadeInListener);
        handFadeOutAnimation.setAnimationListener(animationFadeOutListener);
        logoFadeInAnimation.setAnimationListener(animationFadeInListener);
        logoFadeOutAnimation.setAnimationListener(animationFadeOutListener);

        imageViewHandNewSeason.startAnimation(handFadeInAnimation);

        activityQuestion = new Intent(this, QuestionsActivity.class);
        activityMenu = new Intent(this, MenuActivity.class);
        activityBeforeTest = new Intent(this, BeforeTestActivity.class);

        textViewStartFastTest.setOnClickListener(this);
        textViewStartFullTest.setOnClickListener(this);
        textViewStartAddTest.setOnClickListener(this);
        textViewExit.setOnClickListener(this);

        resetData();


    }

    @Override
    public void onClick(View v) {

        switch(v.getId()) {
            case R.id.textViewStartFastTest:
//                FragmentManager manager = getSupportFragmentManager();
//                MyDialogFragment myDialogFragment = new MyDialogFragment();
//                myDialogFragment.show(manager, "dialog");
                setData("Fast");
                startActivity(activityBeforeTest);
                break;
            case R.id.textViewStartFullTest:
                setData("Full");
                startActivity(activityBeforeTest);
                break;
            case R.id.textViewStartAddTest:
                setData("Add");
                startActivity(activityBeforeTest);
                break;
            case R.id.textViewExit:
                finish();
                System.exit(0);
                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        imageViewHandNewSeason.clearAnimation();
    }

    private void resetData(){
        Questions.indexOfQuestion = 1;
        Questions.itFastTest = false;
        Questions.itFullTest = false;
        Questions.itAddTest = false;
        Questions.arrayUserResult = null;
    }

    private void setData(String itemMenu){

        switch (itemMenu){
            case "Fast":
                Questions.itFastTest = true;
                Questions.countOfQuestions = 3;
                break;
            case "Full":
                Questions.itFullTest = true;
                Questions.countOfQuestions = 25;
                break;
            case "Add":
                Questions.itAddTest = true;
                Questions.countOfQuestions = 0;
                break;
            default:
                Questions.itFastTest = true;
                Questions.countOfQuestions = 10;
                break;
        }

        Questions.arrayUserResult = new int[Questions.countOfQuestions];

    }

    Animation.AnimationListener animationFadeOutListener = new Animation.AnimationListener() {

        @Override
        public void onAnimationEnd(Animation animation) {
            imageViewHandNewSeason.startAnimation(handFadeInAnimation);
//            textViewLogoLine1.startAnimation(logoFadeInAnimation);
//            textViewLogoLine2.startAnimation(logoFadeInAnimation);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
            // TODO Auto-generated method stub
        }

        @Override
        public void onAnimationStart(Animation animation) {
            // TODO Auto-generated method stub
        }
    };

    Animation.AnimationListener animationFadeInListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationEnd(Animation animation) {
            imageViewHandNewSeason.startAnimation(handFadeOutAnimation);
//            textViewLogoLine1.startAnimation(logoFadeOutAnimation);
//            textViewLogoLine2.startAnimation(logoFadeOutAnimation);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
            // TODO Auto-generated method stub
        }

        @Override
        public void onAnimationStart(Animation animation) {
            // TODO Auto-generated method stub
        }
    };

    // Timer.
    class MyTimerTask extends TimerTask {

        @Override
        public void run() {

//            final String RefreshingTextLogoLine1 = CreateLogoText(getString(R.string.LogoTextLine1), 15);
//            final String RefreshingTextLogoLine2 = CreateLogoText(getString(R.string.LogoTextLine2), 10);

            runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    Random mRandom = new Random();

                    if (textViewLogoLine1.getVisibility() == View.VISIBLE) {
//                        Animation out = AnimationUtils.makeOutAnimation(MenuActivity.this, true);
                        Animation logoOut = AnimationUtils.loadAnimation(MenuActivity.this, R.anim.logofadeout);
                        textViewLogoLine1.startAnimation(logoOut);
                        textViewLogoLine2.startAnimation(logoOut);
                        textViewLogoLine1.setVisibility(View.INVISIBLE);
                        textViewLogoLine2.setVisibility(View.INVISIBLE);
                    } else {
                        Animation logoIn = AnimationUtils.loadAnimation(MenuActivity.this, R.anim.logofadein);
                        textViewLogoLine1.startAnimation(logoIn);
                        textViewLogoLine2.startAnimation(logoIn);
                        textViewLogoLine1.setVisibility(View.VISIBLE);
                        textViewLogoLine2.setVisibility(View.VISIBLE);

                        int LogoLine1Left = mRandom.nextInt(textViewLogoLine1.getWidth() - 55);
                        int LogoLine2Left = mRandom.nextInt((textViewLogoLine2.getWidth() / 2) - 125);

                        int LogoLine1Top = mRandom.nextInt(textViewLogoLine1.getHeight() - 80);
                        int LogoLine2Top = mRandom.nextInt(textViewLogoLine2.getHeight() - 80);

                        if (LogoLine1Left < 0) LogoLine1Left = 0;
                        if (LogoLine2Left < 0) LogoLine2Left = 0;
                        if (LogoLine1Top < 0) LogoLine1Top = 0;
                        if (LogoLine2Top < 0) LogoLine2Top = 0;

                        textViewLogoLine1.setPadding(LogoLine1Left, LogoLine1Top, 0, 0);
                        textViewLogoLine2.setPadding(LogoLine2Left, LogoLine2Top, 0, 0);
                    }
                }
            });
        }
    }




    private String CreateLogoText(String givenString, int givemMaxChars){
        Random mRandom = new Random();
        int PrefixLogoText = mRandom.nextInt(givemMaxChars);
        String sResult = createString(PrefixLogoText, " ") + givenString;
        return sResult;
    }

    public String createString(int givenLengthString, String givenChar ) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < givenLengthString; i++) {
//            int number = random.nextInt(mCHAR.length());
            builder.append(givenChar);
        }
        return builder.toString();
    }
}
