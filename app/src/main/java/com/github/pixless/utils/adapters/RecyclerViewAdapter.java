package com.github.pixless.utils.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import io.github.pixabay.model.Images;
import io.github.pixabay.model.Models;
import io.github.pixabay.model.Videos;
import com.github.pixless.R;
import com.github.pixless.utils.OnItemClickListener;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private final OnItemClickListener clickListener;

    private final List<? extends Models> objects;

    public RecyclerViewAdapter(List<? extends Models> objects, OnItemClickListener clickListener) {
        this.clickListener = clickListener;
        this.objects = objects;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(objects.get(position), clickListener);
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.recycler_view_image_view);
        }

        void bind(Object object, OnItemClickListener listener) {
            if (object instanceof Images) {
                Glide.with(itemView.getContext())
                        .load(((Images) object).getPreviewURL())
                        .centerCrop()
                        .into(imageView);
            } else if (object instanceof Videos) {
                Glide.with(itemView.getContext())
                        .load(((Videos) object).getVideoThumbnail())
                        .centerCrop()
                        .into(imageView);
            }

            itemView.setOnClickListener(v -> listener.onItemClick(object));
        }
    }
}
