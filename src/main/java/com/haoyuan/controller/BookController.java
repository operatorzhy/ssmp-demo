package com.haoyuan.controller;

import com.haoyuan.domain.Book;
import com.haoyuan.domain.R;
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
    public R getAll(){
        List<Book> all = bookService.getAll();

        R res=new R();
        if(all!=null){
            res.setFlag(true);
        }else{
            res.setFlag(false);
        }
        res.setObject(all);
        return res;
    }

    @PostMapping
    @ResponseBody
    public R save(@RequestBody Book book){
        Boolean flag = bookService.insert(book);
        R res=new R();
        res.setFlag(flag);
        return res;
    }

    @PutMapping
    @ResponseBody
    public R update(@RequestBody Book book){
        R res=new R();
        res.setFlag(bookService.updateById(book));
        return res;
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public R delete(@PathVariable Integer id){
        R res=new R();
        res.setFlag(bookService.deleteById(id));
        return res;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public R getById(@PathVariable Integer id){
        R res=new R();
        Book book = bookService.getById(id);
        if(book!=null){
            res.setFlag(true);
        }else {
            res.setFlag(false);
        }
        res.setObject(book);
        return res;

    }

    //分页查询
    @GetMapping("/{current}/{size}")
    @ResponseBody
    public R getByPage(@PathVariable Integer current,@PathVariable Integer size){
        List<Book> books = bookService.getByPage(current, size);
        R res=new R();
        if(books !=null){
            res.setFlag(true);
        }else{
            res.setFlag(false);
        }
        res.setObject(books);
        return res;
    }


}
