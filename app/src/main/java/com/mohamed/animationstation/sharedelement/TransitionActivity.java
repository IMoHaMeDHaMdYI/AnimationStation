package com.mohamed.animationstation.sharedelement;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.transition.TransitionInflater;

import com.mohamed.animationstation.R;

public class TransitionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);
        // In second activity:
        getWindow().setSharedElementEnterTransition(
                TransitionInflater.from(this).inflateTransition(R.transition.shared_transition)
        );
    }
}
