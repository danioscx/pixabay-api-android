package com.github.pixless.views;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.github.pixless.R;
import com.github.pixless.utils.CropWallpaperImages;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;


import java.io.IOException;
import java.util.List;

import io.github.danioscx.Pixabay;
import io.github.danioscx.model.Images;

public class ViewImages extends AppCompatActivity {

    public static final String API_KEY = "16013870-0f4196b948c4f65ced4be7fff";

    Pixabay pix;

    ImageView imageViews;

    FloatingActionButton fabMini;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_images);
        FloatingActionButton floatingActionButton = findViewById(R.id.fab_normal);
        fabMini = findViewById(R.id.fab_mini);
        floatingActionButton.setOnClickListener(v -> {
            if (fabMini.getVisibility() == View.GONE) {
                fabMini.setVisibility(View.VISIBLE);
                Animation animation = AnimationUtils.loadAnimation(getApplication(), R.anim.fab);
                fabMini.startAnimation(animation);
            } else {
                Animation animation = AnimationUtils.loadAnimation(getApplication(), R.anim.fab_close);
                fabMini.setVisibility(View.GONE);
                fabMini.startAnimation(animation);
            }
        });
        imageViews =  findViewById(R.id.images_shows);
        Intent intent = getIntent();
        if (intent != null) {
            pix = Pixabay.getInstance(this)
                    .apiKey(API_KEY)
                    .withId(intent.getStringExtra("id"));
            pix.setOnPixabayImageRequest(pix, new Pixabay.OnPixabayImageRequest() {
                @Override
                public void onResult(List<Images> images) {
                    Log.e("TAGS ", images.get(0).getWebFormatURL());
                    Glide.with(ViewImages.this)
                            .load(images.get(0).getLargeImageURL())
                            .centerCrop()
                            .into(imageViews);
                    fabMini.setOnClickListener(v -> {

                        Intent intent1 = new Intent(getApplicationContext(), CropWallpaperImages.class);
                        intent1.putExtra("title", images.get(0).getTags());
                        intent1.putExtra("id", images.get(0).getId());
                        startActivity(intent1);
                    });
                }

                @Override
                public void onError(String error) {

                }
            });
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }

    private void hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    private void setOnWallpaperSelected(Images images) {
        Glide.with(getApplication())
                .asBitmap()
                .load(images.getLargeImageURL())
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        WallpaperManager wallpaperManager = WallpaperManager.getInstance(ViewImages.this);
                        try {
                            wallpaperManager.setBitmap(resource);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

}
