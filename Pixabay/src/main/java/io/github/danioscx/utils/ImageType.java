package io.github.danioscx.utils;

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
