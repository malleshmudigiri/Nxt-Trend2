/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 */

// Write your code here
package com.example.nxttrendz2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

import com.example.nxttrendz2.model.*;
import com.example.nxttrendz2.repository.*;

@Service
public class CategoryJpaService implements CategoryRepository {
    @Autowired
    private CategoryJpaRepository categoryjpaRepository;

    @Override
    public ArrayList<Category> getAllCategories() {
        List<Category> list = categoryjpaRepository.findAll();
        ArrayList<Category> arraylist = new ArrayList<>(list);
        return arraylist;
    }

    @Override

    public Category addCategory(Category category) {
        categoryjpaRepository.save(category);
        return category;

    }

    @Override

    public Category getById(int categoryId) {
        try {
            Category category1 = categoryjpaRepository.findById(categoryId).get();
            return category1;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override

    public void deleteCategory(int categoryId) {

        Optional<Category> categoryOptional = categoryjpaRepository.findById(categoryId);
        if (categoryOptional.isPresent()) {
            categoryjpaRepository.deleteById(categoryId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        }

    }

    @Override

    public Category updateCategory(int categoryId, Category category) {
        try {
            Category category12 = categoryjpaRepository.findById(categoryId).get();
            if (category.getName() != null) {
                category12.setName(category.getName());
            }
            if (category.getDescription() != null) {
                category12.setDescription(category.getDescription());
            }
            categoryjpaRepository.save(category12);
            return categoryjpaRepository.findById(categoryId).get();

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
