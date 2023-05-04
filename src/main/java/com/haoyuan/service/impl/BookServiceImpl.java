package com.haoyuan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.haoyuan.Dao.BookDao;
import com.haoyuan.domain.Book;
import com.haoyuan.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;
    @Override
    public Book getById(Integer id) {
        return bookDao.selectById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.selectList(null);
    }

    @Override
    public boolean insert(Book book) {
        return bookDao.insert(book)>0;
    }

    @Override
    public boolean deleteById(Integer id) {
        return bookDao.deleteById(id)>0;
    }

    @Override
    public boolean updateById(Book book) {
        return bookDao.updateById(book)>0;
    }

    @Override
    public Page<Book> getByPage(Integer current, Integer size, String type, String name, String description) {
        Page<Book> page=new Page<>(current,size);
        QueryWrapper<Book> qw=new QueryWrapper<>();
        qw.eq(type!=null&&type!="","type",type);
        qw.eq(name!=null&&name!="","name",name);
        qw.eq(description!=null&&description!="","description",description);

        Page<Book> page1 = bookDao.selectPage(page,qw);

        return page1;
    }
}
