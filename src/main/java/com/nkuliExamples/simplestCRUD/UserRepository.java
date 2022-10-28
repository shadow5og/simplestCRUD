package com.nkuliExamples.simplestCRUD;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

@Repository
public interface UserRepository {
  ObjectMapper om = new ObjectMapper();
  File dataFile = new File("data.json");
  User defaultUser = new User(
          "John",
          "Doe",
          "00000000"
        );
  
  default User getUser(){
    try {
      return om.readValue(dataFile, User.class);
    } catch (IOException e) {
      System.out.println("\nUnable to access user data.\n" + e.getMessage());
      return defaultUser;
    }
  }
  
  default boolean setUser(User user){
    try {
      om.writeValue(dataFile, user);
      return true;
    } catch (IOException e) {
      return false;
    }
  }
  
  default boolean deleteUser(){
    try {
      PrintWriter pen = new PrintWriter(dataFile);
      //Erase everything
      pen.println("");
      return true;
    } catch (FileNotFoundException e) {
      System.out.println("\n" + e.getMessage() + "\n");
      return false;
    }
  }
}
