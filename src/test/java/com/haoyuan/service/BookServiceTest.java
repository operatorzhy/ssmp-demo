package com.haoyuan.service;

import com.haoyuan.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTest {
    @Autowired
    private BookService bookService;

    @Test
    void testGetById(){
        System.out.println(bookService.getById(3));
    }
    @Test
    void testGetAll(){
        System.out.println(bookService.getAll());
    }
    @Test
    void testInsert(){
        Book book=new Book();
        book.setName("三国演义");
        book.setType("文学名著");
        book.setDescription("未出茅庐便知三分天下");

        System.out.println(bookService.insert(book));

    }

    @Test
    void testUpdateById(){
        Book book=new Book();
        book.setId(52);
        book.setName("三国演义");
        book.setType("文学名著");
        book.setDescription("未出茅庐便知三分天下,你真的值得拥有");
        System.out.println(bookService.updateById(book));
    }

    @Test
    void testDeleteById(){
        System.out.println(bookService.deleteById(52));
    }

    @Test
    void testGetByPage(){
        System.out.println(bookService.getByPage(2, 5));
    }
}
