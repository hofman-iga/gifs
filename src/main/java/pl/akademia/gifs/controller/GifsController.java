package pl.akademia.gifs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.akademia.gifs.model.Gif;
import pl.akademia.gifs.repository.GifRepository;

import java.lang.reflect.Array;
import java.util.List;

@Controller

public class GifsController {

@Autowired
    GifRepository gifRepository; // zeby móc w metodzie showgifs wyswietlic gify

    @GetMapping("/")

    public String hello(ModelMap modelMap){

        //1. Wyciągnięcie gifów
        List<Gif> gifList = gifRepository.getGifs();

        //2. Przekazanie do view
        //jako klucz przyjmuje zmienną z frontendu, jako wartość zmienną z backendu
        modelMap.put("gifs", gifList);

        //3. Zwrócenie widoku
        return "home"; // tu już podajemy plik home.html z resources, nie ma adnotacjie ResponseBody, bo zwracamy html
    }

    @GetMapping("/favorites") // taka ścieżka, bo tak jest w fronendzie
    public String favoritesGifs(ModelMap modelMap){

        //1. Wyciągnięcie wartości z backendu
        List<Gif>gifFav = gifRepository.getFavGifs();

        //2. Przekazanie do view
        modelMap.put("gifs", gifFav);

        //3. Zwrócenie widoku
        return "favorites";
    }

    @GetMapping("/gify")
    @ResponseBody
    public String showGifs(){
       return gifRepository.getGifNames();
    }

}
