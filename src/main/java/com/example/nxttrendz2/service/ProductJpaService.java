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

import com.example.nxttrendz2.repository.CategoryJpaRepository;
import com.example.nxttrendz2.repository.ProductJpaRepository;

@Service
public class ProductJpaService implements ProductRepository {
    @Autowired
    private ProductJpaRepository productjpaservice;
    @Autowired
    private CategoryJpaRepository categoryjpaRepository;

    @Override
    public ArrayList<Product> getAllProducts() {
        List<Product> list = productjpaservice.findAll();
        ArrayList<Product> arraylist = new ArrayList<>(list);
        return arraylist;

    }

    @Override
    public Product addProduct(Product product) {

        Category oldCategory = product.getCategory();
        int categoryId = oldCategory.getId();
        Category newCategory = categoryjpaRepository.findById(categoryId).get();
        product.setCategory(newCategory);
        productjpaservice.save(product);
        return product;

    }

    @Override
    public Product getProductById(int productId) {
        try {
            Product product1 = productjpaservice.findById(productId).get();
            return product1;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        }
    }

    @Override
    public Product updateProduct(int productId, Product product) {
        try {
            Product product123 = productjpaservice.findById(productId).get();
            if (product.getName() != null) {
                product123.setName(product.getName());
            }
            if (product.getDescription() != null) {
                product123.setDescription(product.getDescription());
            }
            if (product.getPrice() != 0) {
                product123.setPrice(product.getPrice());
            }
            if (product.getCategory() != null) {
                Category category = product.getCategory();
                int categoryId = category.getId();
                Category category1 = categoryjpaRepository.findById(categoryId).get();
                product123.setCategory(category1);
            }
            productjpaservice.save(product123);
            return product123;

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public void deleteProduct(int productId) {

        Optional<Product> productOptional = productjpaservice.findById(productId);

        if (productOptional.isPresent()) {
            productjpaservice.deleteById(productId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        }

    }

    @Override
    public Category getCategory1(int productId) {
        try {
            Product product09 = productjpaservice.findById(productId).get();
            Category category123 = product09.getCategory();
            int categoryId1 = category123.getId();
            Category category34 = categoryjpaRepository.findById(categoryId1).get();
            return category34;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        }

    }

}
