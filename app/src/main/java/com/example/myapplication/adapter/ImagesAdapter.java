package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.Image;

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

    public static class ImagesViewHolder extends RecyclerView.ViewHolder {
        private TextView tvId;

        public ImagesViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.imageId);
        }

        public void bind(Image image) {
            tvId.setText(image.getId());
        }
    }

}
