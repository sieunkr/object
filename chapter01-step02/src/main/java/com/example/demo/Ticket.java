package com.example.demo;

public class Ticket {
    private Long fee;

    public Ticket(long fee) {
        this.fee = fee;
    }

    public Long getFee() {
        return fee;
    }
}