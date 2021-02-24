package io.github.danioscx.utils;

public enum Order {

    POPULAR("popular"),
    LATEST("latest");

    public String type;
    Order(String type) {
        this.type = type;
    }
}
