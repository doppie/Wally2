package com.roundsquare.wally.business.model;

/**
 * Created by Jelle on 28/04/2017.
 */

public class Category {

    private long id;
    private String name;

    public Category(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category(long id, Category oldCategory) {
        this.id = id;
        this.name = oldCategory.getName();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
