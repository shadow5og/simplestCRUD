package com.nkuliExamples.simplestCRUD;

public class User {
  public String firstName;
  public String lastName;
  public String contactNumber;
  
  public User(){}
  
  public User(String firstName, String lastName, String contactNumber) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.contactNumber = contactNumber;
  }
}
