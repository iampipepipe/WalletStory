package com.example.x.walletstory;

/**
 * Created by X on 5/20/2018.
 */

public class Expenses {
    private String title;
    private int image;

    public Expenses(String title, int image) {
        this.title = title;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
