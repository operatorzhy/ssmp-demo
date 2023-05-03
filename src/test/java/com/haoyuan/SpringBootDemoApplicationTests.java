package com.haoyuan;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.haoyuan.Dao.BookDao;
import com.haoyuan.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootDemoApplicationTests {

    @Autowired
    private BookDao bookDao;
    @Test
    void contextLoads() {
    }

    @Test
    void testGetById(){
        System.out.println(bookDao.selectById(12));
    }

    @Test
    void testInsert(){
        Book book=new Book();
        book.setName("水浒传");
        book.setDescription("人生必读篇目");
        book.setType("中国古典名著");
        bookDao.insert(book);
    }

    @Test
    void testGetAll(){
        bookDao.selectList(null);
    }

    @Test
    void testGetByPage(){
        Page page=new Page(2,5);
        Page page1 = bookDao.selectPage(page, null);
        System.out.println(page1.getPages());
        System.out.println(page1.getCurrent());
        System.out.println(page1.getRecords());
        System.out.println(page1.getTotal());
        System.out.println(page1.getSize());

    }

    @Test
    void testGetBy(){
        String name="Spring";
        QueryWrapper<Book> qw=new QueryWrapper<>();
        qw.like(name!=null,"name",name);

        bookDao.selectList(qw);
    }

}
