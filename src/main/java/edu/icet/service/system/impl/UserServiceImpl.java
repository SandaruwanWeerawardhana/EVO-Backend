package edu.icet.service.system.impl;

import edu.icet.dto.User;
import edu.icet.service.system.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Override
    public Boolean saveUser(User user) {
        return null;
    }

    @Override
    public Boolean updateUser(Long userId, User user) {
        return null;
    }

    @Override
    public Boolean deleteUser(Long userId) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return List.of();
    }

    @Override
    public boolean isUserExist(Long userId) {
        return false;
    }

    @Override
    public boolean isUserExist(User user) {
        return false;
    }

    @Override
    public List<String> getUserAddress(String username) {
        return List.of();
    }

    @Override
    public List<String> getAllUserAddress() {
        return List.of();
    }

    @Override
    public List<User> getLimitUserAddress(Integer limit) {
        return List.of();
    }
}
