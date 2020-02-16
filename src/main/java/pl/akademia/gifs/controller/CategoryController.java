package pl.akademia.gifs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.akademia.gifs.model.Category;
import pl.akademia.gifs.model.Gif;
import pl.akademia.gifs.repository.CategoryRepository;
import pl.akademia.gifs.repository.GifRepository;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    GifRepository gifRepository;

    @GetMapping("/categories")
    public String gifCategory(ModelMap modelMap) {


        //1. Wyciągnięcie wartości z backendu - pobieranie kategorii
        List<Category> categoryList = categoryRepository.getAllCategories();

        //2. Przekazanie do view
        modelMap.put("categories", categoryList);

        //3. Zwrócenie widoku
        return "categories";

    }

    @GetMapping("/category/{id}")
    public String gifsCategory(@PathVariable int id, ModelMap modelMap){
    //w pliku category mamy zmienne gifs i categories

        //1. Pobieranie kategorii po id
        Category category = categoryRepository.getCategoryByID(id);


        //1.2.  pobieranie gifów z id danej kategorii
        List<Gif> gifs = gifRepository.getGifsByCategoryId(id);

        //2. Przekazanie do view
        modelMap.put("category", category);
        modelMap.put("gifs", gifs);

        //3. Zwrócenie widoku
        return "category";
    }

}
