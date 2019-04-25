package com.qiku.customlistview;

public class myListView {
    private String text;
    private int imageId;

    public myListView(String text, int imageId) {
        this.text = text;
        this.imageId = imageId;
    }

    public String getText(){
        return text;
    }

    public void setText(String text){
        this.text = text;
    }

    public int getImage(){
        return imageId;
    }

    public void setImage(int imageId){
        this.imageId = imageId;
    }
}
