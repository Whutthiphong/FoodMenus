package com.example.foodmenus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InputStream inputStream = getResources().openRawResource(R.raw.data_test);
        InputStreamReader isReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(isReader);
        StringBuffer sb = new StringBuffer();
        String str;
        try {
            while ((str = reader.readLine()) != null) {
                sb.append(str);
            }
            ArrayList<Food> foods = new ArrayList<Food> ();
            Gson gson = new Gson();
            foods = gson.fromJson(sb.toString(), new TypeToken<ArrayList<Food>>(){}.getType());

            Log.e("DATA",foods.toString());

            FoodsAdapter adapter = new FoodsAdapter(foods);
//            bind recycleView
            RecyclerView foodRecycleView = findViewById(R.id.foodRecycleView);
            foodRecycleView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            foodRecycleView.setAdapter(adapter);

        }catch (Exception ex){
            Toast.makeText(getApplicationContext(),ex.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
}