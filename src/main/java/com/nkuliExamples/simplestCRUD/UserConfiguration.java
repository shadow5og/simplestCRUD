package com.nkuliExamples.simplestCRUD;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
public class UserConfiguration {
  @Bean
  UserRepository repository(){
    return new UserRepository() {
      @Override
      public User getUser() {
        return UserRepository.super.getUser();
      }
  
      @Override
      public boolean setUser(User user) {
        return UserRepository.super.setUser(user);
      }
  
      @Override
      public boolean deleteUser() {
        return UserRepository.super.deleteUser();
      }
    };
  }
}
