package com.getrentbd.doodleinctask.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.getrentbd.doodleinctask.R;
import com.getrentbd.doodleinctask.adapter.CategoryListAdapter;
import com.getrentbd.doodleinctask.model.CategoryList;
import com.getrentbd.doodleinctask.model.SubCategory;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class SecondActivity extends AppCompatActivity {
    private RecyclerView rvCategoryList;
    private TextView tvSave;
    private ImageView imageView;
    private RequestQueue requestQueue;
    private String url = "https://www.test.api.liker.com/get_categories";
    private List<CategoryList> categoryList = new ArrayList<>();
    private CategoryListAdapter categoryListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        rvCategoryList = findViewById(R.id.rvCategoryList);
        tvSave = findViewById(R.id.tvSave);
        imageView = findViewById(R.id.imageView);
        requestQueue = Volley.newRequestQueue(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvCategoryList.setLayoutManager(layoutManager);
        rvCategoryList.setHasFixedSize(true);
        categoryListAdapter = new CategoryListAdapter(categoryList);
        rvCategoryList.setAdapter(categoryListAdapter);

        loadCategory();

        tvSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecondActivity.this, MainActivity.class));
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }


    private void loadCategory() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("categories");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject object = jsonArray.getJSONObject(i);

                        String categoryId = object.getString("category_id");
                        String categoryName = object.getString("category_name");
                        JSONArray subCateArray = object.getJSONArray("subcatg");

                        List<SubCategory> subCategory = new ArrayList<>();

                        for (int j=0; j<subCateArray.length(); j++){
                            JSONObject subObject = subCateArray.getJSONObject(j);
                            String subCateId = subObject.getString("sub_category_id");
                            String subCateName = subObject.getString("sub_category_name");
                            subCategory.add((new SubCategory(subCateId,subCateName,false)));
                        }

                        categoryList.add(new CategoryList(categoryId,categoryName,subCategory));

                    }
                    categoryListAdapter.notifyDataSetChanged();
                    //Toast.makeText(SecondActivity.this, ""+String.valueOf(jsonArray.length()), Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);

    }

}