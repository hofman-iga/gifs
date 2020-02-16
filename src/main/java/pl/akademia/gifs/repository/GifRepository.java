package pl.akademia.gifs.repository;


import org.springframework.stereotype.Repository;
import pl.akademia.gifs.model.Gif;

import java.util.Arrays;
import java.util.List;

@Repository // adnotacja dla repozytoriów
//najpierw stworzylismy klase, a nie interface, żeby mieć na sztywno zaszyte wszystkie wartości
public class GifRepository {

    private static List<Gif> ALL_GIFS = Arrays.asList(
            new Gif("android-explosion", "mols", true,1),
            new Gif("ben-and-mike", "mika", true,2),
            new Gif("book-dominos", "mem", true,0),
            new Gif("compiler-bot", "bot", true,1),
            new Gif("cowboy-coder", "code", true,1),
            new Gif("infinite-andrew", "andrew", true,2)
    );



    public List<Gif> getGifs(){
        return ALL_GIFS;
    }

    public String getGifNames() {
        String result = "";
        for (Gif gif : ALL_GIFS){
            result +=gif.getName();
        }
        return result;
    }
}
