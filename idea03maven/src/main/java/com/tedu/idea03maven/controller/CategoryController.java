package com.tedu.idea03maven.controller;

import com.tedu.idea03maven.mapper.CategoryMapper;
import com.tedu.idea03maven.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class CategoryController {
//    从spring容器中取代代理对象
    @Autowired
    CategoryMapper  categoryMapper;
    @RequestMapping("/category/selectAll")
    @CrossOrigin//允许任何网站通过javascript访问
    public List<Category> selectAll(){
        return categoryMapper.selectByExample(null);
    }

}
