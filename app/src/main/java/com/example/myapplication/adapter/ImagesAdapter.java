package com.example.myapplication.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.model.Image;
import com.example.myapplication.view.FullScreenImageActivity;

import java.util.List;

public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ImagesViewHolder> {

    private List<Image> images;

    public ImagesAdapter(List<Image> images) {
        this.images = images;
    }

    @NonNull
    @Override
    public ImagesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_image, parent, false);
        return new ImagesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImagesViewHolder holder, int position) {
        holder.bind(images.get(position));
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public void updateImages(List<Image> images) {
        this.images = images;
        notifyDataSetChanged();
    }

    public List<Image> getImages() {
        return images;
    }

    public static class ImagesViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private Image image;

        public ImagesViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (image != null) {
                        Intent intent = new Intent(imageView.getContext(),
                                FullScreenImageActivity.class);
                        intent.putExtra("imageUrl", image.getUrl());
                        imageView.getContext().startActivity(intent);
                    }
                }
            });
        }

        public void bind(Image image) {
            this.image = image;
            Glide.with(imageView.getContext()).load(image.getUrl()).into(imageView);
        }
    }

}
