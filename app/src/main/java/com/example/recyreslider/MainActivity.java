package com.example.recyreslider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycleView;
    Rv_Activity adapter;
    LinearLayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycleView = findViewById(R.id.recycleView);

        setRv();

    }

    private void setRv() {

        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recycleView.setLayoutManager(layoutManager);
        adapter = new Rv_Activity(this);
        recycleView.setAdapter(adapter);

        LinearSnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(recycleView);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (layoutManager.findLastCompletelyVisibleItemPosition() < (adapter.getItemCount() - 1)) {
                    layoutManager.smoothScrollToPosition(recycleView, new RecyclerView.State(), layoutManager.findLastCompletelyVisibleItemPosition() + 1);

                } else if (layoutManager.findLastCompletelyVisibleItemPosition() < (adapter.getItemCount() - 1)) {
                    layoutManager.smoothScrollToPosition(recycleView, new RecyclerView.State(), 0);
                }
            }
        },0,8000);



    }
}



















