/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.ArrayList;
 * 
 */

// Write your code here
package com.example.nxttrendz2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import com.example.nxttrendz2.service.*;
import com.example.nxttrendz2.model.*;

@RestController
public class CategoryController {
    @Autowired
    public CategoryJpaService categoryjpaService;

    @GetMapping("/categories")
    public ArrayList<Category> getAllCategories() {
        return categoryjpaService.getAllCategories();

    }

    @PostMapping("/categories")
    public Category addCategory(@RequestBody Category category) {
        return categoryjpaService.addCategory(category);
    }

    @GetMapping("/categories/{categoryId}")
    public Category getById(@PathVariable("categoryId") int categoryId) {
        return categoryjpaService.getById(categoryId);

    }

    @PutMapping("/categories/{categoryId}")
    public Category updateCategory(@PathVariable("categoryId") int categoryId, @RequestBody Category category) {
        return categoryjpaService.updateCategory(categoryId, category);

    }

    @DeleteMapping("/categories/{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") int categoryId) {
        categoryjpaService.deleteCategory(categoryId);
    }

}
