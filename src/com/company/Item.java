package com.company;

public abstract class Item {
    private String name;
    private boolean isReusable;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReusable(boolean reusable) {
        isReusable = reusable;
    }

    public boolean isReusable() {
        return isReusable;
    }
    public Item(){}

    public Item(String name, boolean isReusable){
        this.name = name;
        this.isReusable = isReusable;
    }



}
