package com.haoyuan.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.haoyuan.domain.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookDao extends BaseMapper<Book>{
}
