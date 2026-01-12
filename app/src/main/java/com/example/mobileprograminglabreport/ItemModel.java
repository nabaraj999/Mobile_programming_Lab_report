package com.example.mobileprograminglabreport;

public class ItemModel {
    private String title;
    private int icon;

    public ItemModel(String title, int icon) {
        this.title = title;
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public int getIcon() {
        return icon;
    }
}
