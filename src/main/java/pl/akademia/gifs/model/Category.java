package pl.akademia.gifs.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor // żeby tworzył się konstruktor ze wszystkimi polami
public class Category {


    @Getter // jeśli nie wpiszemy tych adnotacji przed nazwą klasy, to gettery i settery beda tworzone tylko dla tych pól przed którymi adnotacje będą
    @Setter //settery potrzebne dla thymeleafa
    private int id;

    @Getter
    @Setter //settery potrzebne dla thymeleafa
    private String name;

}
