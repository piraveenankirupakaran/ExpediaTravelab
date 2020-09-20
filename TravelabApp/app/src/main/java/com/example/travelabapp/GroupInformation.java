package com.example.travelabapp;

import java.util.ArrayList;
import java.util.UUID;

public class GroupInformation {
    private String groupName;
    private int memCount = 0;
    private ArrayList<String> members;
    private ArrayList<Integer> budgets;
    private String location;
    private ArrayList<UUID> flights;
    private String accommodation;
    private int minBudget = 10000, totalBudget = 0;

    //Increment for Yes, decrement for no
    private int voteYes;
    private int voteNo;

    public GroupInformation(String groupName, String firstMember) {
        this.groupName = groupName;
        members.add(firstMember);
    }

    public void addMember(String user) {
        members.add(user);
        memCount ++;
    }

    //Location getter and setter
    public void setLocation(String location) {
        this.location = location;
    }
    public String getLocation() {
        return location;
    }

    //Accommodation getter and setter
    public void setAccommodation(String accommodation) {
        this.accommodation = accommodation;
    }
    public String getAccommodation() {
        return accommodation;
    }

    public void addBudget(int budget) {
        budgets.add(budget);
        if(budget < minBudget) {
            minBudget = budget;
            totalBudget += budget;
        }
    }
    public int getBudget() {
        return minBudget;
    }

}
