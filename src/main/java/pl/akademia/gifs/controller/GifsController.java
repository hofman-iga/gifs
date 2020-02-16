package pl.akademia.gifs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    @ResponseBody
    public String hello(){
        return "Hello";
    }

    @GetMapping("/gify")
    @ResponseBody
    public String showGifs(){
       return gifRepository.getGifNames();
    }

}
