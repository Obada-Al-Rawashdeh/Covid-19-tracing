package com.obadarawashdeh.covid19.Model;

public class Info {
    private int img;
    private int desc;
    private int title;

    public Info(int img, int desc, int title) {
        this.img = img;
        this.desc = desc;
        this.title = title;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getDesc() {
        return desc;
    }

    public void setDesc(int desc) {
        this.desc = desc;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }
}
