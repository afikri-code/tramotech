package de.tramotech.demospringsoap;

import de.tramotech.springsoap.gen.Book;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@Component
public class BookRepository {
    private static final Map<String, Book> books = new HashMap<>();
    @PostConstruct
    public void initData() {
        // initialize book map
        Book book = new Book();
        book.setIsbn("123");
        book.setAuthor("Ahmed Fikri");
        book.setTitle("Java .....");
        book.setPublicationYear(new BigInteger("2020"));
        books.put("123", book);
    }

    public Book findBook(String name) {
        return books.get(name);
    }
}

