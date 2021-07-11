package com.getrentbd.doodleinctask.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.getrentbd.doodleinctask.Common;
import com.getrentbd.doodleinctask.R;
import com.getrentbd.doodleinctask.adapter.SelectitemAdapter;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private RecyclerView rvSelectItem;

    private RecyclerView rvCategoryList;
    private SelectitemAdapter selectitemAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        rvSelectItem = findViewById(R.id.rvSelectItem);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(MainActivity.this, SecondActivity.class));
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        rvSelectItem.setLayoutManager(layoutManager);
        rvSelectItem.setHasFixedSize(true);
        selectitemAdapter = new SelectitemAdapter(MainActivity.this, Common.selectList);
        rvSelectItem.setAdapter(selectitemAdapter);
        selectitemAdapter.notifyDataSetChanged();
    }
}