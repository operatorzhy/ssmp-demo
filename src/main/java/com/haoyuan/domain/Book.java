package com.haoyuan.domain;
import lombok.Data;


@Data
//这里的@data相当于为我们自动添加了get方法和set方法
//但没有去添加构造方法，构造方法需要使用@constructor
//还为我们创建了tostring方法和hashcode方法
public class Book {
    private Integer id;
    private String type;
    private String name;
    private String description;

}
