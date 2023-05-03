package com.haoyuan.service;

import com.haoyuan.domain.Book;

import java.util.List;

public interface BookService {
    Book getById(Integer id);
    List<Book> getAll();
    boolean insert(Book book);
    boolean deleteById(Integer id);
    boolean updateById(Book book);
    List<Book> getByPage(Integer current,Integer size);


}
