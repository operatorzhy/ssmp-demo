package com.haoyuan.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
        res.setMsg(flag?"保存成功":"保存失败");
        return res;
    }

    @PutMapping
    @ResponseBody
    public R update(@RequestBody Book book){
        R res=new R();
        Boolean flag=bookService.updateById(book);
        res.setFlag(flag);
        res.setMsg(flag?"修改成功^><^":"修改失败，请稍后再试");
        return res;
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public R delete(@PathVariable Integer id){
        R res=new R();
        Boolean flag=bookService.deleteById(id);
        res.setFlag(flag);
        res.setMsg(flag?"删除成功":"删除失败");
        return res;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public R getById(@PathVariable Integer id){
        R res=new R();
        Book book = bookService.getById(id);
        if(book!=null){
            res.setFlag(true);
            res.setMsg("查询成功");
        }else {
            res.setFlag(false);
            res.setMsg("查询失败");
        }
        res.setObject(book);
        return res;

    }

    //分页查询
    @GetMapping("/{current}/{size}/{type}/{name}/{description}")
    @ResponseBody
    public R getByPage(@PathVariable Integer current,@PathVariable Integer size,@PathVariable String type,@PathVariable String name,@PathVariable String description){
        Page<Book> books = bookService.getByPage(current, size,type,name,description);

        //针对最后一页数据删除结束，最后一页的显示空白的问题
        //这是其中一种解决方案，解决完成后，页面会跳转到页码数最大的一页
        if(current > books.getPages()){
            books=bookService.getByPage((int) books.getPages(),size,type,name,description);
        }
        R res=new R();
        if(books !=null){
            res.setFlag(true);
            res.setMsg("查询成功");
        }else{
            res.setFlag(false);
            res.setMsg("查询成功");
        }
        res.setObject(books);
        return res;
    }


}
