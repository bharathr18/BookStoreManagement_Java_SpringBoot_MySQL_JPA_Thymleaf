package com.example.BookStoreManagement.Service;

import com.example.BookStoreManagement.Entity.Book;
import com.example.BookStoreManagement.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public void save(Book book)
    {
        bookRepository.save(book);
    }

    public List<Book> getAllBooks()
    {
        return bookRepository.findAll();
    }

    public Book getBookById(int id)
    {
        return bookRepository.findById(id).get();
    }
}
