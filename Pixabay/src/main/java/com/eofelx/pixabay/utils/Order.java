package com.eofelx.pixabay.utils;

public enum Order {

    POPULAR("popular"),
    LATEST("latest");

    public String type;
    Order(String type) {
        this.type = type;
    }
}
