package com.obadarawashdeh.covid19.Model;

public class Help {
    private String phone;
    private int name;

    public Help(String phone, int name) {
        this.phone = phone;
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }
}
