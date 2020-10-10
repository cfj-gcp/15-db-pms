package com.cy.pj.goods.controller;

import com.cy.pj.goods.pojo.Goods;
import com.cy.pj.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/goods/")
public class GoodsController {
    @Autowired
    private GoodsService  goodsService;
    @RequestMapping("findById/{id}")
    public  String findById(@PathVariable Integer id,Model model ){
        Goods goods = goodsService.findById(id);
        model.addAttribute("goods", goods);
        return "goodsUpdate";
    }
    @RequestMapping("updateGoods")
    public String  updateGoods(Goods goods){
        goodsService.updateGoods(goods);
        return "redirect:/goods/do";
    }
    @RequestMapping("do2")
    public String do2(Goods entity){
        goodsService.saveGoods(entity);
        return "redirect:/goods/do";
    }
    @RequestMapping("do3")
    public String do3(){
        return "goodsAdd";
    }
    @RequestMapping("do1/{id}")//restful编码风格，地址栏没有？
    public  String dodelete(@PathVariable Integer id){
           goodsService.deleteById(id);
           return "redirect:/goods/do";
    }
    @RequestMapping("do")
    public String do1(Model model){
        List<Goods> goods = goodsService.findGoods();
        model.addAttribute("goods", goods);
        return "goods";
    }
}
