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

public interface CategoryRepository {
    ArrayList<Category> getAllCategories();

    Category addCategory(Category category);

    Category getById(int categoryId);

    Category updateCategory(int categoryId, Category category);

    void deleteCategory(int categoryId);

}
