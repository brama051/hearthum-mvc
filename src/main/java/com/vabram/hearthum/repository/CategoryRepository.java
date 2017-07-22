package com.vabram.hearthum.repository;

import com.vabram.hearthum.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by brama051 on 02/03/2017.
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
