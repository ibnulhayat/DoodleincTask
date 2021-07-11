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

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private RecyclerView rvSelectItem;
    private List<String> selectItem = new ArrayList<>();
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
        if(Common.categoryLists.size() > 0){
            for(int i = 0; i < Common.categoryLists.size(); i++){
                if(Common.categoryLists.get(i).isSelect()){
                    selectItem.add(Common.categoryLists.get(i).getCategoryName());
                    for(int j = 0; j<Common.categoryLists.get(i).getSubCategory().size(); j++){
                        if(Common.categoryLists.get(i).getSubCategory().get(j).isSelect()){
                            selectItem.add(Common.categoryLists.get(i).getSubCategory().get(j).getSubCateName());
                        }
                    }
                }else {
                    for(int j = 0; j<Common.categoryLists.get(i).getSubCategory().size(); j++){
                        if(Common.categoryLists.get(i).getSubCategory().get(j).isSelect()){
                            selectItem.add(Common.categoryLists.get(i).getSubCategory().get(j).getSubCateName());
                        }
                    }
                }

            }
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        rvSelectItem.setLayoutManager(layoutManager);
        rvSelectItem.setHasFixedSize(true);
        selectitemAdapter = new SelectitemAdapter(MainActivity.this, selectItem);
        rvSelectItem.setAdapter(selectitemAdapter);
        selectitemAdapter.notifyDataSetChanged();
    }
}