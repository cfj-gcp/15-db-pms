package com.tedu.idea03maven.controller;
import com.tedu.idea03maven.mapper.ItemMapper;
import com.tedu.idea03maven.pojo.Item;
import com.tedu.idea03maven.pojo.ItemExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

//处理商品相关请求
@RestController
@RequestMapping("/item")//在类上面加url，每个方法不用加了，访问时还要加/item

//localhost:1315/item/insert?itemName=华为手机&categoryid=1itemprice=99
public class ItemController {
    @Autowired
    ItemMapper  itemMapper;
//    更新商品
    @RequestMapping("/update")
    @CrossOrigin//允许任何网站通过javascript访问
//    localhost:1315/item/update?itemId=2&itemName=v587&itemPrice=121&itemDesc=aaaa&itemImage=13.jpg&categoryId=2
    public  String  update(Item item){
//        根据主键更改商品
        int rowCount = itemMapper.updateByPrimaryKey(item);
        if (rowCount>=1){
            return "更新成功";
        }else{
            return "更新失败";
        }
    }
//    根据itemid删除商品

    @RequestMapping("/delete")
    @CrossOrigin//允许任何网站通过javascript访问
    public  String  delete(Integer itemId){
//        根据主键删除商品
        int rowCount = itemMapper.deleteByPrimaryKey(itemId);
        if (rowCount>=1){
            return "删除成功";

        }else{
            return "删除失败";
        }

    }
//    查询所有商品
    @RequestMapping("/selectAll")
    @CrossOrigin//允许任何网站通过javascript访问
    public List<Item> selectAll(){

        return itemMapper.selectByExample(null);
    }
//    添加商品
    @RequestMapping("/insert")
    @CrossOrigin//允许任何网站通过javascript访问
    public  String insert(Item item){
        int rowCount = itemMapper.insert(item);
        if(rowCount>=1){
            return "添加成功";
        }else{
         return   "添加失败";
        }
    }
//    根据分类的id查询
    @RequestMapping("/findByCategoryId")
    @CrossOrigin//允许任何网站通过javascript访问
    public List<Item> findByCategoryId(Integer categoryId){
//        select * from Item where category_id=1
        ItemExample itemExample = new ItemExample();
        ItemExample.Criteria criteria = itemExample.or();
        criteria.andCategoryIdEqualTo(categoryId);
        return itemMapper.selectByExample(itemExample);
    }
//    根据商品id查询商品
    @RequestMapping("/findByItemId")
    @CrossOrigin//允许任何网站通过javascript访问
    public Item findByItemId(Integer itemId){
//        根据主键查询
        Item item = itemMapper.selectByPrimaryKey(itemId);
        return item;
    }
}
