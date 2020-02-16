package pl.akademia.gifs.repository;


import org.springframework.stereotype.Repository;
import pl.akademia.gifs.model.Category;

import java.util.Arrays;
import java.util.List;

@Repository
public class CategoryRepository {

    private static final List<Category> ALL_CATEGORIES = Arrays.asList(
            new Category(0, "funny"),
            new Category(1, "sport"),
            new Category(2, "it")
            );

    public List<Category> getAllCategories(){
        return ALL_CATEGORIES;
    }

    public Category getCategoryByID(int id) {
        for (Category cat: ALL_CATEGORIES) {
            if(cat.getId() == id){
                return cat;
            }
        }

        return null;
    }
}
