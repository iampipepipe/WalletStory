package com.example.x.walletstory;

/**
 * Created by X on 5/20/2018.
 */

public class Categories {
    private String title;
    private String desc;
    private int image;

    public Categories(String title, String desc, int img) {
        this.title = title;
        this.desc = desc;
        this.image = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int img) {
        this.image = img;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
