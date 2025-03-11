package edu.icet.service.system.impl;

import edu.icet.dto.User;
import edu.icet.service.system.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


import java.util.List;
@Service
@Slf4j

public class UserServiceImpl implements UserService {
    List<User> userList = new ArrayList<>();

    @Override
    public Boolean saveUser(User user) {
        if (user == null) {
            log.info("user is null");
            return false;
        }
        return userList.add(user);
    }

    @Override
    public Boolean updateUser(Long userId, User user) {
        if (user == null) {
            log.info("user is null");
            return false;
        }
        for (int i = 0; i < userList.size(); i++) {
            User existingUser = userList.get(i);
            if (existingUser.getUserId().equals(userId)) {
                userList.set(i, user);
                return true;
            }
        }
        log.info("User with ID {} not found", userId);
        return false;
    }

    @Override
    public Boolean deleteUser(Long userId) {
        if (userList == null || userId == null) {
            log.info("User list is empty or userId is null");
            return false;
        }
        for (User existingUser : userList) {
            if (existingUser.getUserId().equals(userId)) {
                userList.remove(userId.intValue());
                return true;
            }
        }
        log.info("User with ID {} not found", userId);
        return false;
    }

    @Override
    public List<User> getAllUsers() {
        if (userList != null) {
            return userList;
        } else {
            log.info("users not found");
            return null;
        }
    }

    @Override
    public boolean isUserExist(Long userId) {
        if (userList.isEmpty() || userId == null) {
            log.info("user list is empty or userId is null");
            return false;
        }
        for (User existingUser : userList) {
            if (existingUser.getUserId().equals(userId)) {
                return true;
            }
        }
        log.info("User with ID {} not found", userId);
        return false;
    }

    @Override
    public boolean isUserExist(User user) {
        if (userList.isEmpty() || user == null) {
            log.info("users not found or user is null");
            return false;
        }
        if (userList.contains(user)) {
            return true;
        }
        log.info("User {} not found", user);
        return false;

    }
}
