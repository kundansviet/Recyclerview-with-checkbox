package com.cb.recyclerwithcheckbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private List<String> productList;
    private RecyclerView rv_product_list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        productList = new ArrayList<>();


        for (int i = 0; i < 500; i++) {
            productList.add("product "+i);
        }

        rv_product_list = (RecyclerView) findViewById(R.id.rv_product_list);
        rv_product_list.setLayoutManager(new LinearLayoutManager(this));
        rv_product_list.setAdapter(new ListAdapter(this,productList));




    }

}
