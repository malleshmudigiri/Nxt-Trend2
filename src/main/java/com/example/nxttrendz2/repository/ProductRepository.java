/*
 *
 * You can use the following import statements
 * 
 * import java.util.ArrayList;
 * 
 */

// Write your code here
package com.example.nxttrendz2.repository;

import java.util.ArrayList;
import com.example.nxttrendz2.model.*;

public interface ProductRepository {
    ArrayList<Product> getAllProducts();

    Product addProduct(Product product);

    Product getProductById(int productId);

    Product updateProduct(int productId, Product product);

    void deleteProduct(int productId);

    Category getCategory1(int productId);

}