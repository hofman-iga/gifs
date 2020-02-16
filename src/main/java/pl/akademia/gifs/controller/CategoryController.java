package pl.akademia.gifs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import pl.akademia.gifs.model.Category;
import pl.akademia.gifs.model.Gif;
import pl.akademia.gifs.repository.CategoryRepository;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/categories")
    public String gifCategory(ModelMap modelMap) {


        //1. Wyciągnięcie wartości z backendu - pobieranie kategorii
        List<Category> categoryList = categoryRepository.getAllCategories();

        //2. Przekazanie do view
        modelMap.put("categories", categoryList);

        //3. Zwrócenie widoku
        return "categories";

    }

}
