package com.blovvme.webviewsandsqlite;

/**
 * Created by Blovvme on 8/7/17.
 */

public class Contacts {

    String name, number;

    public Contacts(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }



}
