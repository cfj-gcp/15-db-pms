package com.tedu.JT.controller;

import com.tedu.JT.mapper.ItemMapper;
import com.tedu.JT.pojo.Item;
import com.tedu.JT.pojo.ItemExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    ItemMapper itemMapper;
    @RequestMapping("/update")
    @CrossOrigin
    public String update(Item item){
        int rowcount = itemMapper.updateByPrimaryKey(item);
        if(rowcount>=1){
            return "更新成功";
        }else {
            return  "更新失败";
        }
    }
    @RequestMapping("/delete")
    @CrossOrigin
    public String  delete(Integer itemId){
        int rowcount = itemMapper.deleteByPrimaryKey(itemId);
        if (rowcount>=1){
            return "删除成功";
        }else{
            return "删除失败";
        }
    }
    @RequestMapping("/selectAll")
    @CrossOrigin
    public List<Item> selectAll(){
        return itemMapper.selectByExample(null);
    }
    @RequestMapping("/insert")
    @CrossOrigin
    public String insert(Item item){
        int rowcount = itemMapper.insert(item);
        if(rowcount>=1){
            return "添加成功";
        }else{
            return "添加失败";
        }
    }
    @RequestMapping("/findByCategoryId")
    @CrossOrigin
    public List<Item> findByCategoryId(Integer categoryId){
        ItemExample itemExample = new ItemExample();
        ItemExample.Criteria criteria = itemExample.or();
        criteria.andCategoryIdEqualTo(categoryId);
        return itemMapper.selectByExample(itemExample);
    }
    @RequestMapping("/findByItemId")
    @CrossOrigin
    public Item findbyitemid(Integer itemId){
        Item item = itemMapper.selectByPrimaryKey(itemId);
        return item;
    }
}
