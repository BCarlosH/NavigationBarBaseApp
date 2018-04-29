package com.example.carlos.navigationbarbaseapp.data.model;


public class Card {

    private int tittle;
    private int body;

    public Card(int tittle, int body) {
        this.tittle = tittle;
        this.body = body;
    }

    public int getTittle() {
        return tittle;
    }

    public void setTittle(int tittle) {
        this.tittle = tittle;
    }

    public int getBody() {
        return body;
    }

    public void setBody(int body) {
        this.body = body;
    }
}
