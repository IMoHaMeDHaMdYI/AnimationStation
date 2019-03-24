package com.mohamed.animationstation;

import android.content.Intent;
import android.os.Bundle;

import com.mohamed.animationstation.animator.AnimatorActivity;
import com.mohamed.animationstation.motionlayout.EnhancedMotionActivity;
import com.mohamed.animationstation.motionlayout.MotionActivity;
import com.mohamed.animationstation.sharedelement.MainActivity;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ParentActivity extends AppCompatActivity implements AppAdapter.OnItemClicked {


    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent);
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(AnimatorActivity.class);
        arrayList.add(MainActivity.class);
        arrayList.add(MotionActivity.class);
        arrayList.add(EnhancedMotionActivity.class);
        recyclerView = findViewById(R.id.rv);
        recyclerView.setAdapter(new AppAdapter(arrayList, this, this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onClick(Class item) {
        Intent intent = new Intent(this, item);
        startActivity(intent);
    }
}
