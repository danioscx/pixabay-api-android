package com.github.pixabay.utils;

public enum Category {
    BACKGROUNDS("background"),
    FASHION("fashion"),
    NATURE("nature"),
    SCIENCE("science"),
    EDUCATION("education"),
    FEELINGS("feelings"),
    HEALTH("health"),
    PEOPLE("people"),
    RELIGION("religion"),
    PLACES("places"),
    ANIMALS("animals"),
    INDUSTRY("industry"),
    COMPUTER("computer"),
    FOOD("food"),
    SPORTS("sports"),
    TRANSPORTATION("transportation"),
    TRAVEL("travel"),
    BUILDINGS("buildings"),
    BUSINESS("business"),
    MUSIC("music");

    public String type;

    Category(String type) {
        this.type = type;
    }
}
