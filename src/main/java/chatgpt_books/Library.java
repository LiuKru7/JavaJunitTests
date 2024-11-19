package chatgpt_books;

import java.util.*;
import java.util.stream.Collectors;

public class Library {

    public List<Book> getBookWithPriceLeasThan20(List<Book> books) {
        return books.stream()
                .filter(book -> book.getPrice() > 20)
                .toList();
    }

    public List<Book> getBookWithYearsMoreThan2015(List<Book> books) {
        return books.stream()
                .filter(book -> book.getYears() > 2015)
                .toList();
    }

    public Map<Genre, List<Book>> getBooksByGenre(List<Book> books) {
        return books.stream()
                .sorted(Comparator.comparing(Book::getGenre))
                .collect(Collectors.groupingBy(Book::getGenre));
    }

    public List<String> getBooksNamesByPrice(List<Book> books) {
        return books.stream()
                .sorted(Comparator.comparingDouble(Book::getPrice))
                .map(Book::getName)
                .toList();
    }

    public Book getCheapestBook(List<Book> books) {
        return books.stream()
                .min(Comparator.comparingDouble(Book::getPrice))
                .orElse(null);
    }

    public Map<String, Double> getStatistic(List<Book> books) {
        Map<String, Double> statistic = new HashMap<>();

        Double priceAverage = books.stream()
                .mapToDouble(Book::getPrice)
                .average()
                .orElse(0);

        Double minPrice = books.stream()
                .mapToDouble(Book::getPrice)
                .min()
                .orElse(0);

        Double maxPrice = books.stream()
                .mapToDouble(Book::getPrice)
                .max()
                .orElse(0);


        statistic.put("Price average", priceAverage);
        statistic.put("Min price", minPrice);
        statistic.put("Max price", maxPrice);


        return statistic;
    }

}
