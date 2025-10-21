package com.SauceDemoTestAutomation.co.models;

public class InformacionPersonal {
    private String firstName;
    private String lastName;
    private String postalCode;

    public InformacionPersonal(String firstName, String lastName, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPostalCode() { return postalCode; }
}