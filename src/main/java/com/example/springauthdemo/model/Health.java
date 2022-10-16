package com.example.springauthdemo.model;

public class Health {
    private String status;

    public Health(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
