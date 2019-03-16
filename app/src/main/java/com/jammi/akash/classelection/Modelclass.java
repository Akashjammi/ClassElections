package com.jammi.akash.classelection;

public class Modelclass {
    private  int imgresource;
    private  String title;
    private  String body;

    public Modelclass(int imgresource, String title, String body) {
        this.imgresource = imgresource;
        this.title = title;
        this.body = body;
    }

    public Integer getImgresource() {
        return imgresource;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
