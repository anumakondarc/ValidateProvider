package com.validate.provider.model;


public class Providers {

    String name;
    String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Providers{" +
                "name=" + name +
                ", url=" + url +
                "}";
    }
}
