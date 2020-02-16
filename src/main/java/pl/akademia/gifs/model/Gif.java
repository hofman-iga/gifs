package pl.akademia.gifs.model;

import lombok.Getter;
import lombok.Setter;

@Getter // dodajemy lombokiem gettery
@Setter // dodajemy lombokiem settery

//@AllArgsConstructor - żeby lombok utworzył też konstruktor ze wszystkimi polami, ale tego teraz nie
//dodaje, bo stworzyłam konstruktor ręcznie
public class Gif {

    private String name;
    private String username;
    private Boolean favorite;
    private int categoryId;

    public Gif(String name, String username, Boolean favourite, int categoryId) {
        this.name = name;
        this.username = username;
        this.favorite = favourite;
        this.categoryId = categoryId;
    }


}
