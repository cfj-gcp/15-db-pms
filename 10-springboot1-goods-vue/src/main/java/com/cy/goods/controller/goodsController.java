package com.cy.goods.controller;

import com.cy.goods.pojo.Goods;
import com.cy.goods.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/goods/")
public class goodsController {
    @Autowired
    private GoodService  goodService;
//    查询所有商品
//    返回所有商品页面
    @RequestMapping("selectAll")
    @CrossOrigin
    public List  selectAll(){
        List<Goods> goods = goodService.selectAll();
        return  goods;
    }
//    根据id删除
    @RequestMapping("deleteById/{id}")//restful编码风格
    @CrossOrigin
    public String deleteById(@PathVariable Integer id){
           int row = goodService.deleteById(id);
           if(row>0){
               return "删除成功";
           }else{
               return "删除失败";
           }

    }
//    插入商品
    @RequestMapping("insert")
    public String insert(Goods entity){
        int i = goodService.insertObject(entity);
        if(i>0){
            return  "插入成功";
        }else{
        return "插入失败";
    }
    }
//返回添加商品页面
    @RequestMapping("addGoodsPages")
    public String addGoodsPages(){
        return "goodsAdd";
    }
//    根据id更改商品
   @RequestMapping("findById/{id}")
   @CrossOrigin
    public Goods findById(@PathVariable Integer id){
       Goods  list= goodService.findById(id);
       return  list;
   }
   @RequestMapping("update")
   @CrossOrigin
    public String updateGoods( Goods goods){
       int i = goodService.updateGoods(goods);
      if(i>0){
          return "修改成功";
      }else{
          return "修改失败";
      }
   }
}
