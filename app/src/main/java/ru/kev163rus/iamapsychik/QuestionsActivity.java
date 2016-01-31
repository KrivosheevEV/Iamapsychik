package ru.kev163rus.iamapsychik;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class QuestionsActivity extends Activity implements View.OnClickListener {

    private TextView textViewQuestionFinish, textViewQuestionText, textViewQuestionAnswer1, textViewQuestionAnswer2, textViewQuestionAnswer3,
            textViewQuestionBack, textViewQuestionSkip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_questions);

        textViewQuestionFinish = (TextView) findViewById(R.id.textViewQuestionFinish);
        textViewQuestionFinish.setShadowLayer(7f, 25f, 15f, ContextCompat.getColor(this, R.color.colorMenuItemShadow2));
        textViewQuestionFinish.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/crashctt.ttf"));

        textViewQuestionText = (TextView) findViewById(R.id.textViewQuestionText);
        textViewQuestionText.setShadowLayer(7f, 25f, 15f, ContextCompat.getColor(this, R.color.colorMenuItemShadow2));
        textViewQuestionText.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/crashctt.ttf"));

        textViewQuestionAnswer1 = (TextView) findViewById(R.id.textViewQuestionAnswer1);
        textViewQuestionAnswer1.setShadowLayer(7f, 25f, 15f, ContextCompat.getColor(this, R.color.colorMenuItemShadow2));
        textViewQuestionAnswer1.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/crashctt.ttf"));

        textViewQuestionAnswer2 = (TextView) findViewById(R.id.textViewQuestionAnswer2);
        textViewQuestionAnswer2.setShadowLayer(7f, 25f, 15f, ContextCompat.getColor(this, R.color.colorMenuItemShadow2));
        textViewQuestionAnswer2.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/crashctt.ttf"));

        textViewQuestionAnswer3 = (TextView) findViewById(R.id.textViewQuestionAnswer3);
        textViewQuestionAnswer3.setShadowLayer(7f, 25f, 15f, ContextCompat.getColor(this, R.color.colorMenuItemShadow2));
        textViewQuestionAnswer3.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/crashctt.ttf"));

        textViewQuestionBack = (TextView) findViewById(R.id.textViewQuestionBack);
        textViewQuestionBack.setShadowLayer(7f, 25f, 15f, ContextCompat.getColor(this, R.color.colorMenuItemShadow2));
        textViewQuestionBack.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/crashctt.ttf"));

        textViewQuestionSkip = (TextView) findViewById(R.id.textViewQuestionSkip);
        textViewQuestionSkip.setShadowLayer(7f, 25f, 15f, ContextCompat.getColor(this, R.color.colorMenuItemShadow2));
        textViewQuestionSkip.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/crashctt.ttf"));

        textViewQuestionFinish.setOnClickListener(this);
        textViewQuestionAnswer1.setOnClickListener(this);
        textViewQuestionAnswer2.setOnClickListener(this);
        textViewQuestionAnswer3.setOnClickListener(this);
        textViewQuestionBack.setOnClickListener(this);
        textViewQuestionSkip.setOnClickListener(this);

        setQuestionAndAnswers(Questions.itFastTest, Questions.indexOfQuestion);

    }

    private void setQuestionAndAnswers(boolean itFastTest, int indexOfQuestion){

        textViewQuestionText.setText(getQuestionText(itFastTest, indexOfQuestion));
        textViewQuestionAnswer1.setText(getAnswer1Text(itFastTest, indexOfQuestion));
        textViewQuestionAnswer2.setText(getAnswer2Text(itFastTest, indexOfQuestion));
        textViewQuestionAnswer3.setText(getAnswer3Text(itFastTest, indexOfQuestion));

    }

    private String getQuestionText(boolean itFastTest, int indexOfuestion) {

        String result = "";

        if (itFastTest) {
            switch (indexOfuestion) {
                case 1:
                    result = getString(R.string.questionFast1);
                    break;
                case 2:
                    result = getString(R.string.questionFast2);
                    break;
                case 3:
                    result = getString(R.string.questionFast3);
                    break;
            }

        } else {

        }

        return result;

    }

    private String getAnswer1Text(boolean itFastTest, int indexOfuestion) {

        String result = "";

        if (itFastTest) {
            switch (indexOfuestion) {
                case 1:
                    result = getString(R.string.answerFast1_1);
                    break;
                case 2:
                    result = getString(R.string.answerFast2_1);
                    break;
                case 3:
                    result = getString(R.string.answerFast3_1);
                    break;
            }

        } else {

        }

        return result;

    }

    private String getAnswer2Text(boolean itFastTest, int indexOfuestion) {

        String result = "";

        if (itFastTest) {
            switch (indexOfuestion) {
                case 1:
                    result = getString(R.string.answerFast1_2);
                    break;
                case 2:
                    result = getString(R.string.answerFast2_2);
                    break;
                case 3:
                    result = getString(R.string.answerFast3_2);
                    break;
            }

        } else {

        }

        return result;

    }

    private String getAnswer3Text(boolean itFastTest, int indexOfuestion) {

        String result = "";

        if (itFastTest) {
            switch (indexOfuestion) {
                case 1:
                    result = getString(R.string.answerFast1_3);
                    break;
                case 2:
                    result = getString(R.string.answerFast2_3);
                    break;
                case 3:
                    result = getString(R.string.answerFast3_3);
                    break;
            }

        } else {

        }

        return result;

    }

    @Override
    public void onClick(View v) {

        switch(v.getId()) {
            case R.id.textViewQuestionAnswer1:
                setNewQuestion(true);
                break;
            case R.id.textViewQuestionAnswer2:
                setNewQuestion(true);
                break;
            case R.id.textViewQuestionAnswer3:
                setNewQuestion(true);
                break;
            case R.id.textViewQuestionFinish:
                break;
            case R.id.textViewQuestionBack:
                setNewQuestion(false);
                break;
            case R.id.textViewQuestionSkip:
                setNewQuestion(true);
                break;
        }

    }

    private void setNewQuestion(boolean isIncrement){

        if (isIncrement){
            Questions.indexOfQuestion++;
        }else{
            Questions.indexOfQuestion--;
        }

        if (Questions.indexOfQuestion > Questions.countOfQuestions){
            finishTest();
        }

        setQuestionAndAnswers(Questions.itFastTest, Questions.indexOfQuestion);

    }

    private void finishTest(){

    }
}


