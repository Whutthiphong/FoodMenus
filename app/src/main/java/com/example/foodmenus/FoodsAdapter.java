package com.example.foodmenus;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FoodsAdapter extends RecyclerView.Adapter<FoodsAdapter.FoodViewHolder> {
    ArrayList<Food> listFoods;
    IOnItemClickListener itemClickListener;

    public FoodsAdapter(ArrayList<Food> listFoods,IOnItemClickListener itemClickListener) {
        this.listFoods = listFoods;
        this.itemClickListener =itemClickListener;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item, parent, false);
        return new FoodViewHolder(v,itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        holder.bind(listFoods.get(position));
    }

    @Override
    public int getItemCount() {
        if (listFoods != null)
            return listFoods.size();
        return 0;
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView textView;
        IOnItemClickListener itemClickListener;

        public FoodViewHolder(@NonNull View itemView,IOnItemClickListener itemClickListener) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.imageView);
            this.itemClickListener =itemClickListener;
        }

        void bind(final Food item) {
            textView.setText(item.getMenuName());
            //load image from url โดยใช้ Library Picasso
            Picasso.get()
                    .load(item.getImageUrl())
                    .into(imageView);

//            //set onclick แบบง่าย
//            textView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(v.getContext(),String.valueOf(item.getMenuId()),Toast.LENGTH_LONG).show();
//                }
//            });

            textView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            itemClickListener.onItemClick(getAdapterPosition());
        }
    }
}
