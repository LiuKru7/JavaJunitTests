package chatgpt_books;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Altoriu seseliai","Vincas Kudirka",1960,18.99, Genre.HISTORY));
        books.add(new Book("Telefonu knyga","Lietuvos vyriausybe",2000,9.99, Genre.FANTASY));
        books.add(new Book("Kunigunda","Baumila",2022,20.99, Genre.FICTION));
        books.add(new Book("Tenet"," Kudirka",1990,35.99, Genre.NON_FICTION));
        books.add(new Book("Kliudziau","Jonas Biliunas",1954,11.99, Genre.SCIENCE));
        books.add(new Book("Karsonas","Astrida Lingren",1975,10.99, Genre.HISTORY));
        books.add(new Book("Pasaulis","Bite Vilimaite",2000,5.99, Genre.FICTION));
        books.add(new Book("Alegorija","Bumblauskas",1999,6.99, Genre.NON_FICTION));
        books.add(new Book("Pranesejas","Birute Dovidaityte",2023,8.99, Genre.HISTORY));

        Library library = new Library();


        System.out.println(library.getBooksByGenre(books));
        System.out.println(library.getBooksNamesByPrice(books));
        System.out.println(library.getBookWithYearsMoreThan2015(books));
        System.out.println(library.getCheapestBook(books));
        System.out.println(library.getBookWithPriceLeasThan20(books));
    }
}
