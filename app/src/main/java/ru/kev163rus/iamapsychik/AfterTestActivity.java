package ru.kev163rus.iamapsychik;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class AfterTestActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_after_test);

        TextView textViewDialogAfterTestText = (TextView) findViewById(R.id.textViewDialogAfterTestText);
        textViewDialogAfterTestText.setShadowLayer(7f, 25f, 15f, ContextCompat.getColor(this, R.color.colorMenuItemShadow2));
        textViewDialogAfterTestText.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/crashctt.ttf"));

        TextView textViewDialogAfterTestYes = (TextView) findViewById(R.id.textViewDialogAfterTestYes);
        textViewDialogAfterTestYes.setShadowLayer(7f, 25f, 15f, ContextCompat.getColor(this, R.color.colorMenuItemShadow2));
        textViewDialogAfterTestYes.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/crashctt.ttf"));

        TextView textViewDialogAfterTestNo = (TextView) findViewById(R.id.textViewDialogAfterTestNo);
        textViewDialogAfterTestNo.setShadowLayer(7f, 25f, 15f, ContextCompat.getColor(this, R.color.colorMenuItemShadow2));
        textViewDialogAfterTestNo.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/crashctt.ttf"));

        textViewDialogAfterTestYes.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch(v.getId()) {
            case R.id.textViewDialogAfterTestYes:
                startActivity(new Intent(this, FinishActivity.class));
                finish();
                break;
            case R.id.textViewDialogAfterTestNo:
                startActivity(new Intent(this, QuestionsActivity.class));
                finish();
                break;
        }

    }
}
