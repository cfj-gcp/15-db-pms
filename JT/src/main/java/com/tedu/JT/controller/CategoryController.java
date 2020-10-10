package com.tedu.JT.controller;

import com.tedu.JT.mapper.CategoryMapper;
import com.tedu.JT.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    CategoryMapper  categoryMapper;
    @RequestMapping("/category/selectAll")
    @CrossOrigin
    public List<Category>  selectAll(){
        return  categoryMapper.selectByExample(null);
    }
}
