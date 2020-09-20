package com.example.travelabapp;

public class MessageMemberData {
    private String name;
    private String color;

    public MessageMemberData(String name, String color) {
        this.name = name;
        this.color = color;
    }

    // Add an empty constructor so we can later parse JSON into MemberData using Jackson
    public MessageMemberData() {
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }
}
