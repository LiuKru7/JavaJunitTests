package chatgpt_books;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    private String name;
    private String author;
    private int years;
    private double price;
    private Genre genre;
}


