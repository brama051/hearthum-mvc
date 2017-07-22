package com.vabram.hearthum.repository;

import com.vabram.hearthum.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

/**
 * Created by brama051 on 23/06/2017.
 */
@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    List<User> findByEmail(@Param("email") String email);

}
