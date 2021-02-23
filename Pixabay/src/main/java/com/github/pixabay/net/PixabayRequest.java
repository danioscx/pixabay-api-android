package com.github.pixabay.net;

import android.content.Context;

import androidx.annotation.NonNull;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.github.pixabay.Pixabay;

@Deprecated
public class PixabayRequest {

    private static RequestQueue queue;
    private Pixabay pixabay;
    private Pixabay.Video video;

    private PixabayRequest() {

    }

    @NonNull
    public static PixabayRequest with(Context context) {
        PixabayRequest request = new PixabayRequest();
        queue = Volley.newRequestQueue(context);
        return request;
    }

    public PixabayRequest from(Pixabay pixabay) {
        this.pixabay = pixabay;
        return this;
    }

    public PixabayRequest from(Pixabay.Video video) {
        this.video = video;
        return this;
    }

    public void putIn(@NonNull PixabayRequestResult requestResponse) {
        JsonObjectRequest request;
        if (pixabay != null) {
            request = new JsonObjectRequest(Request.Method.GET,
                    pixabay.toString(), null, requestResponse::response, Throwable::printStackTrace);
        } else {
            request = new JsonObjectRequest(Request.Method.GET,
                    video.toString(), null, requestResponse::response, Throwable::printStackTrace);
        }
        queue.add(request);
    }

}
