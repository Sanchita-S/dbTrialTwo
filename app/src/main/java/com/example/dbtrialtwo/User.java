package com.example.dbtrialtwo;

public class User {

    private String FirstName;
    private String LastName;

    public User(String fname, String flast) {
        FirstName = fname;
        LastName = flast;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }
}
