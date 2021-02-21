package com.oscop.pixabay.model;

import androidx.annotation.NonNull;

public class Images {

    private String id;
    private String pageURL;
    private String type;
    private String tags;
    private String previewURL;
    private String previewWidth;
    private String previewHeight;
    private String webFormatURL;
    private String webFormatWidth;
    private String webFormatHeight;
    private String largeImageURL;
    private String imageWidth;
    private String imageHeight;
    private String imageSize;
    private String views;
    private String downloads;
    private String favorites;
    private String likes;
    private String comments;
    private String userId;
    private String user;
    private String userImageURL;

    public Images() {

    }

    @NonNull
    public static Images getInstance() {
        return new Images();
    }

    public String getId() {
        return id;
    }

    public Images withId(String id) {
        this.id = id;
        return this;
    }

    public String getPageURL() {
        return pageURL;
    }

    public Images withPageURL(String pageURL) {
        this.pageURL = pageURL;
        return this;
    }

    public String getType() {
        return type;
    }

    public Images withType(String type) {
        this.type = type;
        return this;
    }

    public String getTags() {
        return tags;
    }

    public Images withTags(String tags) {
        this.tags = tags;
        return this;
    }

    public String getPreviewURL() {
        return previewURL;
    }

    public Images withPreviewURL(String previewURL) {
        this.previewURL = previewURL;
        return this;
    }

    public String getPreviewWidth() {
        return previewWidth;
    }

    public Images withPreviewWidth(String previewWidth) {
        this.previewWidth = previewWidth;
        return this;
    }

    public String getPreviewHeight() {
        return previewHeight;
    }

    public Images withPreviewHeight(String previewHeight) {
        this.previewHeight = previewHeight;
        return this;
    }

    public String getWebFormatURL() {
        return webFormatURL;
    }

    public Images withWebFormatURL(String webFormatURL) {
        this.webFormatURL = webFormatURL;
        return this;
    }

    public String getWebFormatWidth() {
        return webFormatWidth;
    }

    public Images withWebFormatWidth(String webFormatWidth) {
        this.webFormatWidth = webFormatWidth;
        return this;
    }

    public String getWebFormatHeight() {
        return webFormatHeight;
    }

    public Images withWebFormatHeight(String webFormatHeight) {
        this.webFormatHeight = webFormatHeight;
        return this;
    }

    public String getLargeImageURL() {
        return largeImageURL;
    }

    public Images withLargeImageURL(String largeImageURL) {
        this.largeImageURL = largeImageURL;
        return this;
    }

    public String getImageWidth() {
        return imageWidth;
    }

    public Images withImageWidth(String imageWidth) {
        this.imageWidth = imageWidth;
        return this;
    }

    public String getImageHeight() {
        return imageHeight;
    }

    public Images withImageHeight(String imageHeight) {
        this.imageHeight = imageHeight;
        return this;
    }

    public String getImageSize() {
        return imageSize;
    }

    public Images withImageSize(String imageSize) {
        this.imageSize = imageSize;
        return this;
    }

    public String getViews() {
        return views;
    }

    public Images withViews(String views) {
        this.views = views;
        return this;
    }

    public String getDownloads() {
        return downloads;
    }

    public Images withDownloads(String downloads) {
        this.downloads = downloads;
        return this;
    }

    public String getFavorites() {
        return favorites;
    }

    public Images withFavorites(String favorites) {
        this.favorites = favorites;
        return this;
    }

    public String getLikes() {
        return likes;
    }

    public Images withLikes(String likes) {
        this.likes = likes;
        return this;
    }

    public String getComments() {
        return comments;
    }

    public Images withComments(String comments) {
        this.comments = comments;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public Images withUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getUser() {
        return user;
    }

    public Images withUser(String user) {
        this.user = user;
        return this;
    }

    public String getUserImageURL() {
        return userImageURL;
    }

    public Images withUserImageURL(String userImageURL) {
        this.userImageURL = userImageURL;
        return this;
    }
}
