package com.cy.goods.controller;

import com.cy.goods.pojo.Goods;
import com.cy.goods.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/goods/")
public class goodsController {
    @Autowired
    private GoodService  goodService;
//    查询所有商品
//    返回所有商品页面
    @RequestMapping("selectAll")
    public String  selectAll(Model model){
        List<Goods> goods = goodService.selectAll();
        model.addAttribute("good", goods);
        return  "goods";
    }
//    根据id删除
    @RequestMapping("deleteById/{id}")//restful编码风格
    public String deleteById(@PathVariable Integer id){
           int row = goodService.deleteById(id);
        return "redirect:/goods/selectAll";
    }
//    插入商品
    @RequestMapping("insert")
    public String insert(Goods entity){
        goodService.insertObject(entity);
        return "redirect:/goods/selectAll";
    }
//返回添加商品页面
    @RequestMapping("addGoodsPages")
    public String addGoodsPages(){
        return "goodsAdd";
    }
//    根据id更改商品
   @RequestMapping("findById/{id}")
    public String findById(@PathVariable Integer id,Model model){
       Goods byId = goodService.findById(id);
       model.addAttribute("update", byId);
       return  "goodsUpdate";
   }
   @RequestMapping("update")
    public String updateGoods(Goods goods){
       int i = goodService.updateGoods(goods);
       return "redirect:/goods/selectAll";
   }
}
