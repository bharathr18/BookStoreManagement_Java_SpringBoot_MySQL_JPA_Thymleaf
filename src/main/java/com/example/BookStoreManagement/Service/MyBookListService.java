package com.example.BookStoreManagement.Service;

import com.example.BookStoreManagement.Entity.MyBookList;
import com.example.BookStoreManagement.Repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookListService {

    @Autowired
    MyBookRepository myBookRepository;

    public void saveMyBooks(MyBookList myBookList)
    {
        myBookRepository.save(myBookList);
    }

    public List<MyBookList> getAllMyBooks()
    {
        return myBookRepository.findAll();
    }

    public void deleteById(int id)
    {
        myBookRepository.deleteById(id);
    }
}
