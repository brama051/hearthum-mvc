package com.vabram.hearthum.service.impl;

import com.vabram.hearthum.model.Category;
import com.vabram.hearthum.repository.CategoryRepository;
import com.vabram.hearthum.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by brama051 on 02/03/2017.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id){
        return categoryRepository.findOne(id);
    }
}
