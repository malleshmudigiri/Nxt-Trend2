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

import com.example.nxttrendz2.service.*;
import com.example.nxttrendz2.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
public class ProductController {
    @Autowired
    public ProductJpaService productjpaservice;

    @GetMapping("/categories/products")
    public ArrayList<Product> getAllProducts() {
        return productjpaservice.getAllProducts();
    }

    @PostMapping("/categories/products")
    public Product addProduct(@RequestBody Product product) {
        return productjpaservice.addProduct(product);

    }

    @GetMapping("/categories/products/{productId}")
    public Product getProductById(@PathVariable("productId") int productId) {
        return productjpaservice.getProductById(productId);

    }

    @PutMapping("/categories/products/{productId}")
    public Product updateProduct(@PathVariable("productId") int productId, @RequestBody Product product) {
        return productjpaservice.updateProduct(productId, product);
    }

    @DeleteMapping("/categories/products/{productId}")
    public void deleteProduct(@PathVariable("productId") int productId) {
        productjpaservice.deleteProduct(productId);
    }

    @GetMapping("/products/{productId}/category")
    public Category getCategor1(@PathVariable("productId") int productId) {
        return productjpaservice.getCategory1(productId);

    }
}
