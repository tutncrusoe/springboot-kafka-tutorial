package com.example.springbootkafkatutorial.payload;

import lombok.Data;

@Data
public class User {

    private String id;
    private String firstName;
    private String lastName;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
