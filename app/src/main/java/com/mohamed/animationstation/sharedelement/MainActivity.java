package com.mohamed.animationstation.sharedelement;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;

import com.mohamed.animationstation.R;

public class MainActivity extends AppCompatActivity {


    TextView tvName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvName = findViewById(R.id.tv_name);
    }


    public void onNextClicked(View view) {
        Intent intent = new Intent(this, TransitionActivity.class);
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
                this, new Pair<View, String>(tvName, getString(R.string.transition_name))
        );
        startActivity(intent, options.toBundle());
    }
}
