package com.mohamed.animationstation.animator;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;

import com.mohamed.animationstation.R;

public class AnimatorActivity extends AppCompatActivity {

    TextView tvEmpty;
    TextView tvLoading;
    TextView tvCounter;
    ObjectAnimator showInOA;
    ObjectAnimator hideOA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator);
        tvEmpty = findViewById(R.id.tv_empty);
        tvLoading = findViewById(R.id.tv_loading);
        tvCounter = findViewById(R.id.tv_counter);


        PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 0.5f, 1.0f);
        PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 0.5f, 1.0f);
        PropertyValuesHolder alpha = PropertyValuesHolder.ofFloat(View.ALPHA, 0f, 1f);
        showInOA = ObjectAnimator.ofPropertyValuesHolder(tvEmpty, scaleX, scaleY, alpha);
        showInOA.setDuration(500);
        showInOA.setInterpolator(new OvershootInterpolator());


        hideOA = ObjectAnimator.ofFloat(tvLoading, View.ALPHA, 1f, 0f);
        hideOA.setDuration(500);


    }

    public void onButtonClicked(View view) {


        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 1000);
        valueAnimator.setDuration(1000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                final int a = (int) animation.getAnimatedValue();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String newText = a + "";
                        tvCounter.setText(newText);
                    }
                });
            }
        });
        valueAnimator.start();

        tvLoading.setVisibility(View.VISIBLE);

        tvCounter.animate().scaleXBy(2f).scaleYBy(2f).rotationBy(360f)
                .setInterpolator(new AccelerateDecelerateInterpolator())
                .setDuration(500)
                .start();

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(showInOA)
                .after(hideOA);
        animatorSet.start();


    }
}
