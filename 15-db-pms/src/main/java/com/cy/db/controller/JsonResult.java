package com.cy.db.controller;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
public class JsonResult  implements Serializable {
    private static final long serialVersionUID = -370714305980083936L;
    private  int state=1;//1表示成功0表示error
    private  String message="ok";
    private   Object data;

    public JsonResult(String message) {
        this.message = message;
    }
    public JsonResult(Object data) {
        this.data = data;
    }
//    抛出异常
    public JsonResult(Throwable e){
  this.state=0;
  this.message=e.getMessage();
    }
}
