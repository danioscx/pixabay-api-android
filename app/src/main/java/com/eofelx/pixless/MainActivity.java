package com.eofelx.pixless;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.eofelx.pixabay.Pixabay;
import com.eofelx.pixabay.model.Images;
import com.eofelx.pixabay.model.Videos;
import com.eofelx.pixabay.net.PixabayRequestResult;
import com.eofelx.pixabay.net.PixabayRequest;
import com.eofelx.pixabay.utils.VideoType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String API_KEY = "16013870-0f4196b948c4f65ced4be7fff";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* Pixabay pixabay = Pixabay.getInstance(this)
                .apiKey(API_KEY)
                .editorChoice(true)
                .query("nature");

        pixabay.setOnPixabayImageRequest(pixabay, new Pixabay.OnPixabayImageRequest() {

            @Override
            public void onResult(List<Images> images) {
                System.out.println("UKURAN " + images.size());
            }

            @Override
            public void onError(String error) {
                System.out.println(error);
            }
        });*/
        Pixabay.Video videos = new Pixabay.Video(this).apiKey(API_KEY)
                .videoType(VideoType.ANIMATION);

        videos.setOnPixabayVideoRequest(videos, new Pixabay.Video.OnPixabayVideoRequest() {
            @Override
            public void onResult(List<Videos> videos) {
                System.out.println(videos.size());
            }

            @Override
            public void onError(String error) {

            }
        });

        /*PixabayRequestResult result = response -> {
            try {
                JSONArray array = response.getJSONArray("hits");
                for (int i = 0; i < array.length() ; i++) {
                    JSONObject object = array.getJSONObject(i);
                    JSONObject videos1 = object.getJSONObject("videos");
                    JSONObject large = videos1.getJSONObject("large");

                    System.out.println(large.getString("url"));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        };

        PixabayRequest.with(this)
                .from(videos).putIn(result);*/
    }
}