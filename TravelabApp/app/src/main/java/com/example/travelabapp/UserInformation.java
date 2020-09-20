package com.example.travelabapp;

import java.util.ArrayList;

public class UserInformation {

    public String name;
    public String address;
    public ArrayList<String> groups;

    public UserInformation(String name, String address) {
        this.name = name;
        this.address = address;
    }

    //One input = group name
    public void addGroup(String groupName) {
        this.groups.add(groupName);
    }

    //Two inputs = Changing user's name/address
    public void addData(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName()
    {
        return name;
    }
}
