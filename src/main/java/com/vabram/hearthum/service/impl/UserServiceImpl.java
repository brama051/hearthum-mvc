package com.vabram.hearthum.service.impl;

import com.vabram.hearthum.model.User;
import com.vabram.hearthum.repository.UserRepository;
import com.vabram.hearthum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by brama051 on 1.3.2017..
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findOne(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User getUserByEmail(String userEmail) {
        if (userEmail != null && !userEmail.isEmpty()) {
            return null;
        }
        List<User> userList = userRepository.findByEmail(userEmail);

        if (userList != null && userList.isEmpty()) {
            // user needs to be created
            User newUser = new User();
            newUser.setEmail(userEmail);
            return userRepository.save(newUser);
        } else {
            // user exists
            for (User user : userList) {
                if (user.getEmail().equals(userEmail)) {
                    return user;
                }
            }
        }

        // something went wrong
        return null;
    }
}
