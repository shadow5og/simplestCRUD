package com.nkuliExamples.simplestCRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
  private final UserRepository repository;
  
  @Autowired
  public UserService(UserRepository repository){ this.repository = repository; }
  public User getUser(){
    return repository.getUser();
  }
  
  public boolean createUser(User user){
    return repository.setUser(user);
  }
  
  public boolean updateUser(User user){
    return repository.setUser(user);
  }
  
  public boolean deleteUser(){
    return repository.deleteUser();
  }
}
