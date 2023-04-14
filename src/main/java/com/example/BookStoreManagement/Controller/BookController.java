package com.example.BookStoreManagement.Controller;


import com.example.BookStoreManagement.Entity.Book;
import com.example.BookStoreManagement.Entity.MyBookList;
import com.example.BookStoreManagement.Service.BookService;
import com.example.BookStoreManagement.Service.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;


@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    MyBookListService myBookListService;
    @GetMapping("/")
    public String home()
    {
        return "home";
    }

    @GetMapping("/book_register")
    public String bookRegister()
    {
        return "bookRegister";
    }

    @GetMapping("/available_books")
    public ModelAndView getAllBook()
    {
        bookService.getAllBooks();
        List<Book> list = bookService.getAllBooks();
       /* ModelAndView modelAndView = new ModelAndView();
          modelAndView.setViewName("bookList");
          modelAndView.addObject("book",list); */
        return new ModelAndView("bookList","book",list);
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book book)
    {
        bookService.save(book);
        return "redirect:/available_books";
    }

    @GetMapping("/my_books")
    public String getMyBooks()
    {
        return "my_books";
    }

    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id)
    {
        Book book = bookService.getBookById(id);
        MyBookList myBookList = new MyBookList(book.getId(),book.getName(),book.getAuthor(),book.getPrice());
        myBookListService.saveMyBooks(myBookList);
        return "redirect:/my_books";
    }
}
