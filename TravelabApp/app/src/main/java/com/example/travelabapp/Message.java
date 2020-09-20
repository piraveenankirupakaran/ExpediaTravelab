package com.example.travelabapp;

public class Message {
    private String text; // message body
    private MessageMemberData messageMemberData; // data of the user that sent this message
    private boolean belongsToCurrentUser; // is this message sent by us?

    public Message(String text, MessageMemberData messageMemberData, boolean belongsToCurrentUser) {
        this.text = text;
        this.messageMemberData = messageMemberData;
        this.belongsToCurrentUser = belongsToCurrentUser;
    }

    public String getText() {
        return text;
    }

    public MessageMemberData getMessageMemberData() {
        return messageMemberData;
    }

    public boolean isBelongsToCurrentUser() {
        return belongsToCurrentUser;
    }
}