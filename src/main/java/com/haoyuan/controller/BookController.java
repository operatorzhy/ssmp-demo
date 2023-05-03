package com.haoyuan.controller;

import com.haoyuan.domain.Book;
import com.haoyuan.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;  //BookService只有一个实现类，这样虽然定义的是接口，但实际指向仍然是具体的实现类

    @GetMapping
    @ResponseBody
    public List<Book> getAll(){
        return bookService.getAll();
    }

    @PostMapping
    public Boolean save(@RequestBody Book book){
        return bookService.insert(book);
    }

    @PutMapping
    public Boolean update(@RequestBody Book book){
        return bookService.updateById(book);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id){
        return bookService.deleteById(id);
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable Integer id){
        return bookService.getById(id);

    }

    //分页查询
    @GetMapping("/{current}/{size}")
    @ResponseBody
    public List<Book> getByPage(@PathVariable Integer current,@PathVariable Integer size){
        List<Book> books = bookService.getByPage(current, size);
        return books;
    }


}
