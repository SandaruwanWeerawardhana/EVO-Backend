package edu.icet.service.system;

import edu.icet.dto.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
     Boolean saveUser(User user);
     Boolean updateUser(Long userId,User user);
     Boolean deleteUser(Long userId);
     List<User> getAllUsers();
     boolean isUserExist(Long userId);
     boolean isUserExist(User user);
     List<String> getUserAddress(String username);
     List<String> getAllUserAddress();
     List<User> getLimitUserAddress(Integer limit);

}
