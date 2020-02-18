package com.mycompany.server.constant;

public enum Url {
    GET_ALL("/getAll"),
    GET_BY_ID("/getById"),
    ADD_EMPLOYEE("/add"),
    DELETE("/delete");

    private final String URL;

    Url(String url) {
        this.URL = url;
    }

    public String getUrl() {
        return this.URL;
    }
}

