package com.example.foodmenus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

//        ขารับ
        ImageView imageView2 = findViewById(R.id.imageView2);//ผูกวิว bind widget

        //ฝั่งรับ
        Bundle bundle = this.getIntent().getExtras();
        //เช็คว่ามีข้อมูล key นั้นส่งมาไหม
        if(bundle !=null && bundle.containsKey("MY_KEY")){
            String url = bundle.get("MY_KEY").toString();

            //load image from url โดยใช้ Library Picasso
            Picasso.get()
                    .load(url)
                    .into(imageView2);
        }else{
//            ถ้าไม่พบ สั่งปิดหน้านี้
            finish();
        }

    }
}