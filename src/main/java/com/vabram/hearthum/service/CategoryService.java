package com.vabram.hearthum.service;

import com.vabram.hearthum.model.Category;

import java.util.List;

/**
 * Created by brama051 on 02/03/2017.
 */
public interface CategoryService {
    List<Category> findAll();

    Category findById(Long id);
}

