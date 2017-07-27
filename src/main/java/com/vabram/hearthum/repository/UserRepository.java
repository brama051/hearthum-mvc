package com.vabram.hearthum.repository;

import com.vabram.hearthum.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by brama051 on 23/06/2017.
 */
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    List<User> findByEmail(String email);

}
