package com.cy.goods.controller;

import com.cy.goods.pojo.Goods;
import com.cy.goods.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/goods/")
public class goodsController {
    @Autowired
    private GoodService  goodService;
    @RequestMapping("selectAll")
    public String  selectAll(Model model){
        List<Goods> goods = goodService.selectAll();
        model.addAttribute("g", goods);
        return  "goods";
    }
}
