package pl.akademia.gifs.repository;


import org.springframework.stereotype.Repository;
import pl.akademia.gifs.model.Gif;
import sun.net.www.content.image.gif;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository // adnotacja dla repozytoriów
//najpierw stworzylismy klase, a nie interface, żeby mieć na sztywno zaszyte wszystkie wartości
public class GifRepository {

    private static List<Gif> ALL_GIFS = Arrays.asList(
            new Gif("android-explosion", "mols", true,1),
            new Gif("ben-and-mike", "mika", true,2),
            new Gif("book-dominos", "mem", true,0),
            new Gif("compiler-bot", "bot", true,1),
            new Gif("cowboy-coder", "code", true,1),
            new Gif("infinite-andrew", "andrew", false,2)
    );



    public List<Gif> getGifs(){
        return ALL_GIFS;
    }

    public String getGifNames() {
        String result = "";
        for (Gif gif : ALL_GIFS){
            result += gif.getName();
        }
        return result;
    }

    public List<Gif> getFavGifs() { //możemy zrobić strumieniem lub pętlą
       // return ALL_GIFS.stream()
        //     .filter(Gif::getFavorite)
         //    .collect(Collectors.toList());
         // }

        List<Gif> favorites = new ArrayList<>();
        for (Gif allGif : ALL_GIFS) {
            if (allGif.getFavorite()) {
               favorites.add(allGif);
            }
        }
        return favorites;
    }
    public Gif getGifByName(String name) {

        for (Gif allGif: ALL_GIFS) {
                if (allGif.getName().equals(name)) {
                    return allGif;
                }
    }
        return null; // zwracamy nulla, gdy nie znajdziemy gifa,
                        // jak znajdzie to pętla zatrzyma się na return allGif
                         // i to zwróci metoda
    }


    public List<Gif>getGifsByCategoryId(int id){
        List<Gif> gifFromCat = new ArrayList<>();
        for (Gif gifId: ALL_GIFS) {
            if (gifId.getCategoryId() == id){
                gifFromCat.add(gifId);
            }
        }
        return gifFromCat;
    }
}
