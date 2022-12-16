package service.impl;

import model.Book;
import service.BookService;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BookImpl implements BookService {
    List<Book>books = new LinkedList<>();
    @Override
    public List<Book> createBooks(List<Book> books) {
        books = this.books;
        return books;
    }

    @Override
    public List<Book> getAllBooks() {
        return this.books;
    }

    @Override
    public List<Book> getBooksByGenre(String genre) {
        return  books.stream().filter(book -> false).toList();
    }

    @Override
    public Book removeBookById(Long id) {
        for (Book book : books) {
            if(book.getId().longValue()==id);
            books.remove(book);
        }
        return (Book) books;
    }

    @Override
    public List<Book> sortBooksByPriceInDescendingOrder() {
        return null;
    }

    @Override
    public List<Book> filterBooksByPublishedYear() {
        List<Book> books1 = new LinkedList<>();
        for (Book book : this.books) {
            if (book.getPublishedYear().isAfter(LocalDate.of(2012, 1, 1))) {
                books1.add(book);
            }
        }
        return books1;
    }

    @Override
    public List<Book> getBookByInitialLetter() {
        List<Book> books1 = new LinkedList<>();
        for (Book book : this.books) {
            if (book.getName().startsWith(new Scanner(System.in).nextLine())) {
                books1.add(book);
                return books1;
            }
        }
        return books1;
    }

    @Override
    public Book maxPriceBook() {
        books.stream().max(Comparator.comparing(Book::getPrice)).ifPresent(System.out::println);
        return null;

    }
}
