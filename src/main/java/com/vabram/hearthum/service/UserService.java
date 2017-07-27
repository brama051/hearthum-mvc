package com.vabram.hearthum.service;

import com.vabram.hearthum.model.User;

/**
 * Created by brama051 on 1.3.2017..
 */
public interface UserService {

    User findOne(Long id);

    User getUserByEmail(String userEmail);
}


