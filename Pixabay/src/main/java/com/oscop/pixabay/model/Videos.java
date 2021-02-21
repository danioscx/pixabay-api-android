package com.oscop.pixabay.model;

import androidx.annotation.NonNull;


public class Videos extends Models {

    private String id;
    private String pageURL;
    private String type;
    private String tags;
    private String duration;
    private String pictureId;
    private String videoLargeURL;
    private String videoLargeWidth;
    private String videoLargeHeight;
    private String videoLargeSize;
    private String videoMediumURL;
    private String videoMediumWidth;
    private String videoMediumHeight;
    private String videoMediumSize;
    private String videoSmallURL;
    private String videoSmallWidth;
    private String videoSmallHeight;
    private String videoSmallSize;
    private String videoTinyURL;
    private String videoTinyWidth;
    private String videoTinyHeight;
    private String videoTinySize;
    private String views;
    private String downloads;
    private String favorites;
    private String likes;
    private String comments;
    private String userId;
    private String user;
    private String userImageURL;

    public Videos() {

    }

    @NonNull
    public static Videos getInstance() {
        return new Videos();
    }


    public String getId() {
        return id;
    }

    public Videos withId(String id) {
        this.id = id;
        return this;
    }

    public String getPageURL() {
        return pageURL;
    }

    public Videos withPageURL(String pageURL) {
        this.pageURL = pageURL;
        return this;
    }

    public String getType() {
        return type;
    }

    public Videos withType(String type) {
        this.type = type;
        return this;
    }

    public String getTags() {
        return tags;
    }

    public Videos withTags(String tags) {
        this.tags = tags;
        return this;
    }

    public String getDuration() {
        return duration;
    }

    public Videos withDuration(String duration) {
        this.duration = duration;
        return this;
    }

    public String getPictureId() {
        return pictureId;
    }

    public Videos withPictureId(String pictureId) {
        this.pictureId = pictureId;
        return this;
    }

    public String getVideoLargeURL() {
        return videoLargeURL;
    }

    public Videos withVideoLargeURL(String videoLargeURL) {
        this.videoLargeURL = videoLargeURL;
        return this;
    }

    public String getVideoLargeWidth() {
        return videoLargeWidth;
    }

    public Videos withVideoLargeWidth(String videoLargeWidth) {
        this.videoLargeWidth = videoLargeWidth;
        return this;
    }

    public String getVideoLargeHeight() {
        return videoLargeHeight;
    }

    public Videos withVideoLargeHeight(String videoLargeHeight) {
        this.videoLargeHeight = videoLargeHeight;
        return this;
    }

    public String getVideoLargeSize() {
        return videoLargeSize;
    }

    public Videos withVideoLargeSize(String videoLargeSize) {
        this.videoLargeSize = videoLargeSize;
        return this;
    }

    public String getVideoMediumURL() {
        return videoMediumURL;
    }

    public Videos withVideoMediumURL(String videoMediumURL) {
        this.videoMediumURL = videoMediumURL;
        return this;
    }

    public String getVideoMediumWidth() {
        return videoMediumWidth;
    }

    public Videos withVideoMediumWidth(String videoMediumWidth) {
        this.videoMediumWidth = videoMediumWidth;
        return this;
    }

    public String getVideoMediumHeight() {
        return videoMediumHeight;
    }

    public Videos withVideoMediumHeight(String videoMediumHeight) {
        this.videoMediumHeight = videoMediumHeight;
        return this;
    }

    public String getVideoMediumSize() {
        return videoMediumSize;
    }

    public Videos withVideoMediumSize(String videoMediumSize) {
        this.videoMediumSize = videoMediumSize;
        return this;
    }

    public String getVideoSmallURL() {
        return videoSmallURL;
    }

    public Videos withVideoSmallURL(String videoSmallURL) {
        this.videoSmallURL = videoSmallURL;
        return this;
    }

    public String getVideoSmallWidth() {
        return videoSmallWidth;
    }

    public Videos withVideoSmallWidth(String videoSmallWidth) {
        this.videoSmallWidth = videoSmallWidth;
        return this;
    }

    public String getVideoSmallHeight() {
        return videoSmallHeight;
    }

    public Videos withVideoSmallHeight(String videoSmallHeight) {
        this.videoSmallHeight = videoSmallHeight;
        return this;
    }

    public String getVideoSmallSize() {
        return videoSmallSize;
    }

    public Videos withVideoSmallSize(String videoSmallSize) {
        this.videoSmallSize = videoSmallSize;
        return this;
    }

    public String getVideoTinyURL() {
        return videoTinyURL;
    }

    public Videos withVideoTinyURL(String videoTinyURL) {
        this.videoTinyURL = videoTinyURL;
        return this;
    }

    public String getVideoTinyWidth() {
        return videoTinyWidth;
    }

    public Videos withVideoTinyWidth(String videoTinyWidth) {
        this.videoTinyWidth = videoTinyWidth;
        return this;
    }

    public String getVideoTinyHeight() {
        return videoTinyHeight;
    }

    public Videos withVideoTinyHeight(String videoTinyHeight) {
        this.videoTinyHeight = videoTinyHeight;
        return this;
    }

    public String getVideoTinySize() {
        return videoTinySize;
    }

    public Videos withVideoTinySize(String videoTinySize) {
        this.videoTinySize = videoTinySize;
        return this;
    }

    public String getViews() {
        return views;
    }

    public Videos withViews(String views) {
        this.views = views;
        return this;
    }

    public String getDownloads() {
        return downloads;
    }

    public Videos withDownloads(String downloads) {
        this.downloads = downloads;
        return this;
    }

    public String getFavorites() {
        return favorites;
    }

    public Videos withFavorites(String favorites) {
        this.favorites = favorites;
        return this;
    }

    public String getLikes() {
        return likes;
    }

    public Videos withLikes(String likes) {
        this.likes = likes;
        return this;
    }

    public String getComments() {
        return comments;
    }

    public Videos withComments(String comments) {
        this.comments = comments;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public Videos withUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getUser() {
        return user;
    }

    public Videos withUser(String user) {
        this.user = user;
        return this;
    }

    public String getUserImageURL() {
        return userImageURL;
    }

    public Videos withUserImageURL(String userImageURL) {
        this.userImageURL = userImageURL;
        return this;
    }

}
