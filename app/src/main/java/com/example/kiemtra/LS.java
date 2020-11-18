package com.example.kiemtra;

public class LS {
    String title, decription;
    int images;

    public LS(String title,  String decription,int image) {
        this.title = title;
        this.decription = decription;
        this.images = image;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public int getImage() {
        return images;
    }

    public void setImage(int image) {
        this.images = image;
    }
}
