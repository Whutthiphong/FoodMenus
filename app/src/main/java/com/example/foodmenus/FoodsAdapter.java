package com.example.foodmenus;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FoodsAdapter extends RecyclerView.Adapter<FoodsAdapter.FoodViewHolder> {
    ArrayList<Food> listFoods;

    public FoodsAdapter(ArrayList<Food> listFoods) {
        this.listFoods = listFoods;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item, parent, false);
        return new FoodViewHolder(v);
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

    public class FoodViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.imageView);
        }

        void bind(Food item) {
            textView.setText(item.getMenuName());
            Picasso.get()
                    .load(item.getImageUrl())
                    .resize(50, 50)
                    .centerCrop()
                    .into(imageView);
        }
    }
}
