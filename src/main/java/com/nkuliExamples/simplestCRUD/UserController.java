package com.nkuliExamples.simplestCRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "user")
public class UserController {
  private final UserService userService;
  
  @Autowired
  public UserController(UserService userService){
    this.userService =  userService;
  }
  
  @GetMapping
  public User getUser(){
    return userService.getUser();
  }
  
  @DeleteMapping
  public ResponseEntity<User> deleteUser(){
    if (!userService.deleteUser()){
      return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    return new ResponseEntity<User>(HttpStatus.OK);
  }
  
  @PostMapping
  public ResponseEntity<User> postUser(@RequestBody User user){
    if (!userService.createUser(user)){
      return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    return new ResponseEntity<User>(HttpStatus.OK);
  }
  
  @PutMapping
  public ResponseEntity<User> putUser(@RequestBody User user){
    if (!userService.updateUser(user)){
      return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    return new ResponseEntity<User>(HttpStatus.OK);
  }
}
