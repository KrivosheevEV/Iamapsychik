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

public class BeforeTestActivity extends Activity implements View.OnClickListener {

    private TextView textViewDialogBeforeTestText, textViewDialogBeforeTestYes, textViewDialogBeforeTestNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_before_test);

        textViewDialogBeforeTestText = (TextView) findViewById(R.id.textViewDialogBeforeTestText);
        textViewDialogBeforeTestText.setShadowLayer(7f, 25f, 15f, ContextCompat.getColor(this, R.color.colorMenuItemShadow2));
        textViewDialogBeforeTestText.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/crashctt.ttf"));

        textViewDialogBeforeTestYes = (TextView) findViewById(R.id.textViewDialogBeforeTestYes);
        textViewDialogBeforeTestYes.setShadowLayer(7f, 25f, 15f, ContextCompat.getColor(this, R.color.colorMenuItemShadow2));
        textViewDialogBeforeTestYes.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/crashctt.ttf"));

        textViewDialogBeforeTestNo = (TextView) findViewById(R.id.textViewDialogBeforeTestNo);
        textViewDialogBeforeTestNo.setShadowLayer(7f, 25f, 15f, ContextCompat.getColor(this, R.color.colorMenuItemShadow2));
        textViewDialogBeforeTestNo.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/crashctt.ttf"));

        textViewDialogBeforeTestYes.setOnClickListener(this);
        textViewDialogBeforeTestNo.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch(v.getId()) {
            case R.id.textViewDialogBeforeTestYes:
                startActivity(MenuActivity.activityQuestion);
                finish();
                break;
            case R.id.textViewDialogBeforeTestNo:
                finish();
                startActivity(MenuActivity.activityMenu);
                break;
        }

    }
}
