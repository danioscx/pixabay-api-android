package io.github.pixabay;

import android.content.Context;

import androidx.annotation.NonNull;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import io.github.pixabay.utils.Category;
import io.github.pixabay.utils.Colors;
import io.github.pixabay.utils.ImageType;
import io.github.pixabay.model.Images;
import io.github.pixabay.utils.Language;
import io.github.pixabay.utils.Order;
import io.github.pixabay.utils.Orientation;
import io.github.pixabay.utils.VideoType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import io.github.pixabay.model.Videos;

public class Pixabay {

    private static Pixabay instance;

    private String apiKey;
    private String endPoint;
    final String url = "https://pixabay.com/api/?key=";


    private static RequestQueue queue;


    public interface OnPixabayImageRequest {
        void onResult(List<Images> images);
        void onError(String error);
    }

    public interface OnRequestResponse {
        void onResult(JSONObject response);
        void onError(String error);
    }

    public void setOnPixabayImageRequest(@NonNull Pixabay pixabay, @NonNull OnRequestResponse request) {
        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET,
                pixabay.toString(), null, request::onResult, error -> request.onError(error.getMessage()));
        queue.add(objectRequest);
    }

    public void setOnPixabayImageRequest(@NonNull Pixabay pixabay, OnPixabayImageRequest request) {
        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET,
                pixabay.toString(), null, response -> {
                    try {
                        List<Images> images = new ArrayList<>();
                        JSONArray array = response.getJSONArray("hits");
                        for (int i = 0; i < array.length() ; i++) {
                            JSONObject object = array.getJSONObject(i);
                            Images img = Images.getInstance()
                                    .withId(object.getString("id"))
                                    .withPageURL(object.getString("pageURL"))
                                    .withType(object.getString("type"))
                                    .withTags(object.getString("tags"))
                                    .withPreviewURL(object.getString("previewURL"))
                                    .withPreviewWidth(object.getString("previewWidth"))
                                    .withPreviewHeight(object.getString("previewHeight"))
                                    .withWebFormatURL(object.getString("previewHeight"))
                                    .withWebFormatWidth(object.getString("webformatWidth"))
                                    .withWebFormatHeight(object.getString("webformatHeight"))
                                    .withLargeImageURL(object.getString("largeImageURL"))
                                    .withImageWidth(object.getString("imageWidth"))
                                    .withImageHeight(object.getString("imageHeight"))
                                    .withImageSize(object.getString("imageSize"))
                                    .withViews(object.getString("views"))
                                    .withDownloads(object.getString("downloads"))
                                    .withFavorites(object.getString("favorites"))
                                    .withLikes(object.getString("likes"))
                                    .withComments(object.getString("comments"))
                                    .withUserId(object.getString("user_id"))
                                    .withUser(object.getString("user"))
                                    .withUserImageURL(object.getString("userImageURL"));
                            images.add(img);
                        }
                        request.onResult(images);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }, error -> request.onError(error.getMessage()));
        queue.add(objectRequest);
    }

    public Pixabay() {
    }

    public static Pixabay getInstance(Context context) {
        queue = Volley.newRequestQueue(context);
        if (instance == null) {
            instance = new Pixabay();
        }
        return instance;
    }



    public Pixabay apiKey(@NonNull String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    public Pixabay query(String query) {
        this.endPoint += "&q=" + query;
        return this;
    }

    /**
     * apabila fungsi ini dipanggil maka semua fungsi yang sebelumnya
     * di panggil akan otomatis terhapus. fungsi ini hanya di gunakan
     * apabila kita ingin mendapatkan hasil spesifik dari request yang telah dibuat
     * @param id spesifik id yang telah di dapatkan dari request sebelumnya
     * @return this
     */

    public Pixabay withId(String id) {
        this.endPoint = "&id=" + id;
        return this;
    }

    public Pixabay orientation(@NonNull Orientation orientation) {
        this.endPoint += "&orientation=" + orientation.type;
        return this;
    }

    public Pixabay category(@NonNull Category category) {
        this.endPoint += "&category=" + category.type;
        return this;
    }

    public Pixabay colors(@NonNull Colors colors) {
        this.endPoint += "&colors=" + colors.type;
        return this;
    }

    public Pixabay editorChoice(boolean type) {
        this.endPoint += "&editors_choice=" + type;
        return this;
    }

    public Pixabay safeSearch(boolean type) {
        this.endPoint += "&safesearch=" + type;
        return this;
    }

    public Pixabay imageType(@NonNull ImageType type) {
        this.endPoint += "&image_type=" + type.type;
        return this;
    }

    public Pixabay lang(@NonNull Language language) {
        this.endPoint += "&lang=" + language.type;
        return this;
    }

    public Pixabay order(@NonNull Order order) {
        this.endPoint += "&order=" + order.type;
        return this;
    }

    public Pixabay page(int page) {
        this.endPoint += "&page=" + page;
        return this;
    }

    public Pixabay perPage(int value) {
        this.endPoint += "&per_page=" + value;
        return this;
    }

    @NonNull
    @Override
    public String toString() {
        if (apiKey == null) {
            return "Error initialized";
        }
        return url + apiKey + endPoint.replace("null", "");
    }




    public static class Video {


        private String apiKey;
        private String endPoint;

        final String video = "https://pixabay.com/api/videos/?key=";

        public interface OnPixabayVideoRequest {
            void onResult(List<Videos> videos);
            void onError(String error);
        }

        public interface OnRequestResponse {
            void onResult(JSONObject response);
            void onError(String error);
        }

        public void setOnPixabayVideoRequest(@NonNull Video pixabay, @NonNull OnRequestResponse request) {
            JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET,
                    pixabay.toString(), null, request::onResult
            , error -> request.onError(error.getMessage()));
            queue.add(objectRequest);
        }

        public void setOnPixabayVideoRequest(@NonNull Video pixabay, OnPixabayVideoRequest request) {
            JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET,
                    pixabay.toString(), null, response -> {
                try {
                    JSONArray array = response.getJSONArray("hits");
                    List<Videos> videos = new ArrayList<>();
                    for (int i = 0; i < array.length() ; i++) {
                        JSONObject object = array.getJSONObject(i);
                        JSONObject JsonVideos = object.getJSONObject("videos");
                        JSONObject large = JsonVideos.getJSONObject("large");
                        JSONObject medium = JsonVideos.getJSONObject("medium");
                        JSONObject small = JsonVideos.getJSONObject("small");
                        JSONObject tiny = JsonVideos.getJSONObject("tiny");
                        Videos video = Videos.getInstance()
                                .withId(object.getString("id"))
                                .withPageURL(object.getString("pageURL"))
                                .withType(object.getString("type"))
                                .withTags(object.getString("tags"))
                                .withDuration(object.getString("duration"))
                                .withPictureId(object.getString("picture_id"))
                                .withVideoLargeURL(large.getString("url"))
                                .withVideoLargeWidth(large.getString("width"))
                                .withVideoLargeHeight(large.getString("height"))
                                .withVideoLargeSize(large.getString("size"))
                                .withVideoMediumURL(medium.getString("url"))
                                .withVideoMediumWidth(medium.getString("width"))
                                .withVideoMediumHeight(medium.getString("height"))
                                .withVideoMediumSize(medium.getString("size"))
                                .withVideoSmallURL(small.getString("url"))
                                .withVideoSmallWidth(small.getString("width"))
                                .withVideoSmallHeight(small.getString("height"))
                                .withVideoSmallSize(small.getString("size"))
                                .withVideoTinyURL(tiny.getString("url"))
                                .withVideoTinyWidth(tiny.getString("width"))
                                .withVideoTinyHeight(tiny.getString("height"))
                                .withVideoTinySize(tiny.getString("size"))
                                .withViews(object.getString("views"))
                                .withDownloads(object.getString("downloads"))
                                .withFavorites(object.getString("favorites"))
                                .withLikes(object.getString("likes"))
                                .withComments(object.getString("comments"))
                                .withUserId(object.getString("user_id"))
                                .withUser(object.getString("user"))
                                .withUserImageURL("userImageURL");
                        videos.add(video);
                    }
                    request.onResult(videos);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }, error -> request.onError(error.getMessage()));
            queue.add(objectRequest);
        }

        public Video(Context context) {
            queue = Volley.newRequestQueue(context);
        }

        public Video apiKey(@NonNull String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        public Video query(String query) {
            this.endPoint += "&q=" + query;
            return this;
        }

        /**
         * apabila fungsi ini dipanggil maka semua fungsi yang sebelumnya
         * di panggil akan otomatis terhapus. fungsi ini hanya di gunakan
         * apabila kita ingin mendapatkan hasil spesifik dari request yang telah dibuat
         * @param id spesifik id yang telah di dapatkan dari request sebelumnya
         * @return this
         */

        public Video withId(String id) {
            this.endPoint = "&id=" + id;
            return this;
        }

        public Video category(@NonNull Category category) {
            this.endPoint += "&category=" + category.type;
            return this;
        }

        public Video editorChoice(boolean type) {
            this.endPoint += "&editors_choice=" + type;
            return this;
        }

        public Video safeSearch(boolean type) {
            this.endPoint += "&safesearch=" + type;
            return this;
        }

        public Video videoType(@NonNull VideoType type) {
            this.endPoint += "&image_type=" + type.type;
            return this;
        }

        public Video lang(@NonNull Language language) {
            this.endPoint += "&lang=" + language.type;
            return this;
        }

        public Video order(@NonNull Order order) {
            this.endPoint += "&order=" + order.type;
            return this;
        }

        public Video page(int page) {
            this.endPoint += "&page=" + page;
            return this;
        }

        public Video perPage(int value) {
            this.endPoint += "&per_page=" + value;
            return this;
        }

        @NonNull
        @Override
        public String toString() {
            if (apiKey == null) {
                return "Error initialized";
            }
            return video + apiKey + endPoint.replace("null", "");
        }
    }
}
