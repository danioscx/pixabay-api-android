package io.github.pixabay.utils;

public enum ImageType {

    ALL("all"),
    PHOTO("photo"),
    ILLUSTRATION("illustration"),
    VECTOR("vector");

    public String type;

    ImageType(String type) {
        this.type = type;
    }
}
