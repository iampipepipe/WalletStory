package com.example.x.walletstory;

/**
 * Created by X on 4/26/2018.
 */

public class CategoriesData {
    private String title;
    private int icon;

    public CategoriesData(String title, int icon) {
        this.title = title;
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
