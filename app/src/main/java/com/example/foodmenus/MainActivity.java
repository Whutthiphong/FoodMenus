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

public class MainActivity extends AppCompatActivity implements IOnItemClickListener{
    ArrayList<Food> foods ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //start read data source
        InputStream inputStream = getResources().openRawResource(R.raw.data_test);
        InputStreamReader isReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(isReader);
        StringBuffer sb = new StringBuffer();
        String str;
        try {
            while ((str = reader.readLine()) != null) {
                sb.append(str);
            }
            //end read data source

            //start convert json string to Arraylist

            //convert json string โดยใช้ Library Gson
            Gson gson = new Gson();
            foods = gson.fromJson(sb.toString(), new TypeToken<ArrayList<Food>>(){}.getType());
            Log.e("DATA",foods.toString());//test print log


            FoodsAdapter adapter = new FoodsAdapter(foods,this);//create data adapter and passing data to adapter

            RecyclerView foodRecycleView = findViewById(R.id.foodRecycleView);//bind recycleView

            foodRecycleView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            foodRecycleView.setAdapter(adapter);//set Adapter

        }catch (Exception ex){
            Toast.makeText(getApplicationContext(),ex.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onItemClick(int position) {

        Toast.makeText(getApplicationContext(),foods.get(position).getImageUrl(),Toast.LENGTH_LONG).show();
    }
}