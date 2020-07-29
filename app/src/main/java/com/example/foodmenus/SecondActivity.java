package com.example.foodmenus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

//        ขารับ
        ImageView imageView2 = findViewById(R.id.imageView2);//ผูกวิว bind widget
        TextView textView3 = findViewById(R.id.textView3);//ผูกวิว bind widget

        //ฝั่งรับ
        Bundle bundle = this.getIntent().getExtras();
        //เช็คว่ามีข้อมูล key นั้นส่งมาไหม
        if(bundle !=null && bundle.containsKey("MY_KEY")){
            Food food = (Food) bundle.get("MY_KEY");

            //load image from url โดยใช้ Library Picasso
            Picasso.get()
                    .load(food.getImageUrl())
                    .into(imageView2);

            //set message
            textView3.setText(food.getMenuName());
        }else{
//            ถ้าไม่พบ สั่งปิดหน้านี้
            finish();
        }

    }
}