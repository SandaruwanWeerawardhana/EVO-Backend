package edu.icet.service;

import edu.icet.dto.User;

import java.util.List;


public interface UserSerivce {
     Boolean saveUser(User user);
     Boolean updateUser(User user);
     Boolean deleteUser(String username);
     List<User> getAllUsers();
     boolean isUserExist(String username);
     boolean isUserExist(User user);







}
