package com.github.pixless.utils;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.github.pixless.R;
import com.github.pixless.views.Home;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.IOException;
import java.util.List;

import io.github.danioscx.Pixabay;
import io.github.danioscx.model.Images;

public class CropWallpaperImages extends AppCompatActivity {

    public static final String API_KEY = "16013870-0f4196b948c4f65ced4be7fff";

    CropImageView imageView;
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crop_images);
        imageView = findViewById(R.id.cropImageView);
        button = findViewById(R.id.button_wallpaper);
        Intent intent = getIntent();

        if (intent != null) {
            Pixabay pixabay = Pixabay.getInstance(this)
                    .apiKey(API_KEY)
                    .withId(intent.getStringExtra("id"));
            pixabay.setOnPixabayImageRequest(pixabay, new Pixabay.OnPixabayImageRequest() {
                @Override
                public void onResult(List<Images> images) {
                    Glide.with(CropWallpaperImages.this)
                            .asBitmap()
                            .load(images.get(0).getLargeImageURL())
                            .into(new SimpleTarget<Bitmap>() {
                                @Override
                                public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                                    imageView.setImageBitmap(resource);
                                    imageView.setGuidelines(CropImageView.Guidelines.ON);
                                    button.setOnClickListener(v -> {
                                        Bitmap bitmap = imageView.getCroppedImage();
                                        WallpaperManager wallpaperManager = WallpaperManager.getInstance(CropWallpaperImages.this);
                                        try {
                                            wallpaperManager.setBitmap(bitmap);
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    });
                                }
                            });
                }

                @Override
                public void onError(String error) {

                }
            });
        }
    }
}
