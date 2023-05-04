package com.haoyuan.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.haoyuan.domain.Book;

import java.util.List;

public interface BookService {
    Book getById(Integer id);
    List<Book> getAll();
    boolean insert(Book book);
    boolean deleteById(Integer id);
    boolean updateById(Book book);
    Page<Book> getByPage(Integer current, Integer size,String type,String name,String description);


}
